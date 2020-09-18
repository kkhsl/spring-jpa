package com.hkk.buyer.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hkk.buyer.model.User;


public interface UserDao {

	/**
	 * 根据一个ID得到User
	 * 
	 * @param id
	 * @return
	 */
	User getObjById(Long id);

	/**
	 * 保存一个User对象, 成功返回true, 失败返回false
	 * 
	 * @param install
	 *            User对象
	 * @return
	 */
	boolean save(User instance);

	/**
	 * 更新一个User对象
	 * 
	 * @param install User实例
	 * @return
	 */
	boolean update(User instance);
	
	/**
	 * 根据ID删除一个User对象
	 * @param id User ID
	 * @return
	 */ 
	boolean delete(Long id);
	
	/**
	 * 批量删除User
	 * @param ids
	 * @return
	 */
	boolean batchDelete(List<Serializable> ids);
	
	List<User> getUserList();
	
}
