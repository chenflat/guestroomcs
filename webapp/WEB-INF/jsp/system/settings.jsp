<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午04:53:23
	LastModified Date:
	Description:
 -->
<div class="row-fluid">
	<div class="span12">
		<form id="system" class="form-horizontal form_validation_ttip"
			action="#">
			<legend>基本信息</legend>
			<div class="control-group">
				<label class="control-label" for="systemName">系统名称</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName"
						placeholder="必填项"> <span class="help-inline">*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemEnname">英文名称</label>
				<div class="controls">
					<input type="text" id="systemEnname" name="systemEnname"
						placeholder="必填项"> <span class="help-inline">*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">系统描述</label>
				<div class="controls">
					<textarea rows="3"></textarea>
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">版权</label>
				<div class="controls">
					<input type="text" name="copyRight" id="copyRight" placeholder="必填项""> <span
						class="help-inline">*</span>
				</div>
			</div>

			<legend>用户设置</legend>
			<div class="control-group">
				<label class="control-label">系统管理员</label>
				<div class="controls">
					<select>
						<option>1</option>
						<option>2</option>
					</select> <span class="help-inline">help inline</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">管理员角色组</label>
				<div class="controls">
					<select>
						<option>1</option>
						<option>2</option>
					</select> <span class="help-inline">help inline</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">注册用户默认组</label>
				<div class="controls">
					<select>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select> <span class="help-inline">help inline</span>
				</div>
			</div>

			<legend>其它设置</legend>
			<div class="control-group">
				<label class="control-label">默认货币</label>
				<div class="controls">
					<select>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select> <span class="help-inline">help inline</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">所在时区</label>
				<div class="controls">
					<select>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">默认语言</label>
				<div class="controls">
					<select>
						<option value="zh-CN">简体,中文,zh-CN</option>
						<option value="us-EN">English</option>

					</select> <span class="help-inline"></span>
				</div>
			</div>
			<div class="form-actions">
				<button class="btn btn-primary" type="submit">保存</button>
				<button class="btn">Cancel</button>
			</div>
		</form>


	</div>
</div>

