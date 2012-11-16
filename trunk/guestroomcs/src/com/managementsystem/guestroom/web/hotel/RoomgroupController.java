package com.managementsystem.guestroom.web.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.managementsystem.guestroom.domain.hibernate.Roomgroup;
import com.managementsystem.guestroom.domain.hibernate.RoomgroupForm;
import com.managementsystem.guestroom.service.biz.RoomgroupService;

/**
 * 房间组管理
 * */

@Controller
@RequestMapping("/hotel/roomgroup")
public class RoomgroupController {

	@Autowired
	private RoomgroupService roomgroupService;
	
	/**
	 * 保存房间组信息
	 * */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String processSubmit(
			@ModelAttribute("roomgroupForm") RoomgroupForm roomgroupForm,
			HttpServletRequest request) {

		Set<Roomgroup> initRoomgroups =  roomgroupService.getRoomgroups();
		List<String> existRoomgroupIds = new ArrayList<String>();
		for(Roomgroup existRoomgroup : initRoomgroups) {
			existRoomgroupIds.add(existRoomgroup.getRoomgroupId());
		}

		//遍历对象，并保存
		for(Roomgroup roomgroup : roomgroupForm.getRoomgroups()) {
			if(StringUtils.hasLength(roomgroup.getRoomgroupName())) {
				//存在ID则更新
				if(StringUtils.hasLength(roomgroup.getRoomgroupId())) {
					for(Roomgroup existRoomgroup : initRoomgroups) {
						if(roomgroup.getRoomgroupId().equals(existRoomgroup.getRoomgroupId())) {
							roomgroupService.update(roomgroup);
						}	
					}
				}else{
					roomgroupService.save(roomgroup);
				}
			}
		}
		roomgroupService.deleteExcludeIds(roomgroupForm.getRoomgroups());
		return "success";
	}

}
