
package com.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.daos.LogsRepository;
import com.app.entities.LogsSheet  ;
import com.app.models.LogsDTO;

@Service
public class LogsService {

    @Autowired 
    private LogsRepository lgsrp;
    
    @Autowired 
    private CourseService cservice;
    
    @Autowired 
    private ModuleService mservice;
    
    @Autowired 
    private StaffService stfservice;

    // Save new log entry
    public void saveLog(LogsDTO dto) {
        LogsSheet logs = new LogsSheet();
        logs.setCourse(cservice.findById(dto.getCourse_id()));
        logs.setModule(mservice.findById(dto.getModule_id()));
        
        logs.setStaff(stfservice.getStaffById(logs.getStaff()));
        logs.setGroup_name(dto.getGroup_name());
        logs.setStudenProgress(dto.getStudenProgress());
        logs.setAssignmentGiven(dto.getAssignmentGiven());
        logs.setDate(dto.getDate());
        logs.setStartTime(dto.getStartTime());
        logs.setEndTime(dto.getEndTime());
        logs.setStatus("Pending"); // Default status for new logs
        lgsrp.save(logs);
    }

    // Get logs by staff ID (specific to the logged-in staff member)
    public List<LogsSheet> listByStaffId(String staffId) {
        return lgsrp.findByStaff(stfservice.getStaffById(staffId));
    }

    public List<LogsSheet> getLogsByStatus(String status) {
        return lgsrp.findByStatus(status);
    }

    public List<LogsSheet> listAll1() {
        return lgsrp.findAll();  // Get all logs when no specific filter is applied
    }


    // Approve a log
    public void approveLog(int logId) {
        LogsSheet log = lgsrp.findById(logId).orElseThrow(() -> new RuntimeException("Log not found"));
        log.setStatus("Approved");
        lgsrp.save(log);
    }

    // Reject a log
    public void rejectLog(int logId) {
        LogsSheet log = lgsrp.findById(logId).orElseThrow(() -> new RuntimeException("Log not found"));
        log.setStatus("Rejected");
        lgsrp.save(log);
    }

    // List all logs
    public List<LogsSheet> listAll() {
        return lgsrp.findAll();
    }

    // List logs by course
    public List<LogsSheet> listByCourse(int courseId) {
        return lgsrp.findByCourse(cservice.findById(courseId));
    }

    // List logs by module
//    public List<LogsSheet> listByModule(int moduleId) {
//        return lgsrp.findByModule(mservice.findById(moduleId));
//    }

    // Delete a log by ID
    public void deleteLog(int id) {
        lgsrp.delete(lgsrp.getById(id));
    }

    // Find a specific log by ID
    public LogsSheet findById(int id) {
        return lgsrp.getById(id);
    }
}
