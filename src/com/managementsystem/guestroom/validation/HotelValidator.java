package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Hotel;

/**
 * 酒店信息验证类
 * */
public class HotelValidator {

	public void validate(Hotel hotel, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "hotelName", "required");
	}

}
