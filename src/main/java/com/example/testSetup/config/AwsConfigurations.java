package com.example.testSetup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfigurations {

    @Bean
    public LambdaClient createLambdaClient(){
        return LambdaClient.builder().region(Region.AP_SOUTH_1).build();
    }

    @Bean
    public S3Client createS3Client(){
        return S3Client.builder()
                .region(Region.AP_SOUTH_1)
                .build();
    }
}
