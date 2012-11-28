<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:33:30
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form id="shiftwork" method="post">
			<div class="formRow">
				<h4 class="text-info">服务连通状况</h4>

				<div class="control-group">
					<label class="control-label switch" for="tb">服务连通情况</label> <label
						class="controls switch"> <select name="keyNumber"
						id="keyNumber">
							<option>自适应</option>

					</select> <span></span> </label>
				</div>
				<div class="control-group">
					<label class="control-label switch" for="tb">最近一次服务关闭维护时间</label> <label
						class="controls switch"> 2012-11-05<span></span> </label>
				</div>
			</div>
			<div class="formRow">
				<button class="btn btn-success">交接班</button>
			</div>
			<div class="row-fluid">
				<div class="span8">
				<table class="table table-bordered">
					<tr  class="success">
						<th>楼层</th>
						<th>交班人</th>
						<th>接班人</th>
						<th>时间</th>
					</tr>
					<tr></tr>
				</table>
			</div>
			</div>
		</form>
	</div>
</div>