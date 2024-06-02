package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.JDBCinSpring.Student;
import com.spring.jdbc.entities.StudentDao;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		String query =  "insert into students(id, name, city) value(?, ?, ?)";
		int result = this.jdbcTemplate.update(query , student.getId(), student.getName(), student.getCity());
		return result;		
	}

	
}
