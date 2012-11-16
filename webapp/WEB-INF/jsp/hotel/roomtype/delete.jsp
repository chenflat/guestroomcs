<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-15 下午04:13:47
	LastModified Date:
	Description:
 -->

<div id="roomtypeDelModal" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3><strong>确认删除选客房类型?</strong></h3>
  </div>
  <div class="modal-body">
  <p>类型名称为<span class='lead text-error'>${roomtype.roomtypeName}</span>的房间类型将被删除。</p>
  </div>
  <div class="modal-footer">
  	<input type="hidden" name="redirect" id="redirect" value="${pageContext.request.contextPath}/hotel/roomtype" />
    <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code="button.cancel" /> </button>
    <a id="btn-delete" href="#" url="<c:url value="/hotel/roomtype/delete" />" class="btn btn-primary"><spring:message code="button.delete" /> </a>
  </div>
</div>