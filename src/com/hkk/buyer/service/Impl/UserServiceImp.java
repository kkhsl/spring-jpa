package com.hkk.buyer.service.Impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkk.buyer.dao.UserDao;
import com.hkk.buyer.model.User;
import com.hkk.buyer.service.IUserService;

@Service
public class UserServiceImp implements IUserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getObjById(Long id) {
		// TODO Auto-generated method stub
		User instance = this.userDao.getObjById(id);
		if(instance != null){
			return instance;
		}
		return null;
	}

	@Override
	public boolean save(User instance) {
		// TODO Auto-generated method stub
		try {
			this.userDao.save(instance);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	@Override
	public boolean update(User instance) {
		// TODO Auto-generated method stub
		try {
			this.userDao.update(instance);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		try {
			this.userDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean batchDelete(List<Serializable> ids) {
		// TODO Auto-generated method stub
		for(Serializable id : ids){
			this.userDao.delete((Long) id);
		}
		return true;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return this.userDao.getUserList();
	}

}
