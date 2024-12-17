package com.pramod.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramod.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	boolean existsByEmail(String email);
	Optional<User> findByEmail(String username);
 
}
