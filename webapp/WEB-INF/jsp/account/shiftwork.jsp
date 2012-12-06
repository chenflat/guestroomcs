<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:33:30
	LastModified Date:
	Description:
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="row-fluid">
	<div class="span12">
		${message}

		<div class="formRow">
			<h4 class="text-info">服务连通状况</h4>

			<div class="control-group">
				<label class="control-label switch" for="tb">服务连通情况</label> <label
					class="controls switch"> </label>
			</div>
			<div class="control-group">
				<label class="control-label switch" for="tb">最近一次服务关闭维护时间</label> <label
					class="controls switch"> 2012-11-05<span></span> </label>
			</div>
		</div>
		<div class="formRow">
			<button class="btn btn-success" id="btn_shiftwork"
				data-toggle="modal" data-backdrop="static" href="#shiftworkModal">交接班</button>
		</div>
		<div class="row-fluid">
			<div class="span8">
			 <div class="widget-content table-container">
				<table class="table table-bordered" id="shiftworklog">
					<thead>
						<tr class="success">
							<th>楼层</th>
							<th>交班人</th>
							<th>接班人</th>
							<th>时间</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				</div>
			</div>
		</div>

	</div>
</div>
<form:form modelAttribute="shiftwork" method="post"
	class=" form_validation_ttip">
	<div id="shiftworkModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>
				<strong>交接班</strong>
			</h3>
		</div>
		<div class="modal-body">
			<p>用于客房部的客房服务工作换班交接，前厅部前台交接班由于涉及对账操作不包括在内。</p>
			<p></p>
			<div class="control-group">
				<form:label path="backlog" cssClass="control-label">待办事项</form:label>
				<div class="controls">
					<form:textarea path="backlog" rows="3" cssClass="span4"  placeholder="(交班人填写)" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="shiftitems" cssClass="control-label">交接物品</form:label>
				<div class="controls">
					<form:textarea path="shiftitems" rows="3" cssClass="span4"  placeholder="(交班人填写,接班人确认)" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.password">交班人密码</label>
				<div class="controls">
					<input type="password" name="user.password" id="user.password" placeholder="(交班人填写)" />
					<form:hidden path="user.userId" />
					<form:hidden path="user.username" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="comment" cssClass="control-label">备注</form:label>
				<div class="controls">
					<form:textarea path="comment" rows="3" cssClass="span4" placeholder="(接班人填写)" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="shiftworkerName" cssClass="control-label">接班人</form:label>
				<div class="controls">
					<form:input path="shiftworkerName" placeholder="(接班人填空)" />
					<form:hidden path="shiftworker" />
					<form:hidden path="floorNo" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="floorNo" cssClass="control-label">接班人密码</form:label>
				<div class="controls">
					<form:password path="shiftworkerName"  placeholder="(接班人填空)" />
				</div>
			</div>
			<div class="control-group">
				
			
			</div>
		</div>
		<div class="modal-footer">
			<span class="pull-left">交接班时间：<form:hidden path="workEndtime"/> ${shiftwork.workEndtime} </span>
			<button class="btn" data-dismiss="modal" aria-hidden="true">
				<spring:message code="button.cancel" />
			</button>
			<button class="btn btn-primary">
				<spring:message code="button.submit" />
			</button>
		</div>
	</div>
</form:form>