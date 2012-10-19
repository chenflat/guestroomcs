<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午03:09:25
	LastModified Date:
	Description:
 -->

<header>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="brand" href="<c:url value="/index"/>"><i
				class="icon-home icon-white"></i> GRCS <span class="sml_t">1.0</span>
			</a>
			<ul class="nav user_menu pull-right">
				<li class="hidden-phone hidden-tablet">
					<div class="nb_boxes clearfix">
						<a data-toggle="modal" data-backdrop="static" href="#myMail"
							class="label ttip_b" oldtitle="New messages">25 <i
							class="splashy-mail_light"></i>
						</a> <a data-toggle="modal" data-backdrop="static" href="#myTasks"
							class="label ttip_b" oldtitle="New tasks">10 <i
							class="splashy-calendar_week"></i>
						</a>
					</div></li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i
						class="icon-cog icon-white"></i> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/system/settings" />"><i class="icon-wrench"></i> <spring:message code="nav.system.settings" /></a></li>
						<li><a href="<c:url value="/hotel/hotel" />"><i class="icon-star"></i> <spring:message code="nav.hotel" /></a></li>
						<li><a href="<c:url value="/guest" />"><i class="icon-map-marker"></i> <spring:message code="nav.guest" /></a></li>
						<li><a href="<c:url value="/user" />"><i class="icon-user"></i> 用户管理</a></li>
						<li><a href="<c:url value="/handover" />"><i class="icon-thumbs-up"></i> 交接班管理</a></li>
					</ul></li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i
						class="flag-cn"></i> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="?lang=zh-cn"><i class="flag-cn"></i> 中文</a>
						</li>
						<li><a href="?lang=us-en"><i class="flag-us"></i> English</a>
						</li>
					</ul></li>
				<li class="divider-vertical hidden-phone hidden-tablet"></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><img
						src="<c:url value="/img/user_avatar.png"/>" alt=""
						class="user_avatar">Administrator <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/userprofile" />"><i
								class="icon-briefcase"></i> <spring:message code="userprofile" />
						</a>
						</li>
						<li><a href="javascrip:void(0)"><i class="icon-envelope"></i>
								我的消息</a>
						</li>
						<li class="divider"></li>
						<li><a href="<c:url value="/logout"/>"><i
								class="icon-off"></i> <spring:message code="user.logout" />
						</a>
						</li>
					</ul></li>
			</ul>
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn_menu"> <span class="icon-align-justify icon-white"></span>
			</a>
			<div class="nav-collapse">
				<nav>
				<ul class="nav">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><i
							class="icon-list-alt icon-white"></i> <spring:message
								code="nav.view" /> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li class="dropdown sub-dropdown dropdown-submenu"><a
								href="#"><spring:message code="nav.view.guestrequest" /> <b class="caret-right"></b>
							</a>
								<ul class="dropdown-menu sub-menu">
									<li><a href="#"><spring:message code="nav.view.guestrequest.bc" /></a></li>
									<li><a href="#"><spring:message code="nav.view.guestrequest.mur" /></a></li>
									<li><a href="#"><spring:message code="nav.view.guestrequest.valet" /></a></li>
									<li><a href="#"><spring:message code="nav.view.guestrequest.foodtray" /></a></li>
									<li><a href="#"><spring:message code="nav.view.guestrequest.dnd" /></a></li>
									<li><a href="#"><spring:message code="nav.view.guestrequest.sos" /></a></li>
									<li class="divider"></li>
									<li><a href="#"><spring:message code="nav.view.guestrequest.combined" /></a></li>
								</ul></li>
							<li class="divider"></li>
							<li class="dropdown sub-dropdown dropdown-submenu"><a
								href="#"><spring:message code="nav.view.guestpreferences" /><b class="caret-right"></b>
							</a>
								<ul class="dropdown-menu sub-menu">
									<li><a href="#"><spring:message code="nav.view.guestpreferences.ada" /></a></li>
									<li><a href="#"><spring:message code="nav.view.guestpreferences.sabbath" /></a></li>
								</ul></li>
							<li class="dropdown sub-dropdown dropdown-submenu"><a
								href="#"><spring:message code="nav.view.roomstatus" /><b class="caret-right"></b>
							</a>
								<ul class="dropdown-menu sub-menu">
									<li><a href="#">Sub menu 1.1</a></li>
									<li><a href="#">Sub menu 1.2</a></li>
									<li><a href="#">Sub menu 1.3</a></li>
								</ul></li>
							<li class="divider"></li>
							<li class="dropdown sub-dropdown dropdown-submenu"><a
								href="#"><spring:message code="nav.view.hvac" /><b class="caret-right"></b>
							</a>
								<ul class="dropdown-menu sub-menu">
									<li><a href="#"><spring:message code="nav.view.hvac.measuredtemperature" /> </a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.measuredhumidity" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.equipmentoperation" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.loadshedding" /> </a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.opendoors" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.openwindows" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.etm" /> </a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.vip" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.dehumidification" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.deicing" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.havctroble" /></a></li>
									<li><a href="#"><spring:message code="nav.view.hvac.equipmenttype" /></a></li>
								</ul></li>

						</ul></li>
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><i class="icon-th icon-white"></i>
							<spring:message code="nav.control" /> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li class="dropdown sub-dropdown dropdown-submenu"><a
								href="#">Guest Request<b class="caret-right"></b>
							</a>
								<ul class="dropdown-menu sub-menu">
									<li><a href="#">Sub menu 1.1</a>
									</li>
									<li><a href="#">Sub menu 1.2</a>
									</li>
									<li><a href="#">Sub menu 1.3</a>
									</li>
									<li class="sub-dropdown"><a href="#">Sub menu 1.4 <b
											class="caret-right"></b>
									</a>
										<ul class="dropdown-menu sub-menu">
											<li><a href="#">Sub menu 1.4.1</a>
											</li>
											<li><a href="#">Sub menu 1.4.2</a>
											</li>
											<li><a href="#">Sub menu 1.4.3</a>
											</li>
										</ul></li>
								</ul></li>
							<li><a href="index.php?uid=1&amp;page=form_extended">Guest
									Preferences</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=form_extended">Climate
									Control</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=form_extended">Test</a>
							</li>
						</ul></li>
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><i
							class="icon-wrench icon-white"></i> <spring:message
								code="nav.report" /> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="index.php?uid=1&amp;page=charts">Charts</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=calendar">Calendar</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=datatable">Datatable</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=file_manager">File
									Manager</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=floating_header">Floating
									List Header</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=google_maps">Google
									Maps</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=gallery">Gallery
									Grid</a>
							</li>
							<li><a href="index.php?uid=1&amp;page=wizard">Wizard</a>
							</li>
						</ul></li>
					<li></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
