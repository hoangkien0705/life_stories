package com.kienhv.stories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.kienhv.stories.entity.Users;
import com.kienhv.stories.mdl.UserUpdateMdl;
import com.kienhv.stories.repo.UserAuthTokenRepo;
import com.kienhv.stories.repo.UserRepo;
import com.kienhv.stories.repo.UserRoleRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserRoleRepo userRoleRepo;
	@Autowired
	private UserAuthTokenRepo userAuthTokenRepo;
	
	@Transactional
	public List<Users> getAllUser() {
		return userRepo.findAll();
	}
	
	@Transactional
	public Users UpdateUser(long idUser, UserUpdateMdl mdl) {
		Users users = userRepo.findOne(idUser);
		if(!StringUtils.isEmpty(mdl.getDisplayName())) {
			users.setDisplayName(mdl.getDisplayName());
		}
		if(!StringUtils.isEmpty(mdl.getTel())) {
			users.setTel(mdl.getTel());
		}
		if(!StringUtils.isEmpty(mdl.getAddress())) {
			users.setAddress(mdl.getAddress());
		}
		if(!StringUtils.isEmpty(mdl.getImageUrl())) {
			users.setImageUrl(mdl.getImageUrl());
		}
		if(!StringUtils.isEmpty(mdl.getDistributor())) {
			users.setDistributor(mdl.getDistributor());
		}
		userRepo.save(users);
		return users;
	}

	public void enableUser(long idUser, boolean enable) {
		Users user = userRepo.findOne(idUser);
		user.setEnabled(enable);
		userRepo.save(user);
	}

}
