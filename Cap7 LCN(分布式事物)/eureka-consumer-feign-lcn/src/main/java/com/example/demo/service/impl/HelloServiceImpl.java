package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.HelloService;

@Component
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return "sorry "+name;
	}

}
