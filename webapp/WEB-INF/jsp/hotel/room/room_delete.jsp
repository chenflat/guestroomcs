<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="roomDelModal" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3><strong>确认删除选中的房间号?</strong></h3>
  </div>
  <div class="modal-body"></div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code="button.cancel" /> </button>
    <a id="btn-delete" href="#" url="<c:url value="/hotel/room/delete" />" class="btn btn-primary"><spring:message code="button.delete" /> </a>
  </div>
</div>

<!-- 批量删除房间 -->
<div id="roomBatchdelModal" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3><strong>确认批量删除以下的房间号?</strong></h3>
  </div>
  <div class="modal-body">
  		<p>两个房间号码之前的所有房间将被删除，可跨楼层.</p>
  			<div class="control-group">
				<div class="controls">
					<input type="text" name="beginNo" id="beginNo" placeholder="起始房间号" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="text" name="endNo" id="endNo" placeholder="结束房间号" />
				</div>
			</div>
  
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code="button.cancel" /> </button>
    <a id="btn-delete" href="#" url="<c:url value="/hotel/room/batchdelete" />" class="btn btn-primary"><spring:message code="button.batchdelete" /> </a>
  </div>
</div>