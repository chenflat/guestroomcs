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
	Created Date: 2012-11-2 下午01:33:06
	LastModified Date:
	Description:
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="row-fluid main_content_sidebar">
	<div class="span12">
	${message}
		<form action="${requestURL}" method="post" id="search">
			<div class="formRow">
				<h4 class="text-info">自动提示</h4>
				<div class="control-group">
					<label class="control-label switch" for="tb">输入搜索关键词时自动提示</label> <label
						class="controls switch"> <input type="checkbox"
						name="autoComplete" id="autoComplete" /> <span></span> </label>
				</div>

				<div class="control-group">
					<label class="control-label switch" for="tb">按搜索关键字次数排序提示</label> <label
						class="controls switch"> <input type="checkbox"
						name="autoCompleteOrder" id="autoCompleteOrder" /> <span></span>
					</label>
				</div>
				<h4 class="text-info">提示关键字最多个数</h4>
				<div class="control-group">
					<select name="showKeywords" id="showKeywords">
						<c:forEach items="${keywords}" var="keyword">
							<option value="${keyword.value}">${keyword.text}</option>
						</c:forEach>
					</select>


				</div>
			</div>

			<div class="formRow">
				<h4 class="text-info">搜索历史</h4>

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
				<input type="hidden" name="hide_${profile.profilepropertydefinition.propertyname}" id="hide_${profile.profilepropertydefinition.propertyname}" value="${profile.propertyvalue}" />
			</c:forEach>
		</form>
	</div>
</div>