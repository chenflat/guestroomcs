<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Common Nav -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<c:set var="serviceURL"
	value="${pageContext.request.contextPath}/service/requests" />
<c:set var="hvacURL"
	value="${pageContext.request.contextPath}/service/hvac" />
<c:set var="prefsURL"
	value="${pageContext.request.contextPath}/guest/prefs" />
<c:set var="analyseURL"
	value="${pageContext.request.contextPath}/analyse/summary" />
<c:set var="userURL" value="${pageContext.request.contextPath}/user/" />
<c:set var="accountURL"
	value="${pageContext.request.contextPath}/account/" />
<c:set var="settingURL"
	value="${pageContext.request.contextPath}/system/navigation" />
<c:set var="hotelURL" value="${pageContext.request.contextPath}/hotel/" />
<c:set var="deviceURL" value="${pageContext.request.contextPath}/device/" />
<header>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<ul class="nav user_menu pull-left">
				<li><a class="brand" href="#"
					class="dropdown-toggle nav_condensed" data-target="" data-toggle="dropdown"> <img
						src="<c:url value="/img/brand.png"/>" alt="" class="user_avatar">
						<c:choose>
							<c:when test="${requestURL eq serviceURL}">
								<spring:message code="nav.service" />
							</c:when>
							<c:when test="${requestURL eq hvacURL}">
								<spring:message code="nav.service.hvac" />
							</c:when>
							<c:when test="${requestURL eq prefsURL}">
								<spring:message code="nav.guest.prefs" />
							</c:when>
							<c:when test="${requestURL eq analyseURL}">
								<spring:message code="nav.analyse" />
							</c:when>
							<c:when test="${fn:contains(requestURL,accountURL)}">
								<spring:message code="nav.account.settings" />
							</c:when>
							<c:when test="${fn:contains(requestURL,deviceURL)}">
								<spring:message code="nav.device" />
							</c:when>
							<c:when
								test="${fn:contains(requestURL,settingURL) or fn:contains(requestURL,hotelURL) or fn:contains(requestURL,userURL)}">
								<spring:message code="nav.system" />
							</c:when>
							<c:otherwise>
								<spring:message code="nav.home" />
							</c:otherwise>
						</c:choose> <i class="caret" id="mainmenu_caret"></i> </a>
						
					<ul class="dropdown-menu mainmenu" id="mainmenu">
						<li><a href="<c:url value="/service/requests" />"> <i
								class="icon-volume-up icon-white"></i>
							<spring:message code="nav.service" /> </a>
						</li>
						<li><a href="<c:url value="/service/hvac" />"><i
								class="icon-globe icon-white"></i> <spring:message
									code="nav.service.hvac" /> </a>
						</li>
						<li><a href="<c:url value="/guest/prefs" />"><i
								class="icon-camera icon-white"></i> <spring:message
									code="nav.guest.prefs" /> </a>
						</li>
						<li><a href="<c:url value="/analyse/summary" />"><i
								class=" icon-retweet icon-white"></i> <spring:message
									code="nav.analyse" /> </a>
						</li>
						<li><a href="<c:url value="/account/profile" />"><i
								class="icon-cog icon-white"></i> <spring:message
									code="nav.account.settings" /> </a>
						</li>
						<li> <a href="<c:url value="/device/module" />">
					<i class="icon-tags icon-white"></i> <spring:message code="nav.device" />  </a>
						</li>
						<li> <a href="<c:url value="/system/navigation" />">
					<i class="icon-wrench icon-white"></i> <spring:message
									code="nav.system" /> </a>
						</li>
					</ul>
					</li>
			</ul>


			<ul class="nav user_menu pull-right">
			<li id="nav-toggle" data-toggle="collapse" data-target="#navigation" class="collapsed">
				<span class="icon-align-justify icon-white"></span>
			</li> 
				<li class="system-cog"><a class="ssw_trigger" href="javascript:void(0)"><i
						class="icon-cog icon-white"></i> </a>
				</li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle avatar"
					data-toggle="dropdown"> <i class="icon-adminuser"></i> <span
						class="txt"><security:authentication property="name" /> </span> <b
						class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/account/profile" />"><i
								class="icon-cog"></i> <spring:message code="user.editprofile" />
						</a>
						</li>
						<li class="divider"></li>
						<li><a href="javascrip:void(0)"><i class="icon-envelope"></i>
								<spring:message code="button.help" /> </a>
						</li>
						<li><a href="<c:url value="/j_spring_security_logout" />"><i
								class="icon-off"></i> <spring:message code="user.logout" /> </a>
						</li>
					</ul></li>
			</ul>

			<!-- 设备为手机时，使用此菜单 -->
			<ul class="nav nav-collapse " id="navigation" style="width:100%;">
						<li><a href="<c:url value="/service/requests" />"> <i
								class="icon-volume-up icon-white"></i>
							<spring:message code="nav.service" /> </a>
						</li>
						<li><a href="<c:url value="/service/hvac" />"><i
								class="icon-globe icon-white"></i> <spring:message
									code="nav.service.hvac" /> </a>
						</li>
						<li><a href="<c:url value="/guest/prefs" />"><i
								class="icon-camera icon-white"></i> <spring:message
									code="nav.guest.prefs" /> </a>
						</li>
						<li><a href="<c:url value="/analyse/summary" />"><i
								class=" icon-retweet icon-white"></i> <spring:message
									code="nav.analyse" /> </a>
						</li>
						<li><a href="<c:url value="/account/profile" />"><i
								class="icon-cog icon-white"></i> <spring:message
									code="nav.account.settings" /> </a>
						</li>
						<li> <a href="<c:url value="/system/navigation" />">
					<i class="icon-wrench icon-white"></i> <spring:message
									code="nav.system" /> </a>
						</li>
					</ul>

			<c:choose>
				<c:when test="${fn:contains(requestURL,'/user/users')}">
					<%@ include file="../jsp/user/users/users_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/user/groups')}">
					<%@ include file="../jsp/user/groups/groups_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/user/resources')}">
					<%@ include file="../jsp/user/resources/resources_nav.jsp"%>
				</c:when>
				<c:when test="${fn:endsWith(requestURL,'/hotel/room')}">
					<%@ include file="../jsp/hotel/room/room_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/hotel/build')}">
					<%@ include file="../jsp/hotel/build_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/hotel/roomtype')}">
					<%@ include file="../jsp/hotel/roomtype_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/guest/')}">
					<%@ include file="../jsp/guest/guest_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/service/requests')}">
					<%@ include file="../jsp/service/service_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/service/hvac')}">
					<%@ include file="../jsp/service/service_nav.jsp"%>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/device/')}">
					<%@ include file="../jsp/device/nav.jsp"%>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>
</header>