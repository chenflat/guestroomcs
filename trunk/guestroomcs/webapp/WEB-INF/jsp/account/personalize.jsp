<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:32:42
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form class="">
			<h4 class="text-info">头像</h4>


			<h4 class="text-info">用户安全</h4>
			<div class="control-group formSep">
				<a class="btn" href="">修改密码</a>
			</div>



			<h4 class="text-info">登陆后默认查看</h4>
			<div class="control-group formSep">
				<label class="control-label" for="inputWarning">选择应用</label> <select>
					<option>冬季</option>
					<option>夏季</option>
				</select>

			</div>

			<h4 class="text-info">季节</h4>
			<div class="control-group formSep">
				<label class="control-label" for="inputWarning">冬夏转换设置</label> <select>
					<option>冬季</option>
					<option>夏季</option>
				</select>

			</div>




			<h4 class="text-info ">同步</h4>
			<div class="control-group formSep ">
				<label class="control-label" for="inputWarning">本地数据同步周期</label> <select>
					<option>10-15s</option>
				</select>

			</div>
			<div class="control-group formSep">

				<label class="control-label switch" for="tb">同步服务时间到本地业务系统</label> <label
					class="controls switch"> <input type="checkbox"> <span></span>
				</label>

			</div>


			<h4 class="text-info">常用语言与时区</h4>
			<div class="control-group formSep">

				<select>
					<option>...</option>
				</select>

			</div>


			<div class="control-group">
				<div class="controls">
					<button class="btn" type="submit">重置所有为默认</button>
					<button class="btn btn-success">保存</button>
				</div>
			</div>
		</form>
	</div>
</div>