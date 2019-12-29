<template>
    <ContentWrapper>
        <div class="content-heading">
            <div>Dashboard
            </div>
        </div>
        <!-- START cards box-->
        <div class="row">
            <div class="col-xl-3 col-md-6">
                <!-- START card-->
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-purple-dark justify-content-center rounded-left">
                        <em class="icon-globe fa-3x"></em>
                    </div>
                    <div class="col-8 py-3 bg-purple rounded-right">
                        <div class="h2 mt-0">{{officeCount.length}}
                        </div>
                        <div class="text-uppercase">Offices</div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6">
                <!-- START card-->
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-primary-dark justify-content-center rounded-left">
                        <em class="fas fa-users fa-3x"></em>
                    </div>
                    <div class="col-8 py-3 bg-primary rounded-right">
                        <div class="h2 mt-0">{{userCount.length}}</div>
                        <div class="text-uppercase">Users</div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-6 col-md-12">
                <!-- START card-->
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-green-dark justify-content-center rounded-left">
                        <em class="fas fa-toolbox fa-3x"></em>
                    </div>
                    <div class="col-8 py-3 bg-green rounded-right">
                        <div class="h2 mt-0">{{equipmentCount.length}}</div>
                        <div class="text-uppercase">Equipments</div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-6 col-md-12">
                <!-- START date widget-->
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-green justify-content-center rounded-left">
                        <div class="text-center">
                            <!-- See formats: https://docs.angularjs.org/api/ng/filter/date-->
                            <Now class="text-sm" format="MMMM"></Now>
                            <br>
                            <Now class="h2 mt-0" format="D"></Now>
                        </div>
                    </div>
                    <div class="col-8 py-3 rounded-right">
                        <Now class="text-uppercase" format="dddd"></Now>
                        <br>
                        <Now class="h2 mt-0" format="h:mm"></Now>
                        <Now class="text-muted text-sm" format="a"></Now> EST
                    </div>
                </div>
                <!-- END date widget-->
            </div>
        </div>
        <div class="row">
            <div class="col-xl-3 col-lg-6 col-md-12">
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-purple-dark justify-content-center rounded-left">
                        <em class="fas fa-users fa-3x"></em>
                    </div>
                    <div class="col-8 py-3 bg-purple rounded-right">
                        <div class="h2 mt-0">{{americaUserCount}}
                        </div>
                        <div class="text-uppercase">America</div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6">
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-primary-dark justify-content-center rounded-left">
                        <em class="fas fa-users fa-3x"></em>
                    </div>
                    <div class="col-8 py-3 bg-primary rounded-right">
                        <div class="h2 mt-0">{{europeUserCount}}</div>
                        <div class="text-uppercase">Europe</div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-6 col-md-12">
                <div class="card flex-row align-items-center align-items-stretch border-0">
                    <div class="col-4 d-flex align-items-center bg-green-dark justify-content-center rounded-left">
                        <em class="fas fa-users fa-3x"></em>
                    </div>
                    <div class="col-8 py-3 bg-green rounded-right">
                        <div class="h2 mt-0">{{asiaUserCount}}</div>
                        <div class="text-uppercase">Asia</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END cards box-->
        <div class="row">
            <!-- START dashboard main content-->
            <div class="col-xl-9">
                <!-- START chart-->
                <div class="row">
                    <div class="col-xl-12">
                        <!-- START card-->
                        <div class="card card-default card-demo" id="cardChart9">
                            <div class="card-header">
                                <CardTool refresh :onRefresh="onRefresh"/>
                                <div class="card-title">Inbound visitor statistics</div>
                            </div>
                            <div class="card-body">
                                <FlotChart :data="flotData" :options="flotOptions" height="250px" />
                            </div>
                        </div>
                        <!-- END card-->
                    </div>
                </div>
                <!-- END chart-->
                <div class="row">
                    <div class="col-xl-12">
                        <div class="card border-0">
                            <div class="row row-flush">
                                <div class="col-lg-2 col-md-3 col-6 bg-info py-4 d-flex align-items-center justify-content-center rounded-left">
                                    <em class="wi wi-day-sunny fa-4x"></em>
                                </div>
                                <div class="col-lg-2 col-md-3 col-6 py-2 br d-flex align-items-center justify-content-center">
                                    <div>
                                        <div class="h1 m-0 text-bold">32&deg;</div>
                                        <div class="text-uppercase">Clear</div>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-3 d-none d-md-block py-2 text-center br">
                                    <div class="text-info text-sm">10 AM</div>
                                    <div class="text-muted text-md">
                                        <em class="wi wi-day-cloudy"></em>
                                    </div>
                                    <div class="text-info">
                                        <span class="text-muted">20%</span>
                                    </div>
                                    <div class="text-muted">27&deg;</div>
                                </div>
                                <div class="col-lg-2 col-md-3 d-none d-md-block py-2 text-center br">
                                    <div class="text-info text-sm">11 AM</div>
                                    <div class="text-muted text-md">
                                        <em class="wi wi-day-cloudy"></em>
                                    </div>
                                    <div class="text-info">
                                        <span class="text-muted">30%</span>
                                    </div>
                                    <div class="text-muted">28&deg;</div>
                                </div>
                                <div class="col-lg-2 py-2 text-center br d-none d-lg-block">
                                    <div class="text-info text-sm">12 PM</div>
                                    <div class="text-muted text-md">
                                        <em class="wi wi-day-cloudy"></em>
                                    </div>
                                    <div class="text-info">
                                        <span class="text-muted">20%</span>
                                    </div>
                                    <div class="text-muted">30&deg;</div>
                                </div>
                                <div class="col-lg-2 py-2 text-center d-none d-lg-block">
                                    <div class="text-info text-sm">1 PM</div>
                                    <div class="text-muted text-md">
                                        <em class="wi wi-day-sunny-overcast"></em>
                                    </div>
                                    <div class="text-info">
                                        <span class="text-muted">0%</span>
                                    </div>
                                    <div class="text-muted">30&deg;</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- END dashboard main content-->
            <!-- START dashboard sidebar-->
            <aside class="col-xl-3">
                <!-- START loader widget-->
                <div class="card card-default">
                    <div class="card-body">
                        <a class="text-muted float-right" href="#">
                   <em class="fa fa-arrow-right"></em>
                </a>
                        <div class="text-info">Average Monthly Uploads</div>
                        <div class="text-center py-4">
                            <div ref="easypie" class="easypie-chart easypie-chart-lg" data-percent="70">
                                <span>70%</span>
                            </div>
                        </div>
                        <Sparkline :options="{
                                barColor:'#23b7e5',
                                height:30,
                                barWidth:5,
                                barSpacing:2
                            }"
                            :values="[5,4,8,7,8,5,4,6,5,5,9,4,6,3,4,7,5,4,7]"
                            class="text-center"/>
                    </div>
                    <div class="card-footer">
                        <p class="text-muted">
                            <em class="fa fa-upload fa-fw"></em>
                            <span>This Month</span>
                            <span class="text-dark">1000 Gb</span>
                        </p>
                    </div>
                </div>
                <!-- END loader widget-->

            </aside>
            <!-- END dashboard sidebar-->
        </div>
    </ContentWrapper>
