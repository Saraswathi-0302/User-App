package com.jspiders.User_App.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.User_App.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

	Optional<User> findByuserEmail(String email);
	List<User> findByuserName(String name);
}

