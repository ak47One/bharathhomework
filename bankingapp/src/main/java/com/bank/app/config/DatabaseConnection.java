package com.bank.app.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class DatabaseConnection {

	@Bean
	DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		return new HikariDataSource(config);
	}

}
