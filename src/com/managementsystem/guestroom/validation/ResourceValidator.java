package com.managementsystem.guestroom.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Resource;

/**
 * 权限资源验证类
 * 
 * @author CHENPING
 * */
public class ResourceValidator {

	/**
	 * 校验权限资源数据
	 * 
	 * @param resource
	 *            资源信息
	 * @param errors
	 *            错误集合
	 * */
	public void validate(Resource resource, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "resourceName", "required");
		ValidationUtils.rejectIfEmpty(errors, "resourceType", "required");
		ValidationUtils.rejectIfEmpty(errors, "resourceString", "required");
	}

}
