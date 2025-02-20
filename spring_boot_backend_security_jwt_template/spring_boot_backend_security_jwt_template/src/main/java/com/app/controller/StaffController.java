package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Staff;
import com.app.models.Credentials;
import com.app.models.StaffDTO;
import com.app.security.JwtUtil;
import com.app.services.StaffService;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody Credentials cr) {
		// authenticate user with authentication manager		
		Authentication auth = new UsernamePasswordAuthenticationToken(cr.getEmail(), cr.getPassword());
		System.out.println("BEFORE AUTH: " + auth);
		auth = authManager.authenticate(auth);
		System.out.println("AFTER AUTH: " + auth);
		// after authentication, create JWT token and return.
		String token = jwtUtil.createToken(auth);
		return ResponseEntity.ok(token);	
	}
	
	@GetMapping("/staff/all")
	public List<StaffDTO> getAllStaff() {
		List<StaffDTO> list = staffService.findAllStaff();
		return list;
	}
	@GetMapping("/staff/byname/{name}")
	public StaffDTO getStaffByName(@PathVariable("name") String name) {
		StaffDTO staff = staffService.getStaffByName(name);
		return staff;
	}
	@GetMapping("/staff/byemail/{email}")
	public StaffDTO getStaffByEmail(@PathVariable("email") String email) {
		StaffDTO staff = staffService.getStaffByEmail(email);
		return staff;
	}
	@GetMapping("/staff/byid/{staffId}")
	public StaffDTO getStaffByName(@PathVariable("staffId") int staffId) {
		StaffDTO staff = staffService.getStaffById(staffId);
		return staff;
	}
}
