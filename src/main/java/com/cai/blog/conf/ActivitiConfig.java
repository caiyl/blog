package com.cai.blog.conf;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by caiyl on 2017/10/5.
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
