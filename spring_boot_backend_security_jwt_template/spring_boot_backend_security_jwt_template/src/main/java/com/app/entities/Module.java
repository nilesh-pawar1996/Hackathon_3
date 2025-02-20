package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String moduleName;  // Added field for module name
    private String curriculumFilePath;  // Added field for curriculum file path

    private String description;
    private double theoryhr;
    private double practicalhr;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime createdon;

    // Default constructor initializes createdon
    public Module() {
        this.createdon = LocalDateTime.now();
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCurriculumFilePath() {
        return curriculumFilePath;
    }

    public void setCurriculumFilePath(String curriculumFilePath) {
        this.curriculumFilePath = curriculumFilePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTheoryhr() {
        return theoryhr;
    }

    public void setTheoryhr(double theoryhr) {
        this.theoryhr = theoryhr;
    }

    public double getPracticalhr() {
        return practicalhr;
    }

    public void setPracticalhr(double practicalhr) {
        this.practicalhr = practicalhr;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedon() {
        return createdon;
    }

    public void setCreatedon(LocalDateTime createdon) {
        this.createdon = createdon;
    }

    @Override
    public String toString() {
        return "Module [id=" + id + ", moduleName=" + moduleName + ", curriculumFilePath=" + curriculumFilePath
                + ", description=" + description + ", theoryhr=" + theoryhr + ", practicalhr=" + practicalhr
                + ", course=" + course + ", createdon=" + createdon + "]";
    }
}
