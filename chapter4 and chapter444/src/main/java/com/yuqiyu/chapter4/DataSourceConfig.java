package com.yuqiyu.chapter4;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

	
    @Primary //配置一个主连接
    @Bean(name = "bookDataSource")
    @Qualifier("bookDataSource")
    @ConfigurationProperties(prefix="book.spring.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建test2的DataSource实例
     * @return
     */
    @Bean(name = "test2DataSource")
    @Qualifier("test2DataSource")
    @ConfigurationProperties(prefix="test2.spring.datasource")
    public DataSource test2aryDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    /**
     * 创建test2的DataSource实例
     * @return
     */
    @Bean(name = "test1DataSource")
    @Qualifier("test1DataSource")
    @ConfigurationProperties(prefix="test1.spring.datasource")
    public DataSource test1DataSource() {
        return DataSourceBuilder.create().build();
    }

}

