package com.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.ScheduleRepository;
import com.app.entities.Schedules;
import com.app.models.ScheduleDTO;

@Service
public class ScheduleService {

    @Autowired 
    private ScheduleRepository tskrp;
    
    @Autowired 
    private CourseService cservice;
    
    @Autowired 
    private ModuleService mservice;
    
    @Autowired 
    private StaffService sservice;
    
    public void saveSchedule(ScheduleService dto) {
        Schedules schedules = new Schedules();
        
        // Set the module, staff, and course
        schedules.setModule(mservice.findById(dto.getModule_id()));
        schedules.setStaff(sservice.findByUserId(dto.getStaff_id()));
        schedules.setCourse(cservice.findById(dto.getCourse_id()));

        // Set the date and time fields
        schedules.setDate(dto.getDate()); // Assuming you now have LocalDate in DTO
        schedules.setStartTime(dto.getStartTime()); // Assuming LocalTime
        schedules.setEndTime(dto.getEndTime()); // Assuming LocalTime
        
        // Set additional fields
        schedules.setType(dto.getType());
        schedules.setGroup(dto.getGroup());
        schedules.setVenue(dto.getVenue());
        
        // Save the schedule object
        tskrp.save(schedules);
    }

    public List<Schedules> listAll() {
        return tskrp.findAll();
    }

    public List<Schedules> listByCourse(int id) {
        return tskrp.findByCourse(cservice.findById(id));
    }
    
    public List<Schedules> listByStaff(String id) {
        return tskrp.findByStaff(sservice.findByUserId(id));
    }
    
    public List<Schedules> listByModule(int id) {
        return tskrp.findByModule(mservice.findById(id));
    }
    
    public void deleteSchedule(int id) {
        tskrp.deleteById(id);
    }

    public Schedules findById(int id) {
        return tskrp.findById(id).orElse(null); // Use Optional for safe fetching
    }

	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		
	}
}
