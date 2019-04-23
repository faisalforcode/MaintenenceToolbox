package com.toolbox.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Maintenance main Class
 * 
 * @author faisal
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableElasticsearchRepositories("com.toolbox.repositories")
@ComponentScan(basePackages = "com.toolbox")
@PropertySource("classpath:/application.properties")
public class MaintenanceToolbox {

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceToolbox.class, args);
	}
}
