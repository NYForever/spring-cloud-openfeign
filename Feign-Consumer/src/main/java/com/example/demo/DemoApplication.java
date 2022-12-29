package com.example.demo;

import com.netflix.loadbalancer.RandomRule;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DemoApplication {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

	//可通过注入bean来改变ribbon的轮询策略
	@Bean
	public RandomRule getRule() {
		return new RandomRule();
	}

	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
