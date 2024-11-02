package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.TaskDTO;
import com.example.todo.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<TaskDTO> getAllTasks(){
		return taskService.getAllTasks();
	}
	@GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return ResponseEntity.ok(taskDTO);
    }
	
	@PostMapping
	public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) {
		TaskDTO createdTask = taskService.createTask(taskDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully: "+createdTask.getTitle());
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> createTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
		TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
		return ResponseEntity.ok("Task updated successfully: "+updatedTask.getTitle());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id){
		TaskDTO taskDTO = taskService.getTaskById(id);
		taskService.deleteTask(id);
		return ResponseEntity.ok("Task deleted successfully: "+taskDTO.getTitle());
	}

}
