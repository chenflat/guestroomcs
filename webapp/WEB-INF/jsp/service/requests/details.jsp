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
	Created Date: 2012-12-11 上午10:46:21
	LastModified Date:
	Description:Details
 -->
<div class="row-fluid">
	<div class="span5">
		<h1>F${floor.floorNo}</h1>
	</div>
	<div class="span7">
		<div
			class="floors-section pagination pagination-large pagination-right" style="padding-bottom:0px;margin:0px;">
			<ul id="floorSections">
				<c:forEach items="${floorSections}" var="section">
					<li id="${section.key}"><a href="#" rel="popover">${section.key}</a></li>
				</c:forEach>
			</ul>
		</div>
		<!-- 显示楼层列表 -->
		<div class="floors-nav bottom">
			<div class="arrow" style="width:20px;height:20px;"></div>
			<div class='pagination pagination-right' id="floors-nav" style="padding-bottom:0px;margin:0px;">
			<c:forEach items="${floorSections}" var="section">
			<div id="cont_${section.key}" style="display: none;">
							<ul>
								<c:forEach items="${section.value}" var="item">
									<li><a href='#'>${item.floorNo}</a></li>
								</c:forEach>
							</ul>
						</div>
			</c:forEach>
			</div>
		</div>
	</div>
</div>
<div class="row-fluid">

	<c:forEach items="${floor.rooms}" var="room">
		<div id="room_${room.roomNo}" class="room border-color-grayDark">
			<h4 class="pull-right">${room.roomNo}</h4>
			<div class="pull-left">
				<ul class="service-list nav nav-list">
					
				</ul>
			</div>
		</div>
	</c:forEach>

</div>