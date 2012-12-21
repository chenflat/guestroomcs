package com.managementsystem.guestroom.web.account;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.common.Constants;
import com.managementsystem.guestroom.domain.hibernate.Profilepropertydefinition;
import com.managementsystem.guestroom.domain.hibernate.User;
import com.managementsystem.guestroom.domain.hibernate.Userprofile;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.platform.ProfilepropertydefinitionService;
import com.managementsystem.guestroom.service.platform.UserprofileService;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.util.io.FileSystemObject;

/**
 * 编辑用户头像
 * 
 * @author PING.CHEN
 * */
@Controller
@RequestMapping("/account/picture")
public class PictureController extends AbstractController implements
		IController,BeanFactoryAware  {

	private static final Log logger = LogFactory
			.getLog(PictureController.class);

	private final String VIEW_NAME = "account/picture";
	
	private MessageSource messageSource;
	

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
	 * 设置当前用户头像编辑页
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + PictureController.class);
		ModelAndView mav = new ModelAndView();
		User userinfo = getCurrentUser();
		// 获取当前用户信息
		Set<Userprofile> userprofiles = userprofileService
				.getUserprofileByUsername(userinfo.getUsername(), "picture");
		userinfo.setUserprofiles(userprofiles);
		mav.addObject("user", userinfo);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(@RequestParam MultipartFile file,
			HttpServletRequest request, Model model) {
		// 获取个性化设置属性字段
		Set<Profilepropertydefinition> profilepropertydefinitions = profilepropertydefinitionService
				.getProfilepropertiesByCategory("picture");

		// 上传用户头像
		StringBuilder sb = new StringBuilder();
		StringBuilder exp = new StringBuilder();
		String photoPath = "";

		//判断并上传文件
		if (file != null && file.getSize() > 0 && file.getSize() <= 2097152) {
			String realPath = request.getSession().getServletContext()
					.getRealPath("/");
			logger.info(realPath);
			String filePath = Constants.PATH_UPLOADFILE_USER;
			try {
				FileSystemObject.SaveFileFromInputStream(file.getInputStream(),
						realPath + filePath, file.getOriginalFilename());
				sb.append("File '" + file.getOriginalFilename()
						+ "' uploaded successfully!");
				photoPath = filePath + file.getOriginalFilename();
			} catch (IOException e) {
				e.printStackTrace();
				exp.append(e.getMessage());
			}
		} else {
			String errmsg = messageSource.getMessage("error.uploadfile", new Object[] {"2"}, Locale.getDefault());
			exp.append(errmsg);
		}
		
		//没有异常时保存数据
		if (exp.toString().length() <= 0) {
			
			User userinfo = getCurrentUser();
			Set<Userprofile> userprofiles = userprofileService.getUserprofileByUsername(userinfo.getUsername(), "picture");
			
			for (Profilepropertydefinition property : profilepropertydefinitions) {
				String propertyname = property.getPropertyname();
				String value = null;
				for(Userprofile profile : userprofiles) {
					if(profile.getProfilepropertydefinition().getPropertydefinitionid().equals(property.getPropertydefinitionid())) {
						value = profile.getPropertyvalue();
						break;
					}
				}

				logger.info(String.format("save userprofile key=%s,value=%s", property.getPropertyname(),value));
				boolean isnew = false;
				Userprofile userprofile = userprofileService.getUserprofile(
						userinfo.getUsername(), propertyname);
				if (userprofile == null) {
					userprofile = new Userprofile();
					isnew = true;
				}
				if ("userPhoto".equals(propertyname)&& StringUtils.hasLength(photoPath)) {
					value = photoPath;
				}
				userprofile.setLastupdateddate(Calendar.getInstance().getTime());
				userprofile.setProfilepropertydefinition(property);
				userprofile.setPropertyvalue(value);
				userprofile.setUser(userinfo);
				userprofile.setVisibility(0);
				if (isnew) {
					userprofileService.save(userprofile);
					logger.info("save user profile " + propertyname);

				} else {
					userprofileService.update(userprofile);
					logger.info("update user profile " + propertyname);
				}

			}
			sb.append("successful!");
		}
		Message message = null;
		if (sb.toString().length() > 0) {
			message = new Message(Alert.SUCCESS, sb.toString());
		} else {
			message = new Message(Alert.WARNING, exp.toString());
		}

		model.addAttribute("message", message);

	}

	@Override
	protected String getModelViewName() {
		return VIEW_NAME;
	}

	@Override
	protected List<Breadcrumb> getBreadcrumbs() {
		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory context) throws BeansException {
		messageSource = (MessageSource)context.getBean("messageSource");
	}

}
