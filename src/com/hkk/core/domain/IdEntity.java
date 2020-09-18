package com.hkk.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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

@MappedSuperclass
public class IdEntity implements Serializable{
	
	/**
	 * ���л��ӿڣ��Զ��������к�
	 */
	private static final long serialVersionUID = 7602696247854184934L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;
	private Date addTime;
	@Column(columnDefinition = "int default 0")
	private int deleteStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	public IdEntity() {
		super();
	}
	public IdEntity(Long id) {
		super();
		this.id = id;
	}

}
