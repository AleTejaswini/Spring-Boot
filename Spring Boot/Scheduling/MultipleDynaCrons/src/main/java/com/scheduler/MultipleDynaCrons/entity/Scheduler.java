package com.scheduler.MultipleDynaCrons.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Scheduler {
	@Id
	private int id;
	
	private String taskname;
	
	private String cron;
	private boolean isEnabled;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	
	
}
