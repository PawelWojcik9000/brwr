package pl.browarmistrz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.browarmistrz.entities.Recipe;
import pl.browarmistrz.entities.Yeast;

@Component
@Transactional
public class RecipeDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveRecipe(Recipe entity) {
		entityManager.persist(entity);
	}
	
	public List<Recipe> getRecipes() {
		Query query = entityManager.createQuery("SELECT b FROM Recipe b");
		List<Recipe> recipes = query.getResultList();
		return recipes;
	}
	
	public Recipe findById(int id) {
		return entityManager.find(Recipe.class, id);
	}
	
}
