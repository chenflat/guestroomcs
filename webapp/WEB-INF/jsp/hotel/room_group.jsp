<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-14 上午09:49:47
	LastModified Date:
	Description:
 -->
	<div class="modal hide fade" id="roomgroupModal">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">×</button>
			<h3>房间组</h3>
		</div>
		<div class="modal-body">
		<form id="fromRoomgroups" action="<c:url value="/hotel/roomgroup" />" method="post">
			<table class="table table-condensed table-striped" data-rowlink="a">
				<thead>
					<tr>
						<th>name</th>
						<th>description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roomgroups}" var="roomgroup" varStatus="status">
						<tr>
							<td><input type="text"
								name="roomgroups[$(status.index)].roomgroupName"
								value="${roomgroup.roomgroupName}" placeholder="组名称" /> <input
								type="hidden" name="roomgroups[$(status.index)].roomgroupId"
								value="${roomgroup.roomgroupId}" />
							</td>
							<td><input type="hidden"
								name="roomgroups[$(status.index)].roomgroupDesc"
								value="${roomgroup.roomgroupDesc}" placeholder="描述" />
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td><input type="text" name="roomgroupName"
							id="roomgroupName" placeholder="组名称" />
						</td>
						<td><input type="text" name="roomgroupDesc"
							id="roomgroupDesc" placeholder="描述" />
						</td>
					</tr>
				</tbody>
			</table>
			+
			</form>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">
				<spring:message code="button.cancel" />
			</button>
			<button class="btn btn-primary" id="btnSaveroomgroup">
				<spring:message code="button.apply" />
			</button>
		</div>
	</div>
