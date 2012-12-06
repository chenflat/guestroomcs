<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- ROOM Manage Toolbar -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
<div class="nav-collapse">
	<nav>
	<ul class="nav">
		<li class="dropdown"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 分组方式 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li class="nav-header">分组方式</li>
				<li><a href="#"><input type="checkbox" class="checkbox" checked="checked" />
					楼层(默认)</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />网络设置</a></li>
				<li class="divider"></li>
			</ul></li>

		<li id="reqlist_nav" class="dropdown" style="display:none;"><a data-toggle="dropdown"
			class="dropdown-toggle" href="#"></i> 服务请求 <b class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li class="nav-header">分组方式</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />
					订餐</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />收餐盘</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />管理服务</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />叫服务员</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />叫经理</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />擦鞋</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />毛巾</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />浴巾</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />纸巾</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />遥控器</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />插线板</a></li>
				<li><a href="#" class="btn">应用</a></li>
			</ul></li>
			<!-- <li><a href="#" rel="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." data-original-title="Popover on bottom">请求服务</a></li> -->
	</ul>
	</nav>
</div>


