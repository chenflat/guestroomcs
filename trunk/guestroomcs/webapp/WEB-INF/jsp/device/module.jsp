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
	Created Date: 2013-2-25 下午12:34:31
	LastModified Date:
	Description:
 -->
<div class="main_content_sidebar">
	<section id="module_list">
	<div class="heading row-fluid">
		<h4>设备类型定义</h4>
	</div>
	<div class="row-fluid">
		<div class="span9">
			<table class="table table-condensed" id="modules">
				<thead>
					<tr>
						<th><input type="checkbox" name="checkall" /></th>
						<th>DeviceModuleName</th>
						<th>Description</th>
						<th>Internal</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="checkall" /></td>
						<td>rcu_mod</td>
						<td>RCU控制器</td>
						<td>Y</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="checkall" /></td>
						<td>dimmer_mod</td>
						<td>0-10V调光模块</td>
						<td>Y</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="checkall" /></td>
						<td>lightdimmer_mod</td>
						<td>白炽光调光模块</td>
						<td>Y</td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="span3" id="propContainer">
			<div class="accordion" id="accordion">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion" href="#collapseOne"> <span
							class="lead">Information</span> </a>
					</div>
					<div id="collapseOne" class="accordion-body collapse in">
						<div class="accordion-inner">
							<table class="properties">
								<tbody>
									<tr>
										<td>DeviceID</td>
										<td>1</td>
									</tr>
									<tr>
										<td>DeviceName</td>
										<td>rcu1</td>
									</tr>
									<tr>
										<td>Description</td>
										<td>主控制器</td>
									</tr>
									<tr>
										<td>DeviceModuleType</td>
										<td>rcu_mode</td>
									</tr>
									<tr>
										<td>Actived</td>
										<td>Y</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"> <span
							class="lead">Properties</span> (Dynamic Value) </a>
					</div>
					<div id="collapseTwo" class="accordion-body collapse">
						<div class="accordion-inner">
							<table class="properties">
								<tr>
									<td>Master</td>
									<td>1</td>
								</tr>
								<tr>
									<td>RoomNum</td>
									<td>1518</td>
								</tr>
								<tr>
									<td>RCUIPAddr</td>
									<td>172.16.10.151</td>
								</tr>
								<tr>
									<td>MasterIPAddr</td>
									<td>172.16.10.151</td>
								</tr>
								<tr>
									<td>SlaveIPAddr</td>
									<td>172.16.10.152</td>
								</tr>
								<tr>
									<td>ServerIPAddress</td>
									<td>172.16.10.16</td>
								</tr>
								<tr>
									<td>RCUPort</td>
									<td>7000</td>
								</tr>
								<tr>
									<td>IPadPort</td>
									<td>6001</td>
								</tr>
								<tr>
									<td>ServerPort</td>
									<td>6000</td>
								</tr>
								<tr>
									<td>HvacPort</td>
									<td>7001</td>
								</tr>
								<tr>
									<td>UIPort</td>
									<td>7002</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion" href="#collapseThree"> <span
							class="lead">Properties</span> (Default Value) </a>
					</div>
					<div id="collapseThree" class="accordion-body collapse">
						<div class="accordion-inner">
							<table class="properties">
								<tr>
									<td>AliveTime</td>
									<td>10(s)</td>
								</tr>
								<tr>
									<td>PressHoldTime</td>
									<td>0.5(s)</td>
								</tr>
								<tr>
									<td>IRAlarmTime</td>
									<td>30(s)</td>
								</tr>
								<tr>
									<td>iPadAliveTime</td>
									<td>300(s)</td>
								</tr>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
</div>