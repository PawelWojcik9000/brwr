package pl.browarmistrz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class HomeController {
	
	@RequestMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
}
