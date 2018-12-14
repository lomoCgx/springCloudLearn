package com.example.demo.service.impl;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.context.MethodTransactionContextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DemoModel;
import com.example.demo.model.FeignModel;
import com.example.demo.model.TransactionEntity;
import com.example.demo.service.DemoService;
import com.example.demo.service.IFeignDemoService;

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
	
	@Autowired
	private IFeignDemoService feignDemoService;
	
	@Transactional
	@Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = MethodTransactionContextEditor.class)
	public String record(TransactionContext transactionContext, DemoModel demoModel) {
		logger.info("id="+transactionContext.getXid());
		logger.info("record:"+demoModel.toString());
		
		FeignModel feignModel = new FeignModel();
		feignModel.setName("刘德华");
		feignModel.setAge("18");
		logger.info("调用远程服务");
		//logger.info("调用远程服务:"+transactionContext.getStatus());
		String str = "";
		TransactionEntity<FeignModel> transactionEntity = new TransactionEntity<FeignModel>(transactionContext,feignModel);
		str = feignDemoService.sendDemo(transactionEntity);
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
/*		int i=0;
		int num = 5/i;*/
		
		logger.info("调用远程服务，结果："+str);

		return null;
	}
	
	@Transactional
	public void confirmRecord(TransactionContext transactionContext, DemoModel demoModel) {
		logger.info("confirmRecord:"+demoModel.toString());
	}
	
	@Transactional
	public void cancelRecord(TransactionContext transactionContext, DemoModel demoModel) {
		logger.info("cancelRecord:"+demoModel.toString());
	}
}
