package pl.browarmistrz.controllers;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	public void hibInitializeMaltsAdditionsHops(Recipe recipe) {
		Hibernate.initialize(recipe.getMalts());
		Hibernate.initialize(recipe.getAdditions());
		Hibernate.initialize(recipe.getHops());
	}

	@RequestMapping(value = "/addrecipe", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showAddRecipeForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
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
			return "redirect:/recipe/userrecipes";
		}
	}
	
	@GetMapping("/editrecipe/{id}")
	@Transactional
	@PreAuthorize("hasRole('ROLE_USER')")
	public String editRecipe(Model model, @PathVariable int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		Recipe recipe = recipeRepository.getOne(id);
		hibInitializeMaltsAdditionsHops(recipe);
		model.addAttribute("recipe", recipe);
		return "addrecipe";
	}
	@PostMapping("/editrecipe/{id}")
	@Transactional
	public String processEditRecipe(@Valid Recipe recipe, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addrecipe";
		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			recipe.setUser(userRepository.findByUserName(auth.getName()));
			recipe.setAdded(recipeRepository.getOne(recipe.getId()).getAdded());
			recipeRepository.save(recipe);
			return "redirect:/recipe/userrecipes";
		}
	}
	
	@GetMapping("/deleterecipe/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	@Transactional
	public String deleteRecipe(@PathVariable int id) {
		Recipe recipe = recipeRepository.getOne(id);
		hibInitializeMaltsAdditionsHops(recipe);
		recipeRepository.delete(recipe);
		return "redirect:/recipe/userrecipes";
	}
	
	@GetMapping("/publicrecipes")
	public String showPublicRecipes(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		model.addAttribute("publicrecipes", recipeRepository.findPublicRecipes());
		return "publicrecipes";
	}
	
	@Transactional
	@GetMapping("/userrecipes")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showUserRecipes(Model model) {
		User user = userRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		Hibernate.initialize(user.getRecipes());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		model.addAttribute("userrecipes", user.getRecipes());
		return "userrecipes";
	}
	
	@Transactional
	@GetMapping("/showrecipe/{id}")
	public String showRecipe(@PathVariable int id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = auth.getName();
		model.addAttribute("loggeduser", loggedUserName);
		Recipe recipe = recipeRepository.findOne(id);
		hibInitializeMaltsAdditionsHops(recipe);
		if(recipe.isPublicRecipe()) {
			model.addAttribute("recipe", recipe);
			return "showrecipe";
		} else if(!recipe.isPublicRecipe() && recipe.getUser().getUserName().equals(loggedUserName)) {
			model.addAttribute("recipe", recipe);
			return "showrecipe";
		} else if(recipe.isPublicRecipe() && recipe.getUser().getUserName().equals(loggedUserName)) { // POZWALA EDYTOWAC I USUWAC CUDZE PRZEPISY
			model.addAttribute("recipe", recipe);
			model.addAttribute("showeditdelete", true);
			return "showrecipe";
		} else {
			return "redirect:/recipe/publicrecipes";
		}
	}
	
	@Transactional
	@GetMapping("/brewrecipe/{id}")
	public String brewRecipe(@PathVariable int id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		Recipe recipe = recipeRepository.findOne(id);
		hibInitializeMaltsAdditionsHops(recipe);
		if(recipe.isPublicRecipe()) {
			model.addAttribute("recipe", recipe);
			model.addAttribute("waterAmount", recipe.countWaterAmount());
			return "brewrecipe";
		} else {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/brewedrecipe/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String addToBrewed(@PathVariable int id) {
		Recipe recipe = recipeRepository.findOne(id);
		recipe.setBrewedRecipe(true);
		recipe.setBrewed(Calendar.getInstance());
		recipeRepository.save(recipe);
		return "redirect:/recipe/brewedrecipes";
	}
	
	@GetMapping("/brewedrecipes")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showBrewedRecipes(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		model.addAttribute("brewedrecipes", recipeRepository.findBrewedRecipes()); // ZWRACA UWARZONE PRZEPISY WSZYSTKICH UZYTKOWNIKOW
		return "brewedrecipes";
	}
	
	@ModelAttribute("beerstyles")
	public Collection<BeerStyle> beerStyles() {
		return this.beerStyleRepository.findAll();
	}

}
