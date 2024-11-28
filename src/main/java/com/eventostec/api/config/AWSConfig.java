package com.eventostec.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;

@Configuration
public class AWSConfig {
    @Value("${aws.region}")
    private String awsRegion;
    @Value("${aws.accessKey:}")
    private String accessKeyId;
    @Value("${aws.secretKey:}")
    private String secretAccessKey;

    @Bean
    public S3Client createS3Instance() {
        // A configuração do cliente S3 deve usar a região correta
        Region region = Region.of(awsRegion);

        S3ClientBuilder s3ClientBuilder = S3Client.builder()
                .region(region);

        if (accessKeyId != null && !accessKeyId.isEmpty() &&
                secretAccessKey != null && !secretAccessKey.isEmpty()) {
            s3ClientBuilder.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey)));
        }

        return s3ClientBuilder.build();
    }
}