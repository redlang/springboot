package com.yuqiyu.chapter4.entity.test1;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONType;
//控制JSON顺序
@JSONType(orders={"id","name","age",
				  "address","pwd"})
@Entity
@Table(name="t_user")
public class UserEntity implements Serializable{
	@Id
	//@GeneratedValue
	//Table 'test.hibernate_sequence' doesn't exist 解决方法
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	@Column(name="t_id")
	private Long id;
	
	@Column(name="t_name")
	private String name;
	
	@Column(name="t_age")
	private int age;
	
	@Column(name="t_address")
	private String address;
	
	@Column(name="t_pwd")
	private String pwd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
