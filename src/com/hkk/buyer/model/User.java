package com.hkk.buyer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hkk.core.domain.IdEntity;
import com.hkk.global.tools.Global;

/**
 * ����org.hibernate.annotations��org.hibernate.persistence������ע�ͱ���Columns,���ǲ�֪����ôʹ��
 * ������hibernate��Ҳ��װ��javax.persistence,�������ݿ�ӳ��ע����Ҫ����ʹ��javax.persistence,
 * ������ע��Ԫ��Column��ʹ�ù������¡�
 * @Table ���õ�ǰ�־û�����ӳ������ݿ�������ǰ����û��ʹ��@Tableע�⣬Hibernate���Զ�ʹ��Ĭ�ϵĳ־û��������(��������)��Ϊ��ӳ��ı���    
 * @Id  ���õ�ǰ�־û���ı�ʾ������    
 * @GeneratedValue ���õ�ǰ��ʾ�����������ԡ�@GeneratedValue��name�����������ɲ��Ե�������TABLE��INENTITY��SEQUENCE����AUTO֮һ��    
 * @Column  ���־û������ѧ�����ݿ���е��ֶν���ӳ�䣬name����ֵΪӳ����ֶ�����length����ֵΪ�ֶεĳ��ȣ�unique���Ա�ʾ����������Ψһ��Լ����nullable�������ø��е�ֵ�Ƿ����Ϊ�գ�precisionʵ�����ø��ֶεľ��ȣ�scale�������ø��ֶε�С��λ��    
 * @Transient ��ע�����Խ��г־û�ӳ��    
 * @Temporal java��û�ж���ʱ�侫�ȵ�api����˴���ʱ����������ʱ����Ҫ���ô洢�����ݿ�����Ԥ�ڵľ��ȣ�ʹ��@Temporalע�Ϳ��Ե���ʱ��ľ���Ϊ��DATE��TIME��TIMESTAMP����    
 * @ManyToOne  ���øõ�ǰ�־û������������־û���֮��Ķ��һ����������CascadeTypeֵ��ʾHibernate�����м�������    
 * @OneToMany  ���øõ�ǰ�־û����������־û���֮���һ�Զ����    
 * @OneToOne   ���øõ�ǰ�־û����������־û���֮���һ��һ����    
 * @ManyToMany ���øõ�ǰ�־û����������־û���֮��Ķ�Զ����    
 * @NameQueries �ڳ־û���������������ѯ���ο�@NameQuery��ʹ��    
 * @NameQuery   �ڳ־û���������������ѯ��@NamedQuery ��@NamedQueriesע�ͼ�������Ͱ��ϡ�����������ӣ�    
 * @NamedQueries({@NamedQuery(name="queryById",query="select p from Product p where id=:id")})    
    
 * @Version �����ֹ�����    
    
 * @Cache ���ö�������    
    
 * @Filters  ����ʹ�ù�����    
    
 * @FilterDef  ����������    
 * @Entity ������ǰ��һ���־û���    
 * @author 46075
 *
 */

@Entity
@Table(name = Global.DEFAULT_TABLE_SUFFIX + "user")
public class User extends IdEntity{
	private String username;
	private String password;
	@Column(columnDefinition = "int default 0")
	private int age;
	private int sex;
	private Date yeas;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getYeas() {
		return yeas;
	}
	public void setYeas(Date yeas) {
		this.yeas = yeas;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, int sex) {
		super();
		this.username = username;
		this.sex = sex;
	}
	
}
