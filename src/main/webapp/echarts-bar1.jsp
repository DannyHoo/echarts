<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="https://cdn.bootcss.com/echarts/3.7.1/echarts.min.js"></script>

</head>

<body>
<input type="text" id="txtSearch">
<input type="submit" id="su" value="查询" class="bg s_btn">

<script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
    $("#su").click(function () {
        var txt = $("#txtSearch").val();
        var res = [{id: "1", value: "厚朴"}, {id: "2", value: "联想"}]
        for (i = 0; i < res.length; i++) {
            var tempProjectName = res[i].value;
            if (tempProjectName == txt) {
                alert("projectNo=" + res[i].id)
                return false;
            }
        }
        alert("该项目不存在");
    });


</script>
<%--菜单--%>
<jsp:include page="menu.jsp" flush="true"/>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style=""></div>

<script type="text/javascript">
    var echartsContainer = document.getElementById('main');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeWorldMapContainer = function (containerId) {
        echartsContainer.style.width = echartsContainer.clientWidth + 'px';
        echartsContainer.style.height = echartsContainer.clientHeight + 'px';
    };

    // 基于准备好的dom，初始化echarts实例
    //var myChart = echarts.init(document.getElementById('main'), 'macarons');
    var myChart = echarts.init(echartsContainer, 'macarons');

    // 指定图表的配置项和数据
    /*var option = {
     title: {
     text: '某地区蒸发量和降水量',
     subtext: '纯属虚构'
     },
     tooltip: {
     trigger: 'axis'
     },
     legend: {
     data: ['蒸发量', '降水量']
     },
     toolbox: {
     show: true,
     feature: {
     mark: {show: true},
     dataView: {show: true, readOnly: false},
     magicType: {show: true, type: ['line', 'bar']},
     restore: {show: true},
     saveAsImage: {show: true}
     }
     },
     calculable: true,
     xAxis: [
     {
     type: 'value'
     }
     ],
     yAxis: [
     {
     type: 'category',
     data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
     }
     ],
     series: [
     {
     name: '蒸发量',
     type: 'bar',
     data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
     markPoint: {
     data: [
     {type: 'max', name: '最大值'},
     {type: 'min', name: '最小值'}
     ]
     },
     markLine: {
     data: [
     {type: 'average', name: '平均值'}
     ]
     }
     }
     /!*{
     name: '蒸发量',
     type: 'bar',
     data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
     markPoint: {
     data: [
     {type: 'max', name: '最大值'},
     {type: 'min', name: '最小值'}
     ]
     },
     markLine: {
     data: [
     {type: 'average', name: '平均值'}
     ]
     }
     },
     {
     name: '降水量',
     type: 'bar',
     data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
     markPoint: {
     data: [
     {name: '年最高', value: 182.2, xAxis: 7, yAxis: 183, symbolSize: 18},
     {name: '年最低', value: 2.3, xAxis: 11, yAxis: 3}
     ]
     },
     markLine: {
     data: [
     {type: 'average', name: '平均值'}
     ]
     }
     }*!/
     ]
     };*/

    /*var option={"toolbox": {"feature": {},"orient": "vertical","show": true,"left": "right","top": "center"},"tooltip": {"trigger": "item"},"series": [{"mapType": "china","roam": false,"type": "map","label": {"normal": {"show": true},"emphasis": {"show": true}},"data": [{"name": "北京","value": 1},{"name": "河北","value": 1},{"name": "合计","value": 2}]}],"visualMap": [{"min": 0,"max": 200,"calculable": true,"orient": "horizontal","text": ["高","低"],"x": "center","y": "top"}]};*/

    /*var option = {
     title: {
     text: '客户区域分布',
     subtext: '纯属虚构',
     x: 'center'
     },
     tooltip: {//气泡提示框，常用于展现更详细的数据
     trigger: 'item',
     formatter: function(params) {
     var ps=params;
     var tooltipName=params[0].name;
     /!*var res= tooltipName+"<br/>"+params[0].seriesName+"："+params[0].data+"<br/>";
     var myseries = option.series;var data=myseries[0].data;
     var total=0;
     for (var i = 0; i < data.length; i++) {
     total+=data[i];
     }
     var percent=params[0].data/total;
     percent=Number(percent*100).toFixed(2)+"%";
     res+=params[1].seriesName+"："+percent;
     return res;*!/
     }
     /!*,
     show: true,
     formatter: '{c}', //提示标签格式(不同标签值不同，可以用a、b、c……标识)
     backgroundColor: "#ff7f50",//提示标签背景颜色
     textStyle: {color: "#fff"} //提示标签字体颜色*!/
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
     /!*mapLocation: {
     x: 'center',
     y: 'center'
     // width    // 自适应
     // height   // 自适应
     },*!/
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
     /!*{
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
     }*!/
     ]
     };*/

    var option = {
        "calculable": true,
        "toolbox": {"feature": {}, "show": true},
        "tooltip": {
            "trigger": "axis", "formatter": function (params) {
                var tooltipName = params[0].name;
                var res = tooltipName + "<br/>" + params[0].seriesName + "：" + params[0].data + "<br/>";
                var myseries = option.series;
                var data = myseries[0].data;
                var total = 0;
                for (var i = 0; i < data.length; i++) {
                    total += data[i];
                }
                var percent = params[0].data / total;
                percent = Number(percent * 100).toFixed(2) + "%";
                res += '占比' + "：" + percent;
                return res;
            }
        },
        "legend": {"data": ["合同数"]},
        "xAxis": [{"type": "value"}],
        "yAxis": [
            {
                "type": "category",
                "data": ["专业技术人员", "办事人员和有关人员", "生产、运输设备操作人员及有关人员", "军人", "合计"]/*,
             "axisLabel": {
             formatter: function (val) {
             var result = val;
             result = newLinef(val, 4);
             console.log(result);
             return result;
             }
             }*/
            }
        ],
        "series": [
            {
                "name": "合同数",
                "type": "bar",
                "data": [3, 1, 2, 1, 7]
            }
        ],
        grid: { // 控制图的大小，调整下面这些值就可以，
            x: 260,
            x2: 50,
            y2: 50// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
        }

    };
    newline(option, 4, "yAxis");
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    function newLinef(str, len) {
        var reg = /\s{1,}/g;
        var res = "";
        var strArray = new Array();
        var lastPoint = 0;
        //去除空格
        str = str.replace(reg, "");
        for (var i = 0; i < str.length; i++) {
            if ((i + 1) % len == 0) {
                lastPoint = i;
                strArray.push(str.substr(i - 3, len));
                res += str.substr(i - 3, len);
                res += "\n";
            } else if (i == str.length - 1 && str.length >= len) {
                strArray.push(str.substring(lastPoint + 1, i + 1));
                res += str.substring(lastPoint + 1, i + 1);
            } else if (i == str.length - 1 && str.length < len) {
                strArray.push(str.substring(lastPoint, i + 1));
                res += str.substring(lastPoint, i + 1);
            }
        }
        alert(res);
        return res;
    }


    function newline(option, number, axis) {
        /* 此处注意你的json是数组还是对象 */
        option[axis][0]['axisLabel'] = {
            interval: 0,
            formatter: function (params) {
                var newParamsName = "";
                var paramsNameNumber = params.length;
                var provideNumber = number;
                var rowNumber = Math.ceil(paramsNameNumber / provideNumber);
                if (paramsNameNumber > provideNumber) {
                    for (var p = 0; p < rowNumber; p++) {
                        var tempStr = "";
                        var start = p * provideNumber;
                        var end = start + provideNumber;
                        if (p == rowNumber - 1) {
                            tempStr = params.substring(start, paramsNameNumber);
                        } else {
                            tempStr = params.substring(start, end) + "\n";
                        }
                        newParamsName += tempStr;
                    }
                } else {
                    newParamsName = params;
                }
                return newParamsName
            }
        }
        return option;
    }

    //用于使chart自适应高度和宽度
    window.onresize = function () {
        //重置容器高宽
        resizeWorldMapContainer();
        myChart.resize();
    };
</script>

</body>
</html>
