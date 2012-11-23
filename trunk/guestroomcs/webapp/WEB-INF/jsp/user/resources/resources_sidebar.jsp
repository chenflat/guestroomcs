<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-22 上午10:23:22
	LastModified Date:
	Description: 资源列表
 -->

<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- Roles LIST -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<div class="sidebar_inner">
					<form class="input-append" method="post"></form>
					<ul class="nav nav-list" id="resource-tree">
						<li class="nav-header sepH_a_line">权限资源管理</li>
						<c:forEach items="${resourcetree}" var="node">
							<c:set var="currentUrl" value="${pageContext.request.contextPath}/user/resources/edit/${node.id}" />
							<li id="resourceId_${node.id}"
								class="<c:if test="${requestURL eq currentUrl}">active</c:if>"><a
								href="<c:url value="/user/resources/edit/${node.id}"/>">${node.text}</a>
								<c:if test="${!empty node.children}">
									<ul class="nav nav-list">
										<c:forEach items="${node.children}" var="child">
											<c:set var="currentChildUrl" value="${pageContext.request.contextPath}/user/resources/edit/${child.id}" />
											<li id="resourceId_${child.id}"
												class="<c:if test="${requestURL eq currentChildUrl}">active</c:if>"><a
												href="<c:url value="/user/resources/edit/${child.id}"/>">${child.text}</a>
											</li>
										</c:forEach>
									</ul>
								</c:if></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
