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
 	<script language="javascript">
					var roomgroupdata = [<c:forEach items="${roomgroupForm.roomgroups}" var="roomgroup" varStatus="status">{
							'roomgroups[#index#].roomgroupId':'${roomgroup.roomgroupId}',
							'roomgroups[#index#].roomgroupName':'${roomgroup.roomgroupName}',
							'roomgroups[#index#].roomgroupDesc':'${roomgroup.roomgroupDesc}'
						}<c:if test="${status.count>0 and status.index<status.count}">,</c:if></c:forEach>
					];
				</script>
<c:set var="actionUrl" value="${pageContext.request.contextPath}/hotel/roomgroup"></c:set>
<form:form modelAttribute="roomgroupForm" method="post" action="${actionUrl}">
	<div class="modal hide fade" id="roomgroupModal">
		<div class="modal-header">
			<button class="close" data-dismiss="modal">×</button>
			<h3>房间组</h3>
		</div>
		<div class="modal-body">
			<div id="roomgroups">
				<div id="roomgroups_template" class="control-group">
					<div class="controls">
						<input type="text" id="roomgroups[#index#].roomgroupName"
							name="roomgroups[#index#].roomgroupName" placeholder="组名称" /> <input
							type="hidden" name="roomgroups[#index#].roomgroupDesc"
							id="roomgroups[#index#].roomgroupDesc" /> <input type="hidden"
							name="roomgroups[#index#].roomgroupId"
							id="roomgroups[#index#].roomgroupId" /> <span class="close"
							id="roomgroups_remove_current">&times;</span>
					</div>

				</div>
				<div class="control-group">
					<span id="iroomgroups_controls"> <span class="btn btn-mini"
						id="roomgroups_add"><i class="icon-plus"></i>组</span> </span>
				</div>
				<div id="roomgroups_noforms_template" class="control-group">
					<p class="help-block">Add a new input by clicking the (+)
						button above</p>
				</div>
			</div>
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
</form:form>