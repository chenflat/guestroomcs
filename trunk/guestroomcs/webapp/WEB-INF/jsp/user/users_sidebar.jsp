<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- User Sidebar -->
<a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r"
	title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
				<div class="sidebar_inner">
					<form action="<c:url value="/user/usermanage" />"
						class="input-append" method="post">
						<input autocomplete="off" name="query"
							class="search_query input-medium" size="16" type="text" />
						<button type="submit" class="btn">
							<i class="icon-search"></i>
						</button>
					</form>

					<ul class="nav nav-list" id="userlist">
						<c:forEach items="${users}" var="user">
							<li id="li_${user.userId}"><a> <input type="checkbox" name="userId"
									value="${user.userId}"> <img
									src="<c:url value="/img/metro_user.png" />" /> <span>${user.username}</span>
							</a></li>
						</c:forEach>
					</ul>

				</div>


			</div>
		</div>
	</div>
</div>