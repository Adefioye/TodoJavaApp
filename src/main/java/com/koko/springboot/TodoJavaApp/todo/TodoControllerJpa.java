package com.koko.springboot.TodoJavaApp.todo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	
	@Autowired
	private TodoRepository todoRepository;
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedInUserName(model);
		model.addAttribute("todos", todoRepository.findByUserName(userName));
		
		return "listTodo";
	}

	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = getLoggedInUserName(model);
		Todo todo = new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addTodo";
		}
		String userName = getLoggedInUserName(model);
		todo.setUserName(userName);
		
		todoRepository.save(todo);
		
		return "redirect:list-todos";
		
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoRepository.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Optional<Todo> todo = todoRepository.findById(id);
		model.addAttribute("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addTodo";
		}
		
		String userName = getLoggedInUserName(model);
		todo.setUserName(userName);
		
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext()
															.getAuthentication();
		
		return authentication.getName();
	}
	

}
