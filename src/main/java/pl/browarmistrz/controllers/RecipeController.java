package pl.browarmistrz.controllers;

import java.util.Calendar;
import java.util.Collection;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.browarmistrz.entities.BeerStyle;
import pl.browarmistrz.entities.Recipe;
import pl.browarmistrz.entities.User;
import pl.browarmistrz.repositories.BeerStyleRepository;
import pl.browarmistrz.repositories.RecipeRepository;
import pl.browarmistrz.repositories.UserRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	private final RecipeRepository recipeRepository;
	private final BeerStyleRepository beerStyleRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public RecipeController(RecipeRepository recipeRepository, BeerStyleRepository beerStyleRepository, 
							UserRepository userRepository) {
		this.recipeRepository = recipeRepository;
		this.beerStyleRepository = beerStyleRepository;
		this.userRepository = userRepository;
	}
	
	public void hibInitializeMaltsAdditionsHops(Recipe recipe) {
		Hibernate.initialize(recipe.getMalts());
		Hibernate.initialize(recipe.getAdditions());
		Hibernate.initialize(recipe.getHops());
	}
	
	public void setLoggedUserAttribute(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
	}

	@RequestMapping(value = "/addrecipe", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showAddRecipeForm(Model model) {
		setLoggedUserAttribute(model);
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
		setLoggedUserAttribute(model);
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
		setLoggedUserAttribute(model);
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
		if(recipe.getUser().getUserName().equals(loggedUserName)) {
			model.addAttribute("recipe", recipe);
			model.addAttribute("showeditdelete", true);
			return "showrecipe";
		} else if(recipe.isPublicRecipe() && !recipe.getUser().getUserName().equals(loggedUserName)) {
			model.addAttribute("recipe", recipe);
			model.addAttribute("showeditdelete", false);
			return "showrecipe";
		} else {
			return "redirect:/recipe/publicrecipes";
		}
	}
	
	@Transactional
	@GetMapping("/brewrecipe/{id}")
	public String brewRecipe(@PathVariable int id, Model model) {
		setLoggedUserAttribute(model);
		Recipe recipe = recipeRepository.findOne(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = auth.getName();
		hibInitializeMaltsAdditionsHops(recipe);
		if(recipe.isPublicRecipe() || recipe.getUser().getUserName().equals(loggedUserName)) {
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(recipe.getUser().getUserName().equals(auth.getName())) {
			recipe.setBrewedRecipe(true);
			recipe.setBrewed(Calendar.getInstance());
			recipeRepository.save(recipe);
			return "redirect:/recipe/brewedrecipes";
		} else {
			return "redirect:/recipe/brewedrecipes";
		}
	}
	
	@GetMapping("/brewedrecipes")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showBrewedRecipes(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loggeduser", auth.getName());
		model.addAttribute("brewedrecipes", recipeRepository.findBrewedRecipes(auth.getName())); 
		return "brewedrecipes";
	}
	
	@GetMapping("/recipes")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String pageForAdminRecipes(Model model) {
		setLoggedUserAttribute(model);
		model.addAttribute("recipes", recipeRepository.findAll());
		return "recipes";
	}
	
	@GetMapping("/admin/deleterecipe/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional
	public String deleteUser(@PathVariable int id) {
		recipeRepository.delete(id);
		return "redirect:/recipe/recipes";
	}

	@GetMapping("/calculateABV")
	public String calculateAbv() {
		return "calculateabv";
	}
	@PostMapping("/calculateABV")
	public String processCalculateAbv(Model model, @RequestParam(name="og") Double og, @RequestParam(name="fg") Double fg) {
		String alcoholByVolume;
		String str;
		Double abv;
			
		try {
			abv = (og-fg)/1.938;
			str = abv.toString();
			alcoholByVolume = str.substring(0, 4)+"%";
		} catch (NumberFormatException e) {
			alcoholByVolume = "Niepoprawne dane wejściowe";
			model.addAttribute("abv", alcoholByVolume);
			return "calculateabv";
			//e.printStackTrace();
		} catch (NullPointerException e) {
			alcoholByVolume = "Brak danych wejściowych";
			model.addAttribute("abv", alcoholByVolume);
			return "calculateabv";
		} catch (IndexOutOfBoundsException e) {
			alcoholByVolume = "Wartości muszą się różnić";
			model.addAttribute("abv", alcoholByVolume);
			return "calculateabv";
		}
		
		if(og <= 0 || fg <= 0) {
			alcoholByVolume = "Wartości muszą być dodatnie";
		}
		
		model.addAttribute("abv", alcoholByVolume);

		return "calculateabv";
	}
	
	@ModelAttribute("beerstyles")
	public Collection<BeerStyle> beerStyles() {
		return this.beerStyleRepository.findAll();
	}

}
