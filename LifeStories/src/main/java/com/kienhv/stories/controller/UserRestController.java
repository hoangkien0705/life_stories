package com.kienhv.stories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kienhv.stories.entity.Users;
import com.kienhv.stories.mdl.ReponseMdl;
import com.kienhv.stories.mdl.UserUpdateMdl;
import com.kienhv.stories.service.UserService;

@RestController
@RequestMapping("/public")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/greet")
	public String greet() {
		return "greet";
	}
	
	@RequestMapping(value = "/getAllUser", method = { RequestMethod.GET })
	public ResponseEntity<ReponseMdl> getAllUser() {
		List<Users> list = userService.getAllUser();
		ReponseMdl reponseMdl = ReponseMdl.getInsSuccess();
		reponseMdl.setData(list);
		return new ResponseEntity<ReponseMdl>(reponseMdl, HttpStatus.OK);
	}
	
	/*
	 * Headers
	 * [{"key":"Content-Type","value":"application/json","description":""}] ==> Content-Type : application/json
	 * [{"key":"Accept","value":"application/json","description":""}]		==> Accept: application/json
	 * Body raw
	 * {
			"displayName": "Hoang Kien",
			"tel":"0969951417",
			"address": "Trực đại trực ninh Nam đinh",
			"imageUrl": "http://img/demo/1.png",
			"distributor":"Nhà phân phối"
		}
	 */
	@RequestMapping(value = "/updateUser/{idUser}", method = { RequestMethod.POST }, headers = {"Content-Type=application/json" })
	public ResponseEntity<ReponseMdl> UpdateUser(@PathVariable("idUser") long idUser, @RequestBody UserUpdateMdl mdl) {
		try {
			userService.UpdateUser(idUser, mdl);
			ReponseMdl reponseMdl = ReponseMdl.getInsSuccess();
			reponseMdl.setData(true);
			return new ResponseEntity<ReponseMdl>(reponseMdl, HttpStatus.OK);
		} catch (Exception e) {
			ReponseMdl reponseMdl = ReponseMdl.getInsErrorDefault();
			reponseMdl.setData(false);
			return new ResponseEntity<ReponseMdl>(reponseMdl, HttpStatus.OK);
		}
	}
	
	// remove Content-Type : application/json , Accept: application/json
	@RequestMapping(value = "/enableUser/{idUser}", method = { RequestMethod.POST }, headers = {"Content-Type=application/json" })
	public ResponseEntity<ReponseMdl> enableUser(@PathVariable("idUser") long idUser,  @RequestParam("enable") boolean enable) {
		try {
			userService.enableUser(idUser, enable);
			ReponseMdl reponseMdl = ReponseMdl.getInsSuccess();
			reponseMdl.setData(true);
			return new ResponseEntity<ReponseMdl>(reponseMdl, HttpStatus.OK);
		} catch (Exception e) {
			ReponseMdl reponseMdl = ReponseMdl.getInsErrorDefault();
			reponseMdl.setData(false);
			return new ResponseEntity<ReponseMdl>(reponseMdl, HttpStatus.OK);
		}
	}
}
