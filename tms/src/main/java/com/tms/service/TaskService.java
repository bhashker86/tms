package com.tms.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.tms.Entity.*;

public interface TaskService {
	
		public TaskVO createTask(TaskVO task);	
//		public List<TaskVO> getTasks();
//		public List<TaskVO> taskSearchByNameORDesc(String name,String description);
//		public void deleteTask(TaskVO task);
//		public TaskVO updateTask(TaskVO task);
//		public TaskVO getTaskByName(String name);
//		public void deleteByName(String name);
		//All new methods
		public List<TaskVO> listAllTasks();


}
