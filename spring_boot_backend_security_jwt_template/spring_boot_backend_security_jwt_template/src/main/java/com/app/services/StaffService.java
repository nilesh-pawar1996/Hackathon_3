package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.daos.StaffDao;
import com.app.entities.Staff;
import com.app.models.Credentials;

@Service
public class StaffService implements UserDetailsService {
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Staff getStaffByEmail(String email) {
		Staff dbStaff = staffDao.findByEmail(email);
		return dbStaff;
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
}
