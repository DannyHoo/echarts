<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="https://cdn.bootcss.com/echarts/3.7.1/echarts.min.js"></script>
</head>

<body>

<%--菜单--%>
<jsp:include page="menu.jsp" flush="true"/>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script src="http://echarts.baidu.com/asset/map/js/china.js"></script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'),'macarons');

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '客户区域分布',
            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {//气泡提示框，常用于展现更详细的数据
            trigger: 'item',
            formatter: function(params) {
                var tooltipName=params.data.name;
                var tooltipValue=params.data.value==undefined?0:params.data.value;
                var res= tooltipName+"<br/>"+"合同数："+tooltipValue+"<br/>";
                var myseries = option.series;var data=myseries[0].data;
                var total=0;
                for (var i = 0; i < data.length; i++) {
                    total+=data[i].value;
                }
                var percent=total==0?0:tooltipValue/total;
                percent=Number(percent*100).toFixed(2)+"%";
                res+="占比："+"："+percent;
                return res;
            }
            /*,
            show: true,
            formatter: '{c}', //提示标签格式(不同标签值不同，可以用a、b、c……标识)
            backgroundColor: "#ff7f50",//提示标签背景颜色
            textStyle: {color: "#fff"} //提示标签字体颜色*/
        },
        legend: {//图例，表述数据和图形的关联
            orient: 'vertical',
            x: 'left',
            data: ['客户区域分布', 'iphone4', 'iphone5']//对应于series/name的值
        },
        visualMap: {//(3.0叫visualMap；2.0叫dataRange)值域选择范围
            show: true, //不显示值域选择范围
            min: 0,
            max: 2500,
            x: 'left',
            y: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true    //是否启用拖拽重计算特性，默认关闭
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            x: 'right',
            y: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        roamController: {//缩放漫游组件，搭配地图使用
            show: true,
            x: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series: [//数据系列，一个图表可能包含多个系列，每一个系列可能包含多个数据
            {
                name: '客户区域分布',
                type: 'map',
                mapType: 'china',
                roam: false,
                /*mapLocation: {
                    x: 'center',
                    y: 'center'
                    // width    // 自适应
                    // height   // 自适应
                },*/
                label: {
                    normal: {
                        show: true,//显示省份标签
                        textStyle: {color: "#c71585"}//省份标签字体颜色
                    },
                    emphasis: {//对应的鼠标悬浮效果
                        show: true,
                        textStyle: {color: "#800080"}
                    }
                },
                showLegendSymbol:true,// 显示图例颜色标识（系列标识的小圆点），存在legend时生效
                itemStyle: {
                    normal: {
                        color: 'rgba(255,0,255,0.8)', //刚才说的图例颜色设置
                        borderColor: '#009fe8',//区域边框颜色
                        areaColor: "#E3E3E3",//区域背景颜色(该区域没有数据时的默认颜色)
                        borderWidth: 0.5,//区域边框宽度
                        areaStyle: {
                            color: '#ccc'//rgba(135,206,250,0.8)或者#ccc
                        },
                        label: {
                            show: true,
                            textStyle: {
                                color: '#ccc'//rgba(135,206,250,0.8)或者#ccc
                            }
                        }
                    },
                    emphasis: {
                        color: 'rgba(255,0,255,0.8)', //刚才说的图例颜色设置
                        borderColor: '#4b0082',
                        borderWidth: .5,
                        areaColor:"#09F7F7",
                        areaStyle: {
                            color: '#ccc'//rgba(135,206,250,0.8)或者#ccc
                        },
                        label: {
                            show: true,
                            textStyle: {
                                color: "#ccc"
                            }
                        }
                    }
                },
                data: [
                    {name: '北京', value: 2500},
                    {name: '天津', value: 2400},
                    {name: '上海', value: 2360},
                    {name: '重庆', value: 400},
                    {name: '河北', value: 2115},
                    {name: '河南', value: 366},
                    {name: '云南', value: 450},
                    {name: '辽宁', value: 540},
                    {name: '黑龙江', value: 170},
                    {name: '湖南', value: 280},
                    {name: '安徽', value: 220},
                    {name: '山东', value: 345},
                    {name: '新疆', value: 98},
                    {name: '江苏', value: 410},
                    {name: '浙江', value: 440},
                    {name: '江西', value: 178},
                    {name: '湖北', value: 278},
                    {name: '广西', value: 111},
                    {name: '甘肃', value: 90},
                    {name: '山西', value: 600},
                    {name: '内蒙古', value: 30},
                    {name: '陕西', value: 109},
                    {name: '吉林', value: 1000},
                    {name: '福建', value: 908},
                    {name: '贵州', value: 9},
                    {name: '广东', value: 109},
                    {name: '青海', value: 220},
                    {name: '西藏', value: 130},
                    {name: '四川', value: 770},
                    {name: '宁夏', value: 1309},
                    {name: '海南', value: 070},
                    {name: '台湾', value: 08},
                    {name: '香港', value: 09},
                    {name: '澳门', value: 2200}
                ]
            },
            /*{
             name: 'iphone4',
             type: 'map',
             mapType: 'china',
             itemStyle:{
             normal:{label:{show:true}},
             emphasis:{label:{show:true}}
             },
             data:[
             {name: '北京',value: Math.round(Math.random()*1000)},
             {name: '天津',value: Math.round(Math.random()*1000)},
             {name: '上海',value: Math.round(Math.random()*1000)},
             {name: '重庆',value: Math.round(Math.random()*1000)},
             {name: '河北',value: Math.round(Math.random()*1000)},
             {name: '安徽',value: Math.round(Math.random()*1000)},
             {name: '新疆',value: Math.round(Math.random()*1000)},
             {name: '浙江',value: Math.round(Math.random()*1000)},
             {name: '江西',value: Math.round(Math.random()*1000)},
             {name: '山西',value: Math.round(Math.random()*1000)},
             {name: '内蒙古',value: Math.round(Math.random()*1000)},
             {name: '吉林',value: Math.round(Math.random()*1000)},
             {name: '福建',value: Math.round(Math.random()*1000)},
             {name: '广东',value: Math.round(Math.random()*1000)},
             {name: '西藏',value: Math.round(Math.random()*1000)},
             {name: '四川',value: Math.round(Math.random()*1000)},
             {name: '宁夏',value: Math.round(Math.random()*1000)},
             {name: '香港',value: Math.round(Math.random()*1000)},
             {name: '澳门',value: Math.round(Math.random()*1000)}
             ]
             },
             {
             name: 'iphone5',
             type: 'map',
             mapType: 'china',
             itemStyle:{
             normal:{label:{show:true}},
             emphasis:{label:{show:true}}
             },
             data:[
             {name: '北京',value: Math.round(Math.random()*1000)},
             {name: '天津',value: Math.round(Math.random()*1000)},
             {name: '上海',value: Math.round(Math.random()*1000)},
             {name: '广东',value: Math.round(Math.random()*1000)},
             {name: '台湾',value: Math.round(Math.random()*1000)},
             {name: '香港',value: Math.round(Math.random()*1000)},
             {name: '澳门',value: Math.round(Math.random()*1000)}
             ]
             }*/
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

</script>
</body>

</html>
