package com.example.todo.modal;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.todo.enums.ImportanceLevel;
import com.example.todo.enums.TaskCategory;
import com.example.todo.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	private LocalDateTime dueDate;
	@Enumerated(EnumType.STRING)
	private TaskCategory Category;
	@Enumerated(EnumType.STRING)
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
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
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
