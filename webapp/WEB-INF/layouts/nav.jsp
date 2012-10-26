<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>  
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午03:09:25
	LastModified Date:
	Description:
 -->
<c:set var="requestURL" value="${requestScope['javax.servlet.forward.request_uri']}" scope="request" />
<c:set var="serviceURL" value="${pageContext.request.contextPath}/service/guestrequest" />
<c:set var="hvacURL" value="${pageContext.request.contextPath}/service/hvac" />
<c:set var="prefsURL" value="${pageContext.request.contextPath}/guest/prefs" />
<c:set var="analyseURL" value="${pageContext.request.contextPath}/analyse/report" />
<c:set var="profileURL" value="${pageContext.request.contextPath}/user/profile" />
<c:set var="settingURL" value="${pageContext.request.contextPath}/system/settings" />

<header>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<ul class="nav user_menu brand">
				<li class="dropdown">

				<a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown">
					<img
						src="<c:url value="/img/brand.png"/>" alt=""
						class="user_avatar">
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
					<c:when test="${requestURL eq profileURL}">
						<spring:message code="nav.user.profile" />
					</c:when>
					<c:when test="${requestURL eq settingURL}">
						<spring:message code="nav.system" />
					</c:when>
					<c:otherwise>
						<spring:message code="nav.home" />
					</c:otherwise>
				</c:choose>	
					 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
					<li><a href="<c:url value="/service/guestrequest" />"><spring:message code="nav.service" />
					</a>
					</li>
					<li><a href="<c:url value="/service/havc" />"><spring:message code="nav.service.hvac" /></a>
					</li>
					<li><a href="<c:url value="/guest/prefs" />"><spring:message code="nav.guest.prefs" /></a>
					</li>
					<li><a href="<c:url value="/analyse/report" />"><spring:message code="nav.analyse" /></a>
					</li>
					<li><a href="<c:url value="/user/profile" />"><spring:message code="nav.user.profile" /></a>
					</li>
					<li><a href="<c:url value="/system/settings" />"><spring:message code="nav.system" /></a>
					</li>
					<li class="divider"></li>
					<li><a href="<c:url value="/index" />"><spring:message code="nav.home" /></a>
					</li>
				</ul>
				</li>
			</ul>

			<ul class="nav user_menu pull-right">
				<li class="hidden-phone hidden-tablet">
					<div class="nb_boxes clearfix">
						<a data-toggle="modal" data-backdrop="static" href="#myMail"
							class="label ttip_b" oldtitle="New messages">25 <i
							class="splashy-mail_light"></i>
						</a> <a data-toggle="modal" data-backdrop="static" href="#myTasks"
							class="label ttip_b" oldtitle="New tasks">10 <i
							class="splashy-calendar_week"></i>
						</a>
					</div></li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i
						class="icon-cog icon-white"></i> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/system/settings" />"><i class="icon-wrench"></i> <spring:message code="nav.system.settings" /></a></li>
						<li><a href="<c:url value="/hotel/hotelmanage" />"><i class="icon-star"></i> <spring:message code="nav.hotel" /></a></li>
						<li><a href="<c:url value="/guest/prefs" />"><i class="icon-map-marker"></i> <spring:message code="nav.guest" /></a></li>
						<li><a href="<c:url value="/user/usermanage" />"><i class="icon-user"></i> <spring:message code="nav.user" /></a></li>
						<li><a href="<c:url value="/user/handover" />"><i class="icon-thumbs-up"></i> <spring:message code="nav.user.handover" /></a></li>
					</ul></li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i
						class="flag-cn"></i> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="?lang=zh-cn"><i class="flag-cn"></i> 中文</a>
						</li>
						<li><a href="?lang=us-en"><i class="flag-us"></i> English</a>
						</li>
					</ul></li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><img
						src="<c:url value="/img/user_avatar.png"/>" alt=""
						class="user_avatar"><security:authentication property="name" /> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/user/profile" />"><i
								class="icon-briefcase"></i> <spring:message code="userprofile" />
						</a>
						</li>
						<li><a href="javascrip:void(0)"><i class="icon-envelope"></i>
								我的消息</a>
						</li>
						<li class="divider"></li>
						<li><a href="<c:url value="/j_spring_security_logout" />"><i
								class="icon-off"></i> <spring:message code="user.logout" />
						</a>
						</li>
					</ul></li>
			</ul>
			
			
		</div>
	</div>
</div>
<div class="modal hide fade" id="myMail">
	<div class="modal-header">
		<button class="close" data-dismiss="modal">×</button>
		<h3>新消息</h3>
	</div>
	<div class="modal-body">
		<div class="alert alert-info">In this table jquery plugin turns
			a table row into a clickable link.</div>
		<table class="table table-condensed table-striped" data-rowlink="a">
			<thead>
				<tr>
					<th>Sender</th>
					<th>Subject</th>
					<th>Date</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Declan Pamphlett</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a>
					</td>
					<td>23/05/2012</td>
					<td>25KB</td>
				</tr>
				<tr>
					<td>Erin Church</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a>
					</td>
					<td>24/05/2012</td>
					<td>15KB</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0)" class="btn">Go to mailbox</a>
	</div>
</div>
<div class="modal hide fade" id="myTasks">
	<div class="modal-header">
		<button class="close" data-dismiss="modal">×</button>
		<h3>新任务</h3>
	</div>
	<div class="modal-body">
		<div class="alert alert-info">In this table jquery plugin turns
			a table row into a clickable link.</div>
		<table class="table table-condensed table-striped" data-rowlink="a">
			<thead>
				<tr>
					<th>id</th>
					<th>Summary</th>
					<th>Updated</th>
					<th>Priority</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>P-23</td>
					<td><a href="javascript:void(0)">Admin should not break if
							URL…</a>
					</td>
					<td>23/05/2012</td>
					<td class="tac"><span class="label label-important">High</span>
					</td>
					<td>Open</td>
				</tr>
				<tr>
					<td>P-18</td>
					<td><a href="javascript:void(0)">Displaying submenus in
							custom…</a>
					</td>
					<td>22/05/2012</td>
					<td class="tac"><span class="label label-warning">Medium</span>
					</td>
					<td>Reopen</td>
				</tr>
				<tr>
					<td>P-25</td>
					<td><a href="javascript:void(0)">Featured image on post
							types…</a>
					</td>
					<td>22/05/2012</td>
					<td class="tac"><span class="label label-success">Low</span>
					</td>
					<td>Updated</td>
				</tr>
				<tr>
					<td>P-10</td>
					<td><a href="javascript:void(0)">Multiple feed fixes and…</a>
					</td>
					<td>17/05/2012</td>
					<td class="tac"><span class="label label-warning">Medium</span>
					</td>
					<td>Open</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0)" class="btn">Go to task manager</a>
	</div>
</div>

</header>