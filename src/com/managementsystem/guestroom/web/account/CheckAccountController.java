package com.managementsystem.guestroom.web.account;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.ui.easyui.Resultmsg;


/**
 * 账号检查类
 * */
@Controller
public class CheckAccountController {

	private final Log logger = LogFactory.getLog(CheckAccountController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 验证用户是否存在
	 * */
	@RequestMapping(value = "/account/{username}/valid/password", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg isExistUsername(@PathVariable("username")String username, WebRequest request) {
		Resultmsg msg = new Resultmsg();
		 msg.setSuccess("false");
		if(!StringUtils.hasLength(username)) {
			msg.setMsg("username is null");
			return msg;
		}
		User userinfo = userService.getUserByName(username);
		if(userinfo==null) {
			msg.setMsg("username is null");
			return msg;
		}
		if (request.getParameter("password") != null) {
			String password = request.getParameter("password");
			 PasswordEncoder encoder = new Md5PasswordEncoder();
			 boolean istrue = encoder.isPasswordValid(userinfo.getPassword(),password , null);
			 logger.info(String.format("%s change password,valid result is:%s", username,istrue));
			 if(istrue) {
				 msg.setSuccess("true");
			 } else {
				 msg.setMsg("password fail!");
			 }
		} else {
			 msg.setMsg("Password is empty,Please input!");
		}
		return msg;
	}
	
	
}
