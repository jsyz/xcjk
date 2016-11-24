<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="charset=utf-8" />
		<title>噪音折线图</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/stilearn-base.js"></script>
		<script type="text/javascript" src="js/holder.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/pageKit.js"></script>
		<script type="text/javascript" src="js/highcharts.js"></script>
		<script type="text/javascript" src="js/modules/exporting.js"></script>
		<script>
		
		var date =new Array();
		var data = new Array();
		
		<s:iterator value="noises" var="noise" status="index">
				date.push('<s:property value="reportedTime"/>');
				data.push(<s:property value="data"/>);
		</s:iterator>
		
		
    $(function () {
    
    setInterval("ShowLights()",3000);
    
    $('#container').highcharts({
   		 chart: {
            type: 'line'
        },
        title: {
            text: '噪音颗粒折线图',
            x: -20 //center
        },
        subtitle: {
            text: '按数据数显示折线图',
            x: -20
        },
        xAxis: {
            categories: date
        },
        yAxis: {
            title: {
                text: '折线趋势'
            },
             labels:{
		        enabled: false
		    },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '千粒',
        },
        credits: {
                text: '',
                href: 'http://#'
            },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
         plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: '噪音颗粒',
            data: data
        }]
    });
});

function ShowLights(){
				  $.ajax({   
				            url:'realtimeNoise',//这里是你的action或者servlert的路径地址   
				            type:'get', //数据发送方式   
				            dataType:'json', //接受数据格式 (这里有很多,常用的有html,xml,js,json)   
				            error: function(msg)
				            { //失败   
				            },   
				            success: function(msg)
				            { //成功   
				             if(msg!=null)
				             {
				             	if(msg.data=="-1")
				             	{
				             		$("#data").text("暂无数据");
				             	}else
				             	{
				             		$("#data").text(msg.data+"分贝 (db)");
				             	}
				             }
				            }  
		            });        	 
		}
  </script>
	</head>

	<body>

		<div class="formbody">


			<div id="usual1" class="usual">

				<div class="itab">
					<ul>
						<li>
							<a href="#tab3" class="selected">流量报表折线图</a>
						</li>
					</ul>
				</div>


				<div id="tab3" class="tabson">
					<ul class="forminfo">
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr style="height: 35px;">
									<td>
										噪音设备：
									</td>
								</tr>
							</table>
						</li>

					</ul>
				<div class="xmWraper">
							<div class="xmconbox">
								<div class="row cl Huialert-info box-shadow pd-5 bk-gray radius">
									<div id="container"
										style="min-width: 450px; height: 230px; border: 1px solid #09F"></div>
									<div style="font-size: 80px; text-align: center;">
										实时数据=
										<span id="data"></span>
									</div>
								</div>
							</div>
				
						</div>



				</div>

			</div>
	</body>
</html>
