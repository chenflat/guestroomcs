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
	Created Date: 2012-12-24 上午11:30:26
	LastModified Date:
	Description: Floor Heating
 -->

<div id="tileWrap" class="row-fluid">
	<div class="thumbnails">
		<c:forEach items="${floors}" var="floor" varStatus="rowindex">
			<div>
				<div class="span4">
					<label><h4 class="title">F${floor.floorNo}</h4> </label>
					<div class="tile-medium" id="${floor.floorId}"
						floorno="${floor.floorNo}">
						<ul class="tile-medium-list"
							style="padding: 0px; margin: 3px 0 0 3px;">
							<c:forEach items="${floor.rooms}" var="room">
								<li id="${room.roomNo}" class="tile">
									<div class="tile-caption fg-color-white">${room.roomNo}</div></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

