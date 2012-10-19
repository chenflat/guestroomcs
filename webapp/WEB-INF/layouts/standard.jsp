<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><tiles:insertAttribute name="title" />
</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<META HTTP-EQUIV="pragma" CONTENT="no-cache" />
<tiles:insertAttribute name="header" />
</head>
<body>
	<div id="loading_layer" style="display: none">
		<img src="<c:url value="/img/ajax_loader.gif" />" alt="" />
	</div>
	<div class="style_switcher">
		<div class="sepH_c">
			<p>Colors:</p>
			<div class="clearfix">
				<a href="javascript:void(0)"
					class="style_item jQclr blue_theme style_active" title="blue">blue</a>
				<a href="javascript:void(0)" class="style_item jQclr dark_theme"
					title="dark">dark</a> <a href="javascript:void(0)"
					class="style_item jQclr green_theme" title="green">green</a> <a
					href="javascript:void(0)" class="style_item jQclr brown_theme"
					title="brown">brown</a> <a href="javascript:void(0)"
					class="style_item jQclr eastern_blue_theme" title="eastern_blue">eastern
					blue</a> <a href="javascript:void(0)"
					class="style_item jQclr tamarillo_theme" title="tamarillo">tamarillo</a>
			</div>
		</div>
		<div class="sepH_c">
			<p>Backgrounds:</p>
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
			<p>Layout:</p>
			<div class="clearfix">
				<label class="radio inline"><input type="radio"
					name="ssw_layout" id="ssw_layout_fluid" value="" checked /> Fluid</label>
				<label class="radio inline"><input type="radio"
					name="ssw_layout" id="ssw_layout_fixed" value="gebo-fixed" />
					Fixed</label>
			</div>
		</div>
		<div class="sepH_c">
			<p>Sidebar position:</p>
			<div class="clearfix">
				<label class="radio inline"><input type="radio"
					name="ssw_sidebar" id="ssw_sidebar_left" value="" checked /> Left</label>
				<label class="radio inline"><input type="radio"
					name="ssw_sidebar" id="ssw_sidebar_right" value="sidebar_right" />
					Right</label>
			</div>
		</div>
		<div class="sepH_c">
			<p>Show top menu on:</p>
			<div class="clearfix">
				<label class="radio inline"><input type="radio"
					name="ssw_menu" id="ssw_menu_click" value="" checked /> Click</label> <label
					class="radio inline"><input type="radio" name="ssw_menu"
					id="ssw_menu_hover" value="menu_hover" /> Hover</label>
			</div>
		</div>

		<div class="gh_button-group">
			<a href="#" id="showCss" class="btn btn-primary btn-mini">Show
				CSS</a> <a href="#" id="resetDefault" class="btn btn-mini">Reset</a>
		</div>
		<div class="hide">
			<ul id="ssw_styles">
				<li class="small ssw_mbColor sepH_a" style="display: none">body
					{<span class="ssw_mColor sepH_a" style="display: none">
						color: #<span></span>;</span> <span class="ssw_bColor"
					style="display: none">background-color: #<span></span> </span>}</li>
				<li class="small ssw_lColor sepH_a" style="display: none">a {
					color: #<span></span> }</li>
			</ul>
		</div>
	</div>

	<div id="maincontainer" class="clearfix">
		<tiles:insertAttribute name="nav" />
		<div id="contentwrapper">
			<div class="main_content">
				<div id="jCrumbs" class="breadCrumb module">
					<ul>
						<li><a href="#"><i class="icon-home"></i>
						</a></li>
						<li><a href="#">Sports & Toys</a></li>
						<li><a href="#">Toys & Hobbies</a></li>
						<li>Telescope 3735SX</li>
					</ul>
				</div>
				<tiles:insertAttribute name="body" />
			</div>
		</div>

		<tiles:insertAttribute name="sidebar" />
					
	</div>
	<div class="navbar navbar-fixed-bottom">
		<div class="navbar-inner">footer</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
