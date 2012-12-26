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
	Created Date: 2012-12-26 上午11:05:56
	LastModified Date:
	Description: Edit Password
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="heading">更改密码</h3>
			<form class="form_validation_ttip" action="${requestURL}"
				method="post" id="changepwd">
				<div class="control-group">
					<label class="control-label" for="password">输入当前密码</label>
					<div class="controls">
						<input type="password" name="password" id="password"
							placeholder="输入当前密码">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="newpassword">输入新的密码</label>
					<div class="controls">
						<input type="password" id="newpassword" name="newpassword"
							placeholder="输入新密码">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="confirmnewpwd">确认新的密码</label>
					<div class="controls">
						<input type="password" id="confirmnewpwd" name="confirmnewpwd"
							placeholder="再次输入新密码">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="hidden" name="isvalid" id="isvalid" value="false" />
						<input type="hidden" name="username" id="username" value="${user.username}" />
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