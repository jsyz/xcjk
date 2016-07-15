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
		<title>升降机开关记录</title>
	</head>
	<body>
		<div class="xmWraper">
			<div class="xmconbox">
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
		</div>
	</body>
</html>