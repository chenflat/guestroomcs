package com.managementsystem.guestroom.validation;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.managementsystem.guestroom.domain.hibernate.Role;
import com.managementsystem.guestroom.service.platform.RoleService;

/**
 * 角色信息验证类
 * */
public class RoleValidator {

	/**
	 * 角色验证
	 * 
	 * @param role
	 *            角色实体类
	 * @param errors
	 *            错误消息
	 * */
	public void validate(RoleService roleService, Role role, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "roleName", "required");
		ValidationUtils.rejectIfEmpty(errors, "roleDesc", "required");

		if (!StringUtils.hasLength(role.getRoleId())) {
			if (roleService.isExistRoleName(role.getRoleName())) {
				errors.rejectValue("roleName",   "error.object.exist");
			}
		}
	}

}
