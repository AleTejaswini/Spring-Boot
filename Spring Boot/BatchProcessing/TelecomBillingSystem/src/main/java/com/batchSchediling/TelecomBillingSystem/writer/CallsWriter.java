package com.batchSchediling.TelecomBillingSystem.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;

public class CallsWriter implements ItemWriter<CallsSummary>{

	@Override
	public void write(Chunk<? extends CallsSummary> chunk) throws Exception {
		for (CallsSummary summary : chunk) {
            System.out.println(summary.toString());
        }
	}

}
