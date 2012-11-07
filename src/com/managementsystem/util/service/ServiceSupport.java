package com.managementsystem.util.service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务层支持接口类
 * */
public interface ServiceSupport<T extends Serializable, PK extends Serializable> {

	/**
	 * 保存模型对象
	 * 
	 * @param model
	 *            模型对象
	 * @return 返回模型对象
	 */
	public T save(T model);

	/**
	 * 保存或更新模型对象
	 * 
	 * @param model
	 *            模型对象
	 */
	public void saveOrUpdate(T model);

	/**
	 * 更新模型对象
	 * 
	 * @param model
	 *            模型对象
	 */
	public void update(T model);

	/**
	 * 
	 * 合并模型对象状态到底层会话
	 * 
	 * @param model
	 */
	public void merge(T model);

	/**
	 * 删除模型对象
	 * 
	 * @param id
	 *            主键
	 */
	public void delete(PK id);

	/**
	 * 根据主键获取模型对象
	 * 
	 * @param id
	 *            主键
	 * @return 返回模型对象
	 */
	public T get(PK id);


	
}
