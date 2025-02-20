package com.app.models;

public class LogsDTO {
    
    private int module_id;
    private int course_id;
    private int staff_id;
    private String date;
    private String group_name;
    private String startTime;
    private String endTime;
    private String assignmentGiven;
    private String studenProgress;
    private String type; // Lecture or Lab
    private String topicsTaught; // Topics covered in the lecture

    public int getModule_id() {
        return module_id;
    }
    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }
    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    public int getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getGroup_name() {
        return group_name;
    }
    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getAssignmentGiven() {
        return assignmentGiven;
    }
    public void setAssignmentGiven(String assignmentGiven) {
        this.assignmentGiven = assignmentGiven;
    }
    public String getStudenProgress() {
        return studenProgress;
    }
    public void setStudenProgress(String studenProgress) {
        this.studenProgress = studenProgress;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTopicsTaught() {
        return topicsTaught;
    }
    public void setTopicsTaught(String topicsTaught) {
        this.topicsTaught = topicsTaught;
    }

    @Override
    public String toString() {
        return "LogsDTO [module_id=" + module_id + ", course_id=" + course_id + ", staff_id=" + staff_id + ", date="
                + date + ", group_name=" + group_name + ", startTime=" + startTime + ", endTime=" + endTime
                + ", assignmentGiven=" + assignmentGiven + ", studenProgress=" + studenProgress + ", type=" + type + ", topicsTaught=" + topicsTaught + "]";
    }
}
