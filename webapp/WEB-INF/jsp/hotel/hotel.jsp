<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午04:41:35
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form:form commandName="hotel" enctype="multipart/form-data"
			class="form-horizontal form_validation_ttip" method="post">
			<c:if test="${not empty message}">
				<c:out value="${message}" escapeXml="false" />
			</c:if>
			<legend>
				<spring:message code="nav.hotel.hotel" />
			</legend>
			<div class="control-group">
				<form:label path="hotelName" class="control-label">酒店名称</form:label>
				<div class="controls">
					<form:input path="hotelName" />
					<span class="help-inline">* <form:errors path="hotelName" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelEnname" class="control-label">英文名称</form:label>
				<div class="controls">
					<form:input path="hotelEnname" />
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelAddress" class="control-label">酒店地址</form:label>
				<div class="controls">
					<form:input path="hotelAddress" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="district.districtId" class="control-label">所属地区</form:label>
				<div class="controls">
					<form:input path="district.districtId" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelPhone" class="control-label">联系电话</form:label>
				<div class="controls">
					<form:input path="hotelPhone" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelFax" class="control-label">传真号码</form:label>
				<div class="controls">
					<form:input path="hotelFax" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelDesc" class="control-label">描述信息</form:label>
				<div class="controls">
					<form:textarea path="hotelDesc" rows="3" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelPhoto" class="control-label">酒店照片</form:label>
				<div class="controls">
					<form:hidden path="hotelPhoto" />
					<div data-fileupload="image" class="fileupload fileupload-new">
						<div style="width: 80px; height: 80px;"
							class="fileupload-new thumbnail">
							<img src="<c:url value="${hotel.hotelPhoto}" />" alt="" />
						</div>
					</div>
					<input class="input-file" type="file" name="file"/ >
				</div>
			</div>


			<legend>地理设置</legend>
			<div class="control-group">
				<form:label path="hotelLong" class="control-label">经度</form:label>
				<div class="controls">
					<form:input path="hotelLong" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelLat" class="control-label">纬度</form:label>
				<div class="controls">
					<form:input path="hotelLat" />
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="form-actions">

				<form:hidden path="hotelId" />

				<button class="btn btn-inverse" type="submit">
					<spring:message code="button.submit" />
				</button>
				<button class="btn">
					<spring:message code="button.cancel" />
				</button>
			</div>
		</form:form>
	</div>
</div>

