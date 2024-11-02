package com.example.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dto.TaskDTO;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.modal.Task;
import com.example.todo.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<TaskDTO> getAllTasks(){
		return taskRepository.findAll().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	public TaskDTO getTaskById(Long id) {
		Task taskDTO = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found"));
		return convertToDTO(taskDTO);
	}
	public TaskDTO createTask(TaskDTO taskDTO) {
		Task task = convertToEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
	}
	public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
		Task existingTask = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found"));
		existingTask.setTitle(taskDTO.getTitle());
		existingTask.setStatus(taskDTO.getStatus());
		existingTask.setDueDate(taskDTO.getDueDate());
		existingTask.setCategory(taskDTO.getCategory());
		existingTask.setImportanceLevel(taskDTO.getImportanceLevel());
		existingTask.setColor(taskDTO.getColor());
		existingTask.setAlarm(taskDTO.getAlarm());
		existingTask.setDuration(taskDTO.getDuration());
		Task updatedTask = taskRepository.save(existingTask);
		return convertToDTO(updatedTask);
	}
	public void deleteTask(Long id) {
		if(!taskRepository.existsById(id)) {
			throw new ResourceNotFoundException("Task not found.");
		}
		taskRepository.deleteById(id);
	}
	
	private TaskDTO convertToDTO(Task task) {
		TaskDTO dto = new TaskDTO();
		dto.setId(task.getId());
	    dto.setTitle(task.getTitle());
	    dto.setStatus(task.getStatus());
	    dto.setDueDate(task.getDueDate());
	    dto.setCategory(task.getCategory());
	    dto.setImportanceLevel(task.getImportanceLevel());
	    dto.setColor(task.getColor());
	    dto.setAlarm(task.getAlarm());
	    dto.setDuration(task.getDuration());
		return dto;
	}
	 private Task convertToEntity(TaskDTO dto) {
	        Task task = new Task();
	        task.setId(dto.getId());
	        task.setTitle(dto.getTitle());
	        task.setStatus(dto.getStatus());
	        task.setDueDate(dto.getDueDate());
	        task.setCategory(dto.getCategory());
	        task.setImportanceLevel(dto.getImportanceLevel());
	        task.setColor(dto.getColor());
	        task.setAlarm(dto.getAlarm());
	        task.setDuration(dto.getDuration());
	        return task;
	    }
	
}
