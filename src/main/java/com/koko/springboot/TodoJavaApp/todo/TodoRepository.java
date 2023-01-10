package com.koko.springboot.TodoJavaApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	public List<Todo> findByUserName(String UserName);
}