</template>

<script>

    import EasyPieChart from 'easy-pie-chart';

    import CardTool from '@/components/Common/CardTool'
    import Sparkline from '@/components/Common/Sparklines';
    import Scrollable from '@/components/Common/Scrollable'
    import FlotChart from '@/components/Charts/Flot';
    import Now from '@/components/Common/Now';

    import Offices from '../../service/common/OfficeDataService'
    import Users from '../../service/common/UserDataService'
    import Equipments from '../../service/common/EquipmentDataService'

    export default {
        name: 'DashboardV1',
        components: {
            CardTool,
            Sparkline,
            Scrollable,
            FlotChart,
            Now
        },
        data() {
            return {
                officeCount: [],
                userCount: [],
                equipmentCount: [],
                americaUserCount: 950,
                europeUserCount: 1300,
                asiaUserCount: 1200,
                flotData: [{
                    "label": "Uniques",
                    "color": "#768294",
                    "data": [
                        ["Mar", 70],["Apr", 85],["May", 59],["Jun", 93],["Jul", 66],["Aug", 86],["Sep", 60]
                    ]
                }, {
                    "label": "Recurrent",
                    "color": "#1f92fe",
                    "data": [
                        ["Mar", 21],["Apr", 12],["May", 27],["Jun", 24],["Jul", 16],["Aug", 39],["Sep", 15]
                    ]
                }],
                flotOptions: {
                    series: {
                        lines: {
                            show: false
                        },
                        points: {
                            show: true,
                            radius: 4
                        },
                        splines: {
                            show: true,
                            tension: 0.4,
                            lineWidth: 1,
                            fill: 0.5
                        }
                    },
                    grid: {
                        borderColor: '#eee',
                        borderWidth: 1,
                        hoverable: true,
                        backgroundColor: '#fcfcfc'
                    },
                    tooltip: true,
                    tooltipOpts: {
                        content: (label, x, y) => x + ' : ' + y
                    },
                    xaxis: {
                        tickColor: '#fcfcfc',
                        mode: 'categories'
                    },
                    yaxis: {
                        min: 0,
                        max: 150, // optional: use it for a clear represetation
                        tickColor: '#eee',
                        //position: 'right' or 'left',
                        tickFormatter: v => v /* + ' visitors'*/
                    },
                    shadowSize: 0
                },
            }
        },
        mounted() {
            // Easy pie
            let pieOptions1 = {
                animate: {
                    duration: 800,
                    enabled: true
                },
                barColor: '#23b7e5',
                trackColor: 'rgba(200,200,200,0.4)',
                scaleColor: false,
                lineWidth: 10,
                lineCap: 'round',
                size: 145 
            };
            new EasyPieChart(this.$refs.easypie, pieOptions1);
        },
        methods: {
            changeLanguage (lang) {
                this.$i18n.i18next.changeLanguage(lang);
            },
            onRefresh (_,done) {
                setTimeout(done, 2000)
            },
            async getUsers(){
                console.log("getUsers");
                const promise = Users.getAllUsers();
                promise.then(result => {
                this.userCount = result;
                });
                console.log("getUsers end");
            },
            async getOffices(){
                const promise = Offices.getAllOffices();
                promise.then(result => {
                this.officeCount = result;
                });
            },
            async getEquipment(){
                const promise = Equipments.getAllEquipments();
                promise.then(result => {
                this.equipmentCount = result;
                });
            }
        },
        computed: {
        },
        created() {
            this.getUsers();
            this.getOffices();
            this.getEquipment();
        }
    }

</script>
