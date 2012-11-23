package com.managementsystem.guestroom.web.user;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.service.platform.ResourceService;
import com.managementsystem.guestroom.service.platform.RoleService;
import com.managementsystem.ui.easyui.Resultmsg;

/**
 * 编辑用户角色控制器
 * */
@Controller
public class EditRoleControler {

	private final Log logger = LogFactory.getLog(EditRoleControler.class);

	private final String VIEW_NAME = "user/roles/edit";

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;

	@ModelAttribute("roles")
	public Set<Role> getRoles() {
		return roleService.getEnabledRoles();
	}
	
	/**
	 * 编辑角色
	 * */
	@RequestMapping(value = "/user/roles/edit/{roleId}", method = RequestMethod.GET)
	public ModelAndView doGet(@PathVariable("roleId") String roleId) {
		logger.info("Requesting doGet of "+ EditRoleControler.class);
		ModelAndView mav = new ModelAndView();
		Role role = roleService.get(roleId);
		mav.addObject("role", role);
		mav.setViewName(VIEW_NAME);
		return mav;
	}
	
	/**
	 * 删除数据
	 * */
	@RequestMapping(value = "/user/roles/delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processDelete(WebRequest request) {
		String roleId = null;
		Resultmsg msg = new Resultmsg();
		if(request.getParameter("roleId")!=null) {
			roleId = request.getParameter("roleId");
			if(StringUtils.hasLength(roleId)) {
				Role role = roleService.get(roleId);
				if(role.getIssys()) {
					msg.setMsg("System role is not allowed to delete!");
					msg.setSuccess("false");
				} else {
					roleService.delete(roleId);
					msg.setSuccess("true"); 
				}
			} else {
				msg.setMsg("roleId is empty");
			}
		}
		return msg;
	}
	
	@RequestMapping(value = "/user/roles/methodsofresource", method = RequestMethod.GET)
	@ResponseBody
	public List<Resource> getMethodsOfResource(@RequestParam("resourceId")String resourceId) {
		return resourceService.getMethodsOfResource(resourceId);
	}
	
}
