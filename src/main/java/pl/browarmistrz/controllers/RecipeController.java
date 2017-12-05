package pl.browarmistrz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.browarmistrz.dao.RecipeDAO;
import pl.browarmistrz.entities.Malt;
import pl.browarmistrz.entities.Recipe;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeDAO recipeDAO;
	


	@RequestMapping("/addedrecipe")
	public String addedRecipe(HttpServletRequest request) {
		String brewName = request.getParameter("brewName");
		
		System.out.println(brewName);

		Recipe recipe = new Recipe(brewName);
		recipeDAO.saveRecipe(recipe);
		return "addedrecipe";
	}

	@RequestMapping("/addrecipe")
	public String addRecipe() {
		return "addrecipe";
	}

}
