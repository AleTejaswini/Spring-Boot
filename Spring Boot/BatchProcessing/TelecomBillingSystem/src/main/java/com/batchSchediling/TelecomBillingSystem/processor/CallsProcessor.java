package com.batchSchediling.TelecomBillingSystem.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;

public class CallsProcessor implements ItemProcessor<CallsSummary,CallsSummary>{

	@Override
	public CallsSummary process(CallsSummary callsummary) throws Exception {
		// TODO Auto-generated method stub
		return callsummary;
	}

	
}
