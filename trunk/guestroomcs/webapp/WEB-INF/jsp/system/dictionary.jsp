<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-19 下午04:04:10
	LastModified Date:
	Description:
 -->
<div class="row-fluid">
	<div class="span12">
		<legend>数据字典</legend>
		<div class="span3">
			<div class="well">
				<ul class="nav nav-list">
					<li class="nav-header">字典类别
						<div class="btn-group pull-right">
							<a href="#" class="btn btn-mini ttip_t" oldtitle="Refresh list"><i
								class="icon-refresh"></i>
							</a> <a href="#" data-toggle="dropdown"
								class="dropdown-toggle btn btn-mini ttip_t" oldtitle="Options"><i
								class="icon-cog"></i>
							</a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/system/dictionary/new" />">新增列表</a>
								</li>
								
							</ul>
						</div>
					</li>
					<li class="active"><a href="<c:url value="/system/dictionary/edit/4" />">房间状态</a>
					</li>
					<li><a href="#">Library</a>
					</li>
					<li><a href="#">Applications</a>
					</li>
					<li><a href="#">Profile</a>
					</li>
					<li><a href="#">Settings</a>
					</li>
					<li><a href="#">Help</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="span8">
			<div class="well"></div>
		</div>
	</div>
</div>
