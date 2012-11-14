<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- ROOM type Toolbar -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav">
		<li><a href="<c:url value="/hotel/roomtype/edit/" />" id="new" role="menuitem" class="win-command"
			style="height: 20px;"> <i class="winicon-new"></i><span
				class="win-label">新增</span> </a>
		</li>
		<c:if test="${fn:contains(requestURL,'/hotel/roomtype/edit')}">
		<li><a href="#" id="linkDelete">删除</a></li>
		</c:if>
		<li></li>
	</ul>
	</nav>
</div>

