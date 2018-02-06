package com.cai.blog.conf;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 主要引入了这里SpringProcessEngineConfiguration，就可以在其他bean中直接植入activiti的7大服务了，
 * 如在com.cai.blog.activiti.model.ModelSaveRestResource中注入RepositoryService
 */
@Configuration
public class ActivitiConfig {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    DataSource druidDataSource;

    @Bean
    public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
        SpringProcessEngineConfiguration config =
                new SpringProcessEngineConfiguration();
        config.setDataSource(druidDataSource);
        config.setTransactionManager(transactionManager);
        config.setDatabaseType("mysql");
        config.setDatabaseSchemaUpdate("true");
        return config;
    }
}
