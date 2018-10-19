<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%--https://blog.csdn.net/zqx20032009/article/details/78591786--%>
    <meta charset="utf-8">
    <script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
    <!-- 引入 ECharts 文件 -->
    <script src="/js/echarts3.7.1/echarts.min.js"></script>
    <script>
        //全局变量start
        var tagNos = new Array(); // 存放标签的卡号
        var data = []; // 存放温度数据
        var tagCount = 30; // 默认创建20
        var date = []; // 存放当前的时分秒
        var day = 30;  // 定义x轴的坐标刻度15
        var cardNos = []; // 从后台请求的卡号数据
        var param = [];   // 从后台请求的卡号数据作为形参
        var temperatures = [];  // 从后台获取的温度
        var createDates = [];  // 从后台获取的时间
        // 全局变量end


        // 创建data对象数组
        for (var i = 0; i < tagCount; i++) {
            data[i] = new Array();
        }


        //定义x轴的坐标刻度
        for (var i = 0; i < day; i++) {
            addData();
        }
        // 去除字符串的前后空格
        function trim(str) {
            if ("undefined" == typeof (str) || null == str || str.length < 1) {
                return str;
            } else if (str.length > 0) {
                return str.replace(/\s/g, "");
            }
        }

        // 获取不重复的卡号加入到折线图中
        function getArray(param) {
            var same = new Array();
            if (null == tagNos[0]) {
                for (var i = 0; i < param.length && null != param[i]; i++) {
                    tagNos[i] = trim(param[i]);
                }
                return tagNos;
            }

            for (var i = 0; i < tagNos.length && "undefined" != typeof(tagNos[i]); i++) {
                for (var j = 0; j < param.length; j++) {
                    if (tagNos[i] == trim(param[j])) {
                        for (var k = 0; k < (tagNos.length + param.length) / 2; k++) {
                            if (null == same[k]) {
                                same[k] = tagNos[i];
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            var flag = false;
            for (var i = 0; i < param.length; i++) {
                for (var j = 0; j < same.length; j++) {
                    if ("undefined" != typeof(param[i]) && trim(param[i]) == same[j]) {
                        param[i] = null;
                        break;
                    }
                }
            }
            var result = 0;
            for (var i = 0; i < tagCount; i++) {
                if ("undefined" == typeof(tagNos[i]) || null == tagNos[i]) {
                    for (var j = result; j < tagCount && null != param[j] || "undefined" != typeof(param[i]); j++) {
                        tagNos[i] = trim(param[j]);
                        result += 1;
                        break;
                    }
                }
            }
            return tagNos;
        }


        // 获取当前的时分秒
        function getCurrentTime() {
            var date = new Date();// 实例一个时间对象；
            var year = date.getFullYear();// 获取系统的年；
            var month = date.getMonth() + 1;// 获取系统月份，由于月份是从0开始计算，所以要加1
            var day = date.getDate();
            var hour = date.getHours();// 获取系统时间
            hour = hour <= 9 ? '0' + hour : hour;
            var minute = date.getMinutes(); // 分
            minute = minute <= 9 ? '0' + minute : minute;
            var second = date.getSeconds();// 秒
            second = second <= 9 ? '0' + second : second;
            return hour + ':' + minute + ':' + second;
        }


        // 获取更新数据
        function addData(shift) {
            date.push(getCurrentTime());
            console.log(date)
            var tempTagNos = [];
            var tempTemperatures = [];
            getArray(param);
            for (var i = 0; i < tagNos.length; i++) {
                if (cardNos.length > 0) {
                    for (var j = 0; j < cardNos.length; j++) {
                        cardNos[j] = trim(cardNos[j]);
                        if (tagNos[i] == cardNos[j]) {
                            tempTagNos[i] = cardNos[j];
                            tempTemperatures[i] = temperatures[j];
                            break;
                        }
                    }
                }
            }
            for (var i = 0; i < tagCount; i++) {
                cardNos[i] = tempTagNos[i];
                if ("undefined" == typeof(tempTemperatures[i])) {
                    data[i].push(null);
                } else {
                    data[i].push(tempTemperatures[i]);
                }
            }


            if (shift) {
                //console.log(data);
                console.log(data.length);
                date.shift();
                for (var i = 0; i < tagCount; i++) {
                    data[i].shift();
                }
            }
        }

        /*js实现sleep功能 单位：毫秒*/
        function sleep(numberMillis) {
            var now = new Date();
            var exitTime = now.getTime() + numberMillis;
            while (true) {
                now = new Date();
                if (now.getTime() > exitTime)
                    return;
            }
        }

        // 从后台请求数据
        function requestData() {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/dynamic-line-data",
                success: function (json) {// 返回的result为json格式的数据
//json = [{"id":750273,"cardNo":" 8C 07 ED 51 78 E8 00 00 00 00 00 00","createDate":"2017-11-21 11:36:30.007","temperature":24},{"id":750274,"cardNo":" 8C A7 C5 58 F9 20 00 00 00 00 00 0E","createDate":"2017-11-21 11:36:30.07","temperature":22.4},{"id":750275,"cardNo":" 8B F8 31 4B 59 00 00 00 00 00 01 97","createDate":"2017-11-21 11:36:30.09","temperature":23.9}]
                    cardNos = [];
                    temperatures = [];
                    for (var i = 0; i < json.length; i++) {
                        for (var key in json[i]) {
                            if (key == 'cardNo') {
                                cardNos[i] = json[i][key];
                                param[i] = json[i][key];
                            } else if (key == 'createDate') {
                                var temp = json[i][key];
                                createDates[i] = temp.substring(10, temp.length - 4);
                            } else if (key == 'temperature') {
                                temperatures[i] = json[i][key];
                            }
                        }
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }

            });
        }
    </script>
</head>

<body>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<%--<div id="main" style="width: 100%;height:700px; border:1px solid red;"></div>--%>
<div id="main" style="width: 100%;height:600px; border:1px solid red;"></div>
<script language="javascript" type="text/javascript">
    //切记：每隔2秒就会到数据库中以当前时间查询数据；实时插入数据才会显示折线图,如果不插入数据是不会显示折线图

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    option = {
        title: {
            left: 'center',
            text: '请求响应时间监控',//温度实时监控
            subtext: ''//纯属虚构
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#283b56'
                }
            }
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {
                    readOnly: false
                },
                restore: {},
                saveAsImage: {}
            }
        },
        dataZoom: {
            show: false,
            start: 0,
            end: 100
        },
        xAxis: [{
            /* 倾斜 */
            /*type : 'category',
            position: 'bottom',
            boundaryGap: true,
            axisLabel : {
                show:true,
                interval: 'auto',
                rotate: 30,
                margin: 8,
                formatter: '{value}',
                textStyle: {color: '#000000',fontFamily: 'sans-serif',fontSize: 10,fontStyle: '幼圆',fontWeight: 'bold'}
            },*/
            axisLabel: {
                interval:0,
                rotate:40
            },
            type: 'category',
            boundaryGap: false,
            name: '时间{时：分：秒}',
            data: date
        }],
        yAxis: [{
            type: 'value',
            scale: true,
            name: '温度(℃)',
            max: 120,
            min: -10,
            boundaryGap: [0.2, 0.2]
        }]
    };
    myChart.setOption(option);
    sleep(3000);
    setInterval(function () {
        requestData();
        addData(true);
        option = {
            legend: {
                left: 'left',
                data: function () {
                    var list = [];
                    for (var i = 0; i < tagNos.length; i++) {
                        list.push(tagNos[i]);
                    }
                    return list;
                }()
            },
            xAxis: [{
                data: date
            }],
            series: function () {
                var serie = [];
                var distance = 0;
                for (var i = 0; i < tagCount; i++) {
                    var item = {
                        name: tagNos[i],
                        smooth: true, //数据光滑过度
                        type: 'line',
                        data: data[i],
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true,
                                    distance: distance += 15
                                }
                            }
                        }
                    };
                    serie.push(item);
                }
                ;
                return serie;
            }()
        };
        myChart.setOption(option);
    }, 1000);
</script>
</body>
</html>
