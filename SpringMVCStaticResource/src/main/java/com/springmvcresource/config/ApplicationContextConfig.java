package com.springmvcresource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvcresource.dao.CustomerDAO;
import com.springmvcresource.dao.impl.JdbcCustomerDAO;


@Configuration
@ComponentScan("org.o7planning.springmvcresource.*")

//Load to Environment.
@PropertySource("classpath:datasource-cfg.properties")
@EnableTransactionManagement
public class ApplicationContextConfig {
	// Lưu trữ các giá thuộc tính load bởi @PropertySource.
	@Autowired
	private Environment env;
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));

		return dataSource;
	}

	@Bean(name = "CustomerDAO")
	public CustomerDAO customerDAO() {
		return new JdbcCustomerDAO();
	}

}