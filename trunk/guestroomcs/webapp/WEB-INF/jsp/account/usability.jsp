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
	Created Date: 2012-11-2 下午01:33:18
	LastModified Date:
	Description:
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="row-fluid">
	<div class="span12">
		${message}
		<form id="usability" method="post" action="${requestURL}">
			<div class="formRow">
				<h4 class="text-info">默认使用方式</h4>
				<div class="control-group">
					<label class="control-label" for="tb">切换普通PC与平板电脑</label> <label
						class="controls"> <select name="switchDevice"
						id="switchDevice">
							<option value="0">自适应</option>
					</select> <span></span> </label>
				</div>
			</div>
			<div class="formRow">
				<h4 class="text-info">触摸</h4>
				<div class="control-group">
					<label class="control-label" for="tb">点击生效时提示声音</label> <label
						class="controls switch"> <input type="checkbox"
						name="isHintSound" id="isHintSound"> <span></span>
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" for="tb">双击确认</label> <label
						class="controls switch"> <input type="checkbox"
						name="isDdlClickConfirm" id="isDdlClickConfirm"> <span></span>
					</label>
				</div>
			</div>

			<div class="formRow">
				<div class="control-group">
					<div class="controls">
						<button class="btn" type="submit">重置所有为默认</button>
						<button class="btn btn-success">保存</button>
					</div>
				</div>
			</div>
			<c:forEach items="${user.userprofiles}" var="profile">
				<input type="hidden" name="hide_${profile[0].profilepropertydefinition.propertyname}" id="hide_${profile[0].profilepropertydefinition.propertyname}" value="${profile[0].propertyvalue}" />
			</c:forEach>
		</form>
	</div>
</div>