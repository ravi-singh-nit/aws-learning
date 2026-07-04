package com.example.testSetup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class MyConfiguration {

    @Bean
    RestClient createRestClient(){
        return RestClient.builder().build();
    }
}
