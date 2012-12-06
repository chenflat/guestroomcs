<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- groups Manage nav -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav" id="group-nav">
		<li id="group_add"><a href="<c:url value="/user/groups/add" />" id="new"
			role="menuitem" class="win-command" style="height: 20px;"> <i
				class="winicon-new"></i><span class="win-label">新建</span> </a>
		</li>
		<li id="group_manage" class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 管理 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a id="group_resource" href="<c:url value="/user/resources" />">管理权限项</a></li>
				<li><a id="group_resource" href="<c:url value="/user/users" />">管理用户</a></li>
			</ul>
		</li>
		<li id="group_edit"><a href="javascript:void(0);" id="linkEdit">编辑</a>
		</li>
		<li id="group_delete"><a href="javascript:void(0);" id="linkDelete">删除</a></li>
	</ul>
	</nav>
</div>

