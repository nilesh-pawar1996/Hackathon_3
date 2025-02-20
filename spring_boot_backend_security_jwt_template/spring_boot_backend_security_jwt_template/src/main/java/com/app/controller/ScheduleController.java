package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.models.ScheduleDTO;

import com.app.services.ScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
@Autowired private ScheduleService schedules;
	
	@PostMapping("/validate")
	public ResponseEntity<?> save( ScheduleService dto) {	
		System.out.println("inside save........................................................"+dto);
		schedules.saveSchedule(dto);
		System.out.println(dto);
		return ResponseEntity.ok("Task registered successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {	
	System.out.println(schedules.listAll());
		return ResponseEntity.ok(schedules.listAll());
	}
	
	@GetMapping("course/{id}")
	
	public ResponseEntity<?> findAll(@PathVariable("id") int id) {		
		return ResponseEntity.ok(schedules.listByCourse(id));
	}
	
	@GetMapping("staff/{id}")
	public ResponseEntity<?> findAll(@PathVariable("id") String id) {		
		return ResponseEntity.ok(schedules.listByStaff(id));
	}
	//Rename methode name if not working
	@GetMapping("module/{id}")
	public ResponseEntity<?> findAllModule(@PathVariable("id") int id) {		
		return ResponseEntity.ok(schedules.listByModule(id));
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(schedules.findById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		schedules.deleteTask(id);
		return ResponseEntity.ok("Deleted successfully");
	}
}
