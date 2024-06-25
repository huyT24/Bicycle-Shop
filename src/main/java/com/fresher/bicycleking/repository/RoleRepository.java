package com.fresher.bicycleking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String roleName);
}
