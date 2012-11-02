<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:32:55
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form>
			<h4 class="text-info">工作提示</h4>
			<div class="control-group">
				<label class="control-label switch" for="tb">显示所有提示</label> <label
					class="controls switch"> <input type="checkbox"> <span></span>
				</label>
			</div>
			<div class="control-group formSep">
				<label class="control-label switch" for="tb">显示所有HVAC提示</label> <label
					class="controls switch"> <input type="checkbox"> <span></span>
				</label>
			</div>
			<h4 class="text-info">提示音</h4>
			<div class="control-group formSep clearfix">
				<label class="control-label" for="music">选择提示音</label>
					<select name="music">
						<option>beep(Default)</option>
					</select>
			</div>
			<h4 class="text-info">提示历史</h4>
		</form>
	</div>
</div>