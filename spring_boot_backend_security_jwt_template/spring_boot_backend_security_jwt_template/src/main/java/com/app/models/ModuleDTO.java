package com.app.models;

public class ModuleDTO {

    private String moduleName;  // Added field for module name
    private String curriculumFilePath;  // Added field for curriculum file path
    private String description;
    private int course_id;
    private double theoryhr;
    private double practicalhr;

    // Getters and setters
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

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
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

    @Override
    public String toString() {
        return "ModuleDTO [moduleName=" + moduleName + ", curriculumFilePath=" + curriculumFilePath + ", description=" 
                + description + ", course_id=" + course_id + ", theoryhr=" + theoryhr + ", practicalhr=" + practicalhr + "]";
    }
}
