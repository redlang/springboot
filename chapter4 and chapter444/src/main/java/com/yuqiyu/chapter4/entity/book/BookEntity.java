package com.yuqiyu.chapter4.entity.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class BookEntity {
	@Id
	//@GeneratedValue
	//Table 'test.hibernate_sequence' doesn't exist 解决方法
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	@Column(name="b_id")
	private Long id;
	
	@Column(name="b_name")
	private String name;
	

	
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

}
