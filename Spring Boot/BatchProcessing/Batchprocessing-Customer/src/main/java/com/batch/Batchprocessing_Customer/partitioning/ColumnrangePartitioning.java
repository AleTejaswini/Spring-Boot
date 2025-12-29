package com.batch.Batchprocessing_Customer.partitioning;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class ColumnrangePartitioning implements Partitioner {

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> map = new HashMap<>();
		
		int min=1;
		int max =100;
		int targetsize = (max-min)/gridSize +1;
		
		int start = min;
		int end = start + targetsize -1;
		
		for(int i=0;i<gridSize ;i++) {
			ExecutionContext context = new ExecutionContext();
			context.put("start", start);
			context.put("end", end);
			map.put("partition" +i, context);
			
			start = end+1;
			end = Math.min(end+targetsize , max);
			
		}
		return map;
	}

}
