package pl.browarmistrz.controllers;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.browarmistrz.entities.BeerStyle;
import pl.browarmistrz.entities.Recipe;
import pl.browarmistrz.entities.User;
import pl.browarmistrz.repositories.AdditionRepository;
import pl.browarmistrz.repositories.BeerStyleRepository;
import pl.browarmistrz.repositories.HopRepository;
import pl.browarmistrz.repositories.MaltRepository;
import pl.browarmistrz.repositories.RecipeRepository;
import pl.browarmistrz.repositories.UserRepository;
import pl.browarmistrz.repositories.YeastRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	private final MaltRepository maltRepository;
	private final AdditionRepository additionRepository;
	private final HopRepository hopRepository;
	private final RecipeRepository recipeRepository;
	private final YeastRepository yeastRepository;
	private final BeerStyleRepository beerStyleRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public RecipeController(MaltRepository maltRepository, AdditionRepository additionRepository, 
							HopRepository hopRepository, RecipeRepository recipeRepository, 
							YeastRepository yeastRepository, BeerStyleRepository beerStyleRepository, 
							UserRepository userRepository) {
		this.maltRepository = maltRepository;
		this.additionRepository = additionRepository;
		this.hopRepository = hopRepository;
		this.recipeRepository = recipeRepository;
		this.yeastRepository = yeastRepository;
		this.beerStyleRepository = beerStyleRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/addrecipe", method = RequestMethod.GET)
	public String showAddRecipeForm(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "addrecipe";
	}
	@RequestMapping(value = "/addrecipe", method = RequestMethod.POST)
	public String processForm(@Valid Recipe recipe, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addrecipe";
		} else {
			recipe.setAdded(Calendar.getInstance());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			recipe.setUser(userRepository.findByUserName(auth.getName()));
			recipeRepository.save(recipe);
			return "redirect:/recipe/publicrecipes";
		}
	}
	
	@GetMapping("/publicrecipes")
	public String showPublicRecipes(Model model) {
		model.addAttribute("publicrecipes", recipeRepository.findPublicRecipes());
		return "publicrecipes";
	}
	
	@Transactional
	@GetMapping("/userrecipes")
	public String showUserRecipes(Model model) {
		User user = userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		Hibernate.initialize(user.getRecipes());
		model.addAttribute("userrecipes", user.getRecipes());
		return "userrecipes";
	}
	
	@Transactional
	@GetMapping("/showrecipe/{id}")
	public String showRecipe(@PathVariable int id, Model model) {
		Recipe recipe = recipeRepository.findOne(id);
		Hibernate.initialize(recipe.getMalts());
		Hibernate.initialize(recipe.getAdditions());
		Hibernate.initialize(recipe.getHops());
		if(recipe.isPublicRecipe()) {
			model.addAttribute("recipe", recipe);
			return "showrecipe";
		} else {
			return "redirect:/recipe/publicrecipes";
		}
	}
	
	@Transactional
	@GetMapping("/brewrecipe/{id}")
	public String brewRecipe(@PathVariable int id, Model model) {
		Recipe recipe = recipeRepository.findOne(id);
		Hibernate.initialize(recipe.getMalts());
		Hibernate.initialize(recipe.getAdditions());
		Hibernate.initialize(recipe.getHops());
		if(recipe.isPublicRecipe()) {
			model.addAttribute("recipe", recipe);
			model.addAttribute("waterAmount", recipe.countWaterAmount());
			return "brewrecipe";
		} else {
			return "redirect:/home";
		}
	}
	
	@ModelAttribute("beerstyles")
	public Collection<BeerStyle> beerStyles() {
		return this.beerStyleRepository.findAll();
	}

}
