package com.example.demo.service.impl;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;

/**
 * 
 * @author Administrator
 *  1.在服务方法上加上@Compensable注解,并设置注解属性
	2.服务方法的入参都须能序列化(实现Serializable接口)
	3.try方法、confirm方法和cancel方法入参类型须一样
 */
@SuppressWarnings("deprecation")
@Service
public class DemoServiceImpl implements DemoService{

	Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
	@Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = MethodTransactionContextEditor.class)
	public String record(TransactionContext transactionContext, DemoModel demoModel) {
		
		logger.info("record:"+demoModel.toString());
		
		return null;
	}
	public void confirmRecord(TransactionContext transactionContext, DemoModel demoModel) {
		logger.info("confirmRecord:"+demoModel.toString());
	}
	
	public void cancelRecord(TransactionContext transactionContext, DemoModel demoModel) {
		logger.info("cancelRecord:"+demoModel.toString());
	}
}
