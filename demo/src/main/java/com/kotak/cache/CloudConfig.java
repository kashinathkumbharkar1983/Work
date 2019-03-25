package com.kotak.cache;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.common.RedisServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile({"cloud"})
@ConfigurationProperties("application.yaml")

public class CloudConfig  {

	
	/* Find cloud service and get datasource */
//    @Bean
//    public DataSource dataSource() {
//        return cloud().getServiceConnector(SERVICE_NAME, DataSource.class, null);
//    }
	
	
	@Bean
    public CloudFactory cloudFactory() {
        return new CloudFactory();
    }
	@Qualifier("ds")
	@Profile({"cloud"})
    private DataSource createDataSource(CloudFactory cloudFactory, String serviceId) {
		System.out.println("ds in cloud========");
        return cloudFactory.getCloud().getServiceConnector(serviceId, DataSource.class, null);
    }
	@Bean
	@Profile("cloud")
	public RedisConnectionFactory redisConnectionFactory(CloudFactory cloudFactory, String serviceID) {
	  //  CloudFactory cloudFactory = new CloudFactory();
	    Cloud cloud = cloudFactory.getCloud();
	   // RedisServiceInfo serviceInfo = (RedisServiceInfo) cloud.getServiceInfo("redis");
	  //  String serviceID = serviceInfo.getId();
	    return cloud.getServiceConnector(serviceID, RedisConnectionFactory.class, null);
	}
	
}
