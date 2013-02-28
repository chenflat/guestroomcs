<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2013-2-27 上午09:21:01
	LastModified Date:
	Description: DEVICE INITIALIZE
 -->
<div class="main_content_sidebar">
	<section id="module_list">
	<div class="heading row-fluid">
		<h4>
			<spring:message code="nav.device.initialize.title" />
		</h4>
	</div>

	<form class="form-horizontal" name="init" id="initcond" method="post"
		action="">

		<div class="msg_view">
			<c:if test="${!isInitRoom}">
				<!-- 测试是否初始化房间 -->
				<div class="message_view_content">发现未初始化客房数据,请完成客房信息和设备类型定义后，再执行客房设备初始化。</div>
				<input type="submit" name="btnInit" class="btn"
					value='<spring:message code="nav.device.initialize.btn.initguestroom" />' />
				<input type="hidden" name="initType" value="initRoom" />
			</c:if>
			<c:if test="${isInitRoom && !isInitModule}">
				<!-- 测试设备类型是否存在 -->
				<div class="message_view_content">
					发现未初始化客房设备,请完成客房信息和设备类型定义后，再执行客房设备初始化。</div>
			</c:if>
			<%-- <c:if test="${isInitRoom && isInitModule}"> --%>
			<!-- 当设备类型设置就绪，开始校验房间数据和 设置模型数据 -->
				<div class="message_view_content">
					酒店客房数据效验完成，将根据现在房间号进行客房设备初始化;所有房间都会保存一个<br />
					参数大致相关的配置文件；请先测试初始配置过程提示成功后，再选中“生成配置文件”重新一遍。
				</div>

				<div class="control-group row-fluid">
					<label class="control-label span3" for="devieModule">根据现在设备类型列表初始化</label>
					<div class="controls">
						<input type="checkbox" id="devieModule" name="devieModule">
					</div>
				</div>
				<div class="control-group  row-fluid">
					<label class="control-label span3" for="roomConfig">测试房间的初始配置</label>
					<div class="controls">
						<input type="checkbox" id="roomConfig" name="roomConfig">
					</div>
				</div>

				<div class="control-group  row-fluid">
					<label class="control-label span3" for="generateConfig">生成配置文件
					</label>
					<div class="controls">
						<input type="checkbox" id="generateConfig" name="generateConfig">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn">执行设备初始化</button>
					</div>
				</div>
			<%-- </c:if> --%>



		</div>

	</form>


	</section>
</div>