package pl.browarmistrz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.browarmistrz.dao.RecipeDAO;
import pl.browarmistrz.entities.Recipe;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeDAO recipeDAO;

	@RequestMapping(value = "/addrecipe", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "addrecipe";
	}

	@RequestMapping(value = "/addrecipe", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Recipe recipe) {
		System.out.println(recipe.getBrewName());
		recipeDAO.saveRecipe(recipe);
		return "addedrecipe";
	}

}
