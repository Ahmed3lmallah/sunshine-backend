# JavaScript Primer

BY: AHMED ELMALLAH

REFERENCE: [Codecademy.com](https://www.codecademy.com/learn/introduction-to-javascript)

**TABLE OF CONTENT:**

* [INTRODUCTION](learn-javascript-introduction.pdf)
* [DATA TYPES](#data-types)
* [STRING](#string)
	* [String Concatenation](#string-concatenation)
	* [String Length](#string-length)
	* [String Interpolation](#string-interpolation)
* [BUILT-IN OBJECTS](#built-in-objects)
* [COMMENTING](#commenting)
* [VARIABLES](#variables)
	* [typeof operator](#typeof-operator)
* [CONDITIONAL STATEMENTS](#conditional-statements)
	* [The if keyword](#the-if-keyword)
	* [The switch keyword](#the-switch-keyword)
	* [Comparison Operators](#comparison-operators)
	* [Logical Operators](#logical-operators)
	* [Truthy and Falsy](#truthy-and-falsy)
	* [Ternary Operator](#ternary-operator)
* [LOOPS](#loops)
	* [The For Loop](#the-for-loop)
	* [The While Loop](#the-while-loop)
	* [Do...While Statements](#dowhile-statements)
	* [The break Keyword](#the-break-keyword)
* [FUNCTIONS](#functions)
	* [Function Declarations](#function-declarations)
	* [Default Parameters](#default-parameters)
	* [Return](#return)
	* [Helper Functions](#helper-functions)
	* [Function Expressions](#function-expressions)
	* [Arrow Functions](#arrow-functions)
	* [Concise Body Arrow Functions](#concise-body-arrow-functions)
* [HIGHER ORDER FUNCTIONS](#higher-order-functions)
	* [Functions as Data](#functions-as-data)
	* [Functions as Parameters](#functions-as-parameters)
* [SCOPE](#scope)
	* [Blocks and Scope](#blocks-and-scope)
* [ARRAYS](#arrays)
	* [Create an Array](#create-an-array)
	* [Accessing Elements](#accessing-elements)
	* [Update Elements](#update-elements)
	* [Arrays Methods](#arrays-methods)
	* [Nested Arrays](#nested-arrays)
	* [Iterators](#iterators)
* [OBJECTS](#objects)
	* [Creating Object Literals](#creating-object-literals)
	* [Accessing Properties](#accessing-properties)
	* [Bracket Notation](#bracket-notation)
	* [Property Assignment](#property-assignment)
	* [Methods](#methods)
	* [Nested Objects](#nested-objects)
	* [Pass By Reference](#pass-by-reference)
	* [Looping Through Objects](#looping-through-objects)
	* [The this Keyword](#the-this-keyword)
	* [Privacy](#privacy)
	* [Getters](#getters)
	* [Setters](#setters)
	* [Factory Functions](#factory-functions)
	* [Property Value Shorthand](#property-value-shorthand)
	* [Destructured Assignment](#destructured-assignment)
	* [Built-in Object Methods](#built-in-object-methods)
* [CLASSES](#classes)
	* [Constructor](#constructor)
	* [Instance](#instance)
	* [Methods](#methods-1)
	* [Inheritance](#inheritance)
	* [Static Methods](#static-methods)
* [JAVASCRIPT MODULES](#javascript-modules)
	* [`module.exports`](#moduleexports)
	* [`require()`](#require)
	* [export default](#export-default)
	* [import](#import)
	* [Named Exports](#named-exports)
	* [Named Imports](#named-imports)
	* [Export Named Exports](#export-named-exports)
	* [Export as](#export-as)
* [JAVASCRIPT PROMISES](#javascript-promises)
	* [What is a Promise?](#what-is-a-promise)
	* [Constructing a Promise Object](#constructing-a-promise-object)
	* [The Node `setTimeout()` Function](#the-node-settimeout-function)
	* [Consuming Promises](#consuming-promises)
	* [The onFulfilled and onRejected Functions](#the-onfulfilled-and-onrejected-functions)
	* [Using `catch()` with Promises](#using-catch-with-promises)
	* [Chaining Multiple Promises](#chaining-multiple-promises)
	* [Avoiding Common Mistakes](#avoiding-common-mistakes)
	* [Using `Promise.all()`](#using-promiseall)
* [ASYNC AWAIT](#async-await)
	* [Introduction](#introduction)
	* [The async Keyword](#the-async-keyword)
	* [The await Operator](#the-await-operator)
	* [Handling Dependent Promises](#handling-dependent-promises)
	* [Handling Errors](#handling-errors)
	* [Handling Independent Promises](#handling-independent-promises)
	* [Await Promise.all()](#await-promiseall)
* [BROWSER COMPATIBILITY AND TRANSPILATION](#browser-compatibility-and-transpilation)


## Data Types

Data types are the classifications we give to the different kinds of data that we use in programming. In JavaScript, there are seven fundamental data types:

1. **Number:** Any number, including numbers with decimals: `4`, `8`, `1516`, `23.42`.

1. **String:** Any grouping of characters on your keyboard (letters, numbers, spaces, symbols, etc.) surrounded by single quotes: `' ... '` or double quotes `" ... "`. Though we prefer single quotes. Some people like to think of string as a fancy word for text.

1. **Boolean:** This data type only has two possible values— either `true` or `false` (without quotes). It’s helpful to think of booleans as on and off switches or as the answers to a “yes” or “no” question.

1. **Null:** This data type represents the intentional absence of a value, and is represented by the keyword `null` (without quotes).

1. **Undefined:** This data type is denoted by the keyword `undefined` (without quotes). It also represents the absence of a value though it has a different use than null.

1. **Symbol:** A newer feature to the language, symbols are unique identifiers, useful in more complex coding. No need to worry about these for now.

1. **Object:** Collections of related data.

## String

[String Methods & Properties](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String)

### String Concatenation

Operators aren’t just for numbers! When a + operator is used on two strings, it appends the right string to the left string:

	console.log('hi' + 'ya'); // Prints 'hiya'
	console.log('wo' + 'ah'); // Prints 'woah'
	console.log('I love to ' + 'code.')
	// Prints 'I love to code.'
	
### String length

Every string instance has a property called `length` that stores the number of characters in that string. You can retrieve property information by appending the string with a period and the property name:

	console.log('Hello'.length); // Prints 5
	
### String Interpolation

In the ES6 version of JavaScript, we can insert, or interpolate, variables into strings using template literals. 

	const myPet = 'armadillo';
	console.log(`I own a pet ${myPet}.`);
	// Output: I own a pet armadillo.

* Notice that: A template literal is wrapped by backticks. Inside the template literal, you’ll see a placeholder, `${myPet}`. The value of myPet is inserted into the template literal.

One of the biggest benefits to using template literals is the readability of the code. Using template literals, you can more easily tell what the new string will be. You also don’t have to worry about escaping double quotes or single quotes.	
	
## Built-in Objects

* **[Math](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math):** If you wanted to perform more complex mathematical operations than arithmetic, JavaScript has the built-in `Math` object.

* **[Number](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number)**

## Commenting

There are two types of code comments in JavaScript:

1. A single line comment will comment out a single line and is denoted with two forward slashes `//` preceding it.

		// Prints 5 to the console
		console.log(5);
	
	You can also use a single line comment to comment after a line of code:

		console.log(5);  // Prints 5 
	
1. A multi-line comment will comment out multiple lines and is denoted with `/*` to begin the comment, and `*/` to end the comment.

		/*
		This is all commented 
		console.log(10);
		None of this is going to run!
		console.log(99);
		*/
	
	You can also use this syntax to comment something out in the middle of a line of code:

		console.log(/*IGNORED!*/ 5);  // Still just prints 5
	
	When we write `console.log()` what we put inside the parentheses will get printed, or logged, to the console.

## Variables

One of the biggest changes was two new keywords, `let` and `const`, to create, or declare, variables. Prior to the ES6, programmers could only use the `var` keyword to declare variables.

	var myName = 'Arya';
	console.log(myName);

There are a few general rules for naming variables:

* Variable names cannot start with numbers.
* Variable names are case sensitive, so `myName` and `myname` would be different variables. It is bad practice to create two variables that have the same name using different cases.
* Variable names cannot be the same as keywords. For a comprehensive list of keywords check out [MDN’s keyword documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Lexical_grammar#Keywords).

### typeof operator

While writing code, it can be useful to keep track of the data types of the variables in your program. If you need to check the data type of a variable’s value, you can use the `typeof` operator.

The `typeof` operator checks the value to its right and returns, or passes back, a string of the data type.

	const unknown1 = 'foo';
	console.log(typeof unknown1); // Output: string

	const unknown2 = 10;
	console.log(typeof unknown2); // Output: number

	const unknown3 = true; 
	console.log(typeof unknown3); // Output: boolean

## Conditional Statements

#### [Summary](learn-javascript-conditionals.pdf)

### The if keyword

	if (true) {
	  console.log('This message will print!'); 
	}
	
### If...Else Statements

	if (false) {
	  console.log('The code in this block will not run.');
	} else {
	  console.log('But the code in this block will!');
	}

### Else If Statements

The else if statement always comes after the if statement and before the else statement. The else if statement also takes a condition.

	if (stopLight === 'red') {
	  console.log('Stop!');
	} else if (stopLight === 'yellow') {
	  console.log('Slow down.');
	} else if (stopLight === 'green') {
	  console.log('Go!');
	} else {
	  console.log('Caution, unknown!');
	}

### The switch keyword

A switch statement provides an alternative syntax that is easier to read and write. A switch statement looks like this:

	let groceryItem = 'papaya';

	switch (groceryItem) {
	  case 'tomato':
		console.log('Tomatoes are $0.49');
		break;
	  case 'lime':
		console.log('Limes are $1.49');
		break;
	  case 'papaya':
		console.log('Papayas are $1.29');
		break;
	  default:
		console.log('Invalid item');
		break;
	}


### Comparison Operators

Here is a list of some handy comparison operators and their syntax:

* Less than: `<`
* Greater than: `>`
* Less than or equal to: `<=`
* Greater than or equal to: `>=`
* Is equal to: `===`
* Is NOT equal to: `!==`

### Logical Operators

There are three logical operators:

* the and operator `&&`
* the or operator `||`
* the not operator, otherwise known as the bang operator `!`

### Truthy and Falsy

Sometimes, you’ll want to check if a variable exists and you won’t necessarily want it to equal a specific value— you’ll only check to see if the variable has been assigned a value, i.e. `truthy`

So which values are falsy— or evaluate to false when checked as a condition? The list of falsy values includes:

* `0`
* Empty strings like "" or ''
* `null` which represent when there is no value at all
* `undefined` which represent when a declared variable lacks a value
* `NaN`, or Not a Number

**In a boolean condition, JavaScript assigns the truthy value to a variable if you use the || operator in your assignment:**

	let defaultName = username || 'Stranger';

Because `||` or statements check the left-hand condition first, the variable defaultName will be assigned the actual value of username if is truthy, and it will be assigned the value of `'Stranger'` if username is falsy. This concept is also referred to as **short-circuit evaluation**.

### Ternary Operator

In the spirit of using short-hand syntax, we can use a ternary operator to simplify an if...else statement.

Take a look at the if...else statement example:

	if (isNightTime) {
	  console.log('Turn on the lights!');
	} else {
	  console.log('Turn off the lights!');
	}

We can use a ternary operator to perform the same functionality:

	isNightTime ? console.log('Turn on the lights!') : console.log('Turn off the lights!');

## LOOPS

### The For Loop

A for loop contains three expressions separated by ; inside the parentheses:

1. an initialization starts the loop and can also be used to declare the iterator variable.
1. a stopping condition is the condition that the iterator variable is evaluated against— if the condition evaluates to true the code block will run, and if it evaluates to false the code will stop.
1. an iteration statement is used to update the iterator variable on each loop.
The for loop syntax looks like this:

		for (let counter = 0; counter < 4; counter++) {
		  console.log(counter);
		}

### The While Loop
	
	let counterTwo = 1;
	while (counterTwo < 4) {
	  console.log(counterTwo);
	  counterTwo++;
	}

### Do...While Statements

A do...while statement says to do a task once and then keep doing it until a specified condition is no longer met. The syntax for a do...while statement looks like this:

	do {
	  countString = countString + i;
	  i++;
	} while (i < 5);

### The break Keyword

The break keyword allows programs to “break” out of the loop from within the loop’s block.

## FUNCTIONS

#### [Summary](learn-javascript-functions.pdf)

### Function Declarations

In JavaScript, there are many ways to create a function. One way to create a function is by using a function declaration. Just like how a variable declaration binds a value to a variable name, a function declaration binds a function to a name, or an identifier. Take a look at the anatomy of a function declaration below:

	function greetWorld(message) {
		console.log(message);
	}
	
A function declaration consists of:

1. The function keyword.
1. The name of the function, or its identifier, followed by parentheses.
1. A function body, or the block of statements required to perform a specific task, enclosed in the function’s curly brackets, { }.
1. We use parameters as placeholders for information that will be passed to the function when it is called.

We should also be aware of the **hoisting feature** in JavaScript which allows access to function declarations before they’re defined.

Take a look at example of **hoisting**:

	console.log(greetWorld()); // Output: Hello, World!

	function greetWorld() {
	  console.log('Hello, World!');
	}

### Default Parameters

One of the features added in ES6 is the ability to use default parameters. Default parameters allow parameters to have a predetermined value in case there is no argument passed into the function or if the argument is undefined when called.

Take a look at the code snippet below that uses a default parameter:

	function greeting (name = 'stranger') {
	  console.log(`Hello, ${name}!`)
	}

	greeting('Nick') // Output: Hello, Nick!
	greeting() // Output: Hello, stranger!

### Return

When a function is called, the computer will run through the function’s code and evaluate the result of calling the function. By default that resulting value is undefined.

	function rectangleArea(width, height) {
	  let area = width * height 
	}
	console.log(rectangleArea(5, 7)) // Prints undefined
	
### Helper Functions

We can also use the return value of a function inside another function. These functions being called within another function are often referred to as **helper functions**.

### Function Expressions
Another way to define a function is to use a function expression. To define a function inside an expression, we can use the `function` keyword. In a function expression, the function name is usually omitted. A function with no name is called an *anonymous function*. A function expression is often stored in a variable in order to refer to it.

Consider the following function expression:

	const calculateArea = function(width, length){
		const area = width * height;
		return area;
	};

To invoke a function expression, write the name of the variable in which the function is stored followed by parentheses enclosing any arguments being passed into the function.

	variableName(argument1, argument2)

* Unlike function declarations, function expressions are not hoisted so they cannot be called before they are defined.

### Arrow Functions

ES6 introduced arrow function syntax, a shorter way to write functions by using the special “fat arrow” `() =>` notation.

Arrow functions remove the need to type out the keyword function every time you need to create a function. Instead, you first include the parameters inside the `( )` and then add an arrow `=>` that points to the function body surrounded in `{ }` like this:

	const rectangleArea = (width, height) => {
		let area = width * height;
		return area;
	};

### Concise Body Arrow Functions

JavaScript also provides several ways to refactor arrow function syntax. The most condensed form of the function is known as concise body. We’ll explore a few of these techniques below:

1. Functions that take only a single parameter do not need that parameter to be enclosed in parentheses. However, if a function takes zero or multiple parameters, parentheses are required.

	* Zero Parameters
	
			const functionName = () => {};
			
	* One Parameter
	
			const functionName = paramOne => {};

	* Two or More Parameters
	
			const functionName = (paramOne, paramTwo) => {};
			
1. A function body composed of a single-line block does not need curly braces. Without the curly braces, whatever that line evaluates will be automatically returned. The contents of the block should immediately follow the arrow => and the return keyword can be removed. This is referred to as implicit return.

	* Single-line block
	
			const functionName = number => number + number;
			
	* Multi-line block
	
			const functionName = number => {
				const sum = number + number;
				return sum;
			};

## Higher Order Functions

Higher-order functions are functions that accept other functions as arguments and/or return functions as output.

### Functions as Data

JavaScript functions behave like any other data type in the language; we can assign functions to variables, and we can reassign them to new variables.

Below, we have an annoyingly long function name that hurts the readability of any code in which it’s used. Let’s pretend this function does important work and needs to be called repeatedly!

	const announceThatIAmDoingImportantWork = () => {
		console.log("I’m doing very important work!");
	};

What if we wanted to rename this function without sacrificing the source code? We can re-assign the function to a variable with a suitably short name:

	const busy = announceThatIAmDoingImportantWork;

busy is a variable that holds a reference to our original function. If we could look up the address in memory of busy and the address in memory of announceThatIAmDoingImportantWork they would point to the same place. Our new busy() function can be invoked with parentheses as if that was the name we originally gave our function.

**In JavaScript, functions are first class objects. This means that, like other objects you’ve encountered, JavaScript functions can have properties and methods. They have properties such as `.length` and `.name` and methods such as `.toString()`**

### Functions as Parameters

Since functions can behave like any other type of data in JavaScript, we can also pass functions (into other functions) as parameters. **A higher-order function is a function that either accepts functions as parameters, returns a function, or both!** We call the functions that get passed in as parameters and invoked callback functions because they get called during the execution of the higher-order function.

When we pass a function in as an argument to another function, we don’t invoke it. Invoking the function would evaluate to the return value of that function call. With callbacks, we pass in the function itself by typing the function name without the parentheses (that would evaluate to the result of calling the function):

	const timeFuncRuntime = funcParameter => {
	   let t1 = Date.now();
	   funcParameter();
	   let t2 = Date.now();
	   return t2 - t1;
	}

	const addOneToOne = () => 1 + 1;

	timeFuncRuntime(addOneToOne);

**A callback function is a function passed as an argument into another function.**

Note: We wrote a higher-order function, timeFuncRuntime(). It takes in a function as an argument, saves a starting time, invokes the callback function, records the time after the function was called, and returns the time the function took to run by subtracting the starting time from the ending time.

This higher-order function could be used with any callback function which makes it a potentially powerful piece of code.

We then invoked timeFuncRuntime() first with the addOneToOne() function - note how we passed in addOneToOne and did not invoke it.




## Scope

#### [Summary](learn-javascript-scope.pdf)

An important idea in programming is scope. Scope defines where variables can be accessed or referenced.	

### Blocks and Scope

A block is the code found inside a set of curly braces {}. Blocks help us group one or more statements together and serve as an important structural marker for our code.

* **Global Scope:** In global scope, variables are declared outside of blocks. These variables are called **global variables**. Because global variables are not bound inside a block, they can be accessed by any code in the program, including code in blocks.

* **Block Scope:** The next context we’ll cover is block scope. When a variable is defined inside a block, it is only accessible to the code within the curly braces {}. Variables that are declared with block scope are known as **local variables** because they are only available to the code that is part of the same block.

* **Global namespace** is the space in our code that contains globally scoped information.
* **Scope pollution** is when too many variables exist in a namespace or variable names are reused.

## ARRAYS

### Create an Array

* One way we can create an array is to use an array literal.
	
	An array literal creates an array by wrapping items in square brackets `[]`. Remember from the previous exercise, arrays can store any data type — *we can have an array that holds all the same data types or an array that holds different data types*.
	
		let newYearsResolutions = ['Keep a journal', 'Take a falconry class', 'Learn to juggle'];

### Accessing Elements

Each element in an array has a numbered position known as its index. We can access individual items using their index, which is similar to referencing an item in a list based on the item’s position — *Arrays in JavaScript are zero-indexed, meaning the positions start counting from `0` rather than `1`.*

	newYearsResolutions[0]; // Output 'Keep a journal'
	
### Update Elements

In the previous exercise, you learned how to access elements inside an array or a string by using an index. Once you have access to an element in an array, you can update its value.
	
	seasons[3] = 'Autumn';
	
*Variables declared with the const keyword cannot be reassigned. However, elements in an array declared with const remain mutable. Meaning that we can change the contents of a const array, but cannot reassign a new array or a different value.*

### Arrays Methods

* **The .length property:** One of an array’s built-in properties is length and it returns the number of items in the array. We access the `.length` property just like we do with strings. 

* **The .push() Method:** One method, .push() allows us to add items to the end of an array. Here is an example of how this is used:

		const itemTracker = ['item 0', 'item 1', 'item 2'];
		itemTracker.push('item 3', 'item 4');

* **The .pop() Method:** Another array method, .pop(), removes the last item of an array.

**Some [arrays methods](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array) that are available to JavaScript developers include: `.join()`, `.slice()`, `.splice()`, `.shift()`, `.unshift()`, and `.concat()` amongst many others.**

### Nested Arrays

Arrays can store other arrays. When an array contains another array it is known as a nested array. Examine the example below:

	const nestedArr = [[1], [2, 3]];

### Iterators 

Iterators are methods called on arrays to manipulate elements and return values.

Notice the different methods being called on the arrays:

* **The `.forEach()` Method**

	Aptly named, .forEach() will execute the same code for each element of an array.

		const artists = ['Picasso', 'Kahlo', 'Matisse', 'Utamaro'];
		
		artists.forEach(function(artist){
			console.log(artist + ' is one of my favorite artists.');
		});
		
	Another way to pass a callback for .forEach() is to use arrow function syntax.
		
		artists.forEach(artist => {
		  console.log(artist + ' is one of my favorite artists.');
		});
		
	We can also define a function beforehand to be used as the callback function. 
	
		function printArtist(artist){
		  console.log(artist + ' is one of my favorite artists.');
		}

		artists.forEach(printArtist);
	
	*The return value for `.forEach()` will always be `undefined`.*

* **The `.map()` Method**

	When .map() is called on an array, it takes an argument of a callback function and returns a new array!
	
		const numbers = [1, 2, 3, 4, 5];
		
		const squareNumbers = numbers.map(number => {
		  return number * number;
		});


* **The `.filter()` Method**

	Like `.map()`, `.filter()` returns a new array. However, `.filter()` returns an array of elements after filtering out certain elements from the original array. The callback function for the `.filter()` method should return `true` or `false` depending on the element that is passed to it. The elements that cause the callback function to return true are added to the new array.
	
		const things = ['desk', 'chair', 5, 'backpack', 3.14, 100];

		const onlyNumbers = things.filter(thing => {
		  return typeof thing === 'number';
		});

* **The `.findIndex()` Method**

	We sometimes want to find the location of an element in an array. That’s where the .findIndex() method comes in! Calling .findIndex() on an array will return the index of the first element that evaluates to true in the callback function.

		const jumbledNums = [123, 25, 78, 5, 9]; 

		const lessThanTen = jumbledNums.findIndex(num => {
		  return num < 10;
		});

	If there isn’t a single element in the array that satisfies the condition in the callback, then .findIndex() will return `-1`.

* **The `.reduce()` Method**

	Another widely used iteration method is `.reduce()`. The `.reduce()` method returns a single value after iterating through the elements of an array, thereby reducing the array. Take a look at the example below:

		const numbers = [1, 2, 4, 10];

		const summedNums = numbers.reduce((accumulator, currentValue) => {
		  return accumulator + currentValue
		})

		console.log(summedNums) // Output: 17	

	The `.reduce()` method can also take an optional second parameter to set an initial value for accumulator (remember, the first argument is the callback function!). For instance:

		const numbers = [1, 2, 4, 10];

		const summedNums = numbers.reduce((accumulator, currentValue) => {
		  return accumulator + currentValue
		}, 100)  // <- Second argument for .reduce()

		console.log(summedNums); // Output: 117
		
* **[More Methods](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array#Iteration_methods)**

## OBJECTS

### Creating Object Literals

Objects can be assigned to variables just like any JavaScript type. We use curly braces, {}, to designate an object literal:

	let spaceship = {}; // spaceship is an empty object
	
We fill an object with unordered data. This data is organized into key-value pairs. When we have a key that does not have any special characters in it, JavaScript allows us to omit the quotation marks:

	let spaceship = {
	  'Fuel Type': 'diesel',
	  color: 'silver'
	};
	
### Accessing Properties

There are two ways we can access an object’s property. 

1. Let’s explore the first way— dot notation, ..

	You’ve used dot notation to access the properties and methods of built-in objects and data instances:

		let spaceship = {
		  homePlanet: 'Earth',
		  color: 'silver'
		};
		spaceship.homePlanet; // Returns 'Earth',
		spaceship.color; // Returns 'silver',

	If we try to access a property that does not exist on that object, `undefined` will be returned.

### Bracket Notation

The second way to access a key’s value is by using bracket notation, `[ ]`.

	let spaceship = {
	  'Fuel Type': 'Turbo Fuel',
	  'Active Duty': true
	};

	spaceship['Active Duty'];   // Returns true

With bracket notation you can also use a variable inside the brackets to select the keys of an object. This can be especially helpful when working with functions:

	let returnAnyProp = (objectName, propName) => objectName[propName];

	returnAnyProp(spaceship, 'homePlanet'); // Returns 'Earth'

### Property Assignment

Once we’ve defined an object, we’re not stuck with all the properties we wrote. Objects are mutable meaning we can update them after we create them!

We can use either dot notation, `.`, or bracket notation, `[]`, and the assignment operator, `=` to add new key-value pairs to an object or change an existing property.

	spaceship.color = 'gold';
	spaceship['color'] = 'gold';
	
One of two things can happen with property assignment:

1. If the property already exists on the object, whatever value it held before will be replaced with the newly assigned value.
1. If there was no property with that name, a new property will be added to the object.

*It’s important to know that although we can’t reassign an object declared with const, we can still mutate it, meaning we can add new properties and change the properties that are there.*

	const spaceship = {type: 'shuttle'};
	spaceship = {type: 'alien'}; // TypeError: Assignment to constant variable.
	spaceship.type = 'alien'; // Changes the value of the type property
	spaceship.speed = 'Mach 5'; // Creates a new key of 'speed' with a value of 'Mach 5'

You can delete a property from an object with the delete operator.

	delete spaceship.speed;  // Removes the speed property

### Methods

We can include methods in our object literals by creating ordinary, comma-separated key-value pairs. The key serves as our method’s name, while the value is an anonymous function expression.

	const alienShip = {
	  invade: function () { 
		console.log('Hello! We have come to dominate your planet. Instead of Earth, it shall be called New Xaculon.')
	  }
	};

With the new method syntax introduced in ES6 we can omit the colon and the function keyword.

	const alienShip = {
	  invade () { 
		console.log('Hello! We have come to dominate your planet. Instead of Earth, it shall be called New Xaculon.')
	  }
	};

### Nested Objects

In application code, objects are often nested— an object might have another object as a property which in turn could have a property that’s an array of even more objects!

	const spaceship = {
		 nanoelectronics: {
			 computer: {
				terabytes: 100,
				monitors: 'HD'
			 },
			'back-up': {
			   battery: 'Lithium',
			   terabytes: 50
			 }
		}
	};

We can chain operators to access nested properties:

	spaceship.nanoelectronics['back-up'].battery; // Returns 'Lithium'

### Pass By Reference

Objects are passed by reference. This means when we pass a variable assigned to an object into a function as an argument, the computer interprets the parameter name as pointing to the space in memory holding that object. As a result, functions which change object properties actually mutate the object permanently (even when the object is assigned to a const variable).

### Looping Through Objects

`for...in` will execute a given block of code for each property in an object.

	for (let crewMember in spaceship.crew) {
	  console.log(`${crewMember}: ${spaceship.crew[crewMember].name}`)
	};

### The this Keyword

The this keyword references the calling object which provides access to the calling object’s properties.

	const goat = {
	  dietType: 'herbivore',
	  makeSound() {
		console.log('baaa');
	  },
	  diet() {
		console.log(this.dietType);
	  }
	};
	
**Arrow Functions and this:** avoid using arrow functions when using this in a method!

### Privacy

Certain languages have privacy built-in for objects, but JavaScript does not have this feature. Rather, JavaScript developers follow naming conventions that signal to other developers how to interact with a property. One common convention is to place an underscore _ before the name of a property to mean that the property should not be altered.

	const bankAccount = {
	  _amount: 1000
	}
	
#### Getters

Getters are methods that get and return the internal properties of an object. But they can do more than just retrieve the value of a property! Let’s take a look at a getter method:

	const person = {
	  _firstName: 'John',
	  _lastName: 'Doe',
	  get fullName() {
		if (this._firstName && this._lastName){
		  return `${this._firstName} ${this._lastName}`;
		} else {
		  return 'Missing a first name or a last name.';
		}
	  }
	}

Then to call the getter method:
	
	person.fullName; // 'John Doe'
	
#### Setters

Along with getter methods, we can also create setter methods which reassign values of existing properties within an object. Let’s see an example of a setter method:

	const person = {
	  _age: 37,
	  set age(newAge){
		if (typeof newAge === 'number'){
		  this._age = newAge;
		} else {
		  console.log('You must assign a number to age');
		}
	  }
	};
	
Then to use the setter method:

	person.age = 40;
	console.log(person._age); // Logs: 40
	person.age = '40'; // Logs: You must assign a number to age
	
Setter methods like age do not need to be called with a set of parentheses. Syntactically, it looks like we’re reassigning the value of a property.

### Factory Functions

Or else known as **Constructors:**

	const monsterFactory = (name, age, energySource, catchPhrase) => {
	  return { 
		name: name,
		age: age, 
		energySource: energySource,
		scare() {
		  console.log(catchPhrase);
		} 
	  }
	};
	
To make an object that represents a specific monster like a ghost, we can call monsterFactory with the necessary arguments and assign the return value to a variable:

	const ghost = monsterFactory('Ghouly', 251, 'ectoplasm', 'BOO!');
	ghost.scare(); // 'BOO!'

#### Property Value Shorthand

Imagine if we had to include more properties, that process would quickly become tedious! But we can use a destructuring technique, called property value shorthand, to save ourselves some keystrokes. The example below works exactly like the example above:

	const monsterFactory = (name, age) => {
	  return { 
		name,
		age 
	  }
	};
	
#### Destructured Assignment

If we wanted to extract the residence property as a variable, we could using the following code:

	const residence = vampire.residence; 
	console.log(residence); // Prints 'Transylvania' 

However, we can also take advantage of a destructuring technique called destructured assignment to save ourselves some keystrokes. In destructured assignment we create a variable with the name of an object’s key that is wrapped in curly braces { } and assign to it the object. Take a look at the example below:

	const { residence } = vampire; 
	console.log(residence); // Prints 'Transylvania'

### Built-in Object Methods

In the previous exercises we’ve been creating instances of objects that have their own methods. But, we can also take advantage of built-in methods for Objects!

For example, we have access to object instance methods like: .hasOwnProperty(), .valueOf(), and many more! Practice your documentation reading skills and check out: [MDN’s object instance documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object#Methods).

There are also useful Object class methods such as Object.assign(), Object.entries(), and Object.keys() just to name a few. For a comprehensive list, browse: [MDN’s object instance documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object#Methods_of_the_Object_constructor).

## CLASSES

### Constructor

Although you may see similarities between class and object syntax, there is one important method that sets them apart. It’s called the constructor method. JavaScript calls the constructor() method every time it creates a new instance of a class.

	class Dog {
	  constructor(name) {
		this.name = name;
		this.behavior = 0;
	  }
	}

### Instance

An instance is an object that contains the property names and methods of a class, but with unique property values. Let’s look at our Dog class example.

	const halley = new Dog('Halley'); // Create new Dog instance

### Methods

Class method and getter syntax is the same as it is for objects except you can not include commas between methods.

	class Dog {
	  constructor(name) {
		this._name = name;
		this._behavior = 0;
	  }

	  get name() {
		return this._name;
	  }

	  get behavior() {
		return this._behavior;
	  }

	  incrementBehavior() {
		this._behavior++;
	  }
	}
	
### Inheritance

Now that we have these shared properties and methods in the parent Animal class, we can extend them to the subclass, Cat.

	class Cat extends Animal {
	  constructor(name, usesLitter) {
		super(name);
		this._usesLitter = usesLitter;
	  }
	}
	
Notice, we call super on the first line of our constructor(), then set the usesLitter property on the second line. In a constructor(), you must always call the super method before you can use the this keyword — if you do not, JavaScript will throw a reference error.

### Static Methods

Sometimes you will want a class to have methods that aren’t available in individual instances, but that you can call directly from the class.

Take the Date class, for example — you can both create Date instances to represent whatever date you want, and call static methods, like Date.now() which returns the current date, directly from the class. The .now() method is static, so you can call it directly from the class, but not from an instance of the class.

	static generateName() {
		const names = ['Angel', 'Spike', 'Buffy', 'Willow', 'Tara'];
		const randomNumber = Math.floor(Math.random()*5);
		return names[randomNumber];
	  }

## JAVASCRIPT MODULES

JavaScript modules are reusable pieces of code that can be exported from one program and imported for use in another program.

### `module.exports`

We can get started with modules by defining a module in one file and making the module available for use in another file with Node.js `module.exports` syntax. Every JavaScript file run in Node has a local module object with an exports property used to define what should be exported from the file.

The pattern we use to export modules is thus:

1. Create an object to represent the module.
1. Add properties or methods to the module object.
1. Export the module with `module.exports`

	let Menu = {};
	Menu.specialty = "Roasted Beet Burger with Mint Sauce";
	module.exports = Menu; 
	
We can also wrap any collection of data and functions in an object, and export the object using module.exports. In menu.js, we could write:

	module.exports = {
	  specialty: "Roasted Beef Burger with Mint Sauce",
	  getSpecialty: function() {
		return this.specialty;
	  } 
	}; 

### `require()`

To make use of the exported module and the behavior we define within it, we import the module into another file. In Node.js, use the `require()` function to import modules.

	const Menu = require('./menu.js');

	function placeOrder() {
	  console.log('My order is: ' + Menu.specialty);
	}
	
### export default

Node.js supports `require()/module.exports`, but as of ES6, JavaScript supports a new more readable and flexible syntax for exporting modules. These are usually broken down into one of two techniques, default export and named exports.

We’ll begin with the first syntax, default export. The default export syntax works similarly to the module.exports syntax, allowing us to export one module per file.

Let’s look at an example in menu.js.

	let Menu = {};

	export default Menu;
	
When using ES6 syntax, we use export default in place of module.exports. Node.js doesn’t support export default by default, so module.exports is usually used for Node.js development and ES6 syntax is used for front-end development.

### import

ES6 module syntax also introduces the import keyword for importing objects. In our order.js example, we import an object like this:

	import Menu from './menu';

### Named Exports

ES6 introduced a second common approach to export modules. In addition to export default, named exports allow us to export data through the use of variables.

	let specialty = '';
	function isVegetarian() {
	}; 
	function isLowSodium() {
	}; 

	export { specialty, isVegetarian };
	
### Named Imports

To import objects stored in a variable, we use the import keyword and include the variables in a set of {}.

	import { specialty, isVegetarian } from './menu';
	
### Export Named Exports

Named exports are also distinct in that they can be exported as soon as they are declared, by placing the keyword export in front of variable declarations.

	export let specialty = '';
	export function isVegetarian() {
	}; 
	function isLowSodium() {
	}; 

Exporting upon declaration does not have an impact on how we import the variables.

	import { specialty, isVegetarian } from 'menu';
	
### Export as

Named exports also conveniently offer a way to change the name of variables when we export or import them. We can do this with the as keyword.

	let specialty = '';
	let isVegetarian = function() {
	}; 
	let isLowSodium = function() {
	}; 

	export { specialty as chefsSpecial, isVegetarian as isVeg, isLowSodium };
	
To import named export aliases with the as keyword, we add the aliased variable in our import statement.

	import { chefsSpecial, isVeg } from './menu';
	
**We can also use named exports and default exports together. We can use an import keyword to import both types of variables as such:**

	import { specialty, isVegetarian, isLowSodium } from './menu';

	import GlutenFree from './menu';
	
## JAVASCRIPT PROMISES

### What is a Promise?

Promises are objects that represent the eventual outcome of an asynchronous operation. A Promise object can be in one of three states:

* **Pending:** The initial state— the operation has not completed yet.
* **Fulfilled:** The operation has completed successfully and the promise now has a resolved value. For example, a request’s promise might resolve with a JSON object as its value.
* **Rejected:** The operation has failed and the promise has a reason for the failure. This reason is usually an Error of some kind.

We refer to a promise as settled if it is no longer pending— it is either fulfilled or rejected. 

### Constructing a Promise Object

Let’s construct a promise! To create a new Promise object, we use the new keyword and the Promise constructor method:

	const executorFunction = (resolve, reject) => { };
	const myFirstPromise = new Promise(executorFunction);

The Promise constructor method takes a function parameter called the executor function which runs automatically when the constructor is called. The executor function generally starts an asynchronous operation and dictates how the promise should be settled.

The executor function has two function parameters, usually referred to as the `resolve()` and `reject()` functions. The `resolve()` and `reject()` functions aren’t defined by the programmer. When the Promise constructor runs, JavaScript will pass its own `resolve()` and `reject()` functions into the executor function.

`resolve` is a function with one argument. Under the hood, if invoked, `resolve()` will change the promise’s status from pending to fulfilled, and the promise’s resolved value will be set to the argument passed into `resolve()`.

`reject` is a function that takes a reason or error as an argument. Under the hood, if invoked, `reject()` will change the promise’s status from pending to rejected, and the promise’s rejection reason will be set to the argument passed into `reject()`.

Let’s look at an example executor function in a Promise constructor:

	const executorFunction = (resolve, reject) => {
	  if (someCondition) {
		  resolve('I resolved!');
	  } else {
		  reject('I rejected!'); 
	  }
	}
	const myFirstPromise = new Promise(executorFunction);
	
### The Node setTimeout() Function

`setTimeout()` is a Node API (a comparable API is provided by web browsers) that uses callback functions to schedule tasks to be performed after a delay. `setTimeout()` has two parameters: a callback function and a delay in milliseconds.

	const delayedHello = () => {
	  console.log('Hi! This is an asynchronous greeting!');
	};

	setTimeout(delayedHello, 2000);
	
Let’s look at how we can use `setTimeout()` to construct asynchronous promises:

	const returnPromiseFunction = () => {
	  return new Promise((resolve, reject) => {
		setTimeout(( ) => {resolve('I resolved!')}, 1000);
	  });
	};

	const prom = returnPromiseFunction();
	
### Consuming Promises

Promise objects come with an aptly named `.then()` method. It allows us to say, “I have a promise, when it settles, then here’s what I want to happen…”

`.then()` is a higher-order function— it takes two callback functions as arguments. We refer to these callbacks as handlers. When the promise settles, the appropriate handler will be invoked with that settled value.

* The first handler, sometimes called `onFulfilled`, is a success handler, and it should contain the logic for the promise resolving.
* The second handler, sometimes called `onRejected`, is a failure handler, and it should contain the logic for the promise rejecting.

We can invoke `.then()` with one, both, or neither handler! This allows for flexibility, but it can also make for tricky debugging. If the appropriate handler is not provided, instead of throwing an error, `.then()` will just return a promise with the same settled value as the promise it was called on. One important feature of `.then()` is that it always returns a promise.

#### The onFulfilled and onRejected Functions

To handle a “successful” promise, or a promise that resolved, we invoke `.then()` on the promise, passing in a success handler callback function:

	const prom = new Promise((resolve, reject) => {
	  resolve('Yay!');
	});

	const handleSuccess = (resolvedValue) => {
	  console.log(resolvedValue);
	};

	prom.then(handleSuccess); // Prints: 'Yay!'

With typical promise consumption, we won’t know whether a promise will resolve or reject, so we’ll need to provide the logic for either case. We can pass both an `onFulfilled` and `onRejected` callback to `.then()`.

	let prom = new Promise((resolve, reject) => {
	  let num = Math.random();
	  if (num < .5 ){
		resolve('Yay!');
	  } else {
		reject('Ohhh noooo!');
	  }
	});

	const handleSuccess = (resolvedValue) => {
	  console.log(resolvedValue);
	};

	const handleFailure = (rejectionReason) => {
	  console.log(rejectionReason);
	};

	prom.then(handleSuccess, handleFailure);

### Using `catch()` with Promises

One way to write cleaner code is to follow a principle called separation of concerns. Separation of concerns means organizing code into distinct sections each handling a specific task. It enables us to quickly navigate our code and know where to look if something isn’t working.

Remember, `.then()` will return a promise with the same settled value as the promise it was called on if no appropriate handler was provided. This implementation allows us to separate our resolved logic from our rejected logic. Instead of passing both handlers into one `.then()`, we can chain a second `.then()` with a failure handler to a first `.then()` with a success handler and both cases will be handled.

	prom
	  .then((resolvedValue) => {
		console.log(resolvedValue);
	  })
	  .then(null, (rejectionReason) => {
		console.log(rejectionReason);
	  });

Since JavaScript doesn’t mind whitespace, we follow a common convention of putting each part of this chain on a new line to make it easier to read. 

To create even more readable code, we can use a different promise function: `.catch()`.

The `.catch()` function takes only one argument, onRejected. In the case of a rejected promise, this failure handler will be invoked with the reason for rejection. Using `.catch()` accomplishes the same thing as using a `.then()` with only a failure handler.

Let’s look an example using .catch():

	prom
	  .then((resolvedValue) => {
		console.log(resolvedValue);
	  })
	  .catch((rejectionReason) => {
		console.log(rejectionReason);
	  });
	  
### Chaining Multiple Promises

The process of chaining promises together is called composition. Promises are designed with composition in mind! Here’s a simple promise chain in code:

	firstPromiseFunction()
	.then((firstResolveVal) => {
	  return secondPromiseFunction(firstResolveVal);
	})
	.then((secondResolveVal) => {
	  console.log(secondResolveVal);
	});
	
In order for our chain to work properly, we had to `return` the promise `secondPromiseFunction(firstResolveVal)`. This ensured that the return value of the first `.then()` was our second promise rather than the default return of a new promise with the same settled value as the initial.

#### Example: 

	const checkInventory = (order) => {
	  return new Promise ((resolve, reject) => {
	   setTimeout(()=> {  
	   const itemsArr = order.items;  
	   let inStock = itemsArr.every(item => store[item[0]].inventory >= item[1]);
	   
	   if (inStock){
		 let total = 0;   
		 itemsArr.forEach(item => {
		   total += item[1] * store[item[0]].cost
		 });
		 console.log(`All of the items are in stock. The total cost of the order is ${total}.`);
		 resolve([order, total]);
	   } else {
		 reject(`The order could not be completed because some items are sold out.`);
	   }     
	}, generateRandomDelay());
	 });
	};

	const processPayment = (responseArray) => {
	  const order = responseArray[0];
	  const total = responseArray[1];
	  return new Promise ((resolve, reject) => {
	   setTimeout(()=> {  
	   let hasEnoughMoney = order.giftcardBalance >= total;
	   // For simplicity we've omited a lot of functionality
	   // If we were making more realistic code, we would want to update the giftcardBalance and the inventory
	   if (hasEnoughMoney) {
		 console.log(`Payment processed with giftcard. Generating shipping label.`);
		 let trackingNum = generateTrackingNumber();
		 resolve([order, trackingNum]);
	   } else {
		 reject(`Cannot process order: giftcard balance was insufficient.`);
	   }	   
	}, generateRandomDelay());
	 });
	};

	const shipOrder = (responseArray) => {
	  const order = responseArray[0];
	  const trackingNum = responseArray[1];
	  return new Promise ((resolve, reject) => {
	   setTimeout(()=> {  
		 resolve(`The order has been shipped. The tracking number is: ${trackingNum}.`);
	}, generateRandomDelay());
	 });
	};

	function generateTrackingNumber() {
	  return Math.floor(Math.random() * 1000000);
	}

	function generateRandomDelay() {
	  return Math.floor(Math.random() * 2000);
	}
	
**Consuming the promises:**

	checkInventory(order)
	.then((resolvedValueArray) => {
	  return processPayment(resolvedValueArray);
	})
	.then((resolvedValueArray) => {
	  return shipOrder(resolvedValueArray);
	})
	.then((successMessage) => {
	  console.log(successMessage);
	})
	.catch((errorMessage) => {
	  console.log(errorMessage);
	});

### Avoiding Common Mistakes

Promise composition allows for much more readable code than the nested callback syntax that preceded it. However, it can still be easy to make mistakes.
 
Mistake 1: Nesting promises instead of chaining them.

	returnsFirstPromise()
	.then((firstResolveVal) => {
	  return returnsSecondValue(firstResolveVal)
		.then((secondResolveVal) => {
		  console.log(secondResolveVal);
		})
	})

Mistake 2: Forgetting to return a promise.

	returnsFirstPromise()
	.then((firstResolveVal) => {
	  returnsSecondValue(firstResolveVal)
	})
	.then((someVal) => {
	  console.log(someVal);
	})

### Using `Promise.all()`

To maximize efficiency we should use concurrency, multiple asynchronous operations happening together. With promises, we can do this with the function `Promise.all()`.

`Promise.all()` accepts an array of promises as its argument and returns a single promise. That single promise will settle in one of two ways:

* If every promise in the argument array resolves, the single promise returned from Promise.all() will resolve with an array containing the resolve value from each promise in the argument array.
* If any promise from the argument array rejects, the single promise returned from Promise.all() will immediately reject with the reason that promise rejected. This behavior is sometimes referred to as failing fast.

Let’s look at a code example:

	let myPromises = Promise.all([returnsPromOne(), returnsPromTwo(), returnsPromThree()]);

	myPromises
	  .then((arrayOfValues) => {
		console.log(arrayOfValues);
	  })
	  .catch((rejectionReason) => {
		console.log(rejectionReason);
	  });
	  
## ASYNC AWAIT

### Introduction

JavaScript is continually improving, and ES8 provides a new syntax for handling our asynchronous action, async...await. The async...await syntax allows us to write asynchronous code that reads similarly to traditional synchronous, imperative programs.

### The async Keyword

The async keyword is used to write functions that handle asynchronous actions. We wrap our asynchronous logic inside a function prepended with the async keyword. Then, we invoke that function.

	async function myFunc() {
	  // Function body here
	};

	myFunc();

We can also create async function expressions:

	const myFunc = async () => {
	  // Function body here
	};

	myFunc();

async functions always return a promise. This means we can use traditional promise syntax, like `.then()` and `.catch` with our async functions. An async function will return in one of three ways:

* If there’s nothing returned from the function, it will return a promise with a resolved value of undefined.
* If there’s a non-promise value returned from the function, it will return a promise resolved to that value.
* If a promise is returned from the function, it will simply return that promise.

### The await Operator

The await keyword can only be used inside an async function. await is an operator: it returns the resolved value of a promise. Since promises resolve in an indeterminate amount of time, await halts, or pauses, the execution of our async function until a given promise is resolved.

	async function asyncFuncExample(){
	  let resolvedValue = await myPromise();
	  console.log(resolvedValue);
	}

	asyncFuncExample();
	
### Handling Dependent Promises

Here’s how we’d write an async function to accomplish [Multiple Promises Chaining](#chaining-multiple-promises):

	async function asyncAwaitVersion() {
	 let firstValue = await returnsFirstPromise();
	 console.log(firstValue);
	 let secondValue = await returnsSecondPromise(firstValue);
	 console.log(secondValue);
	}
	
### Handling Errors

When `.catch()` is used with a long promise chain, there is no indication of where in the chain the error was thrown. This can make debugging challenging.

With async...await, we use try...catch statements for error handling. By using this syntax, not only are we able to handle errors in the same way we do with synchronous code, but we can also catch both synchronous and asynchronous errors. This makes for easier debugging!

	async function usingTryCatch() {
	 try {
	   let resolveValue = await asyncFunction('thing that will fail');
	   let secondValue = await secondAsyncFunction(resolveValue);
	 } catch (err) {
	   // Catches any errors in the try block
	   console.log(err);
	 }
	}

	usingTryCatch();

Remember, since async functions return promises we can still use native promise’s `.catch()` with an async function

	async function usingPromiseCatch() {
	   let resolveValue = await asyncFunction('thing that will fail');
	}

	let rejectedPromise = usingPromiseCatch();
	rejectedPromise.catch((rejectValue) => {
	console.log(rejectValue);
	})
	
### Handling Independent Promises

What if our async function contains multiple promises which are not dependent on the results of one another to execute?

	async function concurrent() {
		const firstPromise = firstAsyncThing();
		const secondPromise = secondAsyncThing();
		console.log(await firstPromise, await secondPromise);
	}

In our `concurrent()` function, both promises are constructed without using await. We then await each of their resolutions to print them to the console. This allows both promises’ asynchronous operations to run simultaneously.

Note: if we have multiple truly independent promises that we would like to execute fully in parallel, we must use individual `.then()` functions and avoid halting our execution with `await`.

### Await Promise.all()

We can pass an array of promises as the argument to `Promise.all()`, and it will return a single promise. This promise will resolve when all of the promises in the argument array have resolved. This promise’s resolve value will be an array containing the resolved values of each promise from the argument array.

	async function asyncPromAll() {
	  const resultArray = await Promise.all([asyncTask1(), asyncTask2(), asyncTask3(), asyncTask4()]);
	  for (let i = 0; i<resultArray.length; i++){
		console.log(resultArray[i]); 
	  }
	}

`Promise.all()` allows us to take advantage of asynchronicity— each of the four asynchronous tasks can process concurrently. `Promise.all()` also has the benefit of failing fast, meaning it won’t wait for the rest of the asynchronous actions to complete once any one has rejected. As soon as the first promise in the array rejects, the promise returned from `Promise.all()` will reject with that reason. As it was when working with native promises, `Promise.all()` is a good choice if multiple asynchronous tasks are all required, but none must wait for any other before executing.

## BROWSER COMPATIBILITY AND TRANSPILATION

**Transpilation is the process of converting one programming language to another.**

Two important tools for addressing browser compatibility issues.

* [caniuse.com](https://caniuse.com/) — A website that provides data on web browser compatibility for HTML, CSS, and JavaScript features.

* Babel — A Javascript library that you can use to convert new, unsupported JavaScript (ES6), into an older version (ES5) that is recognized by most modern browsers. 

#### Summary of Steps:
		
1. Initialize your project using npm init and create a directory called src
1. Install babel dependencies by running

		npm install babel-cli -D
		npm install babel-preset-env -D

1. Create a .babelrc file inside your project and add the following code inside it:

		{
		  "presets": ["env"]
		}

1. Add the following script to your scripts object in package.json: `"build": "babel src -d lib"`
1. Run `npm run build` whenever you want to transpile your code from your src to lib directories.

### 1. `npm init`

The first step is to place your ES6 JavaScript file in a directory called src. From your root directory, the path to the ES6 file is ./src/main.js

The initial JavaScript project file structure is:

	project
	|_ src
	|___ main.js

Before we install Babel, we need to setup our project to use the node package manager (npm). Developers use npm to access and manage Node packages. Node packages are directories that contain JavaScript code written by other developers. You can use these packages to reduce duplication of work and avoid bugs.

Before we can add Babel to our project directory, we need to run `npm init`. The `npm init` command creates a `package.json` file in the root directory.

A `package.json` file contains information about the current JavaScript project. Some of this information includes:

1. Metadata — This includes a project title, description, authors, and more.
1. A list of node packages required for the project — If another developer wants to run your project, npm looks inside package.json and downloads the packages in this list.
1. Key-value pairs for command line scripts — You can use npm to run these shorthand scripts to perform some process. In a later exercise, we will add a script that runs Babel and transpiles ES6 to ES5.

If you have Node installed on your computer, you can create a `package.json` file by typing `npm init` into the terminal.

The terminal prompts you to fill in fields for the project’s metadata (name, description, etc.)

You are not required to answer the prompts, though we recommend at minimum, you add your own title and description. If you don’t want to fill in a field, you can press enter. npm will leave fill these fields with default values or leave them empty when it creates the package.json file.

After you run `npm init` your directory structure will contain the following files and folders:

	project
	|_ src
	|___ main.js
	|_ package.json

### 2. Install Node Packages

We use the npm install command to install new Node packages locally. The install command creates a folder called node_modules and copies the package files to it. The install command also installs all of the dependencies for the given package.

To install Babel, we need to npm install two packages, babel-cli and babel-preset-env. However, npm installs over one hundred other packages that are dependencies for Babel to run properly.

We install Babel with the following two commands:

	$ npm install babel-cli -D
	$ npm install babel-preset-env -D

The babel-cli package includes command line Babel tools, and the babel-preset-env package has the code that maps any JavaScript feature, ES6 and above (ES6+), to ES5.

The `-D` flag instructs npm to add each package to a property called devDependencies in package.json. Once the project’s dependencies are listed in devDependencies, other developers can run your project without installing each package separately. Instead, they can simply run `npm install` — it instructs npm to look inside package.json and download all of the packages listed in devDependencies.

Once you npm install packages, you can find the Babel packages and all their dependencies in the node_modules folder. The new directory structure contains the following:

	project
	|_ node_modules
	|___ .bin
	|___ ...
	|_ src
	|___ main.js
	|_ package.json

The ... in the file structure above is a placeholder for 100+ packages that npm installed.

### 3. `.babelrc`

Now that you’ve downloaded the Babel packages, you need to specify the version of the source JavaScript code.

You can specify the initial JavaScript version inside of a file named `.babelrc`. In your root directory, you can run touch .babelrc to create this file.

Your project directory contains the following folders and files:

	project
	|_ node_modules
	|___ .bin
	|___ ...
	|_ src
	|___ main.js
	|_ .babelrc
	|_ package.json

Inside .babelrc you need to define the preset for your source JavaScript file. The preset specifies the version of your initial JavaScript file.

Usually, you want to transpile JavaScript code from versions ES6 and later (ES6+) to ES5. From this point on, we will refer to our source code as ES6+, because Ecma introduces new syntax with each new version of JavaScript.

To specify that we are transpiling code from an ES6+ source, we have to add the following JavaScript object into .babelrc:

	{
	  "presets": ["env"]
	}
	
When you run Babel, it looks in .babelrc to determine the version of the initial JavaScript file. In this case, `["env"]` instructs Babel to transpile any code from versions ES6 and later.

### 4. Babel Source Lib

We need to specify a script in package.json that initiates the ES6+ to ES5 transpilation.

Inside of the package.json file, there is a property named "scripts" that holds an object for specifying command line shortcuts. It looks like this:

	...
	"scripts": {
	  "test": "echo \"Error: no test specified\" && exit 1"
	}, ...

In the code above, the "scripts" property contains an object with one property called "test". Below the "test" property, we will add a script that runs Babel like this:

	...
	"scripts": {
	  "test": "echo \"Error: no test specified\" && exit 1",
	  "build": "babel src -d lib"
	}

In the "scripts" object above, we add a property called "build". The property’s value, "babel src -d lib", is a command line method that transpiles ES6+ code to ES5.

### 5. Build

From the command line, we type: `npm run build`

The command above runs the build script in package.json.

Babel writes the ES5 code to a file named main.js (it’s always the same name as the original file), inside of a folder called lib. The resulting directory structure is:

	project
	|_ lib
	|___ main.js
	|_ node_modules
	|___ .bin
	|___ ...
	|_ src
	|___ main.js
	|_ .babelrc
	|_ package.json

Notice, the directory contains a new folder named lib, with one file, called main.js.

The npm run build command will transpile all JavaScript files inside of the src folder. This is helpful as you build larger JavaScript projects — regardless of the number of JavaScript files, you only need to run one command (npm run build) to transpile all of your code.