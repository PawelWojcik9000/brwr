package pl.browarmistrz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.browarmistrz.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	@Query("SELECT r FROM Recipe r WHERE r.publicRecipe = true")
	List<Recipe> findPublicRecipes();

}
