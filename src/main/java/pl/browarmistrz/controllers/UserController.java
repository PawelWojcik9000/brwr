package pl.browarmistrz.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.browarmistrz.entities.User;
import pl.browarmistrz.repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		model.addAttribute("adduser", new User());
		return "adduserform";
	}
	@PostMapping("/adduser")
	public String processAddUser(@Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "adduserform";
		} else {
			userRepository.save(user);
			return "redirect:/recipe/publicrecipes";
		}
	}
	

}
