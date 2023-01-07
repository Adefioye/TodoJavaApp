package com.koko.springboot.TodoJavaApp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {

	private int id;
	private String userName;
	
	@Size(min=10, message="Enter at least 10 characters")
	private String description;
	
	private LocalDate target;
	private boolean done;

	public Todo(int id, String userName, String description, LocalDate target, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.target = target;
		this.done = done;
	}
	
	
	public int getId() {
		return id;
	}


	public String getUserName() {
		return userName;
	}


	public String getDescription() {
		return description;
	}


	public LocalDate getTarget() {
		return target;
	}


	public boolean isDone() {
		return done;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTarget(LocalDate target) {
		this.target = target;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userName=" + userName + ", description=" + description + ", target=" + target
				+ ", done=" + done + "]";
	}

}
