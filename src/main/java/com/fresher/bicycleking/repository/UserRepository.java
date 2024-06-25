package com.fresher.bicycleking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findUserById(Long id);
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
}
