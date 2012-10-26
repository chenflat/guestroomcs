<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午01:42:24
	LastModified Date:
	Description:
 -->
<div class="login_box">

	<div class="row-fluid">
		<div class="span6">
			<img src="<c:url value='/img/login_brand.png' />" />
		</div>
		<div class="span5">
			<div class="cnt_b">
				<div class="top_b">登陆</div>
				<c:if test="${not empty error}">
					<div class="errorblock">
						<spring:message code="login.errmsg" />
						<br /> 
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>

				<form name='f' action="<c:url value='j_spring_security_check' />"
					method='POST' id="login_form">
					<div class="control-group">
						<div class="controls">
							<input type='text' name='j_username' value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"
								placeholder="<spring:message code="user.username" />"
								class="login-input user-name">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type='password' name='j_password'
								placeholder="<spring:message code="user.password" />" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox"> <input type="checkbox"
								name="_spring_security_remember_me"> 记住用户名 </label>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input name="submit" type="submit" class="btn btn-info btm_b" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="footer">
			&copy;2012 Kempinski Hotel
			<div class="pull-right">
				<i class="icon-phone"></i> 20 <i class="icon-th"></i>55
			</div>
		</div>
	</div>

</div>

<script src="<c:url value="/js/bootstrap/jquery.js"/>"></script>
<script src="<c:url value="/js/jquery.actual.min.js" />"></script>
<script src="<c:url value="/lib/validation/jquery.validate.min.js" />"></script>
<script src="<c:url value="/js/bootstrap/bootstrap.js" />"></script>

<script>
	$(document).ready(function() {

		/* //* validation
		$('#login_form').validate({
			onkeyup : false,
			errorClass : 'error',
			validClass : 'valid',
			rules : {
				username : {
					required : true,
					minlength : 3
				},
				password : {
					required : true,
					minlength : 3
				}
			},
			highlight : function(element) {
				$(element).closest('div').addClass("f_error");
				setTimeout(function() {
					boxHeight()
				}, 200)
			},
			unhighlight : function(element) {
				$(element).closest('div').removeClass("f_error");
				setTimeout(function() {
					boxHeight()
				}, 200)
			},
			errorPlacement : function(error, element) {
				$(element).closest('div').append(error);
			}
		}); */
	});
</script>


