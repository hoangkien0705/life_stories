package com.kienhv.stories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kienhv.stories.entity.UserRoles;
import com.kienhv.stories.entity.Users;
import com.kienhv.stories.repo.UserRepo;
import com.kienhv.stories.repo.UserRoleRepo;
import com.kienhv.stories.website.StoriesUserDetails;

@Service
public class StoriesUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserRoleRepo userRoleRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u = userRepo.findByUsername(username);
		if (u == null || !u.isEnabled() || !u.isAccountNonLocked() || !u.isAccountNonExpired())
			return null;
		List<UserRoles> listRole = userRoleRepo.findByUsername(username);
		
		StoriesUserDetails storiesUserDetails = StoriesUserDetails.newInstance(u);
		if (listRole.size() == 0) {
			storiesUserDetails.addAuthorities("ROLE_USER");
		} else {
			for (int i = 0; i < listRole.size(); i++) {
				storiesUserDetails.addAuthorities(listRole.get(i).getRole());
			}
		}
		return storiesUserDetails;
	}

}
