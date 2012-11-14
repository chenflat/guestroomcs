<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-9 下午01:09:00
	LastModified Date:
	Description:
 -->
<div class="row-fluid">
	<div class="span12">
		<form:form commandName="roomtype"
			class="form-horizontal form_validation_ttip"
			enctype="multipart/form-data" method="post">
			<c:if test="${not empty message}">
				<c:out value="${message}" escapeXml="false" />
			</c:if>
			<legend>
				<spring:message code="nav.hotel.roomtype" />
			</legend>
			<div class="control-group">
				<form:label path="roomtypeName" class="control-label">类型名称</form:label>
				<div class="controls">
					<form:input path="roomtypeName" />
					<span class="help-inline">* <form:errors path="roomtypeName" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="roomtypeName" class="control-label">所属酒店</form:label>
				<div class="controls">
					<form:select path="hotel.hotelId">
						<form:options items="${hotels}" itemValue="hotelId" itemLabel="hotelName" />
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<form:label path="roomtypeMinguests" class="control-label">最小客人数</form:label>
				<div class="controls">
					<form:input path="roomtypeMinguests" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="roomtypeMaxguests" class="control-label">最大客人数</form:label>
				<div class="controls">
					<form:input path="roomtypeMaxguests" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="roomtypeIssmoking" class="control-label">是否允许抽烟</form:label>
				<div class="controls">
					<form:checkbox path="roomtypeIssmoking" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="roomtypePhoto" class="control-label">客房照片</form:label>
				<div class="controls">
					<form:hidden path="roomtypePhoto" />
					<div data-fileupload="image" class="fileupload fileupload-new">
						<div style="width: 80px; height: 80px;"
							class="fileupload-new thumbnail">
							<img src="<c:url value="${roomtype.roomtypePhoto}" />" alt="" />
						</div>
					</div>
					<input class="input-file" type="file" name="file"/ >
				</div>
			</div>
			<div class="control-group">
				<form:label path="roomtypeComment" class="control-label">备注</form:label>
				<div class="controls">
					<form:textarea path="roomtypeComment" rows="3" />
				</div>
			</div>

			<div class="form-actions">
				<form:hidden path="roomtypeId" />
				<button class="btn btn-inverse" type="submit">
					<spring:message code="button.submit" />
				</button>
				<a href="<c:url value="/hotel/roomtype" />" class="btn"><spring:message
						code="button.cancel" /> </a>

			</div>
		</form:form>

	</div>
</div>