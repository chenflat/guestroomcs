package com.managementsystem.guestroom.web.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.common.Constants;
import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.platform.ResourceService;
import com.managementsystem.guestroom.service.platform.RoleService;
import com.managementsystem.guestroom.validation.RoleValidator;
import com.managementsystem.ui.easyui.Resultmsg;
import com.managementsystem.ui.easyui.Tree;

/**
 * 添加用户角色控制器
 * 
 * @author CHENPING
 * */
@Controller
public class AddGroupController {

	private final Log logger = LogFactory.getLog(AddGroupController.class);

	private final String VIEW_NAME = "user/groups/add";

	@Autowired
	private RoleService roleService;

	@Autowired
	private ResourceService resourceService;
	
	@ModelAttribute("roles")
	public Set<Role> getRoles() {
		return roleService.getEnabledRoles();
	}

	@ModelAttribute("resources")
	public List<Resource> getResources() {
		return resourceService.getUrlTypeOfResources();
	}
	
	
	/**
	 * 新增角色信息
	 * */
	@RequestMapping(value = "/user/groups/add", method = RequestMethod.GET)
	public ModelAndView doGet() {
		logger.info("Requesting doGet of " + AddGroupController.class);
		ModelAndView mav = new ModelAndView();
		Role role = new Role();
		role.setStatus(1);
		role.setRoleName("ROLE_");
		role.setIssys(false);
		mav.addObject("role", role);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	/**
	 * 保存角色信息
	 * */
	@RequestMapping(value = "/user/groups/add", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processSubmit(@ModelAttribute("role") Role role,
			BindingResult result, SessionStatus status, Model model) {
		new RoleValidator().validate(roleService,role, result);
		Resultmsg msg = new Resultmsg();
		if (result.hasErrors()) {
			logger.error(result);
			msg.setMsg(result.toString());
			msg.setSuccess("false");
		} else {
			if (StringUtils.hasLength(role.getRoleId())) {
				roleService.update(role);
			} else {
				//添加应用资源
				if(role.getResourcelist()!=null) {
					Set<Resource> resources = new HashSet<Resource>();
					for(Resource res : role.getResourcelist()) {
						if(StringUtils.hasLength(res.getResourceId())) {
							resources.add(res);
						}
					}
					role.setResources(resources);
				}
				role = roleService.save(role);
			}
			status.setComplete();
			msg.setSuccess("true");
			msg.setMsg(role.getRoleId());
		}
		return msg;
	}

	/**
	 * 验证角色相关信息
	 * 
	 * @param request
	 *            请求对象
	 * */
	@RequestMapping(value = "/user/groups/validgroupinfo", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg validRolename(WebRequest request) {
		Resultmsg msg = new Resultmsg();
		if (request.getParameter("roleName") != null) {
			String roleName = request.getParameter("roleName");
			if (roleService.isExistRoleName(roleName)) {
				msg.setMsg("Role Is Exists");
				msg.setSuccess("false");
			} else {
				msg.setSuccess("true");
			}
		} else {
			msg.setMsg("no roleName request parameter");
			msg.setSuccess("false");
		}
		return msg;
	}

}
