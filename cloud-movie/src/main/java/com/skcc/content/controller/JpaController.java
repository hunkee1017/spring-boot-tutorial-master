package com.skcc.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.content.dao.UserRepository;
import com.skcc.content.vo.User;

@RestController
public class JpaController {

	@Autowired
	private UserRepository repository;

	@RequestMapping(path="/users", method=RequestMethod.GET)
	public List<User> listUser(Model model) {	
		repository.deleteAll();

		repository.save(new User("Alice", "alice@email.com"));
		repository.save(new User("Bob", "bob@email.com"));

		return repository.findByEmail("alice@email.com");
	}
}
