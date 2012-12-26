package com.managementsystem.guestroom.web.account;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.ui.easyui.Resultmsg;

/**
 * 修改用户密码
 * */
@Controller
@RequestMapping("/account/profile/password")
public class PasswordController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(PasswordController.class);

	public static final String VIEW_NAME = "account/profile/password";

	@Autowired
	private UserService userService;

	/**
	 * 显示更改密码
	 * */
	@Override
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + PasswordController.class);
		ModelAndView mav = new ModelAndView();

		User user = getCurrentUser();
		mav.addObject("user", user);
		mav.setViewName(VIEW_NAME);

		return mav;
	}

	/**
	 * 处理更改密码
	 * 
	 * @param request
	 *            请求对象
	 * */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processSubmit(WebRequest request) {
		Resultmsg result = new Resultmsg();
		result.setSuccess("false");
		String message = "页面缺少表单参数，请联系管理员!";

		if (request.getParameter("username") != null
				&& request.getParameter("password") != null
				&& request.getParameter("newpassword") != null
				&& request.getParameter("confirmnewpwd") != null
				&& request.getParameter("isvalid") != null) {

			String oldPassword = request.getParameter("password");
			String newPassword = request.getParameter("newpassword");
			String confirmNewpwd = request.getParameter("confirmnewpwd");
			String isvalid = request.getParameter("isvalid");
			if (!StringUtils.hasLength(oldPassword)) {
				message += "<li>请输入当前登陆密码</li>";
			}
			if (!StringUtils.hasLength(newPassword)) {
				message += "<li>请输入新的登陆密码</li>";
			}
			if (!StringUtils.hasLength(confirmNewpwd)) {
				message += "<li>请再次输入新的登陆密码</li>";
			}
			if (!confirmNewpwd.equals(newPassword)) {
				message += "<li>两次输入的密码不一致</li>";
			}
			if (!StringUtils.hasLength(isvalid)) {
				message += "<li>重新输入当前登陆密码</li>";
			} else {
				boolean bValid = Boolean.parseBoolean(isvalid);
				if (bValid) {
					User user = getCurrentUser();
					userService.updatePassword(user, newPassword);
					message = "密码更改成功!";
					result.setSuccess("true");
				} else {
					message += "<li>当前登陆密码错误，请重新输入</li>";
				}
			}
		}
		result.setMsg(message);
		return result;
	}

	@Override
	protected String getModelViewName() {
		return null;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		return null;
	}

}
