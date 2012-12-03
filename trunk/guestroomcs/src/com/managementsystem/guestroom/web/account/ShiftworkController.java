package com.managementsystem.guestroom.web.account;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Shiftwork;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.service.biz.ShiftworkService;
import com.managementsystem.guestroom.service.platform.UserService;
import com.managementsystem.guestroom.validation.ShiftworkValidator;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.ui.easyui.Resultmsg;
import com.managementsystem.util.dao.Page;

/**
 * 用户交接班操作控制类
 * 
 * @author ping.chen
 * */
@Controller
@RequestMapping("/account/shiftwork")
public class ShiftworkController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(ShiftworkController.class);

	public static final String VIEW_NAME = "account/shiftwork";

	/**
	 * 交接班服务类
	 * */
	@Autowired
	private ShiftworkService shiftworkService;

	/**
	 * 用户服务类
	 * */
	@Autowired
	private UserService userService;

	/**
	 * 请求交接班展示页
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + ShiftworkController.class);
		ModelAndView mav = new ModelAndView();
		User user = getCurrentUser();
		Shiftwork shiftwork = shiftworkService.getLastShiftworkByUsername(user.getUsername());
		if(shiftwork==null) {
			shiftwork = new Shiftwork();
		}
		shiftwork.setUser(user);
		mav.addObject("shiftwork", shiftwork);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 保存交接班记录
	 * 
	 * @param shiftwork
	 *            交接班记录对象
	 * @param result
	 *            对象验证结果
	 * @param status
	 *            SessionStatus
	 * @return 操作结果消息
	 * */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processSubmit(
			@ModelAttribute("shiftwork") Shiftwork shiftwork,
			BindingResult result, SessionStatus status) {
		Resultmsg msg = new Resultmsg();
		msg.setSuccess("true");
		new ShiftworkValidator().validate(shiftwork, result);
		if (result.hasErrors()) {
			msg.setSuccess("false");
			msg.setMsg(result.toString());
		} else {
			String floorNo = "";
			try {
				//更新当前面的交班时间和接班用户信息
				Shiftwork lastShiftwork = shiftworkService.getLastShiftworkByUsername(shiftwork.getUser().getUsername());
				if(lastShiftwork!=null) {
					floorNo = lastShiftwork.getFloorNo();
					lastShiftwork.setWorkEndtime(Calendar.getInstance().getTime());
					lastShiftwork.setShiftworker(shiftwork.getShiftworker());
					lastShiftwork.setShiftworkerName(shiftwork.getShiftworkerName());
					shiftworkService.update(lastShiftwork);
				} 
				//保存接班用户的基本信息
				shiftwork.setCreatedOnDate(Calendar.getInstance().getTime());
				User shiftUser = new User();
				shiftUser.setUserId(shiftwork.getShiftworker());
				shiftUser.setUsername(shiftwork.getShiftworkerName());
				shiftwork.setUser(shiftUser);
				if(StringUtils.hasLength(shiftwork.getFloorNo()) && !floorNo.equals(shiftwork.getFloorNo())){
					floorNo = shiftwork.getFloorNo();
				}
				shiftwork.setFloorNo(floorNo);
				shiftwork.setWorkStarttime(Calendar.getInstance().getTime());
				shiftwork.setShiftworker(null);
				shiftwork.setShiftworkerName(null);
				shiftworkService.save(shiftwork);
			}catch(Exception e) {
				msg.setSuccess("false");
				msg.setMsg(e.toString());
				logger.error(e);
			}
		}
		return msg;
	}

	/**
	 * 验证接班用户
	 * 
	 * @param username
	 *            用户名称
	 * @return 用户信息对象
	 * */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User getShiftworker(@PathVariable String username) {
		return userService.getUserByName(username);
	}

	/**
	 * 
	 * */
	@RequestMapping(value = "/{username}/{pageIndex}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	public Page getShiftworksByUserName(@PathVariable String username,@PathVariable String pageIndex,@PathVariable String pageSize) {
		return shiftworkService.getShiftworksByUsername(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), username);
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
