package com.managementsystem.guestroom.dao.platform;

import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.managementsystem.guestroom.domain.platform.Listinfo;
import com.managementsystem.util.dao.DaoSupport;

/**
 * 数据字典列表数据操作类
 * */
public interface ListsDao extends DaoSupport {

	/**
	 * 获取列表名称字典
	 * 
	 * @return 列表名称字典
	 * */
	public Set<Listinfo> getListinfoDictionary() throws DataAccessException;

	/**
	 * 获取指定列表名称的所有条目项
	 * 
	 * @param listName
	 *            列表名称
	 * @return 列表条目字典集合
	 * */
	public Set<Listinfo> getListEntryItems(String listName)
			throws DataAccessException;

	/**
	 * 获取指定列表名称的所有条目项
	 * 
	 * @param listName
	 *            列表名称
	 * @param parentKey
	 *            上级键名
	 * @return 列表条目字典集合
	 * */
	public Set<Listinfo> getListEntryItems(String listName, String parentKey)
			throws DataAccessException;

}
