<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-19 下午04:04:10
	LastModified Date:
	Description:
 -->
<div class="row-fluid">
	<div class="span12">
		<legend>数据字典</legend>
		<div class="span3">
			<div class="well">
				<ul class="nav nav-list" id="category">
					<li class="nav-header">字典类别 
					<c:forEach items="${dictionaries}"
							var="dict">
							<li><a href="#">${dict}</a>
							</li>
						</c:forEach>
				</ul>
			</div>
		</div>
		<div class="span8">
			<div class="well">
			<table class="table table-striped" id="listinfos">
			<thead>
                <tr>
                  <th>#</th>
                  <th>名称</th>
                  <th>字典内容</th>
                  <th>字典值</th>
                </tr>
              </thead>
              <tbody>
              
              </tbody>
			</table>
			</div>
		</div>
	</div>
</div>
