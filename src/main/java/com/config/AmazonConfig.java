package com.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Amazon'da hesap oluşturduktan sonra s3 servisi sekmesinden Create New Bucket yaparak accessKey ve secretKey dosyasını
* indiriyoruz ve configuration da s3 bucket'a erişebilmek için kullanıyoruz.
* */
@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "",
                ""
        );
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}