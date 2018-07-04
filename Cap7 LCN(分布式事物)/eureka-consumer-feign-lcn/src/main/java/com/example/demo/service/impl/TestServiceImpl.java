package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.client.HelloClient;
import com.example.demo.client.HelloClient1;
import com.example.demo.dao.HelloDao;
import com.example.demo.entity.Test;
import com.example.demo.service.HelloService;
import com.example.demo.service.TestService;
import com.lorne.tx.annotation.TxTransaction;

@Component
public class TestServiceImpl implements TestService{

	 	@Autowired
	    private HelloDao testDao;

	    @Autowired
	    private HelloClient demo2Client;

	    @Autowired
	    private HelloClient1 demo3Client;


	    @Override
	    public List<Test> list() {
	        return testDao.list();
	    }

	    @Override
	    @TxTransaction
	    @Transactional
	    public int save() {

	    	int rs4 = testDao.save();
	        int rs2 = demo2Client.save();

	        int rs3 = demo3Client.save();

	        int rs1 = testDao.save();

	       //int v = 100/0;

	        return rs1+rs2+rs3;
	    }
	    
	    @Override
	    @Transactional
	    public int save1() {

	    	int rs4 = testDao.save();
	        //int rs2 = demo2Client.save();

	        //int rs3 = demo3Client.save();

	        int rs1 = testDao.save();

	       //int v = 100/0;

	        return rs1+rs4;
	    }

}
