package com.app.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDTO {
    private int course_id;
    private int module_id;
    private String staff_id;
    private LocalDate date; // Representing the date of the schedule
    private LocalTime startTime; // Representing the start time of the schedule
    private LocalTime endTime; // Representing the end time of the schedule
    private String type; // Lecture/Lab
    private String group; // Theory/E1/E2
    private String venue; // Venue where the class is held

    // Getters and Setters
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "ScheduleDTO [course_id=" + course_id + ", module_id=" + module_id + ", staff_id=" + staff_id
                + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + ", type=" + type
                + ", group=" + group + ", venue=" + venue + "]";
    }
}
