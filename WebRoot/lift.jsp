<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link href="css/noise.css" rel="stylesheet" type="text/css" />
		<link href="css/Kentucky.css" rel="stylesheet" type="text/css" />
		<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet"
			type="text/css" />
		<title>升降机</title>
	</head>
	<body>
		<div class="xmWraper">
			<div class="xmconbox">
				<div class="row cl Huialert-info box-shadow pd-5 bk-gray radius">
					<div id="container"
						style="min-width: 450px; height: 230px; border: 1px solid #09F" />
					</div>
				</div>
				<div class="row cl Huialert-info box-shadow pd-5 bk-gray radius">
					<table class="table table-border table-bordered radius table-bg "
						style="background-color: #FFF">
						<thead class="text-c">
							<tr>
								<th width="5%">
									序号
								</th>
								<th width="7.5%">
									身份证
								</th>
								<th width="5%">
									操作（开关）时间
								</th>
							</tr>
						</thead>
						<tbody>

							<s:iterator value="lifts" var="lift" status="status">
								<tr class="text-c">
									<td class="text-c">
										<s:property value="#status.index+1"/>
									</td>
									<td>
										<s:property value="switchRecord"/>
									</td>
									<td>
										<s:property value="reportedTime"/>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
			<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
			<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
			<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script>
			<script type="text/javascript"
				src="lib/Validform/5.3.2/Validform.min.js"></script>
			<script type="text/javascript"
				src="lib/Highcharts/4.1.7/js/highcharts.js"></script>
			<script type="text/javascript"
				src="lib/Highcharts/4.1.7/js/modules/exporting.js"></script>
			<script type="text/javascript" src="js/H-ui.js"></script>
			<script type="text/javascript" src="js/H-ui.admin.js"></script>
			<script type="text/javascript">

$(function () {
	setInterval("ShowLights()",250);
    $('#container').highcharts({
        title: {
            text: '升降机报警',
            x: -20 //center
        },
        subtitle: {
            x: -20
        },
        xAxis: {
            categories: ['2016-6-22', '2016-6-23', '2016-6-24', '2016-6-25', '2016-6-26', '2016-6-27','2016-6-28', '2016-6-29', '2016-6-30', '2016-7-1', '2016-7-2', '2016-7-3']
        },
        yAxis: {
            title: {
                text: '次数'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '次'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '升降机冲顶报警',
            data: [0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0]
        },{
            name: '升降机蹲底报警',
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        }]
    });
});

function ShowLights(){
				  $.ajax({   
				            url:'realtimeLift',//这里是你的action或者servlert的路径地址   
				            type:'get', //数据发送方式   
				            dataType:'json', //接受数据格式 (这里有很多,常用的有html,xml,js,json)   
				            error: function(msg)
				            { //失败   
				            	console.log('Error loading document');   
				            },   
				            success: function(msg)
				            { //成功   
				             if(msg!=null)
				             {
				             	console.log(msg);
				             }
				            }  
		            });        	 
		}
	
</script>
	</body>
</html>