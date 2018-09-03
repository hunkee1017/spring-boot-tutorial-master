package com.skcc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.PooledServiceConnectorConfig.PoolConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class CloudConfiguration extends AbstractCloudConfig {
	
	@Value("${services.datasource.name}")
	private String datasourceName;

	@Value("${services.datasource.initial-size}")
	private int minPoolSize;

	@Value("${services.datasource.maximum-pool-size}")
	private int maxPoolSize;

	@Value("${services.datasource.max-wait-time}")
	private int maxWaitTime;

	/**
	 * configure datasource.
	 * @return dataSource object
	 */
	@Bean
	public DataSource dataSource() {
		PoolConfig poolConfig = new PoolConfig(minPoolSize, maxPoolSize, maxWaitTime);
		DataSourceConfig dbConfig = new DataSourceConfig(poolConfig, null);
		return connectionFactory().dataSource(datasourceName, dbConfig);
	}

}
