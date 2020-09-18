package com.hkk.buyer.dao.Impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hkk.buyer.dao.UserDao;
import com.hkk.buyer.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		/*
		 * EntityManager entityManager =
		 * entityManagerFactory.createEntityManager();
		 * System.out.println(entityManager); System.out.println(
		 * "PersistenceContext: " + em);
		 */
		Query query = em.createQuery("SELECT user FROM User user");
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public User getObjById(Long id) {
		// TODO Auto-generated method stub
		User instance = em.find(User.class, id);
		return instance;
	}
	
	@Override
	public boolean save(User instance) {
		// TODO Auto-generated method stub
		try {
			em.persist(instance);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User instance) {
		// TODO Auto-generated method stub
		try {
			em.merge(instance);
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
		Query query = em.createQuery("DELETE FROM User WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean batchDelete(List<Serializable> ids) {
		// TODO Auto-generated method stub
		for(Serializable id : ids){
			this.delete((Long) id);
		}
		return true;
	}

}
