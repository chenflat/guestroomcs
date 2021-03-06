<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-11-26 上午10:34:10
	LastModified Date:
	Description:
 -->
<div id="buildDelModal" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3><strong>确认删除酒店建筑?</strong></h3>
  </div>
  <div class="modal-body">
  <p>名称为<span class='lead text-error'></span>的建筑将被删除。</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code="button.cancel" /> </button>
    <a id="btn-delete" href="#" url="<c:url value="/hotel/build/delete" />" class="btn btn-primary"><spring:message code="button.delete" /> </a>
  </div>
</div>
