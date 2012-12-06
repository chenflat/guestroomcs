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
<!-- Roles LIST -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<div class="sidebar_inner">
					<form class="input-append" method="post"></form>
					<ul class="nav nav-list" id="grouplist">
						<li class="nav-header sepH_a_line">权限组管理</li>
						<c:forEach items="${roles}" var="role">
							<li id="roleId_${role.roleId}"
								class="<c:if test="${fn:endsWith(requestURL , role.roleId)}">active</c:if>"><a
								href="<c:url value="/user/groups/edit/${role.roleId}"/>">${role.roleDesc}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


