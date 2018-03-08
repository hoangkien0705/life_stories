package com.kienhv.stories.website;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kienhv.stories.entity.Users;
import com.kienhv.stories.utils.DateUtils;

public class StoriesUserDetails implements UserDetails {

	private String username, password, email, displayName, tel, address, imageUrl, distributor;
	private boolean accountNonExpired, accountNonLocked, enabled, credentialsNonExpired;
	private Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	private Date createdDate;
	private static final long serialVersionUID = 3833059027004274663L;
	
	public StoriesUserDetails() {
		
	}
	
	private StoriesUserDetails(Users u) {
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.email = u.getEmail();
		this.displayName = u.getDisplayName();
		this.tel = u.getTel();
		this.address = u.getAddress();
		this.imageUrl = u.getImageUrl();
		this.distributor = u.getDistributor();
		this.accountNonExpired = u.isAccountNonExpired();
		this.accountNonLocked = u.isAccountNonLocked();
		this.enabled = u.isEnabled();
		this.credentialsNonExpired = u.isCredentialsNonExpired();
		this.createdDate = DateUtils.getInstance().convertStringToDate(u.getCreatedDate());
	}
	
	public static StoriesUserDetails newInstance(Users u) {
		return new StoriesUserDetails(u);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void addAuthorities(String... newRole) {
		for (String string : newRole) {
			this.authorities.add(new SimpleGrantedAuthority(string));
		}
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

}
