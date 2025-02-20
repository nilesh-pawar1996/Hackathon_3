package com.app.models;

import lombok.Data;

@Data
public class StaffDTO {
	private int staffId;
	private String name;
	private String email;
	private String password;
	private String role;	
}
