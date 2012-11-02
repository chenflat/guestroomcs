<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- User Manage Sidebar -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<div class="sidebar_inner">
					<form action="<c:url value="/service/guestrequest/query" />"
						class="input-append" method="post">
						<input autocomplete="off" name="query"
							class="search_query input-medium" size="16" type="text"
							placeholder="搜索" />
						<button type="submit" class="btn">
							<i class="icon-search"></i>
						</button>
					</form>
					<div id="side_quickview" class="quickview">
						<ul class="nav nav-list">
							<li class="active"><a href="<c:url value="/account/profile" />">用户资料</a>
							</li>
							<li><a href="<c:url value="/account/profile?act=personalize" />">个性化</a>
							</li>
							<li><a href="<c:url value="/account/profile?act=notification" />">提示</a>
							</li>
							<li><a href="<c:url value="/account/profile?act=search" />">搜索</a>
							</li>
							<li><a href="<c:url value="/account/profile?act=usability" />">易用性</a>
							</li>
							<li><a href="<c:url value="/account/profile?act=shiftwork" />"><spring:message
										code="nav.account.shiftwork" /> </a>
							</li>
						</ul>
					</div>
				</div>


			</div>
		</div>
	</div>
</div>