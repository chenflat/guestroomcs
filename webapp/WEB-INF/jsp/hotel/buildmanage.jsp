<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午04:41:50
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<h3 class="heading">集团酒店</h3>
		<div class="btn-group sepH_b">
			<button data-toggle="dropdown" class="btn dropdown-toggle">
				Action <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#" class="delete_rows_simple"
					data-tableid="smpl_tbl"><i class="icon-trash"></i> Delete</a>
				</li>
				<li><a href="javascript:void(0)">Lorem ipsum</a>
				</li>
				<li><a href="javascript:void(0)">Lorem ipsum</a>
				</li>
			</ul>
		</div>
		<table class="table table-bordered table-striped" id="smpl_tbl">
			<thead>
				<tr>
					<th class="table_checkbox"><input type="checkbox"
						name="select_rows" class="select_rows" data-tableid="smpl_tbl">
					</th>
					<th>id</th>
					<th>Customer</th>
					<th>Status</th>
					<th>Date Added</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" name="row_sel" class="select_row">
					</td>
					<td>134</td>
					<td>Summer Throssell</td>
					<td>Pending</td>
					<td>24/04/2012</td>
					<td>$120.23</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="row_sel">
					</td>
					<td>133</td>
					<td>Declan Pamphlett</td>
					<td>Pending</td>
					<td>23/04/2012</td>
					<td>$320.00</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="row_sel">
					</td>
					<td>132</td>
					<td>Erin Church</td>
					<td>Pending</td>
					<td>23/04/2012</td>
					<td>$44.00</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="row_sel">
					</td>
					<td>131</td>
					<td>Koby Auld</td>
					<td>Pending</td>
					<td>22/04/2012</td>
					<td>$180.20</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="row_sel">
					</td>
					<td>130</td>
					<td>Anthony Pound</td>
					<td>Pending</td>
					<td>20/04/2012</td>
					<td>$610.42</td>
				</tr>
			</tbody>
		</table>

	</div>
</div>