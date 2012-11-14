package com.managementsystem.guestroom.web.hotel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hotel/roomgroup")
public class RoomgroupController {

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String processSubmit(HttpServletRequest request) {
		
		return "success";
	}
	
	
}
