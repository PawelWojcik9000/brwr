package pl.browarmistrz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.browarmistrz.entities.Addition;

public interface AdditionRepository extends JpaRepository<Addition, Integer>{

}
