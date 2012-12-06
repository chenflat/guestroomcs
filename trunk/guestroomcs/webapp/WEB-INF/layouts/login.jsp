<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="login_page">
<head>
<meta charset="utf-8">
<title><tiles:insertAttribute name="title" />
</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<META HTTP-EQUIV="pragma" CONTENT="no-cache" />
<!-- Bootstrap framework -->
<link rel="stylesheet" href="<c:url value="/css/icomoon.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>">
<link href="<c:url value="/css/metro-ui-light.css"/>" rel="stylesheet">
<link href="<c:url value="/css/theme/blue.css"/>" id="link_theme" rel="stylesheet">

<link rel="stylesheet" href="<c:url value="/lib/qtip2/jquery.qtip.min.css"/>" />
<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
<!-- uniform -->
<link rel="stylesheet"
	href="<c:url value="/lib/uniform/uniform.default.css" />" />
<!-- favicon -->
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>"
	type="image/x-icon" />
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value="/img/icons/apple-touch-icon-144-precomposed.png" />">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value="/img/icons/apple-touch-icon-114-precomposed.png" />">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value="/img/icons/apple-touch-icon-72-precomposed.png" />">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value="/img/icons/apple-touch-icon-57-precomposed.png" />">

<link href='http://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
<!--[if lte IE 8]>
  <link rel="stylesheet" href="<c:url value="/css/ie.css"/>" />
 <![endif]-->
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="<c:url value="/js/html5.js"/>"></script>
	<script src="<c:url value="/js/ie/respond.min.js"/>"></script>
	<script src="<c:url value="/lib/flot/excanvas.min.js"/>"></script>	
<![endif]-->

</head>
<body>
	<tiles:insertAttribute name="body" />
</body>
</html>
