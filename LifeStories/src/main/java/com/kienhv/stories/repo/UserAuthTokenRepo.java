package com.kienhv.stories.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kienhv.stories.entity.UserAuthToken;
import com.kienhv.stories.entity.Users;

public interface UserAuthTokenRepo extends JpaRepository<UserAuthToken, Long>{

}
