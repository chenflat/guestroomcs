package com.managementsystem.guestroom.service.platform;

import java.util.Set;

import com.managementsystem.guestroom.domain.hibernate.Listinfo;
import com.managementsystem.util.service.ServiceSupport;

public interface ListinfoService extends ServiceSupport<Listinfo, String> {

	/**
	 * 获取列表名称字典
	 * 
	 * @return 列表名称字典
	 * */
	public Set<Listinfo> getListinfoDictionary();
	
	/**
	 * 获取指定列表名称的所有条目项
	 * 
	 * @param listName
	 *            列表名称
	 * @return 列表条目字典集合
	 * */
	public Set<Listinfo> getListEntryItems(String listName);
	
	/**
	 * 获取指定列表名称的所有条目项
	 * 
	 * @param listName
	 *            列表名称
	 * @param parentKey
	 *            上级键名
	 * @return 列表条目字典集合
	 * */
	public Set<Listinfo> getListEntryItems(String listName, String parentKey);
}
