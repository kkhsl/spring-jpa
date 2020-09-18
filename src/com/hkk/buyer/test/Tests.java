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
		// 创建实体管理类
		EntityManager em = factory.createEntityManager();
		// 获取事务对象
		EntityTransaction tx = em.getTransaction();
		// 开启事物
		tx.begin();
		// find and save merge
		User user = new User();
		//Hibernate get和load的区别？
		//都是根据O1D查询单个实体结果对象的
		//[get]立即加载 get查询ID返回NULL
		//[load]支持懒加载load查询ID,抛出异常ObjectNotFoundExceptionl*1
		//[find] [getReference]
		user = em.find(User.class, Long.parseLong("1"));
		user.setAddTime(new Date());
		user.setUsername("hkk1");
		user.setAge(23);
		user.setSex(1);
		user.setYeas(new Date());
		//Hibernate: saveUpdate -- merge
		em.merge(user);
		// -------------------------- 结束任务
		// 提交事务
		tx.commit();
		// 释放资源
		em.close();
		// factory.close();
	}
	
	/**
	 * HQL and JPQL
	 * sql: select * from user
	 * JPQL: select obj from User obj
	 * 
	 * Query接口
	 * int excuteUpdate 用于执行update 和 delete 语句
	 * List getResultList 用于执行select语句并返回结果集实体列表
	 * Object getSingleResult 用于执行只返回单个结果实体的select语句
	 */
	@Test
	public void query(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		// 创建实体管理类
		EntityManager em = factory.createEntityManager();
		// 获取事务对象
		EntityTransaction tx = em.getTransaction();
		// 开启事物
		tx.begin();
		
		//查询总数
		/*String sql = "select obj from User obj";
		Query query = em.createQuery(sql, User.class);*/
		/*List<User> users = query.getResultList();
		System.out.println("user: " + users.size());*/
		
		/*String countJpql = "select Count(id) from User obj";
		Query queryCount = em.createQuery(countJpql, Long.class);
		Long count = (Long) queryCount.getSingleResult();
		System.out.println("count:" + count);*/
		
		//更新数据
/*		String username = "hkkK";
		String id = "1";
		//String updateJpql = "UPDATE User SET username=? WHERE id=?";
		String updateJpql1 = "UPDATE User SET username=:username WHERE id=:id";
		Query queryUpdate = em.createQuery(updateJpql1);
		占位符
		 *  queryUpdate.setParameter(1,username);
		queryUpdate.setParameter(2,Long.parseLong(id));
		//命名参数传递参数
		queryUpdate.setParameter("username", username);
		queryUpdate.setParameter("id", , password));
		int flag = queryUpdate.executeUpdate();
		System.out.println("update: " + flag);*/
		
		//查询部分属性
		//String queryJpql = "select username,sex from User obj where obj.id=:id";//该jpql返回Object[]
		/*	String queryJpql = "select new User(username,sex) from User obj where obj.id=:id"; //投影： 该jpql返回对象 添加指定构造参数
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
		
		//createNativeQuery: jpql本地化sql  使用sql即可
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
