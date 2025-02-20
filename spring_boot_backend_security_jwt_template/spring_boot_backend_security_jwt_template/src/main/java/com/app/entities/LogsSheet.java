package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.models.StaffDTO;

@Entity
public class LogsSheet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
   
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    
    private String date;
    private String group_name;
    private String startTime;
    private String endTime;
    private String assignmentGiven;
    private String studenProgress;
    private String status; // "Pending", "Approved", "Rejected"
    
    private String type; // Lecture or Lab
    private String topicsTaught; // Topics covered in the lecture

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
        return "LogsSheet [id=" + id + ", module=" + module + ", course=" + course + ", staff=" + staff + ", date="
                + date + ", group_name=" + group_name + ", startTime=" + startTime + ", endTime=" + endTime
                + ", assignmentGiven=" + assignmentGiven + ", studenProgress=" + studenProgress + ", status="
                + status + ", type=" + type + ", topicsTaught=" + topicsTaught + "]";
    }
	
}
