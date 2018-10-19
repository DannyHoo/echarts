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

<script type="text/javascript">

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'), 'macarons');

    // 指定图表的配置项和数据
    /*var option = {
        title: {
            text: '某地区蒸发量和降水量',
            subtext: '纯属虚构'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function (params) {

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
                res += params[1].seriesName + "：" + percent;
                return res;

            }
        },
        legend: {
            data: ['蒸发量', '百分比']
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
                type: 'category',
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '蒸发量',
                type: 'bar',
                data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                /!*markPoint: {
                 data: [
                 {type: 'max', name: '最大值'},
                 {type: 'min', name: '最小值'}
                 ]
                 },*!/
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '百分比',
                type: 'line',
                data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                /!*markPoint: {
                 data: [
                 {type: 'max', name: '最大值'},
                 {type: 'min', name: '最小值'}
                 ]
                 },*!/
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }
        ]
    };*/

    var option ={"calculable": true,"title": {"text": "客户职业分布","subtext": "实时统计"},"toolbox": {"feature": {},"show": true},"tooltip": {"trigger": "axis","formatter": function(params) {var tooltipName=params[0].name;var res= tooltipName+"<br/>"+params[0].seriesName+"："+params[0].data+"<br/>";var myseries = option.series;var data=myseries[0].data;var total=0;for (var i = 0; i < data.length; i++) {total+=data[i];}var percent=params[0].data/total;percent=Number(percent*100).toFixed(2)+"%";res+=params[1].seriesName+"："+percent;return res;}},"legend": {"data": ["人数","占比"]},"xAxis": [{"type": "category","data": ["会计","教师","厨师","理发师","司机","程序员"]}],"yAxis": [{"type": "value"}],"series": [{"name": "人数","type": "bar","markPoint": {"data": [{"name": "最大值","type": "max"},{"name": "最小值","type": "min"}]},"markLine": {"data": [{"name": "平均值","type": "average"}]},"data": [20,25,30,15,10,40]},{"name": "占比","type": "line","markPoint": {"data": [{"name": "最大值","type": "max"},{"name": "最小值","type": "min"}]},"markLine": {"data": [{"name": "平均值","type": "average"}]},"data": [20,25,30,15,10,40]}]};

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>

</body>
</html>
