package com.epam.esm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.esm")
@EnableWebMvc

public class SpringConfig {
    public static final String MYSQL_PROPERTIES_PROD = "/mysql.properties";

    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/module02?serverTimezone=UTC&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("24081984");
        return driverManagerDataSource;
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceProd() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/module02?serverTimezone=UTC&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("24081984");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate template(DataSource dataSource) {

        return new JdbcTemplate(dataSource());
    }




}
