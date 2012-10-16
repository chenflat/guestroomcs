<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Twitter Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


<!-- Le styles -->
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-responsive.css"/>" rel="stylesheet">
<link href="<c:url value="/css/grcs-ui.css"/>" rel="stylesheet">
<link href="<c:url value="/js/google-code-prettify/prettify.css"/>" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>


	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
	
    <!-- Le javascript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
    <script src="<c:url value="/js/bootstrap/jquery.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/google-code-prettify/prettify.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-transition.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-alert.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-modal.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-dropdown.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-scrollspy.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-tab.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-tooltip.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-popover.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-button.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-collapse.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-carousel.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-typeahead.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap-affix.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/application.js"/>"></script>
</body>
</html>
