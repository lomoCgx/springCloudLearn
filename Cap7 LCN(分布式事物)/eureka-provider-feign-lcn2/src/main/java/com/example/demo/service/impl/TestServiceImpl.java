package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TestDao;
import com.example.demo.entity.Test;
import com.example.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
    private TestDao testDao;

    @Override
    public List<Test> list() {
        return testDao.list();
    }

    @Override
    @Transactional
    public int save() {

        int rs = testDao.save();

        return rs;
    }
	
}
