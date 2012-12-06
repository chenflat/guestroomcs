<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午04:53:23
	LastModified Date:
	Description:
 -->
<div class="row-fluid">
	<div class="span12">
		<h3 class="heading">选择管理选项</h3>
		<div class="span4">
			<section>
			<ul class="nav nav-list">
				<li class="nav-header">管理用户</li>
				<li><a href="">安全控制</a>
				</li>
				<li><a href="<c:url value="/user/users" />">用户列表</a>
				</li>
				<li><a href="<c:url value="/user/users" />">查看用户</a>
				</li>
				<li><a href="<c:url value="/user/users" />">新增用户</a>
				</li>
			</ul>
			</section>
			<section>
			<ul class="nav nav-list">
				<li class="nav-header">权限组</li>
				<li><a href="">新增组</a>
				</li>
				<li><a href="">修改组授权</a>
				</li>
				<li><a href="">修改组用户</a>
				</li>
			</ul>
			</section>
			<section>
			<ul class="nav nav-list">
				<li class="nav-header">机构设置</li>
				<li><a href="">机构基础信息</a>
				</li>
				<li><a href="">自动编号设置</a>
				</li>
			</ul>
			</section>
			<section>
			<ul class="nav nav-list">
				<li class="nav-header">管理客房</li>
				<li><a href="">初始化客房定义</a>
				</li>
				<li><a href="">管理客房</a>
				</li>
			</ul>
			</section>
		</div>
		<div class="span4">
			<section>
			<ul class="nav nav-list">
				<li class="nav-header">配置平台数据</li>
				<li><a href="<c:url value="/system/settings" />"><spring:message
									code="nav.system.settings" /> </a>
				</li>
				<li><a href="<c:url value="/system/dictionary" />"><spring:message
									code="nav.system.dictionary" /></a>
				</li>
			</ul>
			</section>
		</div>
	</div>
</div>