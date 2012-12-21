<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form id="roominfo" method="post">
	<div id="roomBatchaddModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-hidden="true">

		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3>批量新增客房</h3>
		</div>
		<div class="modal-body">
			<div class="control-group">
				<div class="controls">
					<input type="text" name="beginNo" id="beginNo" placeholder="起始房间号" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="text" name="endNo" id="endNo" placeholder="结束房间号" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<select name="chosen_a" id="chosen_a" data-placeholder="客房类型"
						class="chzn_a">
						<option value=""></option>
						<option value="DZ">Algeria</option>
						<option value="AO">Angola</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<select id="hvac" name="hvac" placeholder="默认空调模式">
						<option value="auto">Auto</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<select id="temperature" name="temperature" placeholder="默认设定温度">
						<option value="23">23℃</option>
					</select>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">
				<spring:message code="button.cancel" />
			</button>
			<a id="btn-delete" href="#"
				url="<c:url value="/hotel/roommanage/batchadd" />"
				class="btn btn-primary"><spring:message code="button.batchadd" />
			</a>
		</div>

	</div>
</form>