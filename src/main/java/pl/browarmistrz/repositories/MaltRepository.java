package pl.browarmistrz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.browarmistrz.entities.Malt;

public interface MaltRepository extends JpaRepository<Malt, Integer>{

}
