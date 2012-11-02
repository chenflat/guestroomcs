<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-25 下午04:41:35
	LastModified Date:
	Description:
 -->

<div class="row-fluid">
	<div class="span12">
		<form id="hotel" class="form-horizontal form_validation_ttip">
			<legend>
				<spring:message code="nav.hotel.hotel" />
			</legend>
			<div class="control-group">
				<label class="control-label" for="systemName">酒店名称</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline">*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">英文名称</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">酒店地址</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">所属地区</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">联系电话</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">传真号码</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">描述信息</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">酒店照片</label>
				<div class="controls">

					<div class="uni-selector">
						<span>Lorem ipsum dolor sit amet amet, lorem ipsum</span><select
							class="uni_style" style="opacity: 0;">
							<option>Lorem ipsum dolor sit amet amet, lorem ipsum</option>
							<option>Lorem ipsum dolor sit amet</option>
						</select>
					</div>
					<div class="uni-uploader" id="uniform-uni_file">
						<input type="file" name="uni_file" id="uni_file" class="uni_style"
							size="19" style="opacity: 0;"><span class="uni-filename">未选择文件</span><span class="uni-action">上传照片</span>
					</div>

				</div>
			</div>


			<legend>地理设置</legend>
			<div class="control-group">
				<label class="control-label" for="systemName">经度</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="systemName">纬度</label>
				<div class="controls">
					<input type="text" id="systemName" name="systemName" placeholder="">
					<span class="help-inline"></span>
				</div>
			</div>
			<div class="form-actions">
				<button class="btn btn-inverse" type="submit">保存</button>
				<button class="btn">取消</button>
			</div>
		</form>
	</div>
</div>

