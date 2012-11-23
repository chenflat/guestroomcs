package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.User;

/**
 * 用户信息验证
 * */
public class UserValidator {

	public void validate(User user,Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "username", "required");
	}
}
