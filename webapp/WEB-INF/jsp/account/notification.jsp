<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:32:55
	LastModified Date:
	Description:Notification Setting
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="row-fluid main_content_sidebar">
	<div class="span12">
	${message}
		<form action="${requestURL}" method="post" id="notification">
			<div class="formRow">
				<h4 class="text-info">工作提示</h4>
				<div class="control-group">
					<label class="control-label" for="tb">显示所有提示</label> <label
						class="controls switch"> <input type="checkbox"
						name="showAllNotification" id="showAllNotification" /> <span></span> </label>
				</div>

				<div class="control-group">
					<label class="control-label" for="tb">显示所有HVAC提示</label> <label
						class="controls switch"> <input type="checkbox"
						name="showHvacNotification" id="showHvacNotification" /> <span></span> </label>
				</div>
			</div>
			<div class="formRow">
				<h4 class="text-info">提示音</h4>
				<div class="control-group">
					<label class="control-label" for="music">选择提示音</label> 
					<select id="notificationMusic" name="notificationMusic">
						<c:forEach items="${musics}" var="music">
							<option value="${music.value}">${music.text}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<h4 class="text-info">提示历史</h4>
			
			<div class="formRow">
				<div class="control-group">
					<div class="controls">
						<input type="hidden" name="username" id="username"
							value="<security:authentication property="name" />" />
						<button class="btn" type="submit">重置所有为默认</button>
						<button class="btn btn-success">保存</button>
					</div>
				</div>
			</div>
			<c:forEach items="${user.userprofiles}" var="profile">
				<input type="hidden" name="hide_${profile.profilepropertydefinition.propertyname}" id="hide_${profile.profilepropertydefinition.propertyname}" value="${profile.propertyvalue}" />
			</c:forEach>
		</form>
	</div>
</div>