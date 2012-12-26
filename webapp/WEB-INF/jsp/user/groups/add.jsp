<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-21 上午09:33:22
	LastModified Date:
	Description: Add New Role
 -->
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
			<form:form modelAttribute="role" method="post"
				class="form_validation_ttip">
				<c:if test="${not empty message}">
					<c:out value="${message}" escapeXml="false" />
				</c:if>
				<legend> 新增权限组 </legend>
				<div class="control-group">
					<form:label path="roleName" class="control-label">权限组代码 *</form:label>
					<div class="controls">
						<form:input path="roleName" placeholder="例如:ROLE_RECEPTION" />
						<span class="help-inline"><form:errors path="roleName" />
						</span>
					</div>
				</div>
				<div class="control-group">
					<form:label path="roleDesc" class="control-label">权限组描述 *</form:label>
					<div class="controls">
						<form:input path="roleDesc" placeholder="例如:前台接待员" />
						<span class="help-inline"><form:errors path="roleDesc" />
						</span>
					</div>
				</div>

				<legend> 应用列表 </legend>
				<ul class="nav nav-list" id="resource-tree">
					<c:forEach items="${resources}" var="res" varStatus="status">
						<li id="resource_${res.resourceId}"><input type="checkbox"
							name="resourcelist[${status.index}].resourceId"
							value="${res.resourceId}" /> ${res.resourceName}</li>
					</c:forEach>
				</ul>
				<div class="alert alert-info">请在应用列表中为权限组选择应用权限</div>
				<div class="form-actions" id="role-form-actions">
					<form:hidden path="roleId" />
					<form:hidden path="status" />
					<form:hidden path="issys" />
					<button id="btn-submit" class="btn input-small btn-danger"
						type="submit">
						<spring:message code="button.submit" />
					</button>
					<a href="<c:url value="/user/groups" />" class="btn input-mini">
						<spring:message code="button.cancel" /> </a>
				</div>

			</form:form>

		</div>
	</div>
</div>