package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZipkinController2 {

    @Autowired
    private RestTemplate restTemplate;
    
    private static final Logger LOG = LoggerFactory.getLogger(ZipkinController2.class);
    
    @RequestMapping("/fromZipkin2")
    public String fromZipkin1(){
        LOG.debug("request fromZipkin2,goto fromZipkin1");
        return restTemplate.getForObject("http://localhost:16004/info", String.class);
    }
    
    @RequestMapping("/info")
    public String info(){
    	LOG.debug("");

        return "i'm fromZipkin2";

    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
