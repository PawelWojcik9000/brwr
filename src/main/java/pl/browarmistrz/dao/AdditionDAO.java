package pl.browarmistrz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.browarmistrz.entities.Addition;

@Repository
@Transactional
public class AdditionDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveAddition(Addition entity) {
		entityManager.persist(entity);
	}
	
	public List<Addition> getAdditions() {
		Query query = entityManager.createQuery("SELECT d FROM Addition d");
		List<Addition> additions = query.getResultList();
		return additions;
	}
	
	public Addition findById(int id) {
		return entityManager.find(Addition.class, id);
	}
}
