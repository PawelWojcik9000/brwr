package pl.browarmistrz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.browarmistrz.entities.BeerStyle;

public interface BeerStyleRepository extends JpaRepository<BeerStyle, Integer>{

}
