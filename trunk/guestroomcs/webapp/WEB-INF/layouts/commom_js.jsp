<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- javascript ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="<c:url value="/js/bootstrap/widgets.js"/>"></script>
<script src="<c:url value="/js/bootstrap/jquery.js"/>"></script>
<script src="<c:url value="/lib/jquery-ui/jquery-ui-1.8.23.custom.min.js" />"></script>
<!-- touch events for jquery ui-->
<script src="<c:url value="/js/forms/jquery.ui.touch-punch.min.js"/>"></script>
<!-- easing plugin -->
<script src="<c:url value="/js/jquery.easing.1.3.min.js"/>"></script>
<!-- smart resize event -->
<script src="<c:url value="/js/jquery.debouncedresize.min.js"/>"></script>
    <!-- js cookie plugin -->
<script src="<c:url value="/js/jquery.cookie.min.js"/>"></script>
<!-- main bootstrap js -->
<script src="<c:url value="/js/bootstrap/bootstrap.min.js" />"></script>
<!-- bootstrap plugins -->
<script src="<c:url value="/js/bootstrap/bootstrap.plugins.min.js" />"></script>

 <!-- sticky messages -->
<script src="<c:url value="/lib/sticky/sticky.min.js" />"></script>
<!-- tooltips -->
<script src="<c:url value="/lib/qtip2/jquery.qtip.min.js" />"></script>
<!-- lightbox -->
<script src="<c:url value="/lib/colorbox/jquery.colorbox.min.js" />"></script>
<!-- hidden elements width/height -->
<script src="<c:url value="/js/jquery.actual.min.js" />"></script>
<!-- scroll -->
<script src="<c:url value="/lib/antiscroll/antiscroll.js" />"></script>
<script src="<c:url value="/lib/antiscroll/jquery-mousewheel.js" />"></script>
<!-- fix for ios orientation change -->
<script src="<c:url value="/js/ios-orientationchange-fix.js" />"></script>
<!-- to top -->
<script src="<c:url value="/lib/UItoTop/jquery.ui.totop.min.js" />"></script>
<!-- validation -->
<script src="<c:url value="/lib/validation/jquery.validate.min.js" />"></script>
<!-- wizard -->
<script src="<c:url value="/lib/stepy/js/jquery.stepy.min.js" />"></script>
<!-- common functions -->
<script src="<c:url value="/js/application.js"/>"></script>
<c:set var="requestURL" value="${requestScope['javax.servlet.forward.request_uri']}" scope="request" />
<c:choose>
	<c:when test="${fn:contains(requestURL,'/system/settings')}">
		<script src="<c:url value="/js/app_validation.js"/>"></script>
	</c:when>
</c:choose> 