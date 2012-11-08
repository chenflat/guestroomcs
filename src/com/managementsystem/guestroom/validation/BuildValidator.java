package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Build;

/**
 * 建筑信息验证类
 * 
 * @author 08/11/2012 PING.CHEN
 * */
public class BuildValidator {

	/**
	 * 对象验证 ,使用如 {@link org.springframework.validation.ValidationUtils}或
	 * {@link org.springframework.util.StringUtils}类进行验证
	 * <p>
	 * for example: ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code",
	 * "required","required");
	 * </p>
	 * 
	 * @param build
	 *            建筑信息
	 * @param errors
	 *            错误结果集
	 * 
	 * */
	public void validate(Build build, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hotel.hotelId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "buildName", "required");
	}
}
