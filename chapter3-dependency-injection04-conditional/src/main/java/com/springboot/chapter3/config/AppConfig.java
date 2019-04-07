package com.springboot.chapter3.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.springboot.chapter3.condition.DataBaseConditional;

@Configuration
//@ComponentScan("com.springboot.chapter3.*")
//@ComponentScan(basePackages = {"com.springboot.chapter3.pojo"})
//@ComponentScan(basePackageClasses = {User.class})
@ComponentScan(basePackages = "com.springboot.chapter3.*", 
excludeFilters= {@Filter(classes= {Service.class})})
public class AppConfig {
	
	/**
	 * Here we inject on bean from a third party framework, we give the bean name
	 * with annotation '@Bean' and parameter 'name'
	 * @return
	 */
	@Bean(name = "dataSource")
	@Conditional(DataBaseConditional.class)
	public DataSource getDataSource() {
		
		Properties props = new Properties();
		props.setProperty("driver", "com.mysql.jdbc.driver");
		props.setProperty("url", "jdbc:mysql://localhost:3306/chapter3");
		props.setProperty("username", "root");
		props.setProperty("password", "1234");
		
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
}
