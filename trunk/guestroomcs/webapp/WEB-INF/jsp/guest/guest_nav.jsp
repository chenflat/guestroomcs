<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- guest manage nav -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav">
		<li id="guest_group" class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 分组方式 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/user/roles" />" id="linkUsergroup">管理组</a>
				</li>
				<li><a href="<c:url value="/user/resources" />"
					id="linkUsergroup">管理权限项</a>
				</li>
			</ul></li>
		<li id="user_manage" class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 租赁状态 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/user/roles" />" id="linkUsergroup">管理组</a>
				</li>
				<li><a href="<c:url value="/user/resources" />"
					id="linkUsergroup">管理权限项</a>
				</li>
			</ul></li>
		<li id="user_manage" class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 服务请求 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/user/roles" />" id="linkUsergroup">管理组</a>
				</li>
				<li><a href="<c:url value="/user/resources" />"
					id="linkUsergroup">管理权限项</a>
				</li>
			</ul></li>
		<li id="user_setstatus" class="dropdown"><a
			data-toggle="dropdown" class="dropdown-toggle" href="#"></i> 操作 <b
				class="caret"></b> </a>
			<ul class="dropdown-menu" id="user_statuslist">
				<!-- 附加用户状态值 -->
				<li id="enabled" value="1"><a href="javascript:void(0);">活动(默认)</a>
				</li>
				<li id="disabled" value="0"><a href="javascript:void(0);">已禁用</a>
				</li>
			</ul></li>
		<li></li>
	</ul>
	</nav>
</div>

