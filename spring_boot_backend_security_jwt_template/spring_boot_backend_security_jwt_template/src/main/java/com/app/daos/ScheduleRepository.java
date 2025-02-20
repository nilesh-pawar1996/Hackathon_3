package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.app.entities.Schedules;
import com.app.entities.Course;
import com.app.entities.Module;
import com.app.entities.Staff;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, Integer> {

	public List<Schedules> findByCourse(Course findById);
	public List<Schedules> findByStaff(Staff findById);
	public List<Schedules> findByModule(Module findById);

}
