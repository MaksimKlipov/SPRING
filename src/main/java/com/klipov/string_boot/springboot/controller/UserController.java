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
		User realUser = (User)authentication.getPrincipal();
		model.addAttribute("user", userService.findByEmail(realUser.getEmail()));
		return "user";
	}

	@GetMapping("/admin")
	public String adminPage(Model model, Authentication authentication) {
		User realUser = (User)authentication.getPrincipal();
		model.addAttribute("user_1", userService.findByEmail(realUser.getEmail()));
		model.addAttribute("users", userService.getAllUsers());
		return "admin";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/admin";
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