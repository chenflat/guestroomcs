<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	value="${pageContext.request.contextPath}/system/settings" />
<c:set var="hotelURL"
	value="${pageContext.request.contextPath}/hotel/" />
<c:set var="roomURL"
	value="${pageContext.request.contextPath}/hotel/roommanage" />
<header>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="brand" href="#" class="dropdown-toggle nav_condensed"
				data-toggle="dropdown"> <img
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
					<c:when test="${fn:contains(requestURL,userURL)}">
						<spring:message code="nav.user.usermanage" />
					</c:when>
					<c:when test="${fn:contains(requestURL,accountURL)}">
						<spring:message code="nav.account.settings" />
					</c:when>
					<c:when test="${fn:contains(requestURL,settingURL) or fn:contains(requestURL,hotelURL)}">
						<spring:message code="nav.system" />
					</c:when>
					<c:otherwise>
						<spring:message code="nav.home" />
					</c:otherwise>
				</c:choose> <i class="caret"></i> </a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/service/requests" />"><spring:message
							code="nav.service" /> </a></li>
				<li><a href="<c:url value="/service/hvac" />"><spring:message
							code="nav.service.hvac" /> </a></li>
				<li><a href="<c:url value="/guest/prefs" />"><spring:message
							code="nav.guest.prefs" /> </a></li>
				<li><a href="<c:url value="/analyse/summary" />"><spring:message
							code="nav.analyse" /> </a></li>
				<li><a href="<c:url value="/user/usermanage" />"><spring:message
							code="nav.user.usermanage" /> </a></li>
				<li><a href="<c:url value="/account/profile" />"><spring:message
							code="nav.account.settings" /> </a></li>
				<li><a href="<c:url value="/system/settings" />"><spring:message
							code="nav.system" /> </a></li>

				<li class="divider"></li>
				<li><a href="<c:url value="/index" />"><spring:message
							code="nav.home" /> </a></li>
			</ul>

			<ul class="nav user_menu pull-right">
				<li class="hidden-phone hidden-tablet">
					<div class="nb_boxes clearfix">
						<a data-toggle="modal" data-backdrop="static" href="#myMail"
							class="label ttip_b" oldtitle="New messages">20 <i
							class="splashy-mail_light"></i> </a> <a data-toggle="modal"
							data-backdrop="static" href="#myTasks" class="label ttip_b"
							oldtitle="New tasks">10 <i class="splashy-calendar_week"></i>
						</a>
					</div>
				</li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i
						class="icon-cog icon-white"></i> <b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/system/settings" />"><i
								class="icon-wrench"></i> <spring:message
									code="nav.system.settings" /> </a>
						</li>
						<li><a href="<c:url value="/hotel/hotelmanage" />"><i
								class="icon-star"></i> <spring:message code="nav.hotel" /> </a>
						</li>
						<li><a href="<c:url value="/guest/prefs" />"><i
								class="icon-map-marker"></i> <spring:message code="nav.guest" />
						</a>
						</li>
						<li><a href="<c:url value="/user/usermanage" />"><i
								class="icon-user"></i> <spring:message code="nav.user" /> </a>
						</li>
						<li><a href="<c:url value="/account/shiftwork" />"><i
								class="icon-thumbs-up"></i> <spring:message
									code="nav.account.shiftwork" /> </a>
						</li>
					</ul>
				</li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i
						class="flag-cn"></i> <b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="?lang=zh-cn"><i class="flag-cn"></i> 中文</a></li>
						<li><a href="?lang=us-en"><i class="flag-us"></i> English</a>
						</li>
					</ul>
				</li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle avatar"
					data-toggle="dropdown"> <i class="icon-adminuser"></i> <span
						class="txt"><security:authentication property="name" /> </span> <b
						class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/account/profile" />"><i
								class="icon-briefcase"></i> <spring:message
									code="nav.account.profile" /> </a></li>
						<li><a href="<c:url value="/account/settings" />"><i
								class="icon-cog"></i> <spring:message
									code="nav.account.settings" /> </a></li>
						<li><a href="javascrip:void(0)"><i class="icon-envelope"></i>
								我的消息</a></li>
						<li class="divider"></li>
						<li><a href="<c:url value="/j_spring_security_logout" />"><i
								class="icon-off"></i> <spring:message code="user.logout" /> </a></li>
					</ul>
				</li>
			</ul>

			<c:choose>
				<c:when test="${fn:contains(requestURL,userURL)}">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn_menu"> <span class="icon-align-justify icon-white"></span>
				</a>
				<div class="nav-collapse">
					<nav>
					<ul class="nav">
						<li><a href="#" id="new" role="menuitem" class="win-command"
							style="height: 20px;"> <i class="winicon-new"></i><span
								class="win-label">新建</span> </a>
						</li>
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"></i> 管理 <b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="?act=usergroup">管理组</a></li>
							</ul>
						</li>
						<li><a href="?act=edit">编辑</a></li>
						<li><a href="?act=copy">复制</a></li>
						<li><a href="?act=delete">删除</a></li>
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"></i> 设置状态 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="?state=active">活动(默认)</a></li>
								<li><a href="?state=inactive">不活动</a></li>
								<li><a href="?state=disabled">已禁用</a></li>
								<li><a href="?state=new">新注册</a></li>
								<li><a href="?state=">全部</a></li>
							</ul>
						</li>
						<li></li>
					</ul>
					</nav>
				</div>
				</c:when>
				<c:when test="${fn:contains(requestURL,roomURL)}">
					<%@ include file="../jsp/hotel/room_nav.jsp" %>
				</c:when>
				<c:when test="${fn:contains(requestURL,'/hotel/roomtype')}">
					<%@ include file="../jsp/hotel/roomtype_nav.jsp" %>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>
<%@ include file="../jsp/account/mymail.jsp" %>
<%@ include file="../jsp/account/mytasks.jsp" %>
</header>