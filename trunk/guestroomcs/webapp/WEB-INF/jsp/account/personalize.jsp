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
	Created Date: 2012-11-2 下午01:32:42
	LastModified Date:
	Description:
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
			${message}
			<form action="${requestURL}" method="post" id="personalize">
				<div class="formRow">
					<h4 class="text-info">登陆后默认查看</h4>
					<div class="control-group">
						<label class="control-label" for="defRequest">选择应用</label> <select
							name="defRequest" id="defRequest">
							<c:forEach items="${servicerequests}" var="request">
								<option value="${request.value}">${request.text}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="formRow">
					<h4 class="text-info">季节</h4>
					<div class="control-group">
						<label class="control-label" for="season">冬夏转换设置</label> <select
							name="season" id="season">
							<c:forEach items="${seasons}" var="season">
								<option value="${season.value}">${season.text}</option>
							</c:forEach>
						</select>

					</div>
				</div>


				<div class="formRow">
					<h4 class="text-info ">同步</h4>
					<div class="control-group ">
						<label class="control-label" for="synCycle">本地数据同步周期</label> <select
							id="synCycle" name="synCycle">
							<option value="2">10-15s</option>
						</select>

					</div>
					<div class="control-group">
						<label class="control-label switch" for="tb">同步服务时间到本地业务系统</label>
						<label class="controls switch"> <input type="checkbox"
							name="isSynTime" id="isSynTime" /> <span></span> </label>

					</div>
				</div>

				<div class="formRow">
					<h4 class="text-info">常用语言与时区</h4>

					<div class="control-group">
						<select id="langCode" name="langCode">
							<c:forEach items="${languages}" var="lang">
								<option value="${lang.value}">${lang.text}</option>
							</c:forEach>
						</select>
					</div>

					<div class="control-group">
						<select id="timeZone" name="timeZone">
							<c:forEach items="${timezones}" var="timezone">
								<option value="${timezone.value}">${timezone.text}</option>
							</c:forEach>
						</select>

					</div>
				</div>
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
					<input type="hidden"
						name="hide_${profile.profilepropertydefinition.propertyname}"
						id="hide_${profile.profilepropertydefinition.propertyname}"
						value="${profile.propertyvalue}" />
				</c:forEach>
			</form>

		</div>
	</div>
</div>