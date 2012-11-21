<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- user info -->

<form:form modelAttribute="user">
	<div class="span2">

		<img src="<c:url value="/img/metro_user.png" />" width="160px" />
		<section id="changephoto"> <a id="user_pic" class="btn">更换图片</a></section>
	</div>
	<div class="span8">
		<section id="userinfo">
		<h4>用户描述</h4>
		<p>
		<h4>${user.displayname}</h4>
		</p>
		</section>
		<section id="userinfo1">

		<h4>用户ID</h4>
		<p>
		<h4>${user.userId}</h4>
		</p>
		</section>
		<section id="userinfo2">
		<h4>联系方式</h4>
		<p>${user.emailAddress}</p>
		<section id="userinfo3">
		<h4>用户组</h4>
		<p>超级管理员</p>
		</section> <section id="userinfo4">
		<h4>最后登陆</h4>
		<p>${user.lastLoginDate}</p>
		</section>
		
		<form:input type="hidden" path="userId" />
	</div>
</form:form>