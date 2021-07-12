package com.klipov.string_boot.springboot.controller;

import com.klipov.string_boot.springboot.model.User;
import com.klipov.string_boot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public String autUserPage(Model model, Authentication authentication) {
		UserDetails realUser = (UserDetails)authentication.getPrincipal();
		model.addAttribute("user", userService.findByUsername(realUser.getUsername()));
		return "user";
	}

	@GetMapping("/admin")
	public String adminPage(Model model, Authentication authentication) {
		UserDetails realUser = (UserDetails)authentication.getPrincipal();
		model.addAttribute("user_1", userService.findByUsername(realUser.getUsername()));
		model.addAttribute("users", userService.getAllUsers());
		return "admin";
	}

	@GetMapping("/new")
	public String saveUser(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/admin";
	}

	@GetMapping("/{id}/update")
	public String updateUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "update";
	}

	@PatchMapping("/{id}")
	public String updateUser(@PathVariable("id") Long id, User user) {
		userService.updateUser(id, user);
		return "redirect:/admin";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
}