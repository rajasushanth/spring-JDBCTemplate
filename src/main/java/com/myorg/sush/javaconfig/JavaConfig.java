package com.myorg.sush.javaconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "com.myorg")
public class JavaConfig {
	
	private Environment env;
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverName"));
		driverManagerDataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		driverManagerDataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		driverManagerDataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		return driverManagerDataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Autowired
	public void setEnv(Environment env) {
		this.env = env;
	}
	
	

}
