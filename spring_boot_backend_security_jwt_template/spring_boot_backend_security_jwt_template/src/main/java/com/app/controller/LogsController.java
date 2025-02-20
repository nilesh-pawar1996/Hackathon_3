package com.app.controller;

import java.util.List;

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

import com.app.entities.LogsSheet;
import com.app.models.LogsDTO;
import com.app.services.LogsService;


@CrossOrigin
@RestController
@RequestMapping("/api/logs")
public class LogsController {
	
	@Autowired private LogsService logs;
	
	//Save Log method
	
//	@PostMapping("/savelog/{id}")
//	public ResponseEntity<?> save(@RequestBody LogsDTO dto ,@PathVariable("id") int id) {	
//		System.out.println("inside savelog........................................................"+dto);
//		logs.saveLog(dto);
//		System.out.println(dto);
//		return ResponseEntity.ok("Log registered successfully");
//	}
	@PostMapping("/savelog")
	public ResponseEntity<?> save( LogsDTO dto) {	
		System.out.println("inside savelog........................................................"+dto);
		logs.saveLog(dto);
		System.out.println(dto);
		return ResponseEntity.ok("Log registered successfully");
	}

	@GetMapping("/staff/{staffId}")
	public ResponseEntity<?> getLogsByStaffId(@PathVariable String staffId) {
	    List<LogsSheet> log = logs.listByStaffId(staffId);
	    return ResponseEntity.ok(log);
	}
	
	//get all logs method
	
	@GetMapping
	public ResponseEntity<?> findAll() {	
	System.out.println(logs.listAll());
		return ResponseEntity.ok(logs.listAll());
	}
	
	
	//get all course method
	
    @GetMapping("course/{id}")
    public ResponseEntity<?> findAll(@PathVariable("id") int id) {		
		return ResponseEntity.ok(logs.listByCourse(id));
	}
	
    
  //get all module method
    
//    @GetMapping("module/{id}")
//	public ResponseEntity<?> findAllModule(@PathVariable("id") int id) {		
//		return ResponseEntity.ok(logs.listByModule(id));
//	}
    
    //search method
    @GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(logs.findById(id));
	}
    
	//delete method
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		logs.deleteLog(id);
		return ResponseEntity.ok("Deleted successfully");
	}
    
    
}
