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
	Created Date: 2012-12-27 上午11:14:26
	LastModified Date:
	Description: User Name 
 -->

<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="heading">编辑名称</h3>
			<form class="form_validation_ttip" action="${requestURL}" id="name"
				method="post">
				<div class="control-group">
					<form:label path="user.firstName" class="control-label">姓</form:label>
					<div class="controls">
						<form:input path="user.firstName" />
						<span class="help-inline"><form:errors path="firstName" />
						</span>
					</div>
				</div>
				<div class="control-group">
					<form:label path="user.lastName" class="control-label">名</form:label>
					<div class="controls">
						<form:input path="user.lastName" />
						<span class="help-inline"><form:errors path="lastName" />
						</span>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn input-small btn-submit">
							<spring:message code="button.submit" />
						</button>
						<a href="<c:url value="/account/profile" />"
							class="btn btn-cancel input-mini">返回 </a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>