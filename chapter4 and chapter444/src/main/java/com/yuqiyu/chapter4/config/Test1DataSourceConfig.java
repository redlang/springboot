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
        entityManagerFactoryRef = "entityManagerFactoryTest1",
        transactionManagerRef = "transactionManagerTest1",
        basePackages = {"com.yuqiyu.chapter4.jpa.test1"})//设置repository所在位置
public class Test1DataSourceConfig {


    @Autowired(required=false)//required=true表示bean必须存在，否则注入失败，默认为true
    @Qualifier("test1DataSource")
    private DataSource test1DataSource;
    
    @Autowired(required=false)//required=true表示bean必须存在，否则注入失败，默认为true
    private HibernateProperties hibernateProperties;
    
    @Primary
    @Bean(name = "entityManagerTest1")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryTest1(builder).getObject().createEntityManager();
    }


    @Autowired
    private JpaProperties jpaProperties;


    private Map<String, Object> getVendorProperties() {
    	Map<String, Object> map=hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
        return map;
    }

    @Primary
    @Bean(name = "entityManagerFactoryTest1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTest1(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(test1DataSource)
                .packages("com.yuqiyu.chapter4.entity.test1")//设置实体类所在位置
                .persistenceUnit("test1PersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerTest1")
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryTest1(builder).getObject());
    }
    
}
