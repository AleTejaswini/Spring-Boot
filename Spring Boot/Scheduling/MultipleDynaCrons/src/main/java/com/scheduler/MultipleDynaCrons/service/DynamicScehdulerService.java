package com.scheduler.MultipleDynaCrons.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.scheduler.MultipleDynaCrons.entity.SchedulerConfig;
import com.scheduler.MultipleDynaCrons.repository.DynamicSchedulerRepository;

@Service
public class DynamicScehdulerService {
	@Autowired
	private DynamicSchedulerRepository repo;

	private final TaskScheduler taskscheduler;

	private Map<Integer, ScheduledFuture<?>> jobs = new HashMap<>();

	public DynamicScehdulerService(TaskScheduler taskscheduler) {
		super();
		this.taskscheduler = taskscheduler;
	}

	public void startAll() {
		List<SchedulerConfig> tasks = repo.findAll();

		for (SchedulerConfig task : tasks) {
			if (task.isEnabled()) {

				CronTrigger trigger = new CronTrigger(task.getCron());
				ScheduledFuture<?> future = taskscheduler.schedule(() -> run(task.getTaskname()), trigger);

				jobs.put(task.getId(), future);
			}
		}

	}

	public void stopAll() {
		for (ScheduledFuture<?> future : jobs.values()) {
			future.cancel(false);
		}
		jobs.clear();
		System.out.println("All tasks stopped");
	}

	public void run(String taskname) {

		System.out.println("Running task " + taskname + "at " + LocalDateTime.now());
	}
}
