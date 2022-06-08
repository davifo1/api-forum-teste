package io.davifo.forum.repository;

import io.davifo.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

     Optional<User> findByUsername(String username);
}
