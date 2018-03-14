package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@RefreshScope
public class ServerConfig2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerConfig2Application.class, args);
	}
}
