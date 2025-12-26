package com.batchScheduling.CompanyDetail.processor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;

import com.batchScheduling.CompanyDetail.entity.UserDetails;

public class UserProcessor implements ItemProcessor<UserDetails,UserDetails>{
	 
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	@Override
	public UserDetails process(UserDetails user) throws Exception {
		return user;
	}

}
