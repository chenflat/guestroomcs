<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2013-2-25 下午01:49:39
	LastModified Date:
	Description:
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<!-- ROOM Manage Toolbar -->
<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
	<span class="icon-align-justify icon-white"></span> </a>
	
<div class="nav-collapse">
	<ul class="nav">
		<li id="reset"><a href="#">重置所有类型属性</a></li>
		<li id="reselect"><a href="#"> 清除选择 </a></li>
			 
		<li id="device_create" class="dropdown"><a href="javascript:void(0);" id="new" data-toggle="dropdown" class="dropdown-toggle" class="win-command" style="height: 20px;"> <i
				class="winicon-new"></i><span class="win-label">新建</span> <i
				class="caret"></i> </a>
				<ul class="dropdown-menu">
				<li><a href="#">主控制器</a></li>
				<li><a href="#">0-10V调光模块</a></li>
				<li><a href="#">白炽灯调光模块</a></li>
			</ul>
		</li>	 
			 
			 
			 
		<li id="reqlist_nav" class="dropdown"><a
			data-toggle="dropdown" class="dropdown-toggle" href="#">过滤设备 <b
				class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="#"><input type="checkbox" class="checkbox" />
						全部类型</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />
						订餐</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />收餐盘</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />管理服务</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />叫服务员</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />叫经理</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />擦鞋</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />毛巾</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />浴巾</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />纸巾</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />遥控器</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />插线板</a>
				</li>
				<li class="pull-right"><a href="#" class="btn input-mini">应用</a>
				</li>
			</ul></li>
		<li class="dropdown" id="clearStatus_nav" style="display: none;"><a
			data-toggle="dropdown" class="dropdown-toggle" href="#"></i> 保洁状态 <b
				class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="#"><input type="checkbox" class="checkbox" />DND</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />MUR</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />正在清理</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />等待检查</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />正在检查</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />OK房</a>
				</li>
				<li class="pull-right"><a href="#" class="btn input-mini">应用</a>
				</li>
			</ul></li>
		<li class="dropdown" id="temp_nav" style="display: none;"><a
			data-toggle="dropdown" class="dropdown-toggle" href="#"></i> 温度范围 <b
				class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="#"><input type="checkbox" class="checkbox" />DND</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />MUR</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />正在清理</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />等待检查</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />正在检查</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />OK房</a>
				</li>
				<li class="pull-right"><a href="#" class="btn input-mini">应用</a>
				</li>
			</ul></li>
		<li class="dropdown" id="hvac_nav" style="display: none;"><a
			data-toggle="dropdown" class="dropdown-toggle" href="#"></i> 空调模式 <b
				class="caret"></b> </a>
			<ul class="dropdown-menu">
				<li><a href="#"><input type="checkbox" class="checkbox" />Auto
						自动模式</a></li>
				<li><a href="#"><input type="checkbox" class="checkbox" />Heat</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />Cool</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />Fan</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />Dry</a>
				</li>
				<li><a href="#"><input type="checkbox" class="checkbox" />OFF</a>
				</li>
				<li class="pull-right"><a href="#" class="btn input-mini">应用</a>
				</li>
			</ul></li>
		<li class="dropdown" id="emt_nav" style="display: none;"><a
			href="">设置为EMT参考</a>
		</li>
		
	</ul>

</div>
