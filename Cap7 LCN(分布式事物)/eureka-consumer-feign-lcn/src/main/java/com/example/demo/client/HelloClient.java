package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.MyConfiguration;
import com.example.demo.entity.Test;

@FeignClient(value = "eureka-provider-feign-lcn",configuration = MyConfiguration.class)
public interface HelloClient {


    @RequestMapping("/test/list")
    List<Test> list();


    @RequestMapping("/test/save")
    int save();
}
