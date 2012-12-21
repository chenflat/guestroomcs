<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-29 上午09:33:51
	LastModified Date:
	Description:
 -->
<div class="main_content_sidebar">
	<div class="heading row-fluid"">
		<ul class="nav nav-pills pull-right" id="hvacViewmode">
			<li id="panel" class="active"><a href="#">显示操作面板</a></li>
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
							<ul class="tile-large-list" style="padding:0px;margin:3px 0 0 3px;">
								<c:forEach items="${floor.rooms}" var="room">
									<li id="${room.roomNo}" class="tile">
										<div class="tile-caption fg-color-white">${room.roomNo}</div>
										<div class="tile-text fg-color-white"></div>
										<div class="tile-badge fg-color-white"><i class="icon-off icon-white"></i></div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					</div>
				</c:forEach>
			</div>
	
	</div>
	
	<div class="hvac_bar">

	
	</div>
</div>
