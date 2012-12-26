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
				<a href="<c:url value="/system/navigation" />">管理选项</a> <small> > 机构设置</small>
			</legend>
			<p>设置机构相关信息</p>
		<hr class="separator" />
		<legend class="text-info">机构信息</legend>
			<div class="control-group">
				<form:label path="hotelEnname" class="control-label">机构代码</form:label>
				<div class="controls">
					<form:input path="hotelEnname" />
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelName" class="control-label">机构描述</form:label>
				<div class="controls">
					<form:input path="hotelName" />
					<span class="help-inline">* <form:errors path="hotelName" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelDesc" class="control-label">描述后缀</form:label>
				<div class="controls">
					<form:input path="hotelDesc"/>
				</div>
			</div>
			<div class="control-group">
				<form:label path="currency" class="control-label">基本货币</form:label>
				<div class="controls">
					<form:select path="currency">
						<form:options items="${currencies}" itemLabel="text" itemValue="value" />
					</form:select>
				</div>
			</div>
			<legend class="text-info">地址</legend>
			<div class="control-group">
				<form:label path="hotelAddress" class="control-label">地址</form:label>
				<div class="controls">
					<form:input path="hotelAddress" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelState" class="control-label">省/市/自治区</form:label>
				<div class="controls">
					<form:input path="hotelState" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelCity" class="control-label">城市</form:label>
				<div class="controls">
					<form:input path="hotelCity" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelCountry" class="control-label">国家</form:label>
				<div class="controls">
					<form:input path="hotelCountry" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="hotelZip" class="control-label">邮编</form:label>
				<div class="controls">
					<form:input path="hotelZip" />
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
				<form:label path="hotelEmail" class="control-label">邮件地址</form:label>
				<div class="controls">
					<form:input path="hotelEmail" />
				</div>
			</div>
			<legend class="text-info">照片</legend>
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

				<button class="btn input-small btn-submit" type="submit">
					<spring:message code="button.submit" />
				</button>
				<a class="btn input-mini btn-cancel" href="<c:url value="/system/navigation"/>">
					<spring:message code="button.cancel" />
				</a>
			</div>
		</form:form>
	</div>
</div>

