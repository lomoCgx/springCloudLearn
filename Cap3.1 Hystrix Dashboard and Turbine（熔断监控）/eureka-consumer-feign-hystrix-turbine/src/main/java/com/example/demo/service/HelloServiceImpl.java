package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return "sorry "+name;
	}

}
