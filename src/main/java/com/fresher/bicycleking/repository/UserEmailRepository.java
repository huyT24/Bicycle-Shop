package com.fresher.bicycleking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.UserEmail;

@Repository
public interface UserEmailRepository extends JpaRepository<UserEmail, Long>{
	Optional<UserEmail> findUserEmailByEmailAccount(String email);
	boolean existsByEmailAccount(String email);
}
