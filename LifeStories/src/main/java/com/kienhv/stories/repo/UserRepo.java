package com.kienhv.stories.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kienhv.stories.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
	Users findByUsername(String username);

}
