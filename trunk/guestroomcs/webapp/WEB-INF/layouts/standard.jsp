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
	<div id="loading_layer" style="display:none"><img src="<c:url value="images/ajax_loader.gif" />" alt="" /></div>
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
	</div>
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
		
				<div class="sidebar_inner">
					<form action="index.php?uid=1&amp;page=search_page" class="input-append" method="post" >
						<input autocomplete="off" name="query" class="search_query input-medium" size="16" type="text" placeholder="Search..." /><button type="submit" class="btn"><i class="icon-search"></i></button>
					</form>
					<div id="side_accordion" class="accordion">
						
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseOne" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
									<i class="icon-folder-close"></i> Content
								</a>
							</div>
							<div class="accordion-body collapse" id="collapseOne">
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li><a href="javascript:void(0)">Articles</a></li>
										<li><a href="javascript:void(0)">News</a></li>
										<li><a href="javascript:void(0)">Newsletters</a></li>
										<li><a href="javascript:void(0)">Comments</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseTwo" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
									<i class="icon-th"></i> Modules
								</a>
							</div>
							<div class="accordion-body collapse" id="collapseTwo">
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li><a href="javascript:void(0)">Content blocks</a></li>
										<li><a href="javascript:void(0)">Tags</a></li>
										<li><a href="javascript:void(0)">Blog</a></li>
										<li><a href="javascript:void(0)">FAQ</a></li>
										<li><a href="javascript:void(0)">Formbuilder</a></li>
										<li><a href="javascript:void(0)">Location</a></li>
										<li><a href="javascript:void(0)">Profiles</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseThree" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
									<i class="icon-user"></i> Account manager
								</a>
							</div>
							<div class="accordion-body collapse" id="collapseThree">
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li><a href="javascript:void(0)">Members</a></li>
										<li><a href="javascript:void(0)">Members groups</a></li>
										<li><a href="javascript:void(0)">Users</a></li>
										<li><a href="javascript:void(0)">Users groups</a></li>
									</ul>
                                    
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseFour" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
									<i class="icon-cog"></i> Configuration
								</a>
							</div>
							<div class="accordion-body collapse" id="collapseFour">
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li class="nav-header">People</li>
										<li class="active"><a href="javascript:void(0)">Account Settings</a></li>
										<li><a href="javascript:void(0)">IP Adress Blocking</a></li>
										<li class="nav-header">System</li>
										<li><a href="javascript:void(0)">Site information</a></li>
										<li><a href="javascript:void(0)">Actions</a></li>
										<li><a href="javascript:void(0)">Cron</a></li>
										<li class="divider"></li>
										<li><a href="javascript:void(0)">Help</a></li>
									</ul>
								</div>
							</div>
						</div>
                        <div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseLong" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
									<i class="icon-leaf"></i> Long content (scrollbar)
								</a>
							</div>
							<div class="accordion-body collapse" id="collapseLong">
								<div class="accordion-inner">
                                    Some text to show sidebar scroll bar<br>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rhoncus, orci ac fermentum imperdiet, purus sapien pharetra diam, at varius nibh tellus tristique sem. Nulla congue odio ut augue volutpat congue. Nullam id nisl ut augue posuere ullamcorper vitae eget nunc. Quisque justo turpis, tristique non fermentum ac, feugiat quis lorem. Ut pellentesque, turpis quis auctor laoreet, nibh erat volutpat est, id mattis mi elit non massa. Suspendisse diam dui, fringilla id pretium non, dapibus eget enim. Duis fermentum quam a leo luctus tincidunt euismod sit amet arcu. Duis bibendum ultricies libero sed feugiat. Duis ut sapien risus. Morbi non nulla sit amet eros fringilla blandit id vel augue. Nam placerat ligula lacinia tellus molestie molestie vestibulum leo tincidunt.
                                    Duis auctor varius risus vitae commodo. Fusce nec odio massa, ut dapibus justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur dapibus, mauris sit amet feugiat tempor, nulla diam gravida magna, in facilisis sapien tellus non ligula. Mauris sapien turpis, sodales ac lacinia sit amet, porttitor in lacus. Pellentesque tincidunt malesuada magna, in egestas augue sodales vel. Praesent iaculis sapien at ante sodales facilisis.
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapse7" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
								   <i class="icon-th"></i> Calculator
								</a>
							</div>
							<div class="accordion-body collapse in" id="collapse7">
								<div class="accordion-inner">
									<form name="Calc" id="calc">
										<div class="formSep control-group input-append">
											<input type="text" style="width:130px" name="Input" /><button type="button" class="btn" name="clear" value="c" OnClick="Calc.Input.value = ''"><i class="icon-remove"></i></button>
										</div>
										<div class="control-group">
											<input type="button" class="btn btn-large" name="seven" value="7" OnClick="Calc.Input.value += '7'" />
											<input type="button" class="btn btn-large" name="eight" value="8" OnCLick="Calc.Input.value += '8'" />
											<input type="button" class="btn btn-large" name="nine" value="9" OnClick="Calc.Input.value += '9'" />
											<input type="button" class="btn btn-large" name="div" value="/" OnClick="Calc.Input.value += ' / '">
										</div>
										<div class="control-group">
											<input type="button" class="btn btn-large" name="four" value="4" OnClick="Calc.Input.value += '4'" />
											<input type="button" class="btn btn-large" name="five" value="5" OnCLick="Calc.Input.value += '5'" />
											<input type="button" class="btn btn-large" name="six" value="6" OnClick="Calc.Input.value += '6'" />
											<input type="button" class="btn btn-large" name="times" value="x" OnClick="Calc.Input.value += ' * '" />
										</div>
										<div class="control-group">
											<input type="button" class="btn btn-large" name="one" value="1" OnClick="Calc.Input.value += '1'" />
											<input type="button" class="btn btn-large" name="two" value="2" OnCLick="Calc.Input.value += '2'" />
											<input type="button" class="btn btn-large" name="three" value="3" OnClick="Calc.Input.value += '3'" />
											<input type="button" class="btn btn-large" name="minus" value="-" OnClick="Calc.Input.value += ' - '" />
										</div>
										<div class="formSep control-group">
											<input type="button" class="btn btn-large" name="dot" value="." OnClick="Calc.Input.value += '.'" />
											<input type="button" class="btn btn-large" name="zero" value="0" OnClick="Calc.Input.value += '0'" />
											<input type="button" class="btn btn-large" name="DoIt" value="=" OnClick="Calc.Input.value = Math.round( eval(Calc.Input.value) * 1000)/1000" />
											<input type="button" class="btn btn-large" name="plus" value="+" OnClick="Calc.Input.value += ' + '" />
										</div>
										Contributed by <a href="http://themeforest.net/user/maumao">maumao</a>
									</form>
								</div>
							 </div>
						</div>

					</div>
					
					<div class="push"></div>
				</div>
				   
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
	<tiles:insertAttribute name="footer" />
</body>
</html>
