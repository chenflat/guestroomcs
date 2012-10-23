<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- 
	AUTHOR: CHENPING
	Created Date: 2012-10-17 下午01:42:24
	LastModified Date:
	Description:
 -->

<h3>Login with Username and Password (Authentication with Database)</h3>

<c:if test="${not empty error}">
	<div class="errorblock">
		Your login attempt was not successful, try again.<br /> Caused :
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</div>
</c:if>

<form name='f' action="<c:url value='j_spring_security_check' />"
	method='POST'>

	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='j_username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='j_password' /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit"
				value="submit" /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="reset" type="reset" /></td>
		</tr>
	</table>

</form>

<script lanuage="javascript">
	$(function(){
		
		
	});
</script>