package pl.browarmistrz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.browarmistrz.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
