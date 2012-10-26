<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="requestURL" value="${requestScope['javax.servlet.forward.request_uri']}" scope="request" />
<!-- System Manage Sidebar -->
<div class="sidebar_inner">
	<form action="<c:url value="/service/guestrequest/query" />"
		class="input-append" method="post">
		<input autocomplete="off" name="query"
			class="search_query input-medium" size="16" type="text"
			placeholder="搜索" />
		<button type="submit" class="btn">
			<i class="icon-search"></i>
		</button>
	</form>
	<div id="side_accordion" class="accordion">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseTwo" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-globe"></i> <spring:message code="nav.system" /> </a>
			</div>
			<div class="accordion-body collapse in" id="collapseTwo">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li class='<c:if test="${fn:endsWith(requestURL, '/system/settings')}">active</c:if>'><a href="<c:url value="/system/settings" />"><spring:message code="nav.system.settings" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/system/dictionary')}">active</c:if>'><a href="<c:url value="/system/dictionary" />"><spring:message code="nav.system.dictionary" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/system/faqmanage')}">active</c:if>'><a href="<c:url value="/system/faqmanage" />"><spring:message code="nav.system.faqmanage" /></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseThree" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-th"></i> <spring:message code="nav.hotel" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseThree">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li class='<c:if test="${fn:endsWith(requestURL, '/hotel/hotelmanage')}">active</c:if>'><a href="<c:url value="/hotel/hotelmanage" />"><spring:message code="nav.hotel.hotel" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/hotel/buildmanage')}">active</c:if>'><a href="<c:url value="/hotel/buildmanage" />"><spring:message code="nav.hotel.build" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/hotel/roommanage')}">active</c:if>'><a href="<c:url value="/hotel/roommanage" />"><spring:message code="nav.hotel.room" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/hotel/roomtype')}">active</c:if>'><a href="<c:url value="/hotel/roomtype" />"><spring:message code="nav.hotel.roomtype" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/hotel/roomgroup')}">active</c:if>'><a href="<c:url value="/hotel/roomgroup" />"><spring:message code="nav.hotel.roomgroup" /></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseFour" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-leaf"></i> <spring:message code="nav.guest" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseFour">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a href="<c:url value="/guest/prefs" />"><spring:message code="nav.guest.prefs" /></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseFive" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-folder-close"></i> <spring:message code="nav.user" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseFive">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li class='<c:if test="${fn:endsWith(requestURL, '/user/usermanage')}">active</c:if>'><a href="<c:url value="/user/usermanage" />"><spring:message code="nav.user.usermanage" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/user/rolemanage')}">active</c:if>'><a href="<c:url value="/user/rolemanage" />"><spring:message code="nav.user.rolemanage" /></a></li>
						<li class='<c:if test="${fn:endsWith(requestURL, '/user/authorities')}">active</c:if>'><a href="<c:url value="/user/authorities" />"><spring:message code="nav.user.authorities" /></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="push"></div>
</div>
