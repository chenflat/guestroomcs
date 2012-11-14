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
<!-- ROOM Manage Toolbar -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav">
		<li><a href="#" id="new" role="menuitem" class="win-command"
			style="height: 20px;"> <i class="winicon-new"></i><span
				class="win-label">新增</span> </a>
		</li>
		<li class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 管理 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/hotel/roomtype" />">房间类型</a></li>
				<li><a href="#" id="linkRoomgroup">管理房间组
				</a></li>
				<c:if test="${!fn:contains(requestURL,'/hotel/roommanage')}">
				<li><a href="<c:url value="/hotel/roommanage" />">房间管理</a></li>
				</c:if>
			</ul>
		</li>
		<li><a href="#" id="linkDelete">删除</a></li>
		<li><a href="#" id="linkAdd_batch"><spring:message code="button.batchadd" /></a></li>
		<li><a href="#" id="linkDelete_batch"><spring:message code="button.batchdelete" /></a></li>
		<li></li>
	</ul>
	</nav>
</div>


