package com.hkk.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 对于org.hibernate.annotations与org.hibernate.persistence，它的注释比如Columns,可是不知道怎么使用
 * ，但是hibernate中也封装了javax.persistence,而且数据库映射注释主要还是使用javax.persistence,
 * 即如下注释元素Column，使用规则如下。
 * @Table 设置当前持久化类所映射的数据库表，如果当前类中没有使用@Table注解，Hibernate会自动使用默认的持久化类的类名(不带包名)作为所映射的表名    
 * @Id  设置当前持久化类的标示符属性    
 * @GeneratedValue 设置当前标示符的生产策略。@GeneratedValue的name属性设置生成策略的名称是TABLE、INENTITY、SEQUENCE或者AUTO之一。    
 * @Column  将持久化类的数学与数据库表中的字段进行映射，name属性值为映射的字段名，length属性值为字段的长度，unique属性表示该列上设置唯一的约束，nullable属性设置该列的值是否可以为空，precision实现设置该字段的精度，scale属性设置该字段的小数位数    
 * @Transient 标注的属性进行持久化映射    
 * @Temporal java中没有定义时间精度的api，因此处理时间类型数据时，需要设置存储在数据库中所预期的精度，使用@Temporal注释可以调整时间的精度为：DATE、TIME和TIMESTAMP三种    
 * @ManyToOne  设置该当前持久化类类与其他持久化类之间的多对一关联，其中CascadeType值表示Hibernate将进行级联操作    
 * @OneToMany  设置该当前持久化类与其他持久化类之间的一对多关联    
 * @OneToOne   设置该当前持久化类与其他持久化类之间的一对一关联    
 * @ManyToMany 设置该当前持久化类与其他持久化类之间的多对多关联    
 * @NameQueries 在持久化类中设置命名查询，参考@NameQuery的使用    
 * @NameQuery   在持久化类中设置命名查询，@NamedQuery 和@NamedQueries注释加在在类和包上。如下面的例子：    
 * @NamedQueries({@NamedQuery(name="queryById",query="select p from Product p where id=:id")})    
    
 * @Version 设置乐观锁定    
    
 * @Cache 设置二级缓存    
    
 * @Filters  设置使用过滤器    
    
 * @FilterDef  声明过滤器    
 * @Entity 声明当前是一个持久化类    
 * @author 46075
 *
 */

@MappedSuperclass
public class IdEntity implements Serializable{
	
	/**
	 * 序列化接口，自动生成序列号
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
