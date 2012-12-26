package com.managementsystem.guestroom.web.account;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Address;
import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.Phone;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.AddressService;
import com.managementsystem.guestroom.service.platform.EmailaddressService;
import com.managementsystem.guestroom.service.platform.PhoneService;
import com.managementsystem.guestroom.service.platform.ProfilepropertydefinitionService;
import com.managementsystem.guestroom.service.platform.UserprofileService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;


/**
 * 用户资料控制器
 * 
 * CreatedOnDate: 2012-10-23
 * */
@Controller
@RequestMapping("/account/profile")
public class ProfileController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(ProfileController.class);

	public static final String VIEW_NAME = "account/profile";

	@Autowired
	private PhoneService phoneService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmailaddressService emailAddressService;
	
	/**
	 * 用户属性定义服务接口对象
	 * */
	@Autowired
	private ProfilepropertydefinitionService profilepropertydefinitionService;

	/**
	 * 用户属性对应资料服务接口对象
	 * */
	@Autowired
	private UserprofileService userprofileService;
	
	/**
	 * 显示用户资料
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + ProfileController.class);
		ModelAndView mav = new ModelAndView();
		//当前用户对象
		User user = getCurrentUser();
		
		Set<Phone> phones = null;
		Set<Emailaddress> emailaddresses = null;
		Set<Address> addresses = null;
		if(user!=null && StringUtils.hasLength(user.getUserId())) {
			phones = phoneService.getPhonesByUser(user);
			emailaddresses = emailAddressService.getEmailAddressListByUser(user);
			addresses = addressService.getAddressListByUser(user);
			
			// 获取当前用户信息
			Set<Userprofile> userprofiles = userprofileService
					.getUserprofileByUsername(user.getUsername(), "picture");
			user.setUserprofiles(userprofiles);
		}
		
		mav.addObject("phones", phones);
		mav.addObject("emailaddresses", emailaddresses);
		mav.addObject("addresses", addresses);
		mav.addObject("user", user);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		return null;
	}
}
