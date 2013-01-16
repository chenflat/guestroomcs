<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午04:42:05
	LastModified Date:
	Description: 房间管理
 -->
<div class="row-fluid">
	<div class="span12">
		<c:if test="${totalRooms>0}">
			<div class="heading clearfix">
				<div class="pull-left">
					<span class="lead"><a href="<c:url value="/system/navigation" />">管理选项</a> <small> > 客房管理</small> </span>
				</div>
				<ul class="nav nav-pills pull-right sepH_b">
					<li <c:if test="${param.viewmode eq 'list'  or param.viewmode eq null}"> class="active"</c:if>><a
						href="?viewmode=thumbnails">列表</a></li>
					<li
						<c:if test="${param.viewmode eq 'detail'}"> class="active"</c:if>><a
						href="?viewmode=detail">查看</a>
					</li>
				</ul>
			</div>
			<p>已填充颜色的房间，表示已经启用;后续新增的房间未启用时，操作与显示都类似客户定义中的无填充色房间。</p>
			<hr class="separator" />

			<div class="tiles clearfix">
				<c:forEach items="${hotels}" var="hotel">
					<c:forEach items="${hotel.builds}" var="build">
						<c:forEach items="${build.floors}" var="floor">
							<div class="">
								<div class="pull-left span4">
									<label><h4>F${floor.floorNo}</h4> </label>
									<div class="tile-medium">
										<div class="tile-medium-list">
											<c:forEach items="${floor.rooms}" var="room">
												<span class="tile bg-color-white border-color-blue"><c:out
														value="${room.roomNo}"></c:out> </span>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</c:forEach>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${totalRooms==0}">
			<!-- 初始化房间 -->
			<form id="initRoom" class="stepy-wizzard form-horizontal"
				method="post">
				<fieldset title="客房定义 - 初始化参数">
					<legend class="lead hide">Guest Room Definition - init
						paramter </legend>
					<h3>
						<small>当前系统的客房楼层数据为空，需要进行客房号码的初始化操作。请设置好初始化所需参数，然后点击“Next”按钮预览。</small>
					</h3>

					<hr class="separator" />

					<div class="lead">
						<span class="text-info">参数设置</span>
					</div>
					<div class="control-group">
						<label for="hotel" class="control-label">酒店列表</label>
						<div class="controls">
							<select id="hotel" name="hotel">
								<c:forEach items="${hotels}" var="hotel">
									<option value="${hotel.hotelId}">${hotel.hotelName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label for="build" class="control-label">酒店建筑</label>
						<div class="controls">
							<select id="build" name="build">
								<c:forEach items="${builds}" var="build">
									<option value="${build.buildId}">${build.buildName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label for="floor" class="control-label">楼层数</label>
						<div class="controls">
							<input type="text" name="floor" id="floor" />
						</div>
					</div>
					<div class="control-group">
						<label for="room" class="control-label">每层最大房间数</label>
						<div class="controls">
							<input type="text" name="room" id="room" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="removeFloorNum">除去带4、13的楼层数</label>
						<div class="controls">
							<label class="switch"> <input type="checkbox"
								id="removeFloorNum" name="removeFloorNum" checked="checked" />
								<span>On</span> </label>
						</div>
					</div>
					<div class="control-group">
						<label for="hvac" class="control-label">默认空调模式</label>
						<div class="controls">
							<select id="hvac" name="hvac">
								<option value="auto">Auto</option>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label for="temperature" class="control-label">默认设定温度</label>
						<div class="controls">
							<select id="temperature" name="temperature">
								<option value="23">23℃</option>
							</select>
						</div>
					</div>
					<div class="lead">
						<span class="text-info">客房类型</span>
					</div>
					<select name="chosen_a" id="chosen_a" data-placeholder="客房类型"
						class="chzn_a">
						<option value=""></option>
						<option value="DZ">Algeria</option>
						<option value="AO">Angola</option>
					</select>

				</fieldset>
				<fieldset title="客房定义 - 预览">
					<legend class="lead hide"> Preview Guest Room</legend>

				</fieldset>
				<button type="button" class="finish btn btn-primary">
					<i class="icon-ok icon-white"></i> 保存
				</button>

			</form>
		</c:if>
	</div>
</div>
<!-- 删除提示 -->
<%@ include file="room/room_delete.jsp"%>
<!-- 批量新增 -->
<%@ include file="room/room_batchadd.jsp"%>
<!-- 批量新增 -->
<%@ include file="room/room_group.jsp"%>
