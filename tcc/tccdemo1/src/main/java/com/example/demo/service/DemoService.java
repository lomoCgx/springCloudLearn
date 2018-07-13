package com.example.demo.service;

import org.mengyun.tcctransaction.api.TransactionContext;

import com.example.demo.model.DemoModel;

public interface DemoService {

	public String record(TransactionContext transactionContext, DemoModel demoModel);
}
