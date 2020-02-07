package com.yuqiyu.chapter4.jpa.book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yuqiyu.chapter4.entity.book.BookEntity;

import java.io.Serializable;


public interface BookJPA extends
        JpaRepository<BookEntity, Long>
        ,JpaSpecificationExecutor<BookEntity>,
        Serializable
	{
}
