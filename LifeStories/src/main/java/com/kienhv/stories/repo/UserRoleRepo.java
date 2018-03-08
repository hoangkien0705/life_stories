package com.kienhv.stories.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kienhv.stories.entity.UserRoles;

public interface UserRoleRepo extends JpaRepository<UserRoles, Long> {
	
	List<UserRoles> findByUsername(String username);

}
