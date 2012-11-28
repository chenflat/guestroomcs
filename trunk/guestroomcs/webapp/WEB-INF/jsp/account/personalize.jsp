<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-2 下午01:32:42
	LastModified Date:
	Description:
 -->
<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<div class="row-fluid">
	<div class="span12">
		<form action="${requestURL}" method="post" id="personalize"
			enctype="multipart/form-data">
			<div class="formRow">
				<h4 class="text-info">头像</h4>
				<div class="control-group">
					<div class="row-fluid">
						<div data-fileupload="file"
							class="fileupload fileupload-new span1">
							<div style="width: 80px; height: 80px;"
								class="fileupload-new thumbnail">
								<img src="/guestroomcs/uploadfiles/user/" alt="" />
							</div>
						</div>
						<div class="span11">
							<security:authentication property="name" />
						</div>
					</div>
					<input class="input-file" type="file" name="file" id="file" / > <input
						type="hidden" name="userPhoto" />
				</div>
			</div>

			<div class="formRow">
				<h4 class="text-info">用户安全</h4>
				<div class="control-group">
					<a class="btn" href="">修改密码</a>
				</div>
			</div>

			<div class="formRow">
				<h4 class="text-info">登陆后默认查看</h4>
				<div class="control-group">
					<label class="control-label" for="defRequest">选择应用</label> <select
						name="defRequest" id="defRequest">
						<option value="sos">SOS紧急事件</option>
						<option value="dooralarm">门磁报警</option>
						<option value="windowalarm">窗磁报警</option>
					</select>
				</div>
			</div>

			<div class="formRow">
				<h4 class="text-info">季节</h4>
				<div class="control-group">
					<label class="control-label" for="season">冬夏转换设置</label> <select
						name="season" id="season">
						<option>冬季</option>
						<option>夏季</option>
					</select>

				</div>
			</div>


			<div class="formRow">
				<h4 class="text-info ">同步</h4>
				<div class="control-group ">
					<label class="control-label" for="synCycle">本地数据同步周期</label> <select
						id="synCycle" name="synCycle">
						<option>10-15s</option>
					</select>

				</div>
				<div class="control-group">
					<label class="control-label switch" for="tb">同步服务时间到本地业务系统</label>
					<label class="controls switch"> <input type="checkbox" name="isSynTime" id="isSynTime" />
						<span></span> </label>

				</div>
			</div>

			<div class="formRow">
				<h4 class="text-info">常用语言与时区</h4>

				<div class="control-group">
					<select id="langCode" name="langCode">
						<option value="zh_CN">简体,中文,zh-cn(默认)</option>
						<option value="us_EN">United States,English,us-en</option>
					</select>
				</div>

				<div class="control-group">

					<select id="timeZone" name="timeZone">
						<option>
						<option value="-720">(UTC -12:00) 国际日期变更线西</option>
						<option value="-660">(UTC -11:00) 协调世界时-11</option>
						<option value="-600">(UTC -10:00) Hawaii</option>
						<option value="-540">(UTC -09:00) Alaska</option>
						<option value="-480">(UTC -08:00) Pacific Time (US &amp;
							Canada); Tijuana</option>
						<option value="-420">(UTC -07:00) Mountain Time (US &amp;
							Canada)</option>
						<option value="-360">(UTC -06:00) Central Time (US &amp;
							Canada)</option>
						<option value="-300">(UTC -05:00) Eastern Time (US &amp;
							Canada)</option>
						<option value="-240">(UTC -04:00) Atlantic Time (Canada)</option>
						<option value="-210">(UTC -03:30) NewfoundLand Time
							(Canada)</option>
						<option value="-180">(UTC -03:00) Buenos Aires,
							Georgetown</option>
						<option value="-120">(UTC -02:00) Mid-Atlantic</option>
						<option value="-60">(UTC -01:00) Cape Verde Is.</option>
						<option value="0">(UTC 00:00) Dublin, Edinburgh, Lisbon,
							London</option>
						<option value="60">(UTC +01:00) Amsterdam, Berlin, Bern,
							Rome, Paris, Stockholm, Vienna</option>
						<option value="120">(UTC +02:00) Athens, Bucharest,
							Istanbul, Minsk</option>
						<option value="180">(UTC +03:00) Moscow, St. Petersburg,
							Volgograd</option>
						<option value="210">(UTC +03:30) Tehran</option>
						<option value="240">(UTC +04:00) Abu Dhabi, Muscat</option>
						<option value="270">(UTC +04:30) Kabul</option>
						<option value="300">(UTC +05:00) Islamabad, Karachi,
							Tashkent</option>
						<option value="330">(UTC +05:30) Calcutta, Chennai,
							Mumbai,New Delhi</option>
						<option value="345">(UTC +05:45) Kathmandu</option>
						<option value="360">(UTC +06:00) Astana,Almaty, Dhaka,
							Novosibirsk</option>
						<option value="390">(UTC +06:30) Rangoon (Yangon, Burma)</option>
						<option value="420">(UTC +07:00) Bangkok, Hanoi, Jakarta</option>
						<option value="480">(UTC +08:00) 北京, 重庆, 香港特别行政区, 乌鲁木齐</option>
						<option value="540">(UTC +09:00) Osaka, Sapporo, Tokyo</option>
						<option value="570">(UTC +09:30) Adelaide, Darwin</option>
						<option value="600">(UTC +10:00) Canberra, Melbourne,
							Sydney, Vladvostok</option>
						<option value="660">(UTC +11:00) Magadan, Solomon Is.,
							New Caledonia</option>
						<option value="720">(UTC +12:00) Auckland, Fiji,
							Kamchatka, Marshall Is.</option>
						<option value="780">(UTC +13:00) Nuku'alofa</option>
						</option>
					</select>

				</div>
			</div>
			<div class="formRow">
				<div class="control-group">
					<div class="controls">
						<input type="hidden" name="username" id="username" value="<security:authentication property="name" />" />
						<button class="btn" type="submit">重置所有为默认</button>
						<button class="btn btn-success">保存</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>