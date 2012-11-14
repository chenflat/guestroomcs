<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- Bootstrap framework -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/css/bootstrap-responsive.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/metro.css"/>">
<link rel="stylesheet" href="<c:url value="/css/metro-responsive.css"/>">
<!-- jQuery UI theme -->
<link rel="stylesheet"
	href="<c:url value="/lib/jquery-ui/css/Aristo/Aristo.css"/>" />
<c:choose>
	<c:when test="${fn:contains(requestURL,'/hotel/')}">
		<!-- theme color-->
<link href="<c:url value="/css/theme/purple.css"/>" id="link_theme" rel="stylesheet">
	</c:when>
	<c:otherwise>
	<link href="<c:url value="/css/theme/blue.css"/>" id="link_theme" rel="stylesheet">
	</c:otherwise>
</c:choose>
<!-- tooltips-->
<link rel="stylesheet"
	href="<c:url value="/lib/qtip2/jquery.qtip.min.css"/>" />

<!-- notifications -->
<link rel="stylesheet" href="<c:url value="/lib/sticky/sticky.css"/>" />
<!-- aditional icons -->
<link rel="stylesheet" href="<c:url value="/img/splashy/splashy.css"/>" />
<!-- flags -->
<link href="<c:url value="/css/flags.css"/>" rel="stylesheet">
<%-- <link href="<c:url value="/css/icons.css"/>" rel="stylesheet"> --%>
<!-- calendar -->
<link rel="stylesheet"
	href="<c:url value="/lib/fullcalendar/fullcalendar.css" />" />
<!-- datepicker -->
<link rel="stylesheet"
	href="<c:url value="/lib/datepicker/datepicker.css" />" />
<!-- tag handler -->
<link rel="stylesheet"
	href="<c:url value="/lib/tag_handler/css/jquery.taghandler.css" />" />
<!-- uniform -->
<link rel="stylesheet"
	href="<c:url value="/lib/uniform/Aristo/uniform.aristo.css" />" />
<!-- multiselect -->
<link rel="stylesheet"
	href="<c:url value="/lib/multiselect/css/multi-select.css" />" />
<!-- enhanced select -->
<link rel="stylesheet" href="<c:url value="/lib/chosen/chosen.css" />" />
<!-- wizard -->
<link rel="stylesheet"
	href="<c:url value="/lib/stepy/css/jquery.stepy.css" />" />
<!-- upload -->
<link rel="stylesheet"
	href="<c:url value="/lib/plupload/js/jquery.plupload.queue/css/plupload.css" />" />
<!-- CLEditor -->
<link rel="stylesheet"
	href="<c:url value="/lib/CLEditor/jquery.cleditor.css" />" />
<!-- colorpicker -->
<link rel="stylesheet"
	href="<c:url value="/lib/colorpicker/css/colorpicker.css" />" />
<!-- smoke_js -->
<link rel="stylesheet"
	href="<c:url value="/lib/smoke/themes/smoke.css" />" />
<!-- main styles -->
<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
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
<!--[if lte IE 8]>
  <link rel="stylesheet" href="<c:url value="/css/ie.css"/>" />
 <![endif]-->
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="<c:url value="/js/html5.js"/>"></script>
	<script src="<c:url value="/js/ie/respond.min.js"/>"></script>
	<script src="<c:url value="/lib/flot/excanvas.min.js"/>"></script>	
<![endif]-->
<script>
	var contextPath = '<c:url value="/" />';
</script>