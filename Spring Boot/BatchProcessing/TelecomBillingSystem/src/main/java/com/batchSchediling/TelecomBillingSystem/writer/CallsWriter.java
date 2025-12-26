package com.batchSchediling.TelecomBillingSystem.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.batchSchediling.TelecomBillingSystem.entity.CallsDetails;
import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;
import com.batchSchediling.TelecomBillingSystem.repository.CallsDetailsRepository;
import com.batchSchediling.TelecomBillingSystem.repository.CallsSummaryRepository;


public class CallsWriter implements ItemWriter<CallsSummary>{
	@Autowired
	private CallsSummaryRepository callssummaryrepo;
	
	@Autowired
	private CallsDetailsRepository callsdetailsrepo;
	

	@Override
	public void write(List<? extends CallsSummary> callssummary) throws Exception {
		
		for (CallsSummary callsummary : callssummary) {
			callssummaryrepo.save(callsummary);
	    	CallsDetails details = callsdetailsrepo
	    		    .findByMobilenumAndCallDate(
	    		        callsummary.getMobilenum(),
	    		        callsummary.getCall_date()
	    		    )
	    		    .orElseGet(() -> {
	    		        CallsDetails cd = new CallsDetails();
	    		        cd.setMobilenum(callsummary.getMobilenum());
	    		        cd.setCallDate(callsummary.getCall_date());
	    		        cd.setIncoming_call_count(0);
	    		        cd.setOutgoing_call_count(0);
	    		        cd.setTotal_duration(0);
	    		        cd.setTotal_bill_amount(0);
	    		        return cd;
	    		    });


	        // aggregate duration
	        details.setTotal_duration(
	            details.getTotal_duration() + callsummary.getTotal_duration()
	        );

	        // aggregate counts + bill
	        if ("OUTGOING".equalsIgnoreCase(callsummary.getCall_type())) {
	            details.setOutgoing_call_count(details.getOutgoing_call_count() + 1);

	            double cost = Math.ceil(callsummary.getTotal_duration() / 60.0);
	            details.setTotal_bill_amount(details.getTotal_bill_amount() + cost);
	        } else {
	            details.setIncoming_call_count(details.getIncoming_call_count() + 1);
	        }

	        callsdetailsrepo.save(details);
	   
	
		
	}

	

	}}
