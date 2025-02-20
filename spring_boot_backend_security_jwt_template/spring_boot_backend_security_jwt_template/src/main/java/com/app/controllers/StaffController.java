package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.StaffDao;
import com.app.entities.Staff;
import com.app.models.Credentials;
import com.app.services.StaffService;

@RestController
public class StaffController {
	@Autowired
	private StaffService staffService;
	@PostMapping("/authenticate")
	public Staff authenticate(@RequestBody Credentials cr) {
		System.out.println(cr);
		Staff dbStaff = staffService.getStaffByCredentials(cr);
		if(dbStaff != null)
			return dbStaff;
		return null;
	}
}
