<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-9 上午09:01:55
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form:form commandName="build"
			class="form-horizontal form_validation_ttip" method="post">
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">${message}</div>
			</c:if>
			<legend>
				<spring:message code="nav.hotel.build" />
			</legend>
			<div class="control-group">
				<form:label path="buildName" class="control-label">建筑名称</form:label>
				<div class="controls">
					<form:input path="buildName" />
					<span class="help-inline">* <form:errors path="buildName" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="buildAddress" class="control-label">建筑地址</form:label>
				<div class="controls">
					<form:input path="buildAddress" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="buildComment" class="control-label">建筑地址</form:label>
				<div class="controls">
					<form:textarea path="buildComment" />
				</div>
			</div>
			<div class="form-actions">

				<form:hidden path="buildId" />
				<form:hidden path="hotel.hotelId" />
				<button class="btn btn-inverse" type="submit">
					<spring:message code="button.submit" />
				</button>

				<a href="<c:url value="/hotel/build" />" class="btn"><spring:message
						code="button.cancel" />
				</a>

			</div>

		</form:form>
	</div>
</div>