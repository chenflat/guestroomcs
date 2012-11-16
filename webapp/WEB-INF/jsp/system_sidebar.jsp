<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- System Manage Sidebar -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
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
					<ul class="nav nav-list">
						<li class="nav-header"><spring:message code="nav.system" />
						</li>
						<li
							class='<c:if test="${fn:endsWith(requestURL, '/system/settings')}">active</c:if>'><a
							href="<c:url value="/system/settings" />"><spring:message
									code="nav.system.settings" /> </a></li>
						<li
							class='<c:if test="${fn:endsWith(requestURL, '/system/dictionary')}">active</c:if>'><a
							href="<c:url value="/system/dictionary" />"><spring:message
									code="nav.system.dictionary" /> </a></li>
						<li
							class='<c:if test="${fn:endsWith(requestURL, '/system/faqmanage')}">active</c:if>'><a
							href="<c:url value="/system/faqmanage" />"><spring:message
									code="nav.system.faqmanage" /> </a></li>
						<li class="nav-header"><spring:message code="nav.hotel" /></li>
						<li
							class='<c:if test="${fn:endsWith(requestURL, '/hotel/hotel')}">active</c:if>'><a
							href="<c:url value="/hotel/hotel" />"><spring:message
									code="nav.hotel.hotel" /> </a>
						</li>
						<li
							class='<c:if test="${fn:endsWith(requestURL, '/hotel/build')}">active</c:if>'><a
							href="<c:url value="/hotel/build" />"><spring:message
									code="nav.hotel.build" /> </a>
						</li>
						<li
							class='<c:if test="${fn:contains(requestURL, '/hotel/') and !fn:endsWith(requestURL, '/hotel/build') and !fn:endsWith(requestURL, '/hotel/hotel')}">active</c:if>'><a
							href="<c:url value="/hotel/room" />"><spring:message
									code="nav.hotel.room" /> </a>
						</li>
						<li class="divider"></li>
						<li><a href="#">Help</a>
						</li>
					</ul>

					<div class="push"></div>
				</div>

			</div>
		</div>
	</div>
</div>