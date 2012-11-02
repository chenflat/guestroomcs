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
		<h3 class="heading">酒店建筑管理</h3>
		<div class="row">
			<div class="span6">
				<div class="btn-group sepH_b">
					<button data-toggle="dropdown" class="btn dropdown-toggle">
						操作 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="javascript:void(0)"><i class="icon-edit"></i>
								新增</a></li>
						<li><a href="javascript:void(0)"><i class="icon-edit"></i>
								编辑</a></li>
						<li><a href="#" class="delete_rows_simple"
							data-tableid="smpl_tbl"><i class="icon-trash"></i> 删除</a></li>
					</ul>
				</div>
			</div>
			<div class="span6">
				<div class="dataTables_filter" id="dt_gal_filter">
					<label>查找: <input type="text" aria-controls="dt_gal">
					</label>
				</div>
			</div>

		</div>
		<table class="table table-bordered table-striped" id="smpl_tbl">
			<thead>
				<tr>
					<th class="table_checkbox"><input type="checkbox"
						name="select_rows" class="select_rows" data-tableid="smpl_tbl">
					</th>
					<th>建筑名称</th>
					<th>建筑地址</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" name="row_sel" class="select_row">
					</td>
					<td>134</td>
					<td>Summer Throssell</td>
					<td>Pending</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="row_sel"></td>
					<td>133</td>
					<td>Declan Pamphlett</td>
					<td>Pending</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="row_sel"></td>
					<td>132</td>
					<td>Erin Church</td>
					<td>Pending</td>
				</tr>

			</tbody>
		</table>

	</div>
</div>