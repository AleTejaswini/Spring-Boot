package com.batchSchediling.TelecomBillingSystem.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;

public class CallsProcessor implements ItemProcessor<CallsSummary,CallsSummary>{

	@Override
	public CallsSummary process(CallsSummary callssummary) throws Exception {
		
	
		
		if("INCOMING".equalsIgnoreCase(callssummary.getCall_type())) {
			callssummary.setTotal_bill_amount(0);
			callssummary.setIncoming_call_count(callssummary.getIncoming_call_count() +1);
		}
		else {
			callssummary.setTotal_bill_amount((callssummary.total_duration/60)*1);
			callssummary.setOutgoing_call_count(callssummary.getOutgoing_call_count() +1);
		}
		
		
		
		return callssummary;
	}

}
