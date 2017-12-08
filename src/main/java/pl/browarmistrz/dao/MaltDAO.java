package pl.browarmistrz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.browarmistrz.entities.Malt;
import pl.browarmistrz.entities.Recipe;

@Component
@Transactional
public class MaltDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveMalt(Malt entity) {
		entityManager.persist(entity);
	}
	
	public List<Malt> getMalts() {
		Query query = entityManager.createQuery("SELECT b FROM Malt b");
		List<Malt> malts = query.getResultList();
		return malts;
	}
	
	public Malt findById(int id) {
		return entityManager.find(Malt.class, id);
	}
}
