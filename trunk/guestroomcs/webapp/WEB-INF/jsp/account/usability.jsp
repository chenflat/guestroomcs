<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:33:18
	LastModified Date:
	Description:
 -->


<div class="row-fluid">
	<div class="span12">
		<form id="usability" method="post">
			<div class="formRow">
				<h4 class="text-info">默认使用方式</h4>
				<div class="control-group">
					<label class="control-label switch" for="tb">切换普通PC与平板电脑</label> <label
						class="controls switch"> <select name="keyNumber"
						id="keyNumber">
							<option>自适应</option>

					</select> <span></span> </label>
				</div>



			</div>
			<div class="formRow">
				<h4 class="text-info">触摸</h4>
				<div class="control-group">
					<label class="control-label switch" for="tb">点击生效时提示声音</label> <label
						class="controls switch"> <input type="checkbox"
						name="autoCompleteOrder" id="autoCompleteOrder"> <span></span>
					</label>
				</div>
				<div class="control-group">
					<label class="control-label switch" for="tb">双击确认</label> <label
						class="controls switch"> <input type="checkbox"
						name="autoCompleteOrder" id="autoCompleteOrder"> <span></span>
					</label>
				</div>
			</div>

			<div class="formRow">
				<div class="control-group">
					<div class="controls">
						<button class="btn" type="submit">重置所有为默认</button>
						<button class="btn btn-success">保存</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>