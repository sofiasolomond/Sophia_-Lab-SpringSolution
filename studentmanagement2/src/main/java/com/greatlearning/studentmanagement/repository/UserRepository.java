package com.greatlearning.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.greatlearning.studentmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// User and Username are taken from User Entity file
	@Query("select u from User u where u.userName = ?1")
	public User getUserByUsername(String username);
}
