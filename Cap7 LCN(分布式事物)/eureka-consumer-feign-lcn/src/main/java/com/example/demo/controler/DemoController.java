package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Test;
import com.example.demo.service.TestService;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private TestService demoService;


    @RequestMapping("/list")
    @ResponseBody
    public List<Test> list(){
        return demoService.list();
    }


    @RequestMapping("/save")
    @ResponseBody
    public int save(){
    	System.out.println("111111111111");
    	System.out.println(demoService);
        return demoService.save();
    }
    
    @RequestMapping("/save1")
    @ResponseBody
    public int save1(){
        return demoService.save1();
    }
}
