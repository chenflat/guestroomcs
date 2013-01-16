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
	Created Date: 2012-12-28 下午03:22:14
	LastModified Date:
	Description: Cleaning Room
 -->

<div class="heading row-fluid"">
	<ul class="nav nav-pills pull-right" id="cleaningViewmode">
		<li id="list"><a href="#">列表</a></li>
		<li id="detail" class="active"><a href="#">查看</a></li>
	</ul>
</div>
<div id="tileWrap" class="row-fluid">
	<div class="thumbnails">
		<c:forEach items="${floors}" var="floor" varStatus="rowindex">
			<div>
				<div class="span6">
					<label><h4 class="title">F${floor.floorNo}</h4> </label>
					<div class="tile-large" id="${floor.floorId}"
						floorno="${floor.floorNo}">
						<ul class="tile-large-list"
							style="padding: 0px; margin: 3px 0 0 3px;">
							<c:forEach items="${floor.rooms}" var="room">
								<li id="${room.roomNo}" class="tile bg-color-green">
									<div class="tile-caption">${room.roomNo}</div>
									<div class="tile-text fg-color-white">&nbsp;</div>
									<div class="tile-badge fg-color-white">OK房</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</div>