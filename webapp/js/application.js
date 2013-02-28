/* [ ---- App Admin Panel - common ---- ] */

	//* detect touch devices 
    function is_touch_device() {
	  return !!('ontouchstart' in window);
	}

    var console=console||{"log":function(){}};

	$(document).ready(function() {
		//* search typeahead
		$('.search_query').typeahead({
			source: ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"],
			items: 4
		});
		//* make active on accordion change
		$('#side_accordion').on('hidden shown', function () {
			sidebar.make_active();
            sidebar.update_scroll();
		});
		//* resize elements on window resize
		var lastWindowHeight = $(window).height();
		var lastWindowWidth = $(window).width();

		$(window).on("debouncedresize",function() {
			if($(window).height()!=lastWindowHeight || $(window).width()!=lastWindowWidth){
				lastWindowHeight = $(window).height();
				lastWindowWidth = $(window).width();
				sidebar.update_scroll();
				
				
				
				if(!is_touch_device()){
                    $('.sidebar_switch').qtip('hide');
                }
			}
		});
		//* tooltips
		tips.init();
        if(!is_touch_device()){
		    //* popovers
            popOver.init();
        }
		//* sidebar
        sidebar.init();
		sidebar.make_active();

		//* pre block prettify
		//prettyPrint();
		//* external links
		external_links.init();
		//* accordion icons
		acc_icons.init();
		//* colorbox single
		if($('.cbox_single').length) {
			colorbox_single.init();
		}
		//* main menu mouseover
		nav_mouseover.init();
		//* top submenu
		submenu.init();
		
		sidebar.make_scroll();
		sidebar.update_scroll();
		
		//* style switcher
		style_sw.init();
		
		//* to top
		$().UItoTop({inDelay:200,outDelay:200,scrollSpeed: 500});
		
		content.make_scroll();
		content.update_scroll();
		
		//$("input[type='checkbox']").uniform();
		
	});
    
	content = {
		 make_scroll: function() {
				if($('.antiscroll-wrap').length) {
					antiScroll = $('.antiscroll-wrap').antiscroll().data('antiscroll');
				}
	     }, update_scroll: function() {
				if($('.antiscroll-wrap').length) {
					if( $(window).width() > 979 ){
						$('.main_content .antiscroll-inner,.main_content .antiscroll-content').height($(window).height() - 40);
					} else {
						$('.main_content').height('400px');
					}
					$('.main_content').height($(window).height() - 120);
					antiScroll.refresh();
				}
	        }
	};
	
	
    sidebar = {
        init: function() {
			// sidebar onload state
			if($(window).width() > 979){
                if(!$('body').hasClass('sidebar_hidden')) {
                    if( $.cookie('sidebar') == "hidden") {
                        $('body').addClass('sidebar_hidden');
                        $('.sidebar_switch').toggleClass('on_switch off_switch').attr('title','Show Sidebar');
                    }
                } else {
                    $('.sidebar_switch').toggleClass('on_switch off_switch').attr('title','Show Sidebar');
                }
            } else {
                $('body').addClass('sidebar_hidden');
                $('.sidebar_switch').removeClass('on_switch').addClass('off_switch');
            }
            
            sidebar.info_box();
            
			//* sidebar visibility switch
            $('.sidebar_switch').click(function(){
                $('.sidebar_switch').removeClass('on_switch off_switch');
                if( $('body').hasClass('sidebar_hidden') ) {
                    $.cookie('sidebar', null);
                    $('body').removeClass('sidebar_hidden');
                    $('.sidebar_switch').addClass('on_switch').show();
                    $('.sidebar_switch').attr( 'title', "Hide Sidebar" );
                } else {
                    $.cookie('sidebar', 'hidden');
                    $('body').addClass('sidebar_hidden');
                    $('.sidebar_switch').addClass('off_switch');
                    $('.sidebar_switch').attr( 'title', "Show Sidebar" );
                };
				sidebar.info_box();
				sidebar.update_scroll();
				$(window).resize();
            });
            //* prevent accordion link click
            $('.sidebar .accordion-toggle').click(function(e){e.preventDefault()});
        },
        info_box: function(){
			var s_box = $('.sidebar_info');
			var s_box_height = s_box.actual('height');
			s_box.css({
				'height'        : s_box_height
			});
			$('.push').height(s_box_height);
			$('.sidebar_inner').css({
				'margin-bottom' : '-'+s_box_height+'px',
				'min-height'    : '100%'
			});
        },
		make_active: function() {
			var thisAccordion = $('#side_accordion');
			thisAccordion.find('.accordion-heading').removeClass('sdb_h_active');
			var thisHeading = thisAccordion.find('.accordion-body.in').prev('.accordion-heading');
			if(thisHeading.length) {
				thisHeading.addClass('sdb_h_active');
			}
		},
        make_scroll: function() {
			if($('.antiScroll').length) {				
				antiScroll = $('.antiScroll').antiscroll().data('antiscroll');
			}
        },
        update_scroll: function() {
			if($('.sidebar > .antiScroll').length) {
				if( $(window).width() > 979 ){
					$('.sidebar .antiscroll-inner,.sidebar .antiscroll-content').height($(window).height() - 40);
				} else {
					$('.sidebar .antiscroll-inner,.sidebar .antiscroll-content').height('400px');
				}
				antiScroll.refresh();
			}
        }
    };

	//* tooltips
	tips = {
		init: function() {
			if(!is_touch_device()){
				var shared = {
				style		: {
						classes: 'ui-tooltip-shadow ui-tooltip-tipsy'
					},
					show		: {
						delay: 100,
						event: 'mouseenter focus'
					},
					hide		: { delay: 0 }
				};
				if($('.ttip_b').length) {
					$('.ttip_b').qtip( $.extend({}, shared, {
						position	: {
							my		: 'top center',
							at		: 'bottom center',
							viewport: $(window)
						}
					}));
				};
				if($('.ttip_t').length) {
					$('.ttip_t').qtip( $.extend({}, shared, {
						position: {
							my		: 'bottom center',
							at		: 'top center',
							viewport: $(window)
						}
					}));
				};
				if($('.ttip_l').length) {
					$('.ttip_l').qtip( $.extend({}, shared, {
						position: {
							my		: 'right center',
							at		: 'left center',
							viewport: $(window)
						}
					}));
				};
				if($('.ttip_r').length) {
					$('.ttip_r').qtip( $.extend({}, shared, {
						position: {
							my		: 'left center',
							at		: 'right center',
							viewport: $(window)
						}
					}));
				};
			}
		}
	};
    
    //* popovers
    popOver = {
        init: function() {
            $(".pop_over").popover();
        }
    };

	
	//* external links
	external_links = {
		init: function() {
			$("a[href^='http']").not('.thumbnail>a,.ext_disabled').each(function() {
				$(this).attr('target','_blank').addClass('external_link');
			})
		}
	};
	
	//* accordion icons
	acc_icons = {
		init: function() {
			var accordions = $('#accordion1,#accordion2');
			
			accordions.find('.accordion-group').each(function(){
				var acc_active = $(this).find('.accordion-body').filter('.in');
				acc_active.prev('.accordion-heading').find('.accordion-toggle').addClass('acc-in');
			});
			accordions.on('show', function(option) {
				$(this).find('.accordion-toggle').removeClass('acc-in');
				$(option.target).prev('.accordion-heading').find('.accordion-toggle').addClass('acc-in');
			});
			accordions.on('hide', function(option) {
				$(option.target).prev('.accordion-heading').find('.accordion-toggle').removeClass('acc-in');
			});		
		}
	};
	
	//* main menu mouseover
	nav_mouseover = {
		init: function() {
			$('header li.dropdown').mouseenter(function() {
				if($('body').hasClass('menu_hover')) {
					$(this).addClass('navHover')
				}
			}).mouseleave(function() {
				if($('body').hasClass('menu_hover')) {
					$(this).removeClass('navHover open')
				}
			});
		}
	};
	
	//* single image colorbox
	colorbox_single = {
		init: function() {
			$('.cbox_single').colorbox({
				maxWidth	: '80%',
				maxHeight	: '80%',
				opacity		: '0.2', 
				fixed		: true
			});
		}
	};
	
	//* submenu
	submenu = {
		init: function() {
			$('.dropdown-menu li').each(function(){
				var $this = $(this);
				if($this.children('ul').length) {
					$this.addClass('sub-dropdown');
					$this.children('ul').addClass('sub-menu');
				}
			});
			
			$('.sub-dropdown').on('mouseenter',function(){
				$(this).addClass('active').children('ul').addClass('sub-open');
			}).on('mouseleave', function() {
				$(this).removeClass('active').children('ul').removeClass('sub-open');
			})
			
		}
	};
	
	//* 转换界面主题风格
	style_sw = {
		init: function() {
			//$('body').append('<a class="ssw_trigger" href="javascript:void(0)"><i class="icon-cog icon-white"></i></a>');
			var defLink = $('#link_theme').clone();

			$('input[name=ssw_sidebar]:first,input[name=ssw_layout]:first,input[name=ssw_menu]:first').attr('checked', true);
			
			$(".ssw_trigger").click(function(){
				$(".style_switcher").toggle("fast");
				$(this).toggleClass("active");
				return false;
			});
			
			if ($.cookie('link_theme') != null) {
				$('#link_theme').attr('href',contextPath+'css/theme/'+$.cookie('link_theme')+'.css');
			}

			// colors
			$('.style_switcher .jQclr').click(function() {
                $(this).closest('div').find('.style_item').removeClass('style_active');
				$(this).addClass('style_active');
				var style_selected = $(this).attr('title');
				$('#link_theme').attr('href',contextPath+'css/theme/'+style_selected+'.css');
                $.cookie('link_theme', style_selected);
				
				
            });
			
			// backgrounds
			$('.style_switcher .jQptrn').click(function(){
				$(this).closest('div').find('.style_item').removeClass('style_active');
				$(this).addClass('style_active');
				var style_selected = $(this).attr('title');
				if($(this).hasClass('jQptrn')) { $('body').removeClass('ptrn_a ptrn_b ptrn_c ptrn_d ptrn_e').addClass(style_selected); };
				//alert(style_selected);
			});
			//* layout
			$('input[name=ssw_layout]').click(function(){
				var layout_selected = $(this).val();
				$('body').removeClass('app-fixed').addClass(layout_selected);
			});
			//* sidebar position
			$('input[name=ssw_sidebar]').click(function(){
				var sidebar_position = $(this).val();
				$('body').removeClass('sidebar_right').addClass(sidebar_position);
				$(window).resize();
			});
			//* menu show
			$('input[name=ssw_menu]').click(function(){
				var menu_show = $(this).val();
				$('body').removeClass('menu_hover').addClass(menu_show);
			});

			
		}
	};