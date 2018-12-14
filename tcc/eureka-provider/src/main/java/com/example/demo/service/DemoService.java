package com.example.demo.service;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;

import com.example.demo.model.DemoModel;

public interface DemoService {

    @Compensable
	public String record(TransactionContext transactionContext, DemoModel demoModel);
}
