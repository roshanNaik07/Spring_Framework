package com.xworkz.authentication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.xworkz.authentication")
@EnableWebMvc
public class AuthenticationConfiguration implements WebMvcConfigurer {

    public AuthenticationConfiguration(){
        System.out.println("AuthenticationConfiguration created by Application context");
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/",".jsp");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.xworkz.authentication.entity");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return factoryBean;
    }

    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/authentication");
        dataSource.setUsername("root");
        dataSource.setPassword("Xworkzodc@123");

        return dataSource;
    }
}
