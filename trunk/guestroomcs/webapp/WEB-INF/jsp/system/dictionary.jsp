<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-19 下午04:04:10
	LastModified Date:
	Description:
 -->
<div class="main_content">
	<div id="jCrumbs" class="breadCrumb module">
		<ul>
			<li><a href="#"><i class="icon-home"></i>
			</a></li>
			<li><a href="<c:url value="/system/settings" />"><spring:message code="nav.system.settings" /></a></li>
			<li><a href="#"><spring:message code="nav.system.dictionary" /></a></li>
		</ul>
	</div>
</div>
