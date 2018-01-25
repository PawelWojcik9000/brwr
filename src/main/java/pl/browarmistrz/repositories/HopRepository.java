package pl.browarmistrz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.browarmistrz.entities.Hop;

public interface HopRepository extends JpaRepository<Hop, Integer>{

}
