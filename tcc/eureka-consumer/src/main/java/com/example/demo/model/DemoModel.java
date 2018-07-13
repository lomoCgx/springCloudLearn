package com.example.demo.model;

import java.io.Serializable;

public class DemoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String demo;
	private String name;
	public String getDemo() {
		return demo;
	}
	public void setDemo(String demo) {
		this.demo = demo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DemoModel [demo=" + demo + ", name=" + name + "]";
	}
	
	
}
