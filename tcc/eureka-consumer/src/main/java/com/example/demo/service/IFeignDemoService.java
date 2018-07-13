package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.FeignModel;
import com.example.demo.service.impl.FeignDemoService;

@FeignClient(name="eureka-provider",fallback=FeignDemoService.class)
public interface IFeignDemoService {

	@RequestMapping(value="/inner/c1/f01",method=RequestMethod.POST)
	public String sendDemo(@RequestBody FeignModel feignModel);
}
