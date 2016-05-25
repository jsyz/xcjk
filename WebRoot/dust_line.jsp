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
		<title>扬尘折线图</title>
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
		
		var index =new Array();
		var data = new Array();
		
		<s:iterator value="dusts" var="dust" status="index">
		
				index.push(<s:property value="#index.count"/>);
				data.push(<s:property value="data"/>);
			
		</s:iterator>
		
		
    $(function () {
    $('#container').highcharts({
   		 chart: {
            type: 'line'
        },
        title: {
            text: '扬尘颗粒折线图',
            x: -20 //center
        },
        subtitle: {
            text: '按数据数显示折线图',
            x: -20
        },
        xAxis: {
            categories: index
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
            valueSuffix: '粒',
            enabled: false,
             formatter: function() {
               return '<b>'+ this.series.name +'</b><br/>'+this.x +': '+ this.y +'辆';
           }
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
            name: '扬尘颗粒',
            data: data
        }]
    });
});
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
										扬尘设备：
									</td>
								</tr>
							</table>
						</li>

					</ul>


					<div id="container" style="min-width: 700px; height: 800px"></div>


				</div>

			</div>
	</body>
</html>
