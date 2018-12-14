package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.DemoModel;
import com.example.demo.model.TransactionEntity;
import com.example.demo.service.DemoService;


@Controller
@RefreshScope
@RequestMapping(value="/inner/c1")
public class DemoController {

	@Autowired
	private DemoService demoServiceImpl;
	
	@PostMapping(value="/f01")
	@ResponseBody
	public String sendDemo(@RequestBody TransactionEntity<DemoModel> entity) {
		
		demoServiceImpl.record(entity.getContext(), entity.getBody());
		
		return "ok";
	}
}
