package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Course;
import com.app.entities.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    List<Module> findByCourse(Course course);

    // Custom query method to find modules by moduleName
    List<Module> findByModuleName(String moduleName);

    // Custom query method to find modules by curriculumFilePath
    List<Module> findByCurriculumFilePath(String curriculumFilePath);

    // You can combine both to find modules by course and moduleName
    List<Module> findByCourseAndModuleName(Course course, String moduleName);

    // Similarly, you can find modules by course and curriculumFilePath
    List<Module> findByCourseAndCurriculumFilePath(Course course, String curriculumFilePath);
}
