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
<jsp:include page="/echarts/menu.jsp" flush="true"/>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'),'macarons');

    function loadMap(dataUrl) {
        myChart.clear();
        myChart.showLoading({text: '正在努力的读取数据中...'});
        $.ajax({
            type: "GET",
            url: dataUrl,
            dataType: "text",
            data: {},
            async: false,
            success: function(data) {
                var option=eval('(' + data + ')');
                myChart.setOption(option, true);//data.data
                myChart.hideLoading();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });

    }

    // 使用刚指定的配置项和数据显示图表。
    loadMap("/echarts/line_bar/getData_EChartsLineBar");


</script>

</body>
</html>
