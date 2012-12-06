<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="requestURL"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />
<c:set var="serviceURL"
	value="${pageContext.request.contextPath}/service/requests" />
<c:set var="hvacURL"
	value="${pageContext.request.contextPath}/service/hvac" />
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<!-- Service Manage Sidebar -->
				<div class="sidebar_inner">
					<form action="<c:url value="/service/requests?act=query" />"
						class="input-append" method="post">
						<input autocomplete="off" name="query"
							class="search_query input-medium" size="16" type="text"
							placeholder="搜索" />
						<button type="submit" class="btn">
							<i class="icon-search"></i>
						</button>
					</form>

					<ul class="nav nav-pills nav-stacked sidebar-submenu">
						<li
							<c:if test="${fn:contains(requestURL, serviceURL)}">class="active"</c:if>><a
							href="<c:url value="/service/requests" />">客房服务</a>
						</li>
						<li
							<c:if test="${fn:contains(requestURL, hvacURL)}">class="active"</c:if>><a
							href="<c:url value="/service/hvac" />">HAVC</a>
						</li>
					</ul>
					<div class="heading sepH_a"></div>


					<div id="side_quickview" class="quickview">
						<ul class="nav nav-list" id="reqtype">
							<c:choose>
								<c:when test="${fn:contains(requestURL, serviceURL)}">
									<li type="1" class="active"><a href="javascript:void(0);">服务请求</a>
									</li>
									<li type="12"><a href="javascript:void(0);">保洁</a>
									</li>
									<li type="2"><a href="javascript:void(0);">SOS紧急事件</a>
									</li>
									<li type="64"><a href="javascript:void(0);">门磁报警</a>
									</li>
									<li type="128"><a href="javascript:void(0);">窗磁报警</a>
									</li>
								</c:when>
								<c:otherwise>
									<li type="8"><a href="javascript:void(0);">空调</a></li>
									<li type="12"><a href="javascript:void(0);">浴室地板加热</a></li>
									<li type="12"><a href="javascript:void(0);">ETM参考房间</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>

					<div class="push"></div>
				</div>

				<div class="sidebar_info">
					<div class="header"></div>
					<a href="#" class="" rel="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="help"><i class="icon-warning-sign"></i> Help</a>
				</div>

			</div>
		</div>
	</div>
</div>