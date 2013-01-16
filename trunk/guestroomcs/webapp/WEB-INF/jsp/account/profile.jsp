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
	Created Date: 2012-10-22 下午01:02:57
	LastModified Date:
	Description: User Profile
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
			${message}
			<form action="${requestURL}" method="post" id="personalize"
				enctype="multipart/form-data">
				<div class="formRow">
					<h4 class="text-info">头像</h4>
					<div class="control-group">
						<div class="row-fluid">
							<div data-fileupload="file" class="fileupload fileupload-new">
								<div style="width: 80px; height: 80px;"
									class="fileupload-new thumbnail">
									<img src="" alt="" id="userPhoto" />
								</div>
							</div>
							<a href="<c:url value="/account/picture" />" class="">更改图片</a>
						</div>
						<input type="hidden" name="userPhoto" id="userPhoto" value="" />
					</div>
				</div>

				<div class="formRow">
					<h4 class="text-info">用户信息</h4>
					<div class="control-group">
						<a href="<c:url value="/account/profile/name" />">编辑</a>
					</div>
					<div class="control-group">

						<ul class="nav">
							<li><security:authentication property="name" />
							</li>
							<li>${user.firstName} ${user.lastName}</li>
							<li>${user.jobTitle}</li>
						</ul>
					</div>
				</div>

				<div class="formRow">
					<h4 class="text-info">用户安全</h4>
					<div class="control-group">
						<a class="btn" href="<c:url value="/account/profile/password" />">修改密码</a>
					</div>
				</div>
				<div class="formRow">
					<h4 class="text-info">联系信息</h4>
					<div class="control-group">
						<a href="<c:url value="/account/profile/contact" />">编辑</a>
					</div>
					<div class="control-group">
						<ul class="nav">
							<c:forEach items="${phones}" var="phone" varStatus="status">
								<li title="${phone.comment}">${phone.number}</li>
							</c:forEach>
							<c:forEach items="${emailaddresses}" var="email"
								varStatus="status">
								<li title="${email.comment}">${email.address}</li>
							</c:forEach>
							<c:forEach items="${addresses}" var="address" varStatus="status">
								<li title="${address.comment}">${address.state}
									${address.city} ${address.street} ${address.zipcode}
									${address.country}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="formRow">
					<h4 class="text-info">用户组</h4>
					<div class="control-group">
						<ul class="nav">
							<c:forEach items="${user.roles}" var="role">
								<li>${role.roleDesc}</li>
							</c:forEach>
						</ul>
					</div>
				</div>

<%-- 				<div class="formRow">
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="username" id="username"
								value="<security:authentication property="name" />" />
							<button class="btn input-small btn-submit" type="submit">保存</button>
							<a class="btn input-mini btn-cancel">取消</a>
						</div>
					</div>
				</div> --%>
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