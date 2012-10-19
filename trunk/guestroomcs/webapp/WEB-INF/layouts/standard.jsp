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
<tiles:insertAttribute name="header" />
</head>
<body>
	<div id="loading_layer" style="display:none"><img src="<c:url value="/img/ajax_loader.gif" />" alt="" /></div>
	<div class="style_switcher">
			<div class="sepH_c">
				<p>Colors:</p>
				<div class="clearfix">
					<a href="javascript:void(0)" class="style_item jQclr blue_theme style_active" title="blue">blue</a>
					<a href="javascript:void(0)" class="style_item jQclr dark_theme" title="dark">dark</a>
					<a href="javascript:void(0)" class="style_item jQclr green_theme" title="green">green</a>
					<a href="javascript:void(0)" class="style_item jQclr brown_theme" title="brown">brown</a>
					<a href="javascript:void(0)" class="style_item jQclr eastern_blue_theme" title="eastern_blue">eastern blue</a>
					<a href="javascript:void(0)" class="style_item jQclr tamarillo_theme" title="tamarillo">tamarillo</a>
				</div>
			</div>
			<div class="sepH_c">
				<p>Backgrounds:</p>
				<div class="clearfix">
					<span class="style_item jQptrn style_active ptrn_def" title=""></span>
					<span class="ssw_ptrn_a style_item jQptrn" title="ptrn_a"></span>
					<span class="ssw_ptrn_b style_item jQptrn" title="ptrn_b"></span>
					<span class="ssw_ptrn_c style_item jQptrn" title="ptrn_c"></span>
					<span class="ssw_ptrn_d style_item jQptrn" title="ptrn_d"></span>
					<span class="ssw_ptrn_e style_item jQptrn" title="ptrn_e"></span>
				</div>
			</div>
			<div class="sepH_c">
				<p>Layout:</p>
				<div class="clearfix">
					<label class="radio inline"><input type="radio" name="ssw_layout" id="ssw_layout_fluid" value="" checked /> Fluid</label>
					<label class="radio inline"><input type="radio" name="ssw_layout" id="ssw_layout_fixed" value="gebo-fixed" /> Fixed</label>
				</div>
			</div>
			<div class="sepH_c">
				<p>Sidebar position:</p>
				<div class="clearfix">
					<label class="radio inline"><input type="radio" name="ssw_sidebar" id="ssw_sidebar_left" value="" checked /> Left</label>
					<label class="radio inline"><input type="radio" name="ssw_sidebar" id="ssw_sidebar_right" value="sidebar_right" /> Right</label>
				</div>
			</div>
			<div class="sepH_c">
				<p>Show top menu on:</p>
				<div class="clearfix">
					<label class="radio inline"><input type="radio" name="ssw_menu" id="ssw_menu_click" value="" checked /> Click</label>
					<label class="radio inline"><input type="radio" name="ssw_menu" id="ssw_menu_hover" value="menu_hover" /> Hover</label>
				</div>
			</div>
			
			<div class="gh_button-group">
				<a href="#" id="showCss" class="btn btn-primary btn-mini">Show CSS</a>
				<a href="#" id="resetDefault" class="btn btn-mini">Reset</a>
			</div>
			<div class="hide">
				<ul id="ssw_styles">
					<li class="small ssw_mbColor sepH_a" style="display:none">body {<span class="ssw_mColor sepH_a" style="display:none"> color: #<span></span>;</span> <span class="ssw_bColor" style="display:none">background-color: #<span></span> </span>}</li>
					<li class="small ssw_lColor sepH_a" style="display:none">a { color: #<span></span> }</li>
				</ul>
			</div>
		</div>

	<div id="maincontainer" class="clearfix">
	<tiles:insertAttribute name="nav" />
	
	<tiles:insertAttribute name="body" />
	
	<div id="contentwrapper">
                <div class="main_content">
                <div id="jCrumbs" class="breadCrumb module">
    <ul>
        <li>
            <a href="#"><i class="icon-home"></i></a>
        </li>
        <li>
            <a href="#">Sports & Toys</a>
        </li>
        <li>
            <a href="#">Toys & Hobbies</a>
        </li>
        <li>
            <a href="#">Learning & Educational</a>
        </li>
        <li>
            <a href="#">Astronomy & Telescopes</a>
        </li>
        <li>
            Telescope 3735SX 
        </li>
    </ul>
</div>					                    <div class="row-fluid">
    <div class="span12">
		<h3 class="heading">Regular wizard</h3>
        <div class="row-fluid">
			<div class="span12">
                <form id="simple_wizard" class="stepy-wizzard form-horizontal">
                    <fieldset title="Personal info">
                        <legend class="hide">Lorem ipsum dolor&hellip;</legend>
                        <div class="formSep control-group">
                            <label for="s_username" class="control-label">Username:</label>
                            <div class="controls">
								<input type="text" name="s_username" id="s_username" class="span6" />
							</div>
                        </div>
                        <div class="formSep control-group">
                            <label for="s_password" class="control-label">Password:</label>
                            <div class="controls">
								<input type="password" name="s_password" id="s_password" class="span6" />
							</div>
                        </div>
                        <div class="sepH_c control-group">
                            <label for="s_email" class="control-label">E-mail:</label>
                            <div class="controls">
								<input type="text" name="s_email" id="s_email" class="span6" />
							</div>
                        </div>
                    </fieldset>
                    <fieldset title="Contact info">
                        <legend class="hide">Lorem ipsum dolor&hellip;</legend>
                        <div class="formSep control-group">
                            <label for="s_street" class="control-label">Street Address:</label>
                            <div class="controls">
								<input type="text" name="s_street" id="s_street" class="span6" />
							</div>
                        </div>
                        <div class="formSep control-group">
                            <label for="s_city" class="control-label">City:</label>
                            <div class="controls">
								<input type="text" name="s_city" id="s_city" class="span6" />
							</div>
                        </div>
                        <div class="sepH_c control-group">
                            <label for="s_country" class="control-label">Country:</label>
                            <div class="controls">
								<input type="text" name="s_country" id="s_country" class="span6" />
							</div>
                        </div>
                    </fieldset>
                    <button type="button" class="finish btn btn-primary"><i class="icon-ok icon-white"></i> Send registration</button>
                </form>
            </div>
        </div>
	</div>
</div>
<div class="row-fluid">
    <div class="span12">
		<h3 class="heading">Wizard with validation</h3>
		<div class="row-fluid">
			<div class="span12">
                <form id="validate_wizard" class="stepy-wizzard form-horizontal">
                    <fieldset title="Personal info">
                        <legend class="hide">Lorem ipsum dolor&hellip;</legend>
                        <div class="formSep control-group">
                            <label for="v_username" class="control-label">Username:</label>
                            <div class="controls">
								<input type="text" name="v_username" id="v_username" class="span6" />
							</div>
                        </div>
                        <div class="formSep control-group">
                            <label for="v_password" class="control-label">Password:</label>
                            <div class="controls">
								<input type="password" name="v_password" id="v_password" class="span6" />
							</div>
                        </div>
                        <div class="control-group">
                            <label for="v_email" class="control-label">E-mail:</label>
                            <div class="controls">
								<input type="text" name="v_email" id="v_email" class="span6" />
							</div>
                        </div>
                    </fieldset>
                    <fieldset title="Contact info">
                        <legend class="hide">Lorem ipsum dolor&hellip;</legend>
                        <div class="formSep control-group">
                            <label for="v_street" class="control-label">Street Address:</label>
                            <div class="controls">
								<input type="text" name="v_street" id="v_street" class="span6" />
							</div>
                        </div>
                        <div class="formSep control-group">
                            <label for="v_city" class="control-label">City:</label>
                            <div class="controls">
								<input type="text" name="v_city" id="v_city" class="span6" />
							</div>
                        </div>
                        <div class="control-group">
                            <label for="v_country" class="control-label">Country:</label>
                            <div class="controls">
								<input type="text" name="v_country" id="v_country" class="span6" />
							</div>
                        </div>
                    </fieldset>
					<fieldset title="Additional info">
                        <legend class="hide">Lorem ipsum dolor&hellip;</legend>
						<div class="formSep control-group">
                            <label for="v_message" class="control-label">Your Message:</label>
                            <div class="controls">
								<textarea name="v_message" id="v_message" rows="3" class="span6"></textarea>
							</div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Newsletter:</label>
                            <div class="controls">
								<label class="radio inline" for="newsletter_yes">
									<input type="radio" value="yes" id="newsletter_yes" name="v_newsletter"> Yes
								</label>
								<label class="radio inline" for="newsletter_no">
									<input type="radio" value="no" id="newsletter_no" name="v_newsletter"> No
								</label>
							</div>
                        </div>
					</fieldset>
                    <button type="button" class="finish btn btn-primary"><i class="icon-ok icon-white"></i> Send registration</button>
                </form>
            </div>
        </div>
	</div>
</div>
                </div>
            </div>
	
	 <a href="javascript:void(0)" class="sidebar_switch on_switch ttip_r" title="Hide Sidebar">Sidebar switch</a>
<div class="sidebar">
	
	<div class="antiScroll">
		<div class="antiscroll-inner">
			<div class="antiscroll-content">
			<tiles:insertAttribute name="sidebar" />
				<div class="sidebar_info">
					<ul class="unstyled">
						<li>
							<span class="act act-warning">65</span>
							<strong>New comments</strong>
						</li>
						<li>
							<span class="act act-success">10</span>
							<strong>New articles</strong>
						</li>
						<li>
							<span class="act act-danger">85</span>
							<strong>New registrations</strong>
						</li>
					</ul>
				</div> 
			
			</div>
		</div>
	</div>
</div>
</div>
	<div class="navbar navbar-fixed-bottom"><div class="navbar-inner">footer</div></div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
