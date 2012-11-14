<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- My Mail-->
<div class="modal hide fade" id="myMail">
	<div class="modal-header">
		<button class="close" data-dismiss="modal">×</button>
		<h3>新消息</h3>
	</div>
	<div class="modal-body">
		<div class="alert alert-info">In this table jquery plugin turns
			a table row into a clickable link.</div>
		<table class="table table-condensed table-striped" data-rowlink="a">
			<thead>
				<tr>
					<th>Sender</th>
					<th>Subject</th>
					<th>Date</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Declan Pamphlett</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a></td>
					<td>23/05/2012</td>
					<td>25KB</td>
				</tr>
				<tr>
					<td>Erin Church</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a></td>
					<td>24/05/2012</td>
					<td>15KB</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0)" class="btn">Go to mailbox</a>
	</div>
</div>