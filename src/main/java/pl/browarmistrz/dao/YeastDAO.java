package pl.browarmistrz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.browarmistrz.entities.Yeast;

@Repository
@Transactional
public class YeastDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveYeast(Yeast entity) {
		entityManager.persist(entity);
	}
	
	public List<Yeast> getYeasts() {
		Query query = entityManager.createQuery("SELECT b FROM Yeast b");
		List<Yeast> yeasts = query.getResultList();
		return yeasts;
	}
	
	public Yeast findById(int id) {
		return entityManager.find(Yeast.class, id);
	}
}
