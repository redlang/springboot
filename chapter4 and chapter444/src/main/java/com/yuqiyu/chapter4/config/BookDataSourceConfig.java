package com.yuqiyu.chapter4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement

@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorybook",
        transactionManagerRef = "transactionManagerbook",
        basePackages = {"com.yuqiyu.chapter4.jpa.book"})//设置repository所在位置
public class BookDataSourceConfig {


    @Autowired(required=false)//required=true表示bean必须存在，否则注入失败，默认为true
    @Qualifier("bookDataSource")
    private DataSource bookDataSource;
    
    @Autowired(required=false)//required=true表示bean必须存在，否则注入失败，默认为true
    private HibernateProperties hibernateProperties;
    
    @Primary
    @Bean(name = "entityManagerbook")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorybook(builder).getObject().createEntityManager();
    }


    @Autowired
    private JpaProperties jpaProperties;


    private Map<String, Object> getVendorProperties() {
    	Map<String, Object> map=hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
        return map;
    }

    @Primary
    @Bean(name = "entityManagerFactorybook")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorybook(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(bookDataSource)
                .packages("com.yuqiyu.chapter4.entity.book")//设置实体类所在位置
                .persistenceUnit("bookPersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerbook")
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorybook(builder).getObject());
    }
    
}
