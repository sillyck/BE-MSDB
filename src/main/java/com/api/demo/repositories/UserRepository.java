package com.api.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public abstract Optional<User> findByUsername(String username);
}
