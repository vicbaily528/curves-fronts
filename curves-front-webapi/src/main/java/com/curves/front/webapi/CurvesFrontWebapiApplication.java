package com.curves.front.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author vic
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class CurvesFrontWebapiApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CurvesFrontWebapiApplication.class);
        application.run(args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
