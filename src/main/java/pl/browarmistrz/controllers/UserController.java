package pl.browarmistrz.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String pageForAdminUsers(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
	
	@GetMapping("/activatedeactivate/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	public String activateDeactivateUser(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		if(user.getEnabled() == 1) {
			user.setEnabled(0);
		} else {
			user.setEnabled(1);
		}
		userRepository.save(user);
		return "redirect:/user/users";
	}
	
	@GetMapping("/deleteuser/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	public String deleteUser(@PathVariable Long id) {
		userRepository.delete(id);
		return "redirect:/user/users";
	}

}
