package com.fresher.bicycleking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresher.bicycleking.entity.UserFacebook;

@Repository
public interface UserFacebookRepository extends JpaRepository<UserFacebook, Long>{

}
