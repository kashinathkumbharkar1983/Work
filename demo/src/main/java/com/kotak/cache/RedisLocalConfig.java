package com.kotak.cache;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile("default")
public class RedisLocalConfig {

	@Bean
	public RedisConnectionFactory redisConnection()
	{
		return new JedisConnectionFactory();
	}
	@Bean(name= "ds")
    @Primary
    @Qualifier("ds")
    @ConfigurationProperties(prefix ="spring.datasource")
	@Profile({"dev"})

		public DataSource dataSource(DataSourceProperties properties) {
		System.out.println("ds in local cloud========");

	        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
	                .build();
	    }
    
}