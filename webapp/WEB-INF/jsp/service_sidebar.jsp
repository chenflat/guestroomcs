<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Service Manage Sidebar -->
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
			<li><a href="#">服务请求</a>
			</li>
			<li class="active"><a href="#">保洁</a>
			</li>
			<li><a href="#">SOS紧急事件</a>
			</li>
			<li><a href="#">门磁报警</a>
			</li>
			<li><a href="#">窗磁报警</a>
			</li>
		</ul>
	</div>

	<div class="push"></div>
</div>

<div class="sidebar_info">
	<div class="header"></div>
	<ul class="unstyled">
		<li><span class="act act-warning">65</span> <strong>DND</strong></li>
		<li><span class="act act-success">10</span> <strong>MUR</strong></li>
		<li><span class="act act-danger">85</span> <strong>BC</strong></li>
	</ul>
</div>