</div>
<div class="modal hide fade" id="myMail">
	<div class="modal-header">
		<button class="close" data-dismiss="modal">×</button>
		<h3>New messages</h3>
	</div>
	<div class="modal-body">
		<div class="alert alert-info">In this table jquery plugin turns
			a table row into a clickable link.</div>
		<table class="table table-condensed table-striped" data-rowlink="a">
			<thead>
				<tr>
					<th>Sender</th>
					<th>Subject</th>
					<th>Date</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Declan Pamphlett</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a>
					</td>
					<td>23/05/2012</td>
					<td>25KB</td>
				</tr>
				<tr>
					<td>Erin Church</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a>
					</td>
					<td>24/05/2012</td>
					<td>15KB</td>
				</tr>
				<tr>
					<td>Koby Auld</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a>
					</td>
					<td>25/05/2012</td>
					<td>28KB</td>
				</tr>
				<tr>
					<td>Anthony Pound</td>
					<td><a href="javascript:void(0)">Lorem ipsum dolor sit
							amet</a>
					</td>
					<td>25/05/2012</td>
					<td>33KB</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0)" class="btn">Go to mailbox</a>
	</div>
</div>
<div class="modal hide fade" id="myTasks">
	<div class="modal-header">
		<button class="close" data-dismiss="modal">×</button>
		<h3>New Tasks</h3>
	</div>
	<div class="modal-body">
		<div class="alert alert-info">In this table jquery plugin turns
			a table row into a clickable link.</div>
		<table class="table table-condensed table-striped" data-rowlink="a">
			<thead>
				<tr>
					<th>id</th>
					<th>Summary</th>
					<th>Updated</th>
					<th>Priority</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>P-23</td>
					<td><a href="javascript:void(0)">Admin should not break if
							URL…</a>
					</td>
					<td>23/05/2012</td>
					<td class="tac"><span class="label label-important">High</span>
					</td>
					<td>Open</td>
				</tr>
				<tr>
					<td>P-18</td>
					<td><a href="javascript:void(0)">Displaying submenus in
							custom…</a>
					</td>
					<td>22/05/2012</td>
					<td class="tac"><span class="label label-warning">Medium</span>
					</td>
					<td>Reopen</td>
				</tr>
				<tr>
					<td>P-25</td>
					<td><a href="javascript:void(0)">Featured image on post
							types…</a>
					</td>
					<td>22/05/2012</td>
					<td class="tac"><span class="label label-success">Low</span>
					</td>
					<td>Updated</td>
				</tr>
				<tr>
					<td>P-10</td>
					<td><a href="javascript:void(0)">Multiple feed fixes and…</a>
					</td>
					<td>17/05/2012</td>
					<td class="tac"><span class="label label-warning">Medium</span>
					</td>
					<td>Open</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal-footer">
		<a href="javascript:void(0)" class="btn">Go to task manager</a>
	</div>
</div>

</header>