<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-19 下午03:21:42
	LastModified Date:
	Description:System Manage Sidebar
 -->
<div class="sidebar_inner">
	<div id="side_accordion" class="accordion">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseOne" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-user"></i> <spring:message code="nav.user.account" /> </a>
			</div>
			<div class="accordion-body collapse in" id="collapseOne">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a href="<c:url value="/user/profile" />"><spring:message code="nav.user.profile" /></a></li>
						<li><a href="<c:url value="/user/changepwd" />"><spring:message code="nav.user.changepwd" /></a></li>
						<li><a href="<c:url value="/user/handover" />"><spring:message code="nav.user.handover" /></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseTwo" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-globe"></i> <spring:message code="nav.system" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseTwo">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a href="<c:url value="/system/settings" />"><spring:message code="nav.system.settings" /></a></li>
						<li><a href="<c:url value="/system/dictionary" />"><spring:message code="nav.system.dictionary" /></a></li>
						<li><a href="<c:url value="/system/faqmanage" />"><spring:message code="nav.system.faqmanage" /></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseThree" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-th"></i> <spring:message code="nav.hotel" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseThree">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a href="<c:url value="/hotel/hotelmanage" />"><spring:message code="nav.hotel.hotel" /></a></li>
						<li><a href="<c:url value="/hotel/buildmanage" />"><spring:message code="nav.hotel.build" /></a></li>
						<li><a href="<c:url value="/hotel/roommanage" />"><spring:message code="nav.hotel.room" /></a></li>
						<li><a href="<c:url value="/hotel/roomtype" />"><spring:message code="nav.hotel.roomtype" /></a></li>
						<li><a href="<c:url value="/hotel/roomgroup" />"><spring:message code="nav.hotel.roomgroup" /></a></li>

					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseFour" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-leaf"></i> <spring:message code="nav.guest" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseFour">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a href="<c:url value="/guest/prefs" />"><spring:message code="nav.guest.prefs" /></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapseFive" data-parent="#side_accordion"
					data-toggle="collapse" class="accordion-toggle"> <i
					class="icon-folder-close"></i> <spring:message code="nav.user" /> </a>
			</div>
			<div class="accordion-body collapse" id="collapseFive">
				<div class="accordion-inner">
					<ul class="nav nav-list">
						<li><a href="<c:url value="/user/usermanage" />"><spring:message code="nav.user.usermanage" /></a></li>
						<li><a href="<c:url value="/user/rolemanage" />"><spring:message code="nav.user.rolemanage" /></a></li>
						<li><a href="<c:url value="/user/authorities" />"><spring:message code="nav.user.authorities" /></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="push"></div>
</div>
