package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;


@Controller
@RefreshScope
@RequestMapping(value="/member/c1")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	
	@PostMapping(value="/f01")
	@ResponseBody
	public String sendDemo(@RequestBody DemoModel demoModel) {
		
		demoService.record(null, demoModel);
		
		return "ok";
	}
}
