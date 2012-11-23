package com.managementsystem.guestroom.web.user;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.domain.hibernate.Resource;
import com.managementsystem.guestroom.domain.platform.ResourceType;
import com.managementsystem.guestroom.service.platform.ResourceService;
import com.managementsystem.guestroom.validation.ResourceValidator;
import com.managementsystem.ui.easyui.Resultmsg;
import com.managementsystem.ui.easyui.Tree;

@Controller
public class EditResourceController {

	private final Log logger = LogFactory.getLog(EditResourceController.class);

	private final String VIEW_NAME_ADD = "user/resources/add";
	private final String VIEW_NAME_EDIT = "user/resources/edit";

	@Autowired
	private ResourceService resourceService;

	@ModelAttribute("resourcetree")
	public List<Tree> getResourceTree() {
		return resourceService.getUrlTypeOfResourcesTree();
	}

	/**
	 * 新增资源
	 * */
	@RequestMapping(value = "/user/resources/add", method = RequestMethod.GET)
	public ModelAndView setupAddForm() {
		logger.info("request setupAddForm of " + EditResourceController.class);
		ModelAndView mav = new ModelAndView();
		Resource resource = new Resource();
		resource.setStatus(1);
		resource.setPriority(0);
		resource.setResources(null);
		mav.addObject("methods", null);
		mav.addObject("resource", resource);
		mav.setViewName(VIEW_NAME_ADD);
		return mav;
	}

	/**
	 * 编辑资源
	 * */
	@RequestMapping(value = "/user/resources/edit/{resourceId}", method = RequestMethod.GET)
	public ModelAndView setupEditForm(
			@PathVariable("resourceId") String resourceId) {
		logger.info("request setupAddForm of " + EditResourceController.class);
		ModelAndView mav = new ModelAndView();
		Resource resource = resourceService.get(resourceId);
		List<Resource> methods = null;
		if (resource != null) {
			methods = resourceService.getMethodsOfResource(resourceId);
			// resource.setResources(new LinkedHashSet<Resource>(methods));
		}
		mav.addObject("methods", methods);
		mav.addObject("resource", resource);
		mav.setViewName(VIEW_NAME_EDIT);
		return mav;
	}

	/**
	 * 保存新增数据
	 * 
	 * @param resource
	 *            资源数据
	 * @param result
	 *            验证结果
	 * @param status
	 *            Session状态
	 * @return 结果消息
	 * */
	@RequestMapping(value = "/user/resources/save", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processAddSubmit(
			@ModelAttribute("resource") Resource resource,
			BindingResult result, SessionStatus status) {
		logger.info("submit add info");
		Resultmsg msg = new Resultmsg();

		new ResourceValidator().validate(resource, result);
		if (result.hasErrors()) {
			msg.setMsg(result.toString());
			msg.setSuccess("false");
		} else {
			if (!StringUtils.hasLength(resource.getResource().getResourceId())) {
				resource.setResource(null);
			}
			
			if (StringUtils.hasLength(resource.getResourceId())) {
				resourceService.update(resource);
			} else {
				resourceService.save(resource);
			}
			//保存方法列表
			if (resource.getResourcelist() != null) {
				for (Resource method : resource.getResourcelist()) {
					method.setResourceType(ResourceType.METHOD.toString());
					method.setStatus(1);
					method.setResource(resource);
					method.setResourceDesc("");
					if(method.getPriority()==null) {
						method.setPriority(0);
					}
					if (StringUtils.hasLength(method.getResourceName())
							&& StringUtils
									.hasLength(method.getResourceString())) {
						if (StringUtils.hasLength(method.getResourceId())) {
							resourceService.update(method);
						} else {
							resourceService.save(method);
						}
					}
				}
			}
			status.setComplete();
			msg.setSuccess("true");
			msg.setMsg(resource.getResourceId());
		}
		return msg;
	}

	/**
	 * 删除资源文件
	 * */
	@RequestMapping(value = "/user/resources/delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultmsg processDelete(WebRequest request) {
		Resultmsg msg = new Resultmsg();
		msg.setSuccess("false");
		if (request.getParameter("resourceId") != null) {
			String resourceId = request.getParameter("resourceId");
			try {
				resourceService.delete(resourceId);
				msg.setSuccess("true");
			} catch (Exception e) {
				msg.setMsg(e.getMessage());
			}
		} else {
			msg.setMsg("resourceId value is empty");
		}
		return msg;
	}

}
