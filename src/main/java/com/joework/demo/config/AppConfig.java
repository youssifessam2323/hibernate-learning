package com.joework.demo.config;


import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.joework.demo")
@EnableTransactionManagement
public class AppConfig {

    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);


    @Bean
    public DataSource dataSource(){

       try {
           EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();

          return databaseBuilder
                   .setType(EmbeddedDatabaseType.H2)
                   .addScripts("classpath:sql/schema.sql", "classpath:sql/test-data-sql")
                   .build();
       }catch (Exception e){
           logger.error("Embedded DataSource bean cannot be created!", e);
           return null ;
       }
    }


    @Bean
    public Properties hibernateProperties(){
        Properties hibProperties = new Properties();

        hibProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        hibProperties.put("hibernate.format_sql",true);
        hibProperties.put("hibernate.use_sql_comments", true);
        hibProperties.put("hibernate.show_sql", true);
        hibProperties.put("hibernate.max_fetch_depth", 3);
        hibProperties.put("hibernate.jdbc.batch_size", 10);
        hibProperties.put("hibernate.jdbc.fetch_size", 50);

        return hibProperties;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan("com.joework.demo.models");
        sessionFactoryBean.afterPropertiesSet();

        return sessionFactoryBean.getObject();
    }

    @Bean public PlatformTransactionManager transactionManager() throws IOException{
        return new HibernateTransactionManager(sessionFactory());
    }
}
