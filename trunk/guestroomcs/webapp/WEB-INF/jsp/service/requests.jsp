<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Service Request -->
<c:set var="colors"
	value="green,greenLight,greenDark,red,yellow,orange,orangeDark,pink,pinkDark,purple,darken,grayDark,blue,blueLight,blueDark,green,greenLight,greenDark,,pink,pinkDark,purple,darken,grayDark,yellow,orange,orangeDark,pink"></c:set>

<div class="heading row-fluid"">
	<div class="span4 service-title"><h4></h4></div>
	<div class="span8">
		<ul class="nav nav-pills pull-right ">
			<li><a href="#">列表</a></li>
			<li class="active"><a href="#">缩略图</a>
			</li>
			<li><a href="#">详细</a>
			</li>
		</ul>
	</div>
</div>

<div class="tiles clearfix">
	<div class="row" id="roomcontainer">
		<c:forEach items="${floors}" var="floor" varStatus="rowindex">
			<div class="span2">
				<div class="pull-left">
					<label><h4>F${floor.floorNo}</h4> </label>
					<div
						class="tile bg-color-<c:forEach items="${colors}" var="color" varStatus="colorindex"><c:if test="${rowindex.index eq colorindex.index}">${color}</c:if></c:forEach>">
						<div class="tile-small">
							<ul class="tile-smaill-list">
								<c:forEach items="${floor.rooms}" var="room">
									<li id="${room.roomNo}"></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


