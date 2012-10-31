<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午04:40:51
	LastModified Date:
	Description:
 -->

<c:set var="colors"
	value="blue,blueLight,blueDark,green,greenLight,greenDark,red,yellow,orange,orangeDark,pink,pinkDark,purple,darken,grayDark,blue,blueLight,blueDark,green,greenLight,greenDark,,pink,pinkDark,purple,darken,grayDark,yellow,orange,orangeDark,pink"></c:set>

<div class="heading clearfix">
	<ul class="nav nav-pills pull-right sepH_b">
		<li class="active"><a href="#">列表</a>
		</li>
		<li><a href="#">缩略图</a></li>
		<li><a href="#">详细</a></li>
	</ul>
</div>



<div class="tiles clearfix">
	<div class="row">
		<c:forEach var="row" begin="1" end="24" varStatus="rowindex">
			<div class="span2">
				<div class="pull-left">
					<label><h4>F${row}</h4> </label>
					<div
						class="tile bg-color-<c:forEach items="${colors}" var="color" varStatus="colorindex"><c:if test="${rowindex.index eq colorindex.index+1}">${color}</c:if></c:forEach>">
						<div class="tile-small">
							<ul class="tile-smaill-list">
								<c:forEach var="i" begin="1" end="30">
									<li><c:out value="${i}"></c:out>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>

<%-- <c:forEach items="${colors}" var="color" varStatus="colorindex">
	<c:if test="${rowindex.index eq colorindex.index+1}">${color}</c:if>
	${color} ${colorindex.index+1}<br />
</c:forEach> --%>


