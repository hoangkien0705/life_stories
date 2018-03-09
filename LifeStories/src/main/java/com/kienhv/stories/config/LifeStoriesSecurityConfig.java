package com.kienhv.stories.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.kienhv.stories.error.MyAccessDeniedHandler;
import com.kienhv.stories.service.StoriesUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LifeStoriesSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private MyAccessDeniedHandler accessDeniedHandler;
	
	@SuppressWarnings("unused")
	@Autowired
	 private DataSource dataSource;
	
	@Autowired
	private StoriesUserDetailService userDetailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            	.antMatchers("/css/**", "/fonts/**", "/image/**", "/js/**").permitAll()
				.antMatchers("/", "/home", "/about", "/logout","/register","/react").permitAll()//ai cung co the vao cac trang /  /home  /about (cac trang nay nguoi dung khong can xac thuc)
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")// chi cho phep user dang nhap voi quyen admin moi vao duong dan /admin/**
				.antMatchers("/user/**").access("hasRole('ROLE_USER')") //chi cho phep user dang nhap voi quyen user moi vao duong dan /user/**
				.anyRequest().authenticated()// tat ca moi trang khac deu phai thuc hien xac thuc tuc la: neu chua dang nhap thi phai thuc hien dang nhap moi dc vao trong
            .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/home", true).permitAll() //form login thi ai cung co the vao
			.and()
            .logout().permitAll().and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("select * from users where username=?")
	        .authoritiesByUsernameQuery("select username, role from user_roles where username=?"); */
		auth.userDetailsService(userDetailsService);
    }
	
}
