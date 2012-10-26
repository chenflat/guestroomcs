<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- User Manage Sidebar -->
<div class="sidebar_inner">
	<form action="<c:url value="/service/guestrequest/query" />"
		class="input-append" method="post">
		<input autocomplete="off" name="query"
			class="search_query input-medium" size="16" type="text"
			placeholder="搜索" />
		<button type="submit" class="btn">
			<i class="icon-search"></i>
		</button>
	</form>
	<div id="side_quickview" class="quickview">
		<ul class="nav nav-list">
			<li class="active"><a href="<c:url value="/user/profile" />">用户资料</a>
			</li>
			<li><a href="<c:url value="/user/profile" />">个性化</a></li>
			<li><a href="<c:url value="/user/profile" />">提示</a></li>
			<li><a href="<c:url value="/user/profile" />">搜索</a></li>
			<li><a href="<c:url value="/user/profile" />">易用性</a></li>
			<li><a href="<c:url value="/user/handover" />"><spring:message
						code="nav.user.handover" /> </a></li>
		</ul>
	</div>
</div>
