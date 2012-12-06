<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- user manage nav -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav">
		<li id="user_add"><a href="javascript:void(0);" id="new"
			role="menuitem" class="win-command" style="height: 20px;"> <i
				class="winicon-new"></i><span class="win-label">新建</span> </a></li>
		<li id="user_manage" class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 管理 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/user/groups" />" id="linkUsergroup">管理组</a>
				</li>
				<li><a href="<c:url value="/user/resources" />"
					id="linkUsergroup">管理权限项</a>
				</li>
			</ul></li>
		<li id="user_edit"><a href="javascript:void(0);" id="linkEdit">编辑</a>
		</li>
		<!-- <li id="user_copy"><a href="javascript:void(0);" id="linkCopy">复制</a></li> -->
		<li id="user_delete"><a href="javascript:void(0);"
			id="linkDelete">删除</a>
		</li>
		<li id="user_setstatus" class="dropdown"><a
			data-toggle="dropdown" class="dropdown-toggle" href="#"></i> 设置状态 <b
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
