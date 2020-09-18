package com.hkk.buyer.service;

import java.io.Serializable;
import java.util.List;

import com.hkk.buyer.model.User;

public interface IUserService {
	/**
	 * ����һ��ID�õ�User
	 * 
	 * @param id
	 * @return
	 */
	User getObjById(Long id);

	/**
	 * ����һ��User����, �ɹ�����true, ʧ�ܷ���false
	 * 
	 * @param install
	 *            User����
	 * @return
	 */
	boolean save(User instance);

	/**
	 * ����һ��User����
	 * 
	 * @param install Userʵ��
	 * @return
	 */
	boolean update(User instance);
	
	/**
	 * ����IDɾ��һ��User����
	 * @param id User ID
	 * @return
	 */ 
	boolean delete(Long id);
	
	/**
	 * ����ɾ��User
	 * @param ids
	 * @return
	 */
	boolean batchDelete(List<Serializable> ids);
	
	List<User> getUserList();
	
}
