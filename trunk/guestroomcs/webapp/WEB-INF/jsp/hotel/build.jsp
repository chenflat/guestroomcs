<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午04:41:50
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<div class="heading clearfix">
			<div class="pull-left">
				<span class="lead">酒店建筑管理</span>
			</div>
			<ul class="nav nav-pills pull-right sepH_b">
				<li <c:if test="${param.viewmode eq 'list'}"> class="active"</c:if>><a
					href="?viewmode=list">列表</a>
				</li>
				<li
					<c:if test="${param.viewmode eq 'thumbnails' or param.viewmode eq null}"> class="active"</c:if>><a
					href="?viewmode=thumbnails">缩略图</a></li>
				<li><a href="#">详细</a></li>
			</ul>
		</div>

		<c:if test="${!empty message}">
			<div class="alert alert-error">${message}</div>
		</c:if>


		<c:choose>
			<c:when test="${param.viewmode eq 'list'}">

				<table class="table table-bordered table-striped" id="smpl_tbl">
					<thead>
						<tr>
							<th class="table_checkbox"><input type="checkbox"
								name="select_rows" class="select_rows" data-tableid="smpl_tbl">
							</th>
							<th>建筑名称</th>
							<th>建筑地址</th>
							<th width="50">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${builds}" var="build">
							<tr>
								<td><input type="checkbox" name="buildId"
									class="select_row">
								</td>
								<td>${build.buildName}</td>
								<td>${build.buildAddress}</td>
								<td><a
									href="<c:url value="/hotel/build/edit/${build.buildId}" />"
									class="sepV_a" title="Edit"><i class="icon-pencil"></i> </a> <a
									href="#" title="Delete"><i class="icon-trash"></i> </a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>

				<div class="tiles">
					<c:forEach items="${builds}" var="build">

						<a href="<c:url value="/hotel/build/edit/${build.buildId}" />">
							<div class="tile bg-color-pinkDark icon">
								<b class="check"></b>
								<div class="tile-content">
									<img src="<c:url value="/img/icons/build.png" /> ">
								</div>
								<div class="brand">
									<span class="name">${build.buildName}</span>
								</div>
							</div> </a>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>






	</div>
</div>