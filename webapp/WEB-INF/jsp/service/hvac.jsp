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
	
	<div class="hvac_bar navbar-fixed-bottom">
	<form id="havc_control" class="form-horizontal">
		空调模式：<img data-src="holder.js/30x30/#fff:#008000/text:自动" class="img-circle solid" />
		<img data-src="holder.js/30x30/#fff:#FD0202/text:供热" class="img-circle" />
		<img data-src="holder.js/30x30/#fff:#5757FD/text:供冷" class="img-circle" />
		<img data-src="holder.js/30x30/#fff:#000/text:干燥" class="img-circle" />
		<img data-src="holder.js/30x30/#fff:#FDFDAA/text:关闭" class="img-circle" />
		<img data-src="holder.js/30x30/#fff:#7F027F/text:手动" class="img-circle" />
		环境温度：<span id="txtCurrTempValue" class="currTempValue">℃</span> 
		编号 ：  <select name="tempController" class="input-small">
			<option value="0">温控器1</option>
			<option value="1">温控器2</option>
			<option value="2">温控器3</option>
			<option value="3">温控器4</option>
			<option value="4">温控器5</option>
			<option value="5">温控器6</option>
			<option value="6">温控器7</option>
		</select>
		设定温度：
		<img data-src="holder.js/30x30/#fff:#000/text:&lt;" class="img-circle" id="subtractTempVal" />
		<span id="txtCurrSetTempValue" class="currTempValue">℃</span>
		<input type="hidden" name="inputSetTempValue" id="inputSetTempValue" />
		<input type="hidden" name="inputCurrRoomNum" id="inputCurrRoomNum" />
		<img data-src="holder.js/30x30/#fff:#000/text:&gt;" class="img-circle" id="additionTempVal" />
		
		&nbsp;&nbsp;&nbsp;
		客人姓名：<input type="text" class="input-small" name="guestname" id="guestname" />
		<input type="radio" name="sex" id="sex" value="Mr" checked="checked">先生
		<input type="radio" name="sex" id="sex" value="Miss" >女士
		<input type="button" id="checkin" value="checkin" />
	</form>
	</div>
</div>
