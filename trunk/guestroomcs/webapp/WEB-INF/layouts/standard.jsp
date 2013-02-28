<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><tiles:insertAttribute name="title" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<META HTTP-EQUIV="pragma" CONTENT="no-cache" />
<tiles:insertAttribute name="commoncss" />
</head>
<body>
	<div class="style_switcher">
		<div class="sepH_c">
			<p>外观颜色:</p>
			<div class="clearfix">
				<a href="javascript:void(0)"
					class="style_item jQclr blue_theme style_active" title="blue">blue</a>
				<a href="javascript:void(0)" class="style_item jQclr purple_theme"
					title="purple">purple</a> <a href="javascript:void(0)"
					class="style_item jQclr green_theme" title="green">green</a> <a
					href="javascript:void(0)" class="style_item jQclr brown_theme"
					title="brown">brown</a> <a href="javascript:void(0)"
					class="style_item jQclr eastern_blue_theme" title="eastern_blue">eastern
					blue</a> <a href="javascript:void(0)"
					class="style_item jQclr tamarillo_theme" title="tamarillo">tamarillo</a>
			</div>
		</div>
		<div class="sepH_c">
			<p>页面背景:</p>
			<div class="clearfix">
				<span class="style_item jQptrn style_active ptrn_def" title=""></span>
				<span class="ssw_ptrn_a style_item jQptrn" title="ptrn_a"></span> <span
					class="ssw_ptrn_b style_item jQptrn" title="ptrn_b"></span> <span
					class="ssw_ptrn_c style_item jQptrn" title="ptrn_c"></span> <span
					class="ssw_ptrn_d style_item jQptrn" title="ptrn_d"></span> <span
					class="ssw_ptrn_e style_item jQptrn" title="ptrn_e"></span>
			</div>
		</div>
		<div class="sepH_c">
			<p>部局样式:</p>
			<div class="clearfix">
				<label class="radio inline"><input type="radio"
					name="ssw_layout" id="ssw_layout_fluid" value="" checked /> Fluid</label>
				<label class="radio inline"><input type="radio"
					name="ssw_layout" id="ssw_layout_fixed" value="app-fixed" /> Fixed</label>
			</div>
		</div>
		<div class="sepH_c">
			<p>侧边侧显示位置:</p>
			<div class="clearfix">
				<label class="radio inline"><input type="radio"
					name="ssw_sidebar" id="ssw_sidebar_left" value="" checked /> Left</label>
				<label class="radio inline"><input type="radio"
					name="ssw_sidebar" id="ssw_sidebar_right" value="sidebar_right" />
					Right</label>
			</div>
		</div>
		<div class="sepH_c">
			<p>顶部菜单显示:</p>
			<div class="clearfix">
				<label class="radio inline"><input type="radio"
					name="ssw_menu" id="ssw_menu_click" value="" checked /> Click</label> <label
					class="radio inline"><input type="radio" name="ssw_menu"
					id="ssw_menu_hover" value="menu_hover" /> Hover</label>
			</div>
		</div>
	</div>
	<div id="maincontainer" class="clearfix">
		<tiles:insertAttribute name="nav" />
		<div id="contentwrapper">
			<div class="main_content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="sidebar" />
	<div class="navbar navbar-fixed-bottom">
		<div class="footing">
			<div class="pull-left">&copy;2012 Kempinski Hotel</div>
			<div class="pull-right" id="service-status">
				<i id="conn-status" class="icomoon-link"></i>
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="commomjs" />
</body>
</html>
