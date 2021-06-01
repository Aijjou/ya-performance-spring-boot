package com.ya.performance.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.ya.performance")
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {
	/**
	 * Environment in which the current application is running
	 * @see org.springframework.core.env.Environment
	 */
	@Autowired
	private Environment env;

	/**
	 * Bean for DataBase connection using application.properties file
	 * @return datasource : Datasource
	 * @see javax.sql.DataSource
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}
}
