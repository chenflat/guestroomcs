<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-22 上午10:41:55
	LastModified Date:
	Description:
 -->
<script language="javascript">
	var methodsdata = [<c:forEach items="${methods}" var="method" varStatus="status">{
							'resourcelist[#index#].resourceId':'${method.resourceId}',
							'resourcelist[#index#].resourceName':'${method.resourceName}',
							'resourcelist[#index#].priority':'${method.priority}',
							'resourcelist[#index#].resourceString':'${method.resourceString}'
						}<c:if test="${status.count>0}">,</c:if></c:forEach>
					];
</script>
<div class="row-fluid">
	<div class="span12">
		<form:form modelAttribute="resource" method="post"
			class="form_validation_ttip"
			action="${pageContext.request.contextPath}/user/resources/save">
			<c:if test="${not empty message}">
				<c:out value="${message}" escapeXml="false" />
			</c:if>
			<legend>资源信息</legend>
			<div class="control-group">
				<form:label path="resourceName" class="control-label">资源名称 *</form:label>
				<div class="controls">
					<form:input path="resourceName" placeholder="" />
					<span class="help-inline"><form:errors path="resourceName" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="resource.resourceId" class="control-label">上级资源</form:label>
				<div class="controls">
					<form:input path="resource.resourceId" />
					<span class="help-inline"><form:errors
							path="resource.resourceId" /> </span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="resourceType" class="control-label">资源类型 *</form:label>
				<div class="controls">
					<form:select path="resourceType">
						<form:option value="url">链接</form:option>
						<form:option value="method">方法</form:option>
					</form:select>
					<span class="help-inline"><form:errors path="resourceType" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="resourceString" class="control-label">资源地址 *</form:label>
				<div class="controls">
					<form:input path="resourceString"
						placeholder="支持  * 通配符,如：/user/**" />
					<span class="help-inline"><form:errors path="resourceString" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="resourceDesc" class="control-label">资源描述</form:label>
				<div class="controls">
					<form:textarea path="resourceDesc" rows="3" />
					<span class="help-inline"><form:errors path="resourceDesc" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="priority" class="control-label">资源优先权</form:label>
				<div class="controls">
					<form:input path="priority" placeholder="" />
					<span class="help-inline"><form:errors path="priority" /> </span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="status" class="control-label">资源状态</form:label>
				<div class="controls">
					<label class="radio"> <form:radiobutton path="status"
							value="0" /> 禁用</label> <label class="radio"> <form:radiobutton
							path="status" value="1" /> 启用</label><span class="help-inline"><form:errors
							path="status" /> </span>

				</div>
			</div>
			<legend>授权方法</legend>
			<div id="resourcelist">
				<div class="control-group">
					<span id="resourcelist_controls"> <span class="btn btn-mini"
						id="resourcelist_add"><i class="icon-plus"></i>方法</span> </span>
				</div>
				<div id="resourcelist_noforms_template" class="control-group">
					<p class="help-block">Add a new input by clicking the (+)
						button above</p>
				</div>
				<div id="resourcelist_template" class="control-group">
					<div class="controls">
						<input type="text" id="resourcelist[#index#].resourceName"
							name="resourcelist[#index#].resourceName"
							placeholder="方法名称,如：创建记录" /> <input type="text"
							name="resourcelist[#index#].resourceString"
							id="resourcelist[#index#].resourceString"
							placeholder="方法签名,如：/user/user/add" /> <input type="text"
							name="resourcelist[#index#].priority"
							id="resourcelist[#index#].priority" placeholder="权重,取值0-100" />
						<input type="hidden" name="resourcelist[#index#].resourceId"
							id="resourcelist[#index#].resourceId" /> <span class="close"
							id="resourcelist_remove_current">&times;</span>
					</div>
				</div>
			</div>

			<div class="form-actions" id="role-form-actions">
				<form:hidden path="resourceId" />
				<button id="btn-submit" class="btn input-small btn-danger">
					<spring:message code="button.submit" />
				</button>
				<a href="<c:url value="/user/resources" />" class="btn input-mini">
					<spring:message code="button.cancel" /> </a>
			</div>
		</form:form>
	</div>
</div>
<%@ include file="delete.jsp"%>
