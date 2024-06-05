package com.liyang.mvccontroller.backend;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.liyang.mvccontroller.*",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {Controller.class, RestController.class}
        )
)
@MapperScan(
        basePackages = "com.liyang.mvccontroller.service",
        annotationClass = Mapper.class
)
public class BackendConfig {
        @Autowired
        private DataSource dataSource;

        @Bean
        DataSource createDataSource() {
                if (dataSource != null) {
                        return dataSource;
                }
                HikariConfig config = new HikariConfig();
                config.setJdbcUrl("jdbc:hsqldb:file:testdb");
                config.setUsername("sa");
                config.setPassword("");
                config.addDataSourceProperty("autoCommit", "true");
                config.addDataSourceProperty("connectionTimeout", "5");
                config.addDataSourceProperty("idleTimeout", "60");
                return new HikariDataSource(config);
        }

        @Bean
        JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
                return new JdbcTemplate(dataSource);
        }

        @Bean
        SqlSessionFactory createSqlSessionFactoryBean(@Autowired DataSource dataSource) throws Exception {
                SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
                sqlSessionFactoryBean.setDataSource(dataSource);
                return sqlSessionFactoryBean.getObject();
        }

        @Bean
        public PlatformTransactionManager annotationDrivenTransactionManager() {
                DataSourceTransactionManager dataSourceTransactionManager =
                        new DataSourceTransactionManager();
                dataSourceTransactionManager.setDataSource(createDataSource());
                return dataSourceTransactionManager;
        }
}
