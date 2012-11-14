<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- My Tasks -->

<div class="modal hide fade" id="myTasks">
	<div class="modal-header">
		<button class="close" data-dismiss="modal">×</button>
		<h3>新任务</h3>
	</div>
	<div class="modal-body">
		<div class="alert alert-info">In this table jquery plugin turns
			a table row into a clickable link.</div>
		<table class="table table-condensed table-striped" data-rowlink="a">
			<thead>
				<tr>
					<th>id</th>
					<th>Summary</th>
					<th>Updated</th>
					<th>Priority</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>P-23</td>
					<td><a href="javascript:void(0)">Admin should not break if
							URL…</a></td>
					<td>23/05/2012</td>
					<td class="tac"><span class="label label-important">High</span>
					</td>
					<td>Open</td>
				</tr>
				<tr>
					<td>P-18</td>
					<td><a href="javascript:void(0)">Displaying submenus in
							custom…</a></td>
					<td>22/05/2012</td>
					<td class="tac"><span class="label label-warning">Medium</span>
					</td>
					<td>Reopen</td>
				</tr>
				<tr>
					<td>P-25</td>
					<td><a href="javascript:void(0)">Featured image on post
							types…</a></td>
					<td>22/05/2012</td>
					<td class="tac"><span class="label label-success">Low</span></td>
					<td>Updated</td>
				</tr>
				<tr>
					<td>P-10</td>
					<td><a href="javascript:void(0)">Multiple feed fixes and…</a>
					</td>
					<td>17/05/2012</td>
					<td class="tac"><span class="label label-warning">Medium</span>
					</td>
					<td>Open</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0)" class="btn">Go to task manager</a>
	</div>
</div>