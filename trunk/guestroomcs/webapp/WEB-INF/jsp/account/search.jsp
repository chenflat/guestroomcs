<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:33:06
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form>
			<div class="formRow">
				<h4 class="text-info">自动提示</h4>
				<div class="control-group">
					<label class="control-label switch" for="tb">输入搜索关键词时自动提示</label> <label
						class="controls switch"> <input type="checkbox"
						name="autoComplete" id="autoComplete" /> <span></span> </label>
				</div>

				<div class="control-group">
					<label class="control-label switch" for="tb">按搜索关键字次数排序提示</label> <label
						class="controls switch"> <input type="checkbox"
						name="autoCompleteOrder" id="autoCompleteOrder" /> <span></span> </label>
				</div>
				<h4 class="text-info">提示关键字最多个数</h4>
				<div class="control-group">
					<select name="keyNumber" id="keyNumber">
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</select>
				</div>
			</div>

			<div class="formRow">
				<h4 class="text-info">搜索历史</h4>

			</div>
		</form>
	</div>
</div>