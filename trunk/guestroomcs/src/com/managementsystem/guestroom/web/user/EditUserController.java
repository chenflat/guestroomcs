package com.managementsystem.guestroom.web.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Address;
import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.domain.hibernate.Phone;
import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.platform.AddressService;
import com.managementsystem.guestroom.service.platform.EmailaddressService;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.guestroom.service.platform.PhoneService;
import com.managementsystem.guestroom.service.platform.RoleService;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.validation.UserValidator;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.ui.easyui.Resultmsg;

@Controller
public class EditUserController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(EditUserController.class);

	private final String VIEW_NAME = "user/users/edit";
	private final String VIEW_NAME_EDITPIC = "user/users/editpic";
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ListinfoService listinfoService;
	
	@Autowired
	private PhoneService phoneService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmailaddressService emailAddressService;
	
	private int phoneCount = 0;
	private int emailaddressCount = 0;
	private int addressCount = 0;
	
	/**
	 * 活动角色
	 * */
	@ModelAttribute("roles")
	public Set<Role> getEnabledRoles() {
		return roleService.getEnabledRoles();
	}

	/**
	 * 获取所有用户列表
	 * */
	@ModelAttribute("users")
	public Set<User> getUsers() {
		return userService.getUsers();
	}

	/**
	 * 用户电话号码类型定义
	 * */
	@ModelAttribute("phoneTypes")
	public Set<Listinfo> getPhoneTypes() {
		Set<Listinfo> lists = listinfoService.getListEntryItems("Phone");
		phoneCount = lists.size();
		return lists;
	}
	
	/**
	 * 用户电子邮件地址类型定义
	 * */
	@ModelAttribute("emailladdressTypes")
	public Set<Listinfo> getEmailAddressTypes() {
		Set<Listinfo> lists = listinfoService.getListEntryItems("EmaillAddress");
		emailaddressCount = lists.size();
		return lists;
	}
	
	/**
	 * 用户地址类型定义
	 * */
	@ModelAttribute("addressTypes")
	public Set<Listinfo> getAddressTypes() {
		Set<Listinfo> lists = listinfoService.getListEntryItems("Address");
		addressCount = lists.size();
		return lists;
	}
	
	/**
	 * 初始化用户电话信息
	 * @param user 用户对象
	 * @param lists 定义字典列表
	 * */
	private void initPhone(User user,Collection<Listinfo> lists) {
		//设置用户电话列表
		int pi = 0;
		for(Listinfo li : getPhoneTypes()) {
			Phone phone = new Phone();
			phone.setEntryid(li.getEntryid());
			phone.setComment(li.getText());
			phone.setKeyname(li.getValue());
			phone.setPrimary(pi==0);
			user.getPhoneList().add(phone);
			pi++;
		}
	}
	
	
	/**
	 * 初始化用户电子邮件信息
	 * @param user 用户对象
	 * @param lists 定义字典列表
	 * */
	private void initEmailAddress(User user,Collection<Listinfo> lists) {
		//设置用户电子邮件列表
		int ei = 0;
		for(Listinfo li : lists ) {
			Emailaddress email = new Emailaddress();
			email.setEntryid(li.getEntryid());
			email.setComment(li.getText());
			email.setKeyname(li.getValue());
			email.setPrimary(ei==0);
			user.getEmailaddressList().add(email);
			ei++;
		}
	}


	/**
	 * 初始化用户地址信息
	 * @param user 用户对象
	 * @param lists 定义字典列表
	 * */
	private void initAddress(User user,Collection<Listinfo> lists) {
		//设置用户地址列表
		int ai = 0;
		for(Listinfo li : getAddressTypes() ) {
			Address address = new Address();
			address.setEntryid(li.getEntryid());
			address.setComment(li.getText());
			address.setKeyname(li.getValue());
			address.setPrimary(ai==0);
			user.getAddressList().add(address);
			ai++;
		}	
	}
	
	/**
	 * 新增用户
	 * */
	@RequestMapping(value = "/user/users/add", method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + EditUserController.class);
		ModelAndView mav = new ModelAndView();

		User user = new User();
		//设置用户电话列表
		initPhone(user,getPhoneTypes());
		
		//设置用户电子邮件列表
		initEmailAddress(user,getEmailAddressTypes());
		
		//设置用户地址列表
		initAddress(user,getAddressTypes());	

		mav.addObject("user", user);
		mav.addObject("action","add");
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 编辑用户
	 * */
	@RequestMapping(value = "/user/users/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView doGetEdit(@PathVariable("userId") String userId) {
		logger.info("Requesting doGetEdit of " + EditUserController.class);
		ModelAndView mav = new ModelAndView();
		User user = userService.get(userId);
		if(user.getRoles()!=null) {
			user.setRolelist(new ArrayList<Role>(user.getRoles()));
		}
		
		//设置用户联系信息
		if(user!=null && StringUtils.hasLength(user.getUserId())) {
			//设置用户电话列表
			List<Phone> phoneList = new ArrayList<Phone>(phoneService.getPhonesByUser(user));
			user.setPhoneList(phoneList);
			checkPhones(user);
			
			//设置用户电子邮件列表
			List<Emailaddress> emailaddressList = new ArrayList<Emailaddress>(emailAddressService.getEmailAddressListByUser(user));
			user.setEmailaddressList(emailaddressList);
			checkEmailaddress(user);
			
			//设置用户地址列表
			List<Address> addressList = new ArrayList<Address>(addressService.getAddressListByUser(user));
			user.setAddressList(addressList);
			checkAddresses(user);
		}
	
		mav.addObject("user", user);
		mav.addObject("action","edit");
		mav.setViewName(VIEW_NAME);
		return mav;
	}
	
	/**
	 * check user's phone list
	 * @param user user object
	 * */
	private void checkPhones(User user) {
		int pCount = user.getPhoneList().size();
		//电话号码数据为0时初始化电话列表
		if(pCount==0) {
			initPhone(user,getPhoneTypes());
		} else if(pCount>0 && pCount<phoneCount) {
			//电话号码数小于定义数时，加入差集
			List<Listinfo> lists = new ArrayList<Listinfo>(getPhoneTypes());
			for(int i=0;i<lists.size();i++) {
				Listinfo li = lists.get(i);
				for(Phone phone : user.getPhoneList()) {
					if(phone.getEntryid().equals(li.getEntryid())) {
						lists.remove(li);
					}
				}
			}
			initPhone(user,lists);
		}
	}
	
	/**
	 * Check user's address list
	 * @param user user object
	 * */
	private void checkAddresses(User user) {
		int addrCount = user.getAddressList().size();
		if(addrCount==0) {
			initAddress(user,getAddressTypes());
		} else if (addrCount>0 && addrCount<addressCount) {
			List<Listinfo> lists = new ArrayList<Listinfo>(getAddressTypes());
			for(int i=0;i<lists.size();i++) {
				Listinfo li = lists.get(i);
				for(Address address : user.getAddressList()) {
					if(address.getEntryid().equals(li.getEntryid())) {
						lists.remove(li);
					}
				}
			}
			initPhone(user,lists);
		}
	}
	
	/**
	 * Check user's email address 
	 * @param user user object
	 * */
	private void checkEmailaddress(User user) {
		int hasEmailCount = user.getEmailaddressList().size();
		if(hasEmailCount==0) {
			initEmailAddress(user,getEmailAddressTypes());
		}else if (hasEmailCount>0 && hasEmailCount<emailaddressCount) {
			List<Listinfo> lists = new ArrayList<Listinfo>(getAddressTypes());
			for(int i=0;i<lists.size();i++) {
				Listinfo li = lists.get(i);
				for(Emailaddress email : user.getEmailaddressList()) {
					if(email.getEntryid().equals(li.getEntryid())) {
						lists.remove(li);
					}
				}
			}
			initPhone(user,lists);
		}
	}
	
	
	

	/**
	 * 编辑用户照片
	 * */
	@RequestMapping(value = "/user/users/editpic/{userId}", method = RequestMethod.GET)
	public ModelAndView doGetEditpic(@PathVariable("userId") String userId) {
		logger.info("Requesting doGetEdit of " + EditUserController.class);
		ModelAndView mav = new ModelAndView();
		User user = userService.get(userId);
		mav.addObject("user", user);
		mav.setViewName(VIEW_NAME_EDITPIC);
		return mav;
	}

	/**
	 * 验证用户是否存在
	 * */
	@RequestMapping(value = "/user/users/validusername", method = RequestMethod.POST)
	@ResponseBody
	public String isExistUsername(WebRequest request) {
		if (request.getParameter("username") != null) {
			String username = request.getParameter("username");
			if (userService.isExistUsername(username)) {
				return "true";
			}
		}
		return "false";
	}
	
	/**
	 * 验证用户是否存在
	 * */
	@RequestMapping(value = "/user/users/setstatus", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg setUserStatus(@RequestParam("userId")String userId,@RequestParam("status")String status) {
		Resultmsg msg = new Resultmsg();
		msg.setSuccess("true");
		if(StringUtils.hasLength(userId)&&NumberUtils.isNumber(status)) {
			User user = userService.get(userId);
			if(user!=null) {
				user.setStatus(Integer.valueOf(status));
				userService.update(user);
			}
		} else {
			msg.setSuccess("false");
			msg.setMsg("userId or status value is empty");
		}
		return msg;
	}

	/**
	 * 保存用户信息
	 * */
	@RequestMapping(value = "/user/users/save", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processSubmit(@ModelAttribute("user") User user,
			BindingResult result, SessionStatus status, Model model,
			WebRequest request) {
		new UserValidator().validate(user, result);
		Resultmsg msg = new Resultmsg();
		if (result.hasErrors()) {
			logger.error(result);
			msg.setMsg(result.toString());
		} else {
			
			 if(user.getRolelist()!=null) {
				 Set<Role> roles = new HashSet<Role>();
				 for(Role role : user.getRolelist()) {
					 if(StringUtils.hasLength(role.getRoleId())) {
						 roles.add(role);
					 }
				 }
				 user.setRoles(roles);
			 }
			
			// 更新
			if (StringUtils.hasLength(user.getUserId())) {
				userService.update(user);
				saveorUpdateUserContact(user,false);
			} else {
				user.setStatus(1);
				user.setIsSuperUser(false);
				user = userService.save(user);
				saveorUpdateUserContact(user,true);
			}
			msg.setMsg(user.getUserId());
			msg.setSuccess("true");
		}
		return msg;
	}
	
	/**
	 * Save Or update user contact info
	 * @param user user object
	 * @param isnew  If it is new is true
	 * */
	private void saveorUpdateUserContact(User user,boolean isnew) {
		for(Phone phone : user.getPhoneList()) {
			phone.setUser(user);
			if(isnew) {
				phone.setCreatedOnDate(Calendar.getInstance().getTime());
				phoneService.save(phone);
			} else {
				if(StringUtils.hasLength(phone.getPhoneId())) {
					phoneService.update(phone);
				} else {
					phone.setCreatedOnDate(Calendar.getInstance().getTime());
					phoneService.save(phone);
				}	
			}
		}
		for(Address addr : user.getAddressList()) {
			
			addr.setUser(user);
			if(isnew) {
				addr.setCreatedOnDate(Calendar.getInstance().getTime());
				addressService.save(addr);
			} else {
				if(StringUtils.hasLength(addr.getAddressId())) {
					addressService.update(addr);
				} else {
					addr.setCreatedOnDate(Calendar.getInstance().getTime());
					addressService.save(addr);
				}
			}
		}
		for(Emailaddress email : user.getEmailaddressList()) {
			
			email.setUser(user);
			if(isnew) {
				email.setCreatedOnDate(Calendar.getInstance().getTime());
				emailAddressService.save(email);
			}else {
				if(StringUtils.hasLength(email.getEmailAddressId())) {
					emailAddressService.update(email);
				} else {
					email.setCreatedOnDate(Calendar.getInstance().getTime());
					emailAddressService.save(email);
				}
			}
		}
	}
	
	
	

	/**
	 * 删除用户
	 * */
	@RequestMapping(value = "/user/users/delete", method = RequestMethod.POST)
	@ResponseBody
	public String processDelete(Model model, WebRequest request) {
		if (request.getParameter("userId") != null) {
			String userId = request.getParameter("userId");
			logger.info("delete user ids:" + userId);
			if (userId.indexOf(",") > 0) {
				for (String id : userId.split(",")) {
					if (StringUtils.hasLength(id)) {
						if (!isSupperUser(id)) {
							userService.delete(id);
						}
					}
				}
			} else {
				if (!isSupperUser(userId)) {
					userService.delete(userId);
				}
			}
		}
		return "error";
	}

	/**
	 * 判断是否超级用户
	 * 
	 * @param userId
	 *            用户ID
	 * */
	private boolean isSupperUser(String userId) {
		return userService.get(userId).getIsSuperUser();
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
