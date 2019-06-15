package com.tms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.tms.Entity.TaskVO;
import com.tms.service.TaskService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@CrossOrigin
@RestController
@EnableSwagger2
@RequestMapping("api/v1/task")
public class TaskController {
	
	@Autowired
	private TaskService  task_Service;
			
		@PostMapping("add")	
		public ResponseEntity<TaskVO> addTask(@RequestBody TaskVO task){
		    return new ResponseEntity<>(task_Service.createTask(task),HttpStatus.CREATED);	
		}
		
	/*	
		
		
		@DeleteMapping("deleteTask")
		public ResponseEntity<Void> deleteTask(@RequestBody TaskVO task){
			task_Service.deleteTask(task);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		@GetMapping("getByName/{name}")
		public ResponseEntity<TaskVO> getByTaskName(@PathVariable("name") String name){
			return new ResponseEntity<>(task_Service.getTaskByName(name),HttpStatus.OK);
		}
		
		@DeleteMapping("deleteByName/{name}")
		public ResponseEntity<Void> deleteByTaskName(@PathVariable String name){
			task_Service.deleteByName(name);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		
		@PutMapping("updateTask")
		public ResponseEntity<TaskVO> UpdateTask(@RequestBody TaskVO task){
			return new ResponseEntity<>(task_Service.updateTask(task),HttpStatus.OK);
		}
		
		
		
		@GetMapping("get_tasks")
		public ResponseEntity<List<TaskVO>> listTask(){
			return new ResponseEntity<>(task_Service.getTasks(),HttpStatus.OK);
		}
		
		@GetMapping("search_task")
		public  ResponseEntity<List<TaskVO>> searchTask(@RequestParam("query") String query){
		  return new ResponseEntity<>(task_Service.taskSearchByNameORDesc(query, query),HttpStatus.OK);
		}
		
		*/
		/********List all tasks****************/
		@GetMapping("listTasks")
		public ResponseEntity<List<TaskVO>> listTasks(){
			return new ResponseEntity<>(task_Service.listAllTasks() ,HttpStatus.OK);
		}
		

}
