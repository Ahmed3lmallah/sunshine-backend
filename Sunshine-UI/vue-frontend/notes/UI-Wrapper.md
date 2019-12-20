# UI Microservice

Reference: [JWorks Tech Blog](https://ordina-jworks.github.io/architecture/2018/10/12/spring-boot-angular-gradle.html)

*There are several ways to integrate Angular in Spring Boot using Gradle (or Maven), but this is the easiest.*
 
## Application structure

This guide assumes you have a root directory that contains two child directories. One with the Angular code, and another one with the Spring Boot code. By keeping these apart from each other it will be easier to develop within the application.

We’ll make use of [Gradle’s multi-project builds](https://docs.gradle.org/current/userguide/intro_multi_project_builds.html) to split the application into multiple modules.

Because I generated my Spring Boot project with [Spring Initializr](https://start.spring.io) I already have a Gradle Wrapper, `gradlew` file, `gradle.bat` file and `settings.gradle` file available. We want to move those to our root directory. Keep the `build.gradle` file within the Spring Boot directory.

We should also add a new `build.gradle` file to the root directory and another one to the child directory with our Angular code.

Your application structure should look like this:

    ├── build.gradle
    ├── settings.gradle
    ├── gradlew
    ├── gradle.bat
    ├── gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── demo-api
    │   └── build.gradle
    └── demo-ui
        └── build.gradle
    
You should have three `build.gradle` files, we’ll check their content within a minute.

## Root 

1. We first have to tell Gradle the name of our project and make sure it will recognize the two modules. This can be done in `settings.gradle`.

		rootProject.name = 'demo'
		
		include 'demo-api', 'demo-ui'
		
	We’ll use `demo` as the project name and include both the backend and frontend module by specifying their directory name. **It’s important that this name matches the path of the directory, otherwise Gradle cannot find these modules.** Gradle will now recognize both child directories as a subproject.
    
1. We can have a `build.gradle` with only the project description in the root directory.

		allprojects {
			group = 'com.cognizant'
			version = '0.0.1-SNAPSHOT'
		}

## Angular

For the Angular part we want to create a jar with a `static` directory that contains the result of our Angular build. By doing this we can include the jar in our backend module. And because Spring Boot will automatically add static web resources located within `static`, the Angular application will be visible when we launch the application.

This can be done by using the [com.moowork.node](https://plugins.gradle.org/plugin/com.moowork.node) plugin.

Let’s take a look at the `build.gradle` file in our `demo-ui` project.

    plugins {
      id 'java'
      id "com.moowork.node" version "1.2.0"
    }
    
    node {
      version = '11.4.0'
	  npmVersion = '6.4.1'
	  download = true
    }

    jar.dependsOn 'npm_run_build'

    jar {
      from 'dist/demo-ui' into 'static'
    }
    
Let me explain step-by-step what we’re doing here:

1.  We need the `java` plugin to have the `jar` task available and the `com.moowork.node` plugin to execute node scripts like `npm_run_build`.
1.  We have to specify which node and NPM version we want to use.
1.  Before creating the jar with the `jar` task we want to build our Angular project, otherwise we don’t have any static files to serve. This can be done by using the `npm_run_build` task.[1]
1.  When we build the Angular project our static files will become available in `dist/demo-ui`. We want those files into `static`. The `from 'dist/demo-ui' into 'static'` command in the `jar` task will simply copy everything from `dist/demo-ui` into `static`.[2]

When we build the subproject it will run `npm run build` and create a new jar with the build result in the `static` directory.

We can now setup Spring Boot to include the jar.

## Spring Boot

Our Spring Boot project already has a `build.gradle` file generated. We just have to add one line within our dependencies to include the demo-ui module.

    dependencies {
    	implementation(project(':demo-ui'))
    }

Build the project, execute the generated Spring Boot jar and go to [localhost:8080](http://localhost:8080), you should see your Angular web application. That’s all folks!

## Notes

1. by default, `npm run build` will execute `ng build` (specified in `package.json`)  
1. by default, Angular will output the build result in `dist/{project-name}` (specified in `angular.json`)

# Another Way to do it!

## Managing NPM

build.gradle

    plugins {
      id "com.moowork.node" version "1.2.0"
    }
    
    ext {
        // change this, if necessary, to be the path to the root of your Angular app
        angularDir = projectDir
    }
    
    node {
        nodeModulesDir = file(angularDir)
        download = true
        version = '10.15.3'
        npmVersion = '6.4.1'
    }
    
    task compileAngular(type: NpmTask, dependsOn: npmInstall) {
        def inputFiles = project.fileTree(dir: "${angularDir}/src", exclude: "**/karma-test-results.xml")
        inputs.files(inputFiles)
    
        def outputFile = "${angularDir}/dist"
        outputs.dir outputFile
    
        group 'build'
        description = 'Compile client side assets for production'
        args = ['run', 'build']
    }
    
    task copyAngular(type: Copy, dependsOn: compileAngular) {
        def inputFiles = project.fileTree(dir: "${angularDir}/dist")
        inputs.files(inputFiles)
    
        def outputFile = "${projectDir}/src/main/resources/static"
        outputs.dir outputFile
    
        from "${angularDir}/dist/$rootProject.name"
        into "${projectDir}/src/main/resources/static"
    }
    
    tasks.processResources.dependsOn(copyAngular)
    
    task testAngular(type: NpmTask, dependsOn: npmInstall) {
        def inputFiles = project.fileTree(dir: "${angularDir}/src", exclude: "**/karma-test-results.xml")
        inputs.files(inputFiles)
    
        def outputFile = "${angularDir}/coverage/"
        outputs.dir outputFile
    
        group 'verification'
        description = 'run ng test'
        args = ['run', 'test']
    }
    
    
    tasks.check.dependsOn(testAngular)
    
    task lintAngular(type:NpmTask, dependsOn: npmInstall) {
      def inputFiles = project.fileTree(dir: "${angularDir}/src", exclude: "**/karma-test-results.xml")
      inputs.files(inputFiles)
    
      group 'build'
      args = ['run', 'lint']
    }

### Angular Directory

Be sure to change the `angularDir`, inside `ext`, to match where the root of your Angular app is.

#### Examples

	app-root-dir
	+--- src // Angular app is here
	|    +--- app
	|    \\--- ...
	\\--- server // Spring App is here
		 +--- src
		 |    +--- main
		 |    \\--- test
		 +--- build.gradle
		 \\--- ...

_Spring Boot app is within an inner folder_

`angularDir = "$projectDir/../"`

	app-root-dir
	+--- src // Spring App is here
	|    +--- main
	|    \\--- test
	+--- build.gradle
	\\--- client // Angular app is here
		 \\--- src
			  +--- app
			  \\--- ...

_Spring Boot app is at the root, but Angular app is within an inner folder_

`angularDir = "$projectDir/client/"`
