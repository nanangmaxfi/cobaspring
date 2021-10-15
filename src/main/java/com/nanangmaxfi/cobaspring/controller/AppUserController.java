package com.nanangmaxfi.cobaspring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanangmaxfi.cobaspring.dto.AppUserData;
import com.nanangmaxfi.cobaspring.dto.ResponseData;
import com.nanangmaxfi.cobaspring.models.entities.AppUser;
import com.nanangmaxfi.cobaspring.services.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData){
		ResponseData<AppUser> response = new ResponseData<>();
		AppUser appUser = modelMapper.map(userData, AppUser.class);
		response.setPayload(appUserService.registerAppUser(appUser));
		response.setStatus(true);
		response.getMessages().add("AppUser saved");
		return ResponseEntity.ok(response);
	}
}
