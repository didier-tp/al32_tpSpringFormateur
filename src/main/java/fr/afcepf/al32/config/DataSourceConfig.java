package fr.afcepf.al32.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
	@Bean(name = "myDataSource") // by default beanName is same of method name
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/minibankdb?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");// "root" ou "formation" ou "..."
		return dataSource;
	}
}
