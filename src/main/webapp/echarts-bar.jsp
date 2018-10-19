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


</script>
<%--菜单--%>
<jsp:include page="menu.jsp" flush="true"/>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

<div style="width:600px;height: 400px;">
    <div id="WorldMap" ></div>
</div>

<script type="text/javascript">
    var worldMapContainer = document.getElementById('WorldMap');

    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeWorldMapContainer = function () {
        var width=worldMapContainer.parentNode.clientWidth + 'px';
        worldMapContainer.style.width = width;
        var height=worldMapContainer.parentNode.clientHeight + 'px';
        worldMapContainer.style.height = height;
    };
    //设置容器高宽
    resizeWorldMapContainer();
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(worldMapContainer);

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data: ['销量'],
            height: worldMapContainer.style.height,
            width: worldMapContainer.style.width
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            data: ["啊打发打发打发的说法的说法都是衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
        },
        xAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    //用于使chart自适应高度和宽度
    window.onresize = function () {
        //重置容器高宽
        resizeWorldMapContainer();
        myChart.resize();
    };
</script>

</body>
</html>
