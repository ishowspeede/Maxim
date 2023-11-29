package com.example.kz.maxim.project.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource getdataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("Bebra");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("admin");
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getdataSource());
        return jdbcTemplate;
    }

}