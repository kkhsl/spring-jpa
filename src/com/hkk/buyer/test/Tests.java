package com.hkk.buyer.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hkk.buyer.model.User;
import com.hkk.buyer.service.IUserService;
import com.hkk.buyer.tools.CommUtil;

public class Tests {

	public static void main(String[] args) {
		/*
		 * EntityManagerFactory factory =
		 * Persistence.createEntityManagerFactory("myjpa"); EntityManager
		 * entityManage = factory.createEntityManager(); EntityTransaction
		 * transaction = entityManage.getTransaction(); transaction.begin();
		 * User user = new User(); user.setUsername("hkk"); user.setAge(23);
		 * user.setSex(1); user.setYeas(new Date()); entityManage.persist(user);
		 * transaction.commit(); entityManage.clear();
		 */
		
		// Jpa: EntityManagerFactory mybatis: SqlSessionFactory Hibernate:
		// SesssionFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		// ����ʵ�������
		EntityManager em = factory.createEntityManager();
		// ��ȡ�������
		EntityTransaction tx = em.getTransaction();
		// ��������
		tx.begin();
		// find and save merge
		User user = new User();
		//Hibernate get��load������
		//���Ǹ���O1D��ѯ����ʵ���������
		//[get]�������� get��ѯID����NULL
		//[load]֧��������load��ѯID,�׳��쳣ObjectNotFoundExceptionl*1
		//[find] [getReference]
		user = em.find(User.class, Long.parseLong("1"));
		user.setAddTime(new Date());
		user.setUsername("hkk1");
		user.setAge(23);
		user.setSex(1);
		user.setYeas(new Date());
		//Hibernate: saveUpdate -- merge
		em.merge(user);
		// -------------------------- ��������
		// �ύ����
		tx.commit();
		// �ͷ���Դ
		em.close();
		// factory.close();
	}
	
	/**
	 * HQL and JPQL
	 * sql: select * from user
	 * JPQL: select obj from User obj
	 * 
	 * Query�ӿ�
	 * int excuteUpdate ����ִ��update �� delete ���
	 * List getResultList ����ִ��select��䲢���ؽ����ʵ���б�
	 * Object getSingleResult ����ִ��ֻ���ص������ʵ���select���
	 */
	@Test
	public void query(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		// ����ʵ�������
		EntityManager em = factory.createEntityManager();
		// ��ȡ�������
		EntityTransaction tx = em.getTransaction();
		// ��������
		tx.begin();
		
		//��ѯ����
		/*String sql = "select obj from User obj";
		Query query = em.createQuery(sql, User.class);*/
		/*List<User> users = query.getResultList();
		System.out.println("user: " + users.size());*/
		
		/*String countJpql = "select Count(id) from User obj";
		Query queryCount = em.createQuery(countJpql, Long.class);
		Long count = (Long) queryCount.getSingleResult();
		System.out.println("count:" + count);*/
		
		//��������
/*		String username = "hkkK";
		String id = "1";
		//String updateJpql = "UPDATE User SET username=? WHERE id=?";
		String updateJpql1 = "UPDATE User SET username=:username WHERE id=:id";
		Query queryUpdate = em.createQuery(updateJpql1);
		ռλ��
		 *  queryUpdate.setParameter(1,username);
		queryUpdate.setParameter(2,Long.parseLong(id));
		//�����������ݲ���
		queryUpdate.setParameter("username", username);
		queryUpdate.setParameter("id", , password));
		int flag = queryUpdate.executeUpdate();
		System.out.println("update: " + flag);*/
		
		//��ѯ��������
		//String queryJpql = "select username,sex from User obj where obj.id=:id";//��jpql����Object[]
		/*	String queryJpql = "select new User(username,sex) from User obj where obj.id=:id"; //ͶӰ�� ��jpql���ض��� ���ָ���������
		Query queryObject = em.createQuery(queryJpql);
		queryObject.setParameter("id", Long.parseLong("1"));
		Object object = queryObject.getSingleResult();
		System.out.println(object);*/
		String queryJpql = "select new User(username,sex) from User obj"; 
		Query query = em.createQuery(queryJpql);
		List<User> users = query.getResultList();
		for(User user : users){
			System.out.println(user.getUsername());
		}
		
		//createNativeQuery: jpql���ػ�sql  ʹ��sql����
		tx.commit();
		em.close();
	}
	
	@Test
	public void userTest(){
		ClassPathXmlApplicationContext cxc = new ClassPathXmlApplicationContext("applicationContext-config.xml");
		/*String[] names = cxc.getBeanDefinitionNames();
		for(String name : names){
			System.out.println(name);
		}
		*/
		IUserService userService = cxc.getBean(IUserService.class);
		/*List<User> users = userService.getUserList();
		for(User user : users){
			System.out.println(user.getUsername());
		}
		*/
		
		/*User user = userService.getObjById(CommUtil.null2Long(1));
		System.out.println(user.getUsername());*/
		
		/*User user = new User();
		user.setUsername("jpaPersistence");
		user.setPassword("123456");
		user.setAddTime(new Date());
		user.setAge(23);
		userService.save(user);
		userService.update(user);*/
		
		boolean flag = userService.delete(CommUtil.null2Long(7));
		System.out.println(flag);
	}
}
