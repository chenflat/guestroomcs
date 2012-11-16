<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午01:34:29
	LastModified Date:
	Description:
 -->

<div class="tile  bg-color-blue">
	<div class="tile-content icon">
		<a href="<c:url value="/service/requests" />"><img src="<c:url value="/img/icons/8.png" />"></a>
	</div>
	<div class="brand">
		<span class="name"><spring:message code="nav.service" />
		</span>
	</div>
</div>

<div class="tile bg-color-blueLight">
	<b class="check"></b>
	<div class="tile-content icon">
		<a href="<c:url value="/service/hvac" />"><img src="<c:url value="/img/icons/3.png" />"></a>
	</div>
	<div class="brand">
		<span class="name"><spring:message code="nav.service.hvac" />
		</span>
	</div>
</div>

<div class="tile bg-color-green">
	<div class="tile-content icon">
		<a href="<c:url value="/guest/prefs" />"><img src="<c:url value="/img/icons/1.png" />" alt=""></a>
	</div>
	<div class="brand">
		<span class="name"><spring:message code="nav.guest.prefs" />
		</span>
	</div>
</div>

<div class="tile  bg-color-greenLight">
	<div class="tile-content icon">
		<a href="<c:url value="/analyse/report" />"><img src="<c:url value="/image/Calendar128.png" />"></a>
	</div>
	<div class="brand">
		<span class="name"><spring:message code="nav.analyse" />
		</span>
	</div>
</div>

<div class="tile bg-color-grayDark">
	<b class="check"></b>
	<div class="tile-content icon">
		<a href="<c:url value="/account/profile" />"><img src="<c:url value="/img/icons/11.png" />"></a>
	</div>
	<div class="brand">
		<span class="name"><spring:message code="nav.account.profile" />
		</span>
	</div>
</div>

<div class="tile bg-color-red">
	<div class="tile-content icon">
		<a href="<c:url value="/system/settings" />"><img src="<c:url value="/img/icons/12.png" />" alt=""></a>
	</div>
	<div class="brand">
		<span class="name"><spring:message code="nav.system" />
		</span>
	</div>
</div>
