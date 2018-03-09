package com.kicinger.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    @Bean
    @LiquibaseDataSource
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

}
