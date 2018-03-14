package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloService;

@RestController
public class HelloControler {

	 @Autowired
    HelloService helloService;
    @RequestMapping(value = "/dc")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
    
    @Value("${neo.hello}")
    String foo;
    
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
