<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="https://cdn.bootcss.com/echarts/3.7.1/echarts.min.js"></script>
</head>

<body>


<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'), 'macarons');

    // 指定图表的配置项和数据
    var option =
    {"calculable": true,"toolbox": {"feature": {},"show": true},"tooltip": {"trigger": "axis","formatter": function(params) {var tooltipName=params[0].name;var res= tooltipName+"<br/>"+params[0].seriesName+"："+params[0].data+"<br/>";var myseries = option.series;var data=myseries[0].data;var total=0;for (var i = 0; i < data.length; i++) {total+=data[i];}var percent=params[0].data/total;percent=Number(percent*100).toFixed(2)+"%";res+='占比'+"："+percent;return res;}},"legend": {"data": ["合同数"]},"grid": {"containLabel": true,"left": "3%","right": "4%","bottom": "3%"},"xAxis": [{"type": "value"}],"yAxis": [{"type": "category","axisLabel": {"interval": 0},"data": ["审核通过","已发布","合作中"]}],"series": [{"name": "合同数","type": "bar","data": [4,1,3]}]};

    //var option = eval("(" + echartsInitCode + ")");

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option,true);

</script>
</body>

</html>
