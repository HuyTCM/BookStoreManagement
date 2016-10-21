<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<!-- Vendor CSS -->
<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/fullcalendar/dist/fullcalendar.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendors/bower_components/google-material-color/dist/palette.css"
	rel="stylesheet">

<!-- CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/app.min.1.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/app.min.2.css"
	rel="stylesheet">

</head>

<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/jquery/dist/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Javascript Libraries -->
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/Waves/dist/waves.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/moment/min/moment.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/simpleWeather/jquery.simpleWeather.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/salvattore/dist/salvattore.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/flot/jquery.flot.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/flot/jquery.flot.resize.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/flot.curvedlines/curvedLines.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/sparklines/jquery.sparkline.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendors/bower_components/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/flot-charts/curved-line-chart.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/flot-charts/line-chart.js"></script>

<!-- Placeholder for IE9 -->
<!--[if IE 9 ]>
        <script src="vendors/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
        <![endif]-->

<script src="${pageContext.request.contextPath}/resources/js/charts.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/functions.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/actions.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/demo.js"></script>


<body data-ma-header="teal">
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>
	<tilesx:useAttribute name="current" />
	<c:set var="cur" scope="request" value="${current}" />

	<header id="header" class="media">
		<tiles:insertAttribute name="header" />
	</header>

	<section id="main">
		<tiles:insertAttribute name="sidebar-menu" />

		<section id="content">
			<tiles:insertAttribute name="body" />
		</section>

		<tiles:insertAttribute name="footer" />

	</section>

	<div class="page-loader palette-Teal bg">
		<div class="preloader pl-xl pls-white">
			<svg class="pl-circular" viewBox="25 25 50 50">
                    <circle class="plc-path" cx="50" cy="50" r="20" />
                </svg>
		</div>
	</div>

</body>
</html>