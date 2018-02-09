package pl.browarmistrz.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.browarmistrz.entities.User;
import pl.browarmistrz.entities.UserRole;
import pl.browarmistrz.repositories.UserRepository;
import pl.browarmistrz.repositories.UserRolesRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private final UserRepository userRepository;
	private final UserRolesRepository userRoleRepository;
	
	@Autowired
	public UserController(UserRepository userRepository, UserRolesRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
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
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setEnabled(1);
			userRepository.save(user);
			UserRole userRole = new UserRole();
			userRole.setRole("ROLE_USER");
			userRole.setUserid(user.getUserId());
			userRoleRepository.save(userRole);
			return "redirect:/home";
		}
	}
	
//	@Transactional
//	@GetMapping("/edituser")
//	public String showEditUserForm(Model model) {
//		model.addAttribute("user", (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//		return "adduser";
//	}
//	@PostMapping("/edituser")
//	public String processEditUserForm(@Valid User user, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "edituser";
//		} else {
			//user.setPassword(passwordEncoder.encode(user.getPassword()));
//			User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			user.setUserId(currentUser.getUserId());
//			userRepository.save(user);
//			return "redirect:/home";
//		}
//	}

}
