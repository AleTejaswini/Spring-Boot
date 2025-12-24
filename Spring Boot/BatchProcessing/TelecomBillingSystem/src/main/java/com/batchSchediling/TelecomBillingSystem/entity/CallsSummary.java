package com.batchSchediling.TelecomBillingSystem.entity;

import jakarta.persistence.Entity;

@Entity
public class CallsSummary {

	private String mobilenum;
    private String call_type;
    private int total_duration;
    private Date call_date;
}
