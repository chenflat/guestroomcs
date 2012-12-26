<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
	
<c:set var="requestParam"
	value="${requestScope['javax.servlet.forward.query_string']}"
	scope="request" />	
	
	
<!-- User Manage Sidebar -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<div class="sidebar_inner">
					<form class="input-append" >
					</form>
					
					<div id="side_quickview" class="quickview">
						<ul class="nav nav-list">
							<li <c:if test="${fn:contains(requestURL, '/account/profile') or fn:endsWith(requestURL, '/account/picture')}">class="active"</c:if>><a href="<c:url value="/account/profile" />"><spring:message code="nav.account.profile" /></a>
							</li> 
							<li <c:if test="${fn:endsWith(requestURL, '/account/personalize')}">class="active"</c:if>><a href="<c:url value="/account/personalize" />"><spring:message code="nav.account.personalize" /></a>
							</li>
							<li <c:if test="${fn:endsWith(requestURL, '/account/notification')}">class="active"</c:if>><a href="<c:url value="/account/notification" />"><spring:message code="nav.account.notification" /></a>
							</li>
							<li <c:if test="${fn:endsWith(requestURL, '/account/search')}">class="active"</c:if>><a href="<c:url value="/account/search" />"><spring:message code="nav.account.search" /></a>
							</li>
							<li <c:if test="${fn:endsWith(requestURL, '/account/usability')}">class="active"</c:if>><a href="<c:url value="/account/usability" />"><spring:message code="nav.account.usability" /></a>
							</li>
							<li <c:if test="${fn:endsWith(requestURL, '/account/shiftwork')}">class="active"</c:if>><a href="<c:url value="/account/shiftwork" />"><spring:message
										code="nav.account.shiftwork" /> </a>
							</li>
						</ul>
					</div>
				</div>


			</div>
		</div>
	</div>
</div>