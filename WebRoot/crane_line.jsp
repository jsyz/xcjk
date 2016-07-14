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
		<title>塔基</title>

	</head>
	<body>
		<div class="xmWraper">
			<div class="xmconbox">
				<div class="row cl Huialert-info box-shadow pd-5 bk-gray radius">
					<table class="table table-border table-bordered radius table-bg "
						style="background-color: #FFF">
						<thead class="text-c">
							<tr>
								<th width="10%">
									起重量(t)
								</th>
								<th width="10%">
									起升高度
								</th>
								<th width="10%">
									变幅幅度(m)
								</th>
								<th width="10%">
									回旋角度(°)
								</th>
								<th width="10%">
									额定力矩(N.m)
								</th>
								<th width="10%">
									倾斜角度(°)
								</th>
								<th width="10%">
									风速(m/s)
								</th>
								<th width="12%">
									力矩百分比(%)
								</th>
								<th width="11%">
									额定起重量(t)
								</th>
								<th width="12%">
									起重百分比(%)
								</th>
							</tr>
						</thead>
						<tbody>
							<tr class="text-c">
								<td>
									<span id="liftingCapacity">0</span>
								</td>
								<td>
									<span id="liftingHeight">0</span>
								</td>
								<td>
									<span id="luffingWidth">0</span>
								</td>
								<td>
									<span id="rotationAngle">0</span>
								</td>
								<td>
									<span id="ratedTorque">0</span>
								</td>
								<td>
									<span id="slope">0</span>
								</td>
								<td>
									<span id="windVelocity">0</span>
								</td>
								<td>
									<span id="torquePercent">0</span>
								</td>
								<td>
									<span id="ratedCapacity">0</span>
								</td>
								<td>
									<span id="capacityPercent">0</span>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="container"
					style="min-width: 450px; height: 160px; width: 100%; border: 1px solid #09F; margin-top: 10px;"></div>
				<div id="container1"
					style="min-width: 450px; height: 160px; width: 100%; border: 1px solid #09F; margin-top: 10px;"></div>
				<div id="container2"
					style="min-width: 450px; height: 160px; width: 100%; border: 1px solid #09F; margin-top: 10px;"></div>
				<div id="container3"
					style="min-width: 450px; height: 160px; width: 100%; border: 1px solid #09F; margin-top: 10px;"></div>
				<div id="container4"
					style="min-width: 450px; height: 150px; width: 100%; border: 1px solid #09F; margin-top: 10px;"></div>
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
		
		
		var index =new Array();
		var dataT = new Array();
		var dataM = new Array();
		var dataF = new Array();
		
		<s:iterator value="cranes" var="crane" status="index">
				index.push(<s:property value="#index.count"/>);
				dataT.push(<s:property value="liftingCapacity"/>);
				dataM.push(<s:property value="liftingHeight"/>);
				dataF.push(<s:property value="windVelocity"/>);
		</s:iterator>

$(function () {
	setInterval("ShowLights()",3000);
    $('#container').highcharts({
    
        title: {
            text: '塔基故障记录',
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
            name: '重量故障标志',
            data: [1, 0,0, 0, 0, 0, 1, 0, 0, 0, 0,0]
        }, {
            name: '高度故障标志',
            data: [0, 0,0, 0, 1, 0, 0, 0, 0, 0, 0,0]
        }, {
            name: '幅度故障标志',
            data: [0, 0,0, 0, 1, 0, 1, 0, 1, 0, 0,0]
        }, {
            name: '角度故障标志',
            data: [0, 0,0, 0, 0, 0, 1, 0, 0, 0, 0,1]
        }, {
            name: '风速故障标志',
            data: [0, 0,0, 0, 0, 0, 1, 0, 0, 0, 0,1]
        }, {
            name: '倾角故障标志',
            data: [0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0,0]
        }, {
            name: '继电器故障标志',
            data: [1, 0,0, 0, 0, 0, 1, 0, 0, 0, 1,0]
        }]
    });
});
	

$(function () {
    $('#container1').highcharts({
        title: {
            text: '塔基报警记录',
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
            name: '重量报警标志',
            data: [0, 0,0, 0, 0, 0, 1, 0, 0, 0, 0,0]
        }, {
            name: '力矩报警标志',
            data: [0, 0,0, 0, 1, 0, 1, 0, 0, 0, 0,0]
        }, {
            name: '高度报警标志',
            data: [0, 0,0, 1, 0, 0, 1, 0, 0, 0, 0,0]
        }, {
            name: '幅度报警标志',
            data: [0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0,0]
        }, {
            name: '角度报警标志',
            data: [0, 0,0, 0, 0, 0, 0, 0, 1, 0, 0,0]
        }, {
            name: '风速报警标志',
            data: [0, 0,0, 0, 0, 0, 1, 0, 0, 0, 0,0]
        }, {
            name: '倾角报警标志',
            data: [0, 1,0, 0, 0, 0, 0, 0, 0, 0, 0,0]
        }, {
            name: '防碰撞报警标志',
            data: [1, 0,0, 0, 1, 0, 0, 0, 0, 0, 0,0]
        }, {
            name: '区域限制报警标志',
            data: [0, 0,0, 0, 0, 0, 0, 1, 0, 0, 1,0]
        }]
    });
});


$(function () {
    $('#container2').highcharts({
        title: {
            text: '重量记录',
            x: -20 //center
        },
        subtitle: {
            x: -20
        },
        xAxis: {
            categories: index
        },
        yAxis: {
            title: {
                text: '顿'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '顿'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '重量记录',
            data: dataT
        }]
    });
});


$(function () {
    $('#container3').highcharts({
        title: {
            text: '高度记录',
            x: -20 //center
        },
        subtitle: {
            x: -20
        },
        xAxis: {
            categories: index
        },
        yAxis: {
            title: {
                text: '米'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '米'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '高度记录',
            data: dataM
        }]
    });
});


$(function () {
    $('#container4').highcharts({
        title: {
            text: '风速记录',
            x: -20 //center
        },
        subtitle: {
            x: -20
        },
        xAxis: {
            categories: index
        },
        yAxis: {
            title: {
                text: 'm/s'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'm/s'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '风速记录',
            data: dataF
        }]
    });
});

function ShowLights(){
				  $.ajax({   
				            url:'realtimeCrane',//这里是你的action或者servlert的路径地址   
				            type:'get', //数据发送方式   
				            dataType:'json', //接受数据格式 (这里有很多,常用的有html,xml,js,json)   
				            error: function(msg)
				            { //失败   
				            },   
				            success: function(msg)
				            { //成功   
				             if(msg!=null)
				             {
			             		$("#liftingCapacity").text(msg.liftingCapacity);
			             		$("#liftingHeight").text(msg.liftingHeight);
			             		$("#luffingWidth").text(msg.luffingWidth);
			             		$("#rotationAngle").text(msg.rotationAngle);
			             		$("#ratedTorque").text(msg.ratedTorque);
			             		$("#slope").text(msg.slope);
			             		$("#windVelocity").text(msg.windVelocity);
			             		$("#torquePercent").text(msg.torquePercent);
			             		$("#ratedCapacity").text(msg.ratedCapacity);
			             		$("#capacityPercent").text(msg.capacityPercent);
				             }
				            }  
		            });        	 
		}
						
</script>
	</body>
</html>