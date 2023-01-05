package com.koko.springboot.TodoJavaApp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap model) {
		model.addAttribute("todos", todoService.findByUserName("in28minutes"));
		
		return "todoList";
	}
}
