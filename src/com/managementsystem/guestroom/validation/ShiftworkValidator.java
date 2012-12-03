package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Shiftwork;

/**
 * 交接班记录对象验证类
 * 
 * @author ping.chen
 * */
public class ShiftworkValidator {

	/**
	 * 验证交接班记录对象
	 * 
	 * @param shiftwork
	 *            交接班记录
	 * @param errors
	 *            错误集
	 * */
	public void validate(Shiftwork shiftwork, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "user.userId", "required");
		ValidationUtils.rejectIfEmpty(errors, "shiftworkerName", "required");
	}

}
