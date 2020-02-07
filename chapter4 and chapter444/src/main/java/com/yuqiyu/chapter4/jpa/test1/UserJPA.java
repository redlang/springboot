package com.yuqiyu.chapter4.jpa.test1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yuqiyu.chapter4.entity.test1.UserEntity;

import java.io.Serializable;


public interface UserJPA extends
        JpaRepository<UserEntity, Long>
        ,JpaSpecificationExecutor<UserEntity>,
        Serializable
{
}
