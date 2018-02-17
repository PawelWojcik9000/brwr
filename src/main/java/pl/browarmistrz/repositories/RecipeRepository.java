package pl.browarmistrz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.browarmistrz.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	@Query("SELECT r FROM Recipe r WHERE r.publicRecipe = true")
	List<Recipe> findPublicRecipes();
	
	@Query("SELECT r FROM Recipe r WHERE r.user.userName LIKE %:searchTerm% AND r.brewedRecipe = true")
	List<Recipe> findBrewedRecipes(@Param("searchTerm") String searchTerm);

}
