package com.batch.batchprocessing2.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batch.batchprocessing2.entity.User;

public class UserProcessor implements ItemProcessor<User,User>{

	@Override
	public User process(User user) throws Exception {
		
		if("Active".equalsIgnoreCase(user.getStatus())){
			return user;
		}
		return null;
	}
	

	
}
