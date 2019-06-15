package com.tms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tms.Entity.TaskEntity;
import com.tms.Entity.TaskVO;
import com.tms.repository.TaskRepository;

@Service
public class TaskServiceImpl  implements TaskService{

	
	@Autowired
	private TaskRepository task_repo;
	
	
	public TaskVO createTask(TaskVO task) {
		
		TaskEntity task_entity=new TaskEntity();
		task_entity.setName(task.getName());
		task_entity.setDescription(task.getDescription());
		task_entity.setStatus(task.isStatus());
		
		
		TaskEntity generated_task=task_repo.save(task_entity);
		TaskVO new_task=new TaskVO();
		new_task.setId(generated_task.getId());
		new_task.setName(generated_task.getName());
		new_task.setDescription(generated_task.getDescription());
		new_task.setStatus(generated_task.isStatus());
		return new_task;
	
	}
	
	
/*	
	@Cacheable(value="test", key="#name")
	public TaskVO getTaskByName(String name) {
		
		TaskEntity task=task_repo.findByName(name);
		TaskVO new_value=new TaskVO();
		new_value.setId(task.getId());
		new_value.setName(task.getName());
		new_value.setDescription(task.getDescription());
		new_value.setStatus(task.isStatus());
		return new_value;
	}
	
	@CacheEvict(value="test", key="#name")
	public void deleteByName(String name) {
		TaskEntity task=task_repo.findByName(name);
		task_repo.delete(task);
	}
	
	
	
	//@Cacheable(value="test", key="#p0")
	public List<TaskVO> getTasks(){
	 List<TaskEntity> task_list=new ArrayList<>();
	 task_repo.findAll().forEach((v)->task_list.add(v));
	 List<TaskVO> task_list_vo=new ArrayList<>();
	 
	 
	 for(TaskEntity task:task_list) {
		 
		TaskVO tsk=new TaskVO();
		tsk.setId(task.getId());
		tsk.setName(task.getName());
		tsk.setDescription(task.getDescription());
		tsk.setStatus(task.isStatus());
		task_list_vo.add(tsk);
	 }
	 return  task_list_vo;
	}
	
	@Cacheable(value="test")
	public List<TaskVO> taskSearchByNameORDesc(String name,String description){
		List<TaskEntity> task_list=new ArrayList<>();
		 task_repo.findByNameOrDescriptionAllIgnoreCase(name,description).forEach((v)->task_list.add(v));
		 List<TaskVO> task_list_vo=new ArrayList<>();
		 
		 
		 for(TaskEntity task:task_list) {
			 
			TaskVO tsk=new TaskVO();
			tsk.setId(task.getId());
			tsk.setName(task.getName());
			tsk.setDescription(task.getDescription());
			tsk.setStatus(task.isStatus());
			task_list_vo.add(tsk);
		 }
		 return  task_list_vo;
		
	}
	
	@CacheEvict(value="test" , key="#p0")
	public void deleteTask(TaskVO task) {
		
		TaskEntity task_ent=new TaskEntity();
		task_ent.setId(task.getId());
		task_ent.setName(task.getName());
		task_ent.setDescription(task.getDescription());
		task_ent.setStatus(task.isStatus());
		 
		task_repo.delete(task_ent);
	}
	
	@CachePut(value="test" , key="#p0")
	public TaskVO updateTask(TaskVO task) {
		
		TaskEntity old_task=new TaskEntity();
		old_task=task_repo.findById(task.getId());
		
		old_task.setName(task.getName());
		old_task.setDescription(task.getDescription());
		old_task.setStatus(task.isStatus());
		
		TaskEntity updated_task=new TaskEntity();
		updated_task=task_repo.save(old_task);
		
		TaskVO new_value=new TaskVO();
		
		new_value.setId(updated_task.getId());
		new_value.setName(updated_task.getName());
		new_value.setDescription(updated_task.getDescription());
		new_value.setStatus(updated_task.isStatus());
		return new_value;
		
	} *******************/
	//All new methods
	public List<TaskVO> listAllTasks(){
		  List<TaskEntity> task_list=new ArrayList<>();	
		  task_repo.findAll().forEach(v->task_list.add(v));
		  List<TaskVO> task_list_vo=new ArrayList<>();
			 
			 for(TaskEntity task:task_list) {
				 
				TaskVO tsk=new TaskVO();
				tsk.setId(task.getId());
				tsk.setName(task.getName());
				tsk.setDescription(task.getDescription());
				tsk.setStatus(task.isStatus());
				task_list_vo.add(tsk);
			 }
			 return  task_list_vo;
     }

	
	
}
