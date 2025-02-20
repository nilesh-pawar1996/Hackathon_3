package com.app.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	@Entity
	public class Course {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String coursename;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCoursename() {
			return coursename;
		}
		public void setCoursename(String coursename) {
			this.coursename = coursename;
		}
		@Override
		public String toString() {
			return "Course [id=" + id + ", coursename=" + coursename + "]";
		}
		
		
	}

