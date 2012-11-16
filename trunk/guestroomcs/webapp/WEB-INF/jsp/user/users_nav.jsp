<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- user manage nav -->
<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn_menu"> <span class="icon-align-justify icon-white"></span>
				</a>
				<div class="nav-collapse">
					<nav>
					<ul class="nav">
						<li><a href="<c:url value="/user/add" />" id="new" role="menuitem" class="win-command"
							style="height: 20px;"> <i class="winicon-new"></i><span
								class="win-label">新建</span> </a>
						</li>
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"></i> 管理 <b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="?act=usergroup">管理组</a></li>
							</ul>
						</li>
						<li><a href="?act=edit">编辑</a></li>
						<li><a href="?act=copy">复制</a></li>
						<li><a href="?act=delete">删除</a></li>
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"></i> 设置状态 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="?state=active">活动(默认)</a></li>
								<li><a href="?state=inactive">不活动</a></li>
								<li><a href="?state=disabled">已禁用</a></li>
								<li><a href="?state=new">新注册</a></li>
								<li><a href="?state=">全部</a></li>
							</ul>
						</li>
						<li></li>
					</ul>
					</nav>
				</div>
