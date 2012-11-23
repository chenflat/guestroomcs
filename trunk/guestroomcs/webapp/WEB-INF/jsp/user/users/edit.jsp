<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- begin edit user info -->
<div class="row-fluid">
	<div class="span12">
		<legend>
			<strong> <c:choose>
					<c:when test="${empty user.userId}">
						<spring:message code="user.manage.add" />
					</c:when>
					<c:otherwise>
						<spring:message code="user.manage.edit" />
					</c:otherwise>
				</c:choose> </strong>
		</legend>

		<form:form modelAttribute="user" method="post"
			class="form_validation_ttip"
			action="${pageContext.request.contextPath}/user/users/save">
			<c:if test="${not empty message}">
				<c:out value="${message}" escapeXml="false" />
			</c:if>
			<div class="formRow">
				<div class="control-group">
					<h4>个人信息</h4>
				</div>
				<div class="control-group">
					<form:label path="firstName" class="control-label">姓</form:label>
					<div class="controls">
						<form:input path="firstName" />
						<span class="help-inline"><form:errors path="firstName" />
						</span>
					</div>
				</div>
				<div class="control-group">
					<form:label path="lastName" class="control-label">名</form:label>
					<div class="controls">
						<form:input path="lastName" />
						<span class="help-inline"><form:errors path="lastName" />
						</span>
					</div>
				</div>
			</div>

			<div class="formRow">
				<div class="control-group">
					<h4>联系信息</h4>
				</div>
				<div class="control-group">
					<form:label path="emailAddress" class="control-label">电子邮件 *</form:label>
					<div class="controls">
						<form:input path="emailAddress" placeholder="email address" />
						<span class="help-inline"><form:errors path="emailAddress" />
						</span>
					</div>
				</div>
			</div>
			<div class="formRow">
				<div class="control-group">
					<h4>用户信息</h4>
				</div>
				<div class="control-group">
					<form:label path="username" class="control-label">用户名 *</form:label>
					<div class="controls">
						<form:input path="username" />
						<span class="help-inline"> <form:errors path="username" />
						</span>
					</div>
				</div>
				<c:choose>
				<c:when test="${action eq 'add'}">
				<div class="control-group" id="row-password">
					<form:label path="password" class="control-label">初始密码 *</form:label>
					<div class="controls">
						<form:input path="password" type="password" />
						<span class="help-inline"> <form:errors path="password" />
						</span>
					</div>
				</div>
				<div class="control-group" id="row-confirmpwd">
					<label for="confirmpwd" class="control-label">确认密码 *</label>
					<div class="controls">
						<input type="password" name="confirmpwd" id="confirmpwd" /> <span
							class="help-inline"> </span>
					</div>
				</div>
				</c:when>
				<c:otherwise>
					<form:hidden path="password" />
					<form:hidden path="username" />
				</c:otherwise>
				</c:choose>
				<div class="control-group">
					<div class="controls">
						<select name="rolelist" id="rolelist">
							<option value="">选择用户组</option>
							<c:forEach items="${roles}" var="role">
							<option value="${role.roleId}"
								<c:forEach items="${user.rolelist}" var="item">
								<c:if test="${item.roleId eq role.roleId}">selected="selected"</c:if>
								</c:forEach>
								>${role.roleDesc}</option>
							</c:forEach>
						</select> 
					</div>
				</div>
			</div>
			<div class="formRow">
				<div class="control-group">
					<h4>其它信息</h4>
				</div>
				<div class="control-group">
					<form:label path="jobTitle" class="control-label">工作头衔 </form:label>
					<div class="controls">
						<form:input path="jobTitle" />
						<span class="help-inline"><form:errors path="jobTitle" />
						</span>
					</div>
				</div>
				<div class="control-group">
					<form:label path="comments" class="control-label">备注 </form:label>
					<div class="controls">
						<form:textarea path="comments" rows="3"/>
						<span class="help-inline"><form:errors path="comments" />
						</span>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<form:hidden path="userId" />
				<form:hidden path="status" />
				<form:hidden path="isSuperUser" />
				<button class="btn input-small btn-danger">
					<spring:message code="button.submit" />
				</button>
				<a href="<c:url value="/user/users" />" class="btn input-mini">
					<spring:message code="button.cancel" /> </a>
			</div>
		</form:form>

	</div>
</div>
