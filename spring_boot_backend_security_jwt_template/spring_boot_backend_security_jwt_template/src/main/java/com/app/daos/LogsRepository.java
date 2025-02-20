package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Course;
import com.app.entities.LogsSheet;
import com.app.entities.Staff;
import com.app.models.StaffDTO;


@Repository
public interface LogsRepository extends JpaRepository<LogsSheet, Integer>{

	List<LogsSheet> findByCourse(Course findById);

	List<LogsSheet> findByModule(Module findById);

	List<LogsSheet> findByStatus(String string);

	List<LogsSheet> findByStaff(StaffDTO staffDTO);

}
