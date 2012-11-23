<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-20 下午03:41:32
	LastModified Date:
	Description: EDIT ROLE INFO
 -->
<div class="row-fluid">
	<div class="span12">
		<form:form modelAttribute="role" method="post">

			<div class="formRow">
				<div class="control-group">
					<h4>组描述</h4>
					<div class="controls">
						<span class="lead">${role.roleDesc}</span>
						<form:hidden path="roleDesc" />
					</div>
				</div>
			</div>
			<div class="formRow">
				<div class="control-group">
					<h4>组ID</h4>
					<div class="controls">
						<span class="lead">${role.roleId}</span>
						<form:hidden path="roleId" />
					</div>
				</div>
			</div>

			<div class="formRow clearfix">
				<div class="control-group">
					<h4>应用列表</h4>
				</div>
				<div class="controls">
					<ul class="nav nav-list span3" id="resource-list">
						<c:forEach items="${role.resources}" var="resource">
							<li id="res_${resource.resourceId}"><a href="#">${resource.resourceName}</a>
							</li>
						</c:forEach>
					</ul>

				</div>
			</div>
			<div class="formRow">
				<div class="control-group">
					<h4>组用户</h4>
				</div>
				<div class="controls"></div>
			</div>

		</form:form>
	</div>
</div>

<div class="infoPaneContainer">
	<div class="sidebar">
		<div class="antiScroll">
			<div class="antiscroll-inner">
				<div class="antiscroll-content">
					<div class="sidebar_inner">
						<form class="input-append" method="post"></form>
						<div class="row-fluid">
							<ul class="nav nav-list" id="authority-method-list">
								<li class="nav-header sepH_a_line">授权项</li>
								<!-- dynamic insert element -->	
							</ul>
							<div class="span12">
								<div class="control-group">
									<div class="controls">
										<button class="btn">
											<spring:message code="button.submit" />
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="delete.jsp"%>

