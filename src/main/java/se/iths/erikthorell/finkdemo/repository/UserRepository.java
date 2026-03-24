package se.iths.erikthorell.finkdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.erikthorell.finkdemo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}