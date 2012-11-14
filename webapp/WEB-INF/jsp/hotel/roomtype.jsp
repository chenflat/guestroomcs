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
		<c:forEach items="${roomtypes}" var="roomtype">
			<a href="<c:url value="/hotel/roomtype/edit/${roomtype.roomtypeId}" />">
				<div class="tile bg-color-pinkDark icon">
					<b class="check"></b>
					<div class="tile-content">
						<img src="<c:url value="/img/icons/Windows 8.png" /> ">
					</div>
					<div class="brand">
						<span class="name">${roomtype.roomtypeName}</span>
					</div>
				</div> </a>
		</c:forEach>
	</div>
</div>