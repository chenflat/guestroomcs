<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" class="error_page">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Bootstrap framework -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet"
		href="<c:url value="/css/bootstrap-responsive.min.css"/>">
		<!-- main styles -->
		<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
<title>404</title>
</head>
<body>
	<div class="error_box">
		<h1>404 Page/File not found</h1>
		<p>The page/file you've requested has been moved or taken off the
			site.</p>
		<a href="javascript:history.back()" class="back_link btn btn-small">Go
			back</a>
	</div>

</body>
</html>