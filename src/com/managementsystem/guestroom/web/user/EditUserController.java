package com.managementsystem.guestroom.web.user;

import java.util.ArrayList;
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

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
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

	/**
	 * 活动角色
	 * */
	@ModelAttribute("roles")
	public Set<Role> getEnabledRoles() {
		return roleService.getEnabledRoles();
	}

	/**
	 * 所有用户
	 * */
	@ModelAttribute("users")
	public Set<User> getUsers() {
		return userService.getUsers();
	}

	/**
	 * 新增用户
	 * */
	@RequestMapping(value = "/user/users/add", method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + EditUserController.class);
		ModelAndView mav = new ModelAndView();

		User user = new User();
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
		mav.addObject("user", user);
		mav.addObject("action","edit");
		mav.setViewName(VIEW_NAME);
		return mav;
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
			} else {
				user.setStatus(1);
				user.setIsSuperUser(false);
				user = userService.save(user);
			}
			msg.setMsg(user.getUserId());
			msg.setSuccess("true");
		}
		return msg;
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
