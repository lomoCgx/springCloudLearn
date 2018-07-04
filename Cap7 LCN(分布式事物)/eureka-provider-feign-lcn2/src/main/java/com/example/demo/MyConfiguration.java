package com.example.demo;

import org.springframework.context.annotation.Bean;

import com.lorne.tx.springcloud.feign.TransactionRestTemplateInterceptor;

import feign.RequestInterceptor;

public class MyConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new TransactionRestTemplateInterceptor();
    }
}