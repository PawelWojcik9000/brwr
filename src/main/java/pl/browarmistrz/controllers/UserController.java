package pl.browarmistrz.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String showAdduserForm(Model model) {
		model.addAttribute("user", new User());
		return "adduser";
	}
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String processAddUser(@Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "adduser";
		} else {
			user.setLogged(true);
			userRepository.save(user);
			return "redirect:/home";
		}
	}
	

}
