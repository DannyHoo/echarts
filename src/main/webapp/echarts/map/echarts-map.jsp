<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
</head>

<body>

<%--菜单--%>
<jsp:include page="/echarts/menu.jsp" flush="true"/>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script src="http://echarts.baidu.com/asset/map/js/china.js"></script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'), 'macarons');

    function loadMap() {
        myChart.clear();
        myChart.showLoading({text: '正在努力的读取数据中...'});
        $.getJSON('/echarts/map/getData_EChartsMap', function (data) {
            if (true) {//data.success
                myChart.setOption(data, true);//data.data
                myChart.hideLoading();
            } else {
                alert('提示', data.msg);
            }
        });
    }

    // 使用刚指定的配置项和数据显示图表。
    loadMap();

</script>
</body>

</html>
