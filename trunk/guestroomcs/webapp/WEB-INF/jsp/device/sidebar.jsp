<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2013-2-25 下午12:29:55
	LastModified Date:
	Description: DEVICE SIDEBAR
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- SUBMENU LIST -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<div class="sidebar_inner">
					<form class="input-append" method="post"></form>
					<div class="menu">
						<div class="menu-group">
							<div class="menu-heading">
								<h4><a href="<c:url value="/device/initialize"/>" class="menu-toggle"><spring:message code="nav.device.initialize" /> </a></h4>
							</div>
							<div class="menu-body">
								<div class="menu-inner">
									<ul class="nav nav-list">
										<li id="module"
											class="<c:if test="${fn:endsWith(requestURL , '/device/module')}">active</c:if>"><a
											href="<c:url value="/device/module"/>"><spring:message
													code="nav.device.module" /> </a></li>

										<li id="room"
											class="<c:if test="${fn:endsWith(requestURL , '/device/room')}">active</c:if>"><a
											href="<c:url value="/device/room"/>"><spring:message
													code="nav.device.room" /> </a></li>

										<li id="group"
											class="<c:if test="${fn:endsWith(requestURL , '/device/group')}">active</c:if>"><a
											href="<c:url value="/device/group"/>"><spring:message
													code="nav.device.group" /> </a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="menu-group">
							<div class="menu-heading">
								<h4><a href="#" class="menu-toggle">控制模式 </a></h4>
							</div>
							<div class="menu-body"">
								<div class="menu-inner">
									<ul class="nav nav-list">
										
									</ul>
								</div>
							</div>
						</div>

					</div>

					
				</div>


				<div class="sidebar_info">
					<div class="header"></div>
					<div class="dropup">
						<a class="dropdown-toggle" data-toggle="dropdown"><span
							class="icon-warning-sign"></span> 说明</a>

						<ul class="dropdown-menu">
							<li class="nav-header">说明：</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;右侧属性设置中</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;黑色 字体直接点击修改</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: #ccc">灰色</span>
								字体内容只读</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: blue">蓝色</span>
								字体为点击修改内容</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp; - 或 空内容 表示内容需要实例化才有值，目前暂不可改;</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;列表点击标题排序。</li>
						</ul>

					</div>

				</div>

			</div>
		</div>
	</div>
</div>
