package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Roomtype;

/**
 * 客房类型验证类
 * */
public class RoomtypeValidator {

	/**
	 * 验证客户类型类
	 * */
	public void validator(Roomtype roomtype, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "hotel.hotelId", "required");
		ValidationUtils.rejectIfEmpty(errors, "roomtypeName", "required");
	}
}
