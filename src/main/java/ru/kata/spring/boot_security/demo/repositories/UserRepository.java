package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u left join fetch u.roles where u.email=:email")
    Optional<User> findByEmail(String email);
    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.roles")
    List<User> findAllWithRoles();

}
