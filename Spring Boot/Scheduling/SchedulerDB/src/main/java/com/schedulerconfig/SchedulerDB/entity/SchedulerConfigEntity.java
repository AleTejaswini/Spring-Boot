package com.schedulerconfig.SchedulerDB.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SchedulerConfigEntity {
	@Id
	private int id;
	
	private String task;
	
	@Column(name= "cron_expression")
	private String cron;
	
    public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	@Column(name = "interval_ms")
	private long interval;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public long getInterval() {
		return interval;
	}
	public void setInterval(long interval) {
		this.interval = interval;
	}
	
	
	
}
