<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午12:34:28
	LastModified Date:
	Description:
 -->
<form action="<c:url value="/guest/prefs" />" class="input-append">
	<input autocomplete="off" name="query" class="search_query input-large"
		type="text" placeholder="Filter" />
	<button type="submit" class="btn">
		<i class="icon-search"></i>
	</button>
</form>
<hr class="separator">

<table class="table">
	<thead>
		<tr>
			<th>编号</th>
			<th>客人姓名</th>
			<th>分组</th>
			<th>常用房间号</th>
			<th>常用房间类型</th>
			<th>常用空调模式</th>
			<th>常用设定温度</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>Mark</td>
			<td>Otto</td>
			<td>@mdo</td>
			<td>Mark</td>
			<td>Otto</td>
			<td>@mdo</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Jacob</td>
			<td>Thornton</td>
			<td>@fat</td>
			<td>Mark</td>
			<td>Otto</td>
			<td>@mdo</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Larry</td>
			<td>the Bird</td>
			<td>@twitter</td>
			<td>Mark</td>
			<td>Otto</td>
			<td>@mdo</td>
		</tr>
	</tbody>
</table>