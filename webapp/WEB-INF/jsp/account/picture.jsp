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
	Created Date: 2012-12-10 上午09:51:39
	LastModified Date:
	Description: User Picture
 -->
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
		${message}
			<form method="post" enctype="multipart/form-data">
				<div class="formRow">
					<h4 class="text-info">图片</h4>
					<div class="control-group ">
						<label class="control-label">选择你的头像，文件最大为2M</label>
					</div>
				</div>
				<div class="formRow">
					<input type="file" id="file" name="file">
				</div>
				<div class="formRow">
					<label class="control-label">已上传头像(最多3个)</label>
					<div class="control-group ">
					
						<img src="<c:url value="/img/icons/userpicture.png" />"
							id="userPhoto" class="input-medium img-rounded" /> <img src=""
							id="userPhoto2" class="input-medium img-rounded" /> <img src=""
							id="userPhoto3" class="input-medium img-rounded" />
							
					</div>
				</div>

				<div class="formRow">
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="username" id="username"
								value="<security:authentication property="name" />" />
							<button class="btn btn-submit input-small">保存</button>
							<a class="btn btn-cancel input-mini"
								href="<c:url value="/account/profile" />">取消</a>
						</div>
					</div>
				</div>

				<c:forEach items="${user.userprofiles}" var="profile">
					<input type="hidden"
						name="hide_${profile.profilepropertydefinition.propertyname}"
						id="hide_${profile.profilepropertydefinition.propertyname}"
						value="<c:url value="${profile.propertyvalue}" />" />
				</c:forEach>
			</form>
		</div>
	</div>
</div>