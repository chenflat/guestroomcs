package com.managementsystem.guestroom.web.hotel;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.managementsystem.guestroom.common.Constants;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.guestroom.domain.platform.Alert;
import com.managementsystem.guestroom.domain.platform.Breadcrumb;
import com.managementsystem.guestroom.domain.platform.Message;
import com.managementsystem.guestroom.service.biz.HotelService;
import com.managementsystem.guestroom.service.platform.ListinfoService;
import com.managementsystem.guestroom.validation.HotelValidator;
import com.managementsystem.guestroom.web.AbstractController;
import com.managementsystem.guestroom.web.IController;
import com.managementsystem.util.io.FileSystemObject;

@Controller
@RequestMapping("/hotel/hotel")
public class HotelmanageController extends AbstractController implements
		IController {

	private final Log logger = LogFactory.getLog(HotelmanageController.class);

	public static final String VIEW_NAME = "hotel/hotel";

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private ListinfoService listinfoService;
	
	@ModelAttribute("currencies")
	public Set<Listinfo> getCurrencies() {
		return listinfoService.getListEntryItems("Currency");
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelMap model) {
		logger.info("Requesting doGet of " + HotelmanageController.class);
		ModelAndView mav = new ModelAndView();
		Hotel hotel = hotelService.getDefaultHotel();
		if (hotel == null)
			hotel = new Hotel();
		mav.addObject("hotel", hotel);
		mav.setViewName(VIEW_NAME);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(@ModelAttribute("hotel") Hotel hotel,
			@RequestParam MultipartFile file, Model model,
			BindingResult result, SessionStatus status,
			HttpServletRequest request) {
		new HotelValidator().validate(hotel, result);
		if (result.hasErrors()) {
			logger.error(result);
			model.addAttribute("message",
					new Message(Alert.ERROR, result.toString()));
		} else {
			StringBuilder sb = new StringBuilder();
			StringBuilder exp = new StringBuilder();
			String photoPath = "";
			if (file.getSize() > 0) {
				String realPath = request.getSession().getServletContext()
						.getRealPath("/");
				logger.info(realPath);
				String filePath = Constants.PATH_UPLOADFILE_HOTEL;
				try {
					FileSystemObject.SaveFileFromInputStream(
							file.getInputStream(), realPath + filePath,
							file.getOriginalFilename());
					sb.append("File '" + file.getOriginalFilename()
							+ "' uploaded successfully!");
					photoPath = filePath + file.getOriginalFilename();
					hotel.setHotelPhoto(photoPath);
				} catch (IOException e) {
					e.printStackTrace();
					exp.append(e.getMessage());
				}
			}
			try {
				if (StringUtils.hasLength(hotel.getHotelId()))
					hotelService.update(hotel);
				else
					hotelService.save(hotel);
				status.setComplete();
				sb.append("Save successful");
			} catch (Exception e) {
				exp.append(e.getMessage());
			}
			Message message = null;
			if (sb.toString().length() > 0) {
				message = new Message(Alert.SUCCESS, sb.toString());
			} else {
				message = new Message(Alert.WARNING, exp.toString());
			}
			model.addAttribute("message", message);
		}
	}

	
	@RequestMapping(value="/query",method = RequestMethod.POST)
	public String processQuery(@RequestParam("query")String query) {
		logger.info("requesting query post of " + HotelmanageController.class);
		
		return "redirect:/hotel/hotel";
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
