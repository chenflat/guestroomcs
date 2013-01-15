package com.managementsystem.guestroom.web.account;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Address;
import com.managementsystem.guestroom.domain.hibernate.Emailaddress;
import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.domain.hibernate.Phone;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.AddressService;
import com.managementsystem.guestroom.service.platform.EmailaddressService;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.guestroom.service.platform.PhoneService;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.ui.easyui.Resultmsg;

/**
 * 编辑联系信息
 * */
@Controller
@RequestMapping("/account/profile/contact")
public class ContactController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(ContactController.class);

	private final String VIEW_NAME = "account/profile/contact";

	@Autowired
	private PhoneService phoneService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmailaddressService emailAddressService;
	
	@Autowired
	private ListinfoService listinfoService;
	
	@Autowired
	private UserService userService;
	
	private int phoneCount = 0;
	private int emailaddressCount = 0;
	private int addressCount = 0;
	
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
	 * 编辑联系信息
	 * */
	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + ContactController.class);
		ModelAndView mav = new ModelAndView();
		User user = getCurrentUser();
		
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
		mav.setViewName(VIEW_NAME);

		return mav;
	}

	
	/**
	 * 保存联系信息
	 * */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processSubmit(@ModelAttribute("user") User user,WebRequest request) {
		Resultmsg result = new Resultmsg();
		result.setSuccess("false");
		try {

			saveorUpdateUserContact(user,false);
			
			/*for(Iterator<String> it = request.getParameterNames();it.hasNext();) {
				String name = it.next().toString();
				String value = request.getParameter(name);
				
				  logger.info("edit user contact info,field name:" + name + " value:"+ value);
				    if(!("userId").equals(name)) {
				    	try {
							BeanUtils.setProperty(user, name, value);
						} catch (IllegalAccessException e) {
							logger.error(e);
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							logger.error(e);
							e.printStackTrace();
						}
				    }
				
				
			}*/
			

		//	saveorUpdateUserContact(user,false);
			result.setSuccess("true");
		}catch(Exception e) {
			result.setMsg(e.getLocalizedMessage());
		}
		return result;
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
	
	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		return null;
	}

}
