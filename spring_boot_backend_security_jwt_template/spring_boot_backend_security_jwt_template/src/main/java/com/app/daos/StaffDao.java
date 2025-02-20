package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

	Staff findByEmail(String email);

}
