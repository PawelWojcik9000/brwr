package pl.browarmistrz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.browarmistrz.entities.Yeast;

public interface YeastRepository extends JpaRepository<Yeast, Integer>{

}
