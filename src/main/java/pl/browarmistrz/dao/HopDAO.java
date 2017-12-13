package pl.browarmistrz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.browarmistrz.entities.Hop;

@Repository
@Transactional
public class HopDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void saveHop(Hop entity) {
		entityManager.persist(entity);
	}
	
	public List<Hop> getHops() {
		Query query = entityManager.createQuery("SELECT b FROM Hop b");
		List<Hop> hops = query.getResultList();
		return hops;
	}
	
	public Hop findById(int id) {
		return entityManager.find(Hop.class, id);
	}

}
