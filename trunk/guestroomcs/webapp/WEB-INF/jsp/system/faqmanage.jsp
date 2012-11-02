<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-19 下午03:51:42
	LastModified Date:
	Description: FAQ LIST
 -->
<div class="row-fluid">
	
		<div class="span8">
			<form class="form-search">
			<div class="input-append">
				<input class="input-xxlarge" type="text" placeholder="search">
				 <button type="submit" class="btn">Search</button>
			</div>
			</form>
			<legend>常规问题</legend>

			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseOne"> Collapsible
							Group Item #1 </a>
					</div>
					<div id="collapseOne" class="accordion-body collapse in">
						<div class="accordion-inner">Anim pariatur cliche...</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseTwo"> Collapsible
							Group Item #2 </a>
					</div>
					<div id="collapseTwo" class="accordion-body collapse">
						<div class="accordion-inner">Anim pariatur cliche...</div>
					</div>
				</div>
			</div>



		</div>
		<div class="span4">
			<div class="well">
              <ul class="nav nav-list">
                <li class="nav-header">FAQ 分类</li>
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Library</a></li>
                <li><a href="#">Applications</a></li>
                <li class="nav-header">Another list header</li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Settings</a></li>
                <li class="divider"></li>
                <li><a href="#">Help</a></li>
              </ul>
            </div>
		</div>

</div>
