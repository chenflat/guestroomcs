package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Portal;

/**
 * 系统信息验证类
 * */
public class PortalValidator {

	/**
	 * 系统信息验证
	 * @param portal 系统信息类
	 * @param errors 错误结果集
	 * */
	public void validator(Portal portal,Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalEnname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copyright", "required");
	}
	
}
