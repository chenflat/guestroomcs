<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Resource Manage nav -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav" id="resource-nav">
		<li id="resource-add"><a href="<c:url value="/user/resources/add" />"
			id="new" role="menuitem" class="win-command" style="height: 20px;">
				<i class="winicon-new"></i><span class="win-label">新建</span> </a>
		</li>
		<li id="role_manage" class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 管理 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a id="role_resource" href="<c:url value="/user/roles" />">管理组</a></li>
				<li><a id="role_resource" href="<c:url value="/user/users" />">管理用户</a></li>
			</ul>
		</li>
		<li id="resource-delete"><a href="javascript:void(0);"
			id="linkDelete">删除</a>
		</li>
		
	</ul>
	</nav>
</div>
