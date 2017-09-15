<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地图</title>
    <style type="text/css">
        html {
            height: 100%
        }

        body {
            height: 100%;
            margin: 0px;
            padding: 0px
        }

        #container {
            height: 100%
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=5gwQ4KRsSkFGnL6Wo7lDqwxjPsITOxsZ">
        //v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
    </script>
</head>

<body>
<div id="container"></div>
<script type="text/javascript">
    var map = new BMap.Map("container");          // 创建地图实例
    var point = new BMap.Point(108.953098279, 34.2777998978);  // 创建点坐标
    map.centerAndZoom(point, 15);                 // 初始化地图，设置中心点坐标和地图级别
    var local = new BMap.LocalSearch(map, {
        renderOptions: {map: map}
    });

    //    local.search("太白南路2号");
    local.search('${address}');

    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.addControl(new BMap.MapTypeControl());
    map.addControl(new BMap.GeolocationControl());
    map.setCurrentCity("西安"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用

    map.enableScrollWheelZoom();
</script>
</body>
</html>
