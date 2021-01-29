package com.example.webfluxtest.employee.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**  * DataBaseConfig
 *
 * @author incheol.jung
 * @since 2021. 01. 29.
 */
@Configuration
public class DataBaseConfig {
	private static final String DEFAULT_NAMING_STRATEGY
		= "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy";

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.article")
	public DataSource articleDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
		EntityManagerFactoryBuilder builder) {

		Map<String, String> propertiesHashMap = new HashMap<>();
		propertiesHashMap.put("hibernate.ejb.naming_strategy", DEFAULT_NAMING_STRATEGY);

		return builder.dataSource(articleDataSource())
			.packages("com.example.webfluxtest.employee.entity")
			.properties(propertiesHashMap)
			.build();
	}

	@Primary
	@Bean(name = "transactionManager")
	PlatformTransactionManager transactionManager(
		EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
	}

	@Configuration
	@EnableJpaRepositories(
		basePackages = "com.example.webfluxtest.employee.dao",
		entityManagerFactoryRef = "entityManagerFactory",
		transactionManagerRef = "transactionManager")
	static class DbArticleJpaRepositoriesConfig {
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource.user")
	public DataSource userDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "entityManagerFactoryUser")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
		EntityManagerFactoryBuilder builder) {

		return builder.dataSource(userDataSource())
			.packages("com.example.webfluxtest.employee.entity")
			.build();
	}

	@Bean(name = "transactionManagerUser")
	@Primary
	PlatformTransactionManager userTransactionManagerMain(
		EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(userEntityManagerFactory(builder).getObject());
	}

	@Configuration
	@EnableR2dbcRepositories(basePackages = "com.example.webfluxtest.employee.reactive")
	static class DbUserJpaRepositoriesConfig {
	}
}
