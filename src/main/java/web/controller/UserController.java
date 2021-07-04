package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String welcome() {
		return "home";
	}

	@GetMapping("/user")
	public String autUserPage(Model model, Authentication authentication) {
		UserDetails realUser = (UserDetails)authentication.getPrincipal();
		model.addAttribute("user", userService.findByUsername(realUser.getUsername()));
		return "user";
	}

	@GetMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "admin";
	}

	@GetMapping("/new")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/update")
	public String updateUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "update";
	}

	@PatchMapping("/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userService.updateUser(id, user);
		return "redirect:/admin";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }

}