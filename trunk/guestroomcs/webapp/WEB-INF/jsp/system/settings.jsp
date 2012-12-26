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
		<form:form commandName="portal"
			class="form-horizontal form_validation_ttip">
			<c:if test="${not empty message}">
				<c:out value="${message}" escapeXml="false" />
			</c:if>
			<legend>
				<a href="<c:url value="/system/navigation" />">管理选项</a> <small>> 基本信息</small>
			</legend>
			<p>设置当前WEB平台基础信息</p>
			<hr class="separator" />
				<legend>
				平台基本信息
			</legend>
			<div class="control-group">
				<form:label path="portalName" class="control-label">系统名称</form:label>
				<div class="controls">
					<form:input path="portalName" placeholder="必填项" />
					<span class="help-inline">* <form:errors path="portalName" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="portalEnname" class="control-label">英文名称</form:label>
				<div class="controls">
					<form:input path="portalEnname" placeholder="必填项" />
					<span class="help-inline">* <form:errors path="portalEnname" />
					</span>
				</div>
			</div>
			<div class="control-group">
				<form:label path="portalDesc" class="control-label">系统描述</form:label>
				<div class="controls">
					<form:textarea path="portalDesc" rows="3" />
				</div>
			</div>
			<div class="control-group">
				<form:label path="copyright" class="control-label">版权信息</form:label>
				<div class="controls">
					<form:input path="copyright" placeholder="必填项" />
					<span class="help-inline">* <form:errors path="copyright" />
					</span>
				</div>
			</div>

			<%-- <legend>用户设置</legend>
			<div class="control-group">
				<form:label path="administratorid" class="control-label">系统管理员</form:label>
				<div class="controls">
					<form:select path="administratorid">
						<form:option value="admin">Admin</form:option>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<form:label path="administratorroleid" class="control-label">管理员角色组</form:label>
				<div class="controls">
					<form:select path="administratorroleid">
						<form:option value="ROLE_ADMIN">ROLE_ADMIN</form:option>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<form:label path="registeredroleid" class="control-label">注册用户默认组</form:label>
				<div class="controls">
					<form:select path="registeredroleid">
						<form:option value="ROLE_USER">ROLE_USER</form:option>
					</form:select>
				</div>
			</div>

			<legend>其它设置</legend>
			<div class="control-group">
				<form:label path="currency" class="control-label">默认货币</form:label>
				<div class="controls">
					<form:select path="currency">
						<form:options items="${listitems}" itemLabel="text"
							itemValue="value" />
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<form:label path="timezoneoffset" class="control-label">所在时区</form:label>
				<div class="controls">
					<form:select path="timezoneoffset">
						<form:option value="-720">(UTC -12:00) 国际日期变更线西</form:option>
						<form:option value="-660">(UTC -11:00) 协调世界时-11</form:option>
						<form:option value="-600">(UTC -10:00) Hawaii</form:option>
						<form:option value="-540">(UTC -09:00) Alaska</form:option>
						<form:option value="-480">(UTC -08:00) Pacific Time (US &amp; Canada); Tijuana</form:option>
						<form:option value="-420">(UTC -07:00) Mountain Time (US &amp; Canada)</form:option>
						<form:option value="-360">(UTC -06:00) Central Time (US &amp; Canada)</form:option>
						<form:option value="-300">(UTC -05:00) Eastern Time (US &amp; Canada)</form:option>
						<form:option value="-240">(UTC -04:00) Atlantic Time (Canada)</form:option>
						<form:option value="-210">(UTC -03:30) NewfoundLand Time (Canada)</form:option>
						<form:option value="-180">(UTC -03:00) Buenos Aires, Georgetown</form:option>
						<form:option value="-120">(UTC -02:00) Mid-Atlantic</form:option>
						<form:option value="-60">(UTC -01:00) Cape Verde Is.</form:option>
						<form:option value="0">(UTC  00:00) Dublin, Edinburgh, Lisbon, London</form:option>
						<form:option value="60">(UTC +01:00) Amsterdam, Berlin, Bern, Rome, Paris, Stockholm, Vienna</form:option>
						<form:option value="120">(UTC +02:00) Athens, Bucharest, Istanbul, Minsk</form:option>
						<form:option value="180">(UTC +03:00) Moscow, St. Petersburg, Volgograd</form:option>
						<form:option value="210">(UTC +03:30) Tehran</form:option>
						<form:option value="240">(UTC +04:00) Abu Dhabi, Muscat</form:option>
						<form:option value="270">(UTC +04:30) Kabul</form:option>
						<form:option value="300">(UTC +05:00) Islamabad, Karachi, Tashkent</form:option>
						<form:option value="330">(UTC +05:30) Calcutta, Chennai, Mumbai,New Delhi</form:option>
						<form:option value="345">(UTC +05:45) Kathmandu</form:option>
						<form:option value="360">(UTC +06:00) Astana,Almaty, Dhaka, Novosibirsk</form:option>
						<form:option value="390">(UTC +06:30) Rangoon (Yangon, Burma)</form:option>
						<form:option value="420">(UTC +07:00) Bangkok, Hanoi, Jakarta</form:option>
						<form:option value="480">(UTC +08:00) 北京, 重庆, 香港特别行政区, 乌鲁木齐</form:option>
						<form:option value="540">(UTC +09:00) Osaka, Sapporo, Tokyo</form:option>
						<form:option value="570">(UTC +09:30) Adelaide, Darwin</form:option>
						<form:option value="600">(UTC +10:00) Canberra, Melbourne, Sydney, Vladvostok</form:option>
						<form:option value="660">(UTC +11:00) Magadan, Solomon Is., New Caledonia</form:option>
						<form:option value="720">(UTC +12:00) Auckland, Fiji, Kamchatka, Marshall Is.</form:option>
						<form:option value="780">(UTC +13:00) Nuku'alofa</form:option>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<form:label path="defaultlanguage" class="control-label">默认语言</form:label>
				<div class="controls">
					<form:select path="defaultlanguage">
						<form:option value="zh_CN">简体,中文,zh-cn(默认)</form:option>
						<form:option value="us_EN">United States,English,us-en</form:option>
					</form:select>
				</div>
			</div> --%>
			<div class="form-actions">
				<form:hidden path="portalId" />
				<button class="btn input-small btn-submit" type="submit">
					<spring:message code="button.submit" />
				</button>
				<a class="btn input-mini btn-cancelbtn-cancel" href="<c:url value="/system/navigation"/>">
					<spring:message code="button.cancel" />
				</a>
			</div>
		</form:form>


	</div>
</div>

