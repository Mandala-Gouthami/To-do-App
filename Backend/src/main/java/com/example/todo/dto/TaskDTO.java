package com.example.todo.dto;

import java.time.LocalDateTime;

import com.example.todo.enums.ImportanceLevel;
import com.example.todo.enums.TaskCategory;
import com.example.todo.enums.TaskStatus;

public class TaskDTO {
	
	private Long id;
	private String title;
	private TaskStatus status;
	private LocalDateTime dueDate;
	private TaskCategory Category;
	private ImportanceLevel importanceLevel;
	private String color;
	private LocalDateTime alarm;
	private long duration;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public TaskCategory getCategory() {
		return Category;
	}
	public void setCategory(TaskCategory category) {
		Category = category;
	}
	public ImportanceLevel getImportanceLevel() {
		return importanceLevel;
	}
	public void setImportanceLevel(ImportanceLevel importanceLevel) {
		this.importanceLevel = importanceLevel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LocalDateTime getAlarm() {
		return alarm;
	}
	public void setAlarm(LocalDateTime alarm) {
		this.alarm = alarm;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	

}
