package pl.browarmistrz.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.browarmistrz.entities.Recipe;

@Component
@Transactional
public class RecipeDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveRecipe(Recipe entity) {
		entityManager.persist(entity);
	}
	
	
}
