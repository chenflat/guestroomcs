<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-12-27 上午11:14:52
	LastModified Date:
	Description: Contact Info
 -->

<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="main_content_sidebar">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="heading">编辑联系信息</h3>
			<form:form modelAttribute="user" class="form_validation_ttip" method="post">
			<!-- Email Form -->
			<div class="formRow">
				<div class="control-group">
					<h4>电子邮件</h4>
				</div>
				<!-- ForEach Email -->
				
				<c:forEach items="${user.emailaddressList}" var="email" varStatus="status">
				<div type="list" id="${email.keyname}" style="display:<c:choose><c:when test="${status.index eq 0 or !empty email.address}">block</c:when><c:otherwise>none</c:otherwise></c:choose>;">
					<div class="control-group">
						<label class="control-label" for="emailaddressList[${status.index}].address">${email.comment}</label>
					</div>
					<div class="controls">
						<input type="text" name="emailaddressList[${status.index}].address" value="${email.address}" />
						<input type="hidden" name="emailaddressList[${status.index}].entryid" value="${email.entryid}" />
						<input type="hidden" name="emailaddressList[${status.index}].comment" value="${email.comment}" />
						<input type="hidden" name="emailaddressList[${status.index}].keyname" value="${email.keyname}" />
						<input type="hidden" name="emailaddressList[${status.index}].primary" value="${email.primary}" />
						<input type="hidden" name="emailaddressList[${status.index}].emailAddressId" value="${email.emailAddressId}" />
					</div>
				</div>
				</c:forEach>
				<!-- /ForEach Email -->

				<div class="dropdown">
					<a class="dropdown-toggle win-command" data-toggle="dropdown"><i
						class="winicon-new-small"></i><span class="win-label" style="color:#000000;">邮件</span> </a>
					<ul id="menuEmailAddress" class="dropdown-menu detail-entry">
						<c:forEach items="${emailladdressTypes}" var="eat"
							varStatus="status">
							<li class="menu-entry"><a id="${eat.value}" tabindex="${status.index}" href="#">${eat.text}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- /Email Form -->
			
			<!-- Phone Form -->
			<div class="formRow">
				<div class="control-group">
					<h4>电话</h4>
				</div>
				<!-- ForEach Phone -->
				<c:forEach items="${user.phoneList}" var="phone" varStatus="status">
				<div type="list" id="${phone.keyname}" style="display:<c:choose><c:when test="${status.index eq 0  or !empty phone.number}">block</c:when><c:otherwise>none</c:otherwise></c:choose>;">
					<div class="control-group">
						<label class="control-label" for="phoneList[${status.index}].number">${phone.comment}</label>
					</div>
					<div class="controls">
						<input type="text" name="phoneList[${status.index}].number" value="${phone.number}" />
						<input type="hidden" name="phoneList[${status.index}].entryid" value="${phone.entryid}" />
						<input type="hidden" name="phoneList[${status.index}].comment" value="${phone.comment}" />
						<input type="hidden" name="phoneList[${status.index}].keyname" value="${phone.keyname}" />
						<input type="hidden" name="phoneList[${status.index}].primary" value="${phone.primary}" />
						<input type="hidden" name="phoneList[${status.index}].phoneId" value="${phone.phoneId}" />
					</div>
					</div>
				</c:forEach>
				<!-- /ForEach Phone -->
				<div class="dropdown">
					<a class="dropdown-toggle win-command" data-toggle="dropdown"><i
						class="winicon-new-small"></i><span class="win-label" style="color:#000000;">电话</span> </a>
					<ul id="menuPhone" class="dropdown-menu">
						<c:forEach items="${phoneTypes}" var="pt" varStatus="status">
							<li class="menu-entry"><a id="${pt.value}" tabindex="${status.index}" href="#">${pt.text}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- /Phone Phone -->

			<!-- Address Form -->
			<div class="formRow">
				<div class="control-group">
					<h4>地址</h4>
				</div>
				<!-- ForEach Address -->
				<c:forEach items="${user.addressList}" var="address" varStatus="status">
				<div type="list" id="${address.keyname}" style="display:<c:choose><c:when test="${!empty address.state}">block</c:when><c:otherwise>none</c:otherwise></c:choose>;">
					<div class="control-group">
						<label class="control-label" for="addressList[${status.index}].state">${address.comment}</label>
					</div>
					<div class="controls">
						<input type="text" name="addressList[${status.index}].state" value="${address.state}" placeholder="省/市/自治区" /> <br />
						<input type="text" name="addressList[${status.index}].city" value="${address.city}" placeholder="市县" />  <br />
						<input type="text" name="addressList[${status.index}].street" value="${address.street}" placeholder="街道" />  <br />
						<input type="text" name="addressList[${status.index}].zipcode" value="${address.zipcode}" placeholder="邮编" />  <br />
						<input type="text" name="addressList[${status.index}].country" value="${address.country}" placeholder="国家地区" />
						
						<input type="hidden" name="addressList[${status.index}].entryid" value="${address.entryid}" />
						<input type="hidden" name="addressList[${status.index}].comment" value="${address.comment}" />
						<input type="hidden" name="addressList[${status.index}].keyname" value="${address.keyname}" />
						<input type="hidden" name="addressList[${status.index}].primary" value="${address.primary}" />
						<input type="hidden" name="addressList[${status.index}].addressId" value="${address.addressId}" />
					</div>
					</div>
				</c:forEach>
				<!-- /ForEach Address -->

				<div class="dropdown">
					<a class="dropdown-toggle win-command" data-toggle="dropdown"><i
						class="winicon-new-small"></i><span class="win-label" style="color:#000000;">地址</span> </a>
					<ul id="menuAddress" class="dropdown-menu">
						<c:forEach items="${addressTypes}" var="at" varStatus="status">
							<li class="menu-entry"><a id="${at.value}" tabindex="${status.index}" href="#">${at.text}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- /Address Form -->
			
				<div class="control-group">
					<div class="controls">
						<form:hidden path="userId" />
						<button class="btn input-small btn-submit">
							<spring:message code="button.submit" />
						</button>
						<a href="<c:url value="/account/profile" />"
							class="btn btn-cancel input-mini">返回 </a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
