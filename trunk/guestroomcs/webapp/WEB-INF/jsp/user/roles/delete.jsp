<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- delete user info -->

<div id="roleDelModal" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3><strong>是否删除此权限组?</strong></h3>
  </div>
  <div class="modal-body">
  <p>权限<span class='lead text-error'></span>将从权限组列表删除。</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code="button.cancel" /> </button>
    <a id="btn-delete" href="#" url="<c:url value="/user/roles/delete" />" class="btn btn-primary"><spring:message code="button.delete" /> </a>
  </div>
</div>
