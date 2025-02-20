package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.ModuleRepository;
import com.app.entities.Module;
import com.app.models.ModuleDTO;

@Service
public class ModuleService {

    @Autowired private ModuleRepository repo;
    @Autowired private CourseService cservice;

    // Updated saveModule method to handle the new fields (moduleName and curriculumFilePath)
    public void saveModule(ModuleDTO dto) {
        Module module = new Module();
        module.setDescription(dto.getDescription());
        module.setTheoryhr(dto.getTheoryhr());
        module.setPracticalhr(dto.getPracticalhr());
        module.setCourse(cservice.findById(dto.getCourse_id()));
        
        // Set new fields from DTO
        module.setModuleName(dto.getModuleName());  // Set the module name
        module.setCurriculumFilePath(dto.getCurriculumFilePath());  // Set the curriculum file path

        repo.save(module);
    }

    public List<Module> listall() {
        return repo.findAll();
    }

    // Updated method to list modules by course, now it also considers the new fields
    public List<Module> listByCourse(int id) {
        return repo.findByCourse(cservice.findById(id));
    }

    public void deleteModule(int id) {
        repo.delete(repo.getById(id));
    }

    public Module findById(int id) {
        return repo.getById(id);
    }

    // Optional: Add methods to search by the new fields if needed.
    public List<Module> listByModuleName(String moduleName) {
        return repo.findByModuleName(moduleName);
    }

    public List<Module> listByCurriculumFilePath(String curriculumFilePath) {
        return repo.findByCurriculumFilePath(curriculumFilePath);
    }

    // Optionally, add a method to find by both course and module name
    public List<Module> listByCourseAndModuleName(int courseId, String moduleName) {
        return repo.findByCourseAndModuleName(cservice.findById(courseId), moduleName);
    }

    // Optionally, add a method to find by both course and curriculum file path
    public List<Module> listByCourseAndCurriculumFilePath(int courseId, String curriculumFilePath) {
        return repo.findByCourseAndCurriculumFilePath(cservice.findById(courseId), curriculumFilePath);
    }
}
