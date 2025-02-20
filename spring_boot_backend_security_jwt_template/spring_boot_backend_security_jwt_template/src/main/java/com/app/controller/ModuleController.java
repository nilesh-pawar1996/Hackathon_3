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

import com.app.models.ModuleDTO;
import com.app.services.ModuleService;

@CrossOrigin
@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired private ModuleService module;

    // Updated save method to handle the new fields (moduleName, curriculumFilePath)
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ModuleDTO dto) {        
        module.saveModule(dto);
        System.out.println(dto);
        return ResponseEntity.ok("Module registered successfully");
    }

    // Get all modules
    @GetMapping
    public ResponseEntity<?> findAll() {    
        System.out.println(module.listall());
        return ResponseEntity.ok(module.listall());
    }

    // Get modules by course ID
    @GetMapping("course/{id}")
    public ResponseEntity<?> findByCourse(@PathVariable("id") int id) {        
        return ResponseEntity.ok(module.listByCourse(id));
    }

    // Get a module by its ID
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {        
        return ResponseEntity.ok(module.findById(id));
    }

    // Delete a module by ID
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        module.deleteModule(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    // Optional: Endpoint to find modules by moduleName
    @GetMapping("/name/{moduleName}")
    public ResponseEntity<?> findByModuleName(@PathVariable("moduleName") String moduleName) {
        return ResponseEntity.ok(module.listByModuleName(moduleName));
    }

    // Optional: Endpoint to find modules by curriculumFilePath
    @GetMapping("/file/{curriculumFilePath}")
    public ResponseEntity<?> findByCurriculumFilePath(@PathVariable("curriculumFilePath") String curriculumFilePath) {
        return ResponseEntity.ok(module.listByCurriculumFilePath(curriculumFilePath));
    }

    // Optional: Endpoint to find modules by course ID and module name
    @GetMapping("course/{courseId}/name/{moduleName}")
    public ResponseEntity<?> findByCourseAndModuleName(@PathVariable("courseId") int courseId, @PathVariable("moduleName") String moduleName) {
        return ResponseEntity.ok(module.listByCourseAndModuleName(courseId, moduleName));
    }

    // Optional: Endpoint to find modules by course ID and curriculum file path
    @GetMapping("course/{courseId}/file/{curriculumFilePath}")
    public ResponseEntity<?> findByCourseAndCurriculumFilePath(@PathVariable("courseId") int courseId, @PathVariable("curriculumFilePath") String curriculumFilePath) {
        return ResponseEntity.ok(module.listByCourseAndCurriculumFilePath(courseId, curriculumFilePath));
    }
}
