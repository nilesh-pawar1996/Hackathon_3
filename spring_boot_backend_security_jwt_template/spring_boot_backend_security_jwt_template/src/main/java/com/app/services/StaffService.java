package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.daos.StaffDao;
import com.app.entities.Staff;
import com.app.models.Credentials;
import com.app.models.StaffDTO;

@Service
public class StaffService implements UserDetailsService {
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper modelMapper;

	public StaffDTO getStaffByEmail(String email) {
		Staff dbStaff = staffDao.findByEmail(email);
		return modelMapper.map(dbStaff, StaffDTO.class);
	}
	
	public Staff getStaffByCredentials(Credentials cr) {
		Staff dbStaff = staffDao.findByEmail(cr.getEmail());
		if(dbStaff != null && passwordEncoder.matches(cr.getPassword(), dbStaff.getPassword()))
			return dbStaff;
		return null;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Staff dbUser = staffDao.findByEmail(email);
		if(dbUser == null)
			throw new UsernameNotFoundException("No user exists!");
		return dbUser;
	}

	public List<StaffDTO> findAllStaff() {
		List<Staff> list = staffDao.findAll();
		return list.stream()
			.map(staffEntity -> modelMapper.map(staffEntity, StaffDTO.class))
			.collect(Collectors.toList());
	}

	public StaffDTO getStaffById(int staffId) {
		Staff dbStaff = staffDao.findById(staffId).orElse(null);
		return modelMapper.map(dbStaff, StaffDTO.class);
	}

	public StaffDTO getStaffByName(String name) {
		Staff dbStaff = staffDao.findByName(name);
		return modelMapper.map(dbStaff, StaffDTO.class);
	}
}
