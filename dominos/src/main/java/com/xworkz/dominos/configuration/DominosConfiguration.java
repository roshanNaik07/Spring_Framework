package com.xworkz.dominos.configuration;

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
@ComponentScan(basePackages = "com.xworkz.dominos")
@EnableWebMvc
public class DominosConfiguration implements WebMvcConfigurer {

    public DominosConfiguration(){
        System.out.println("No arg const of DominosConfiguration");
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/",".jsp");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean (){

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
       factoryBean.setDataSource(dataSource());
       factoryBean.setPackagesToScan("com.xworkz.dominos.entity");
       factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return  factoryBean;
    }

    @Bean

    public DataSource dataSource (){
        DriverManagerDataSource   source  = new DriverManagerDataSource();
      source.setDriverClassName("com.mysql.cj.jdbc.Driver");
      source.setUrl("jdbc:mysql://localhost:3306/dominas");
      source.setUsername("root");
      source.setPassword("Xworkzodc@123");

        return  source;
    }

}
