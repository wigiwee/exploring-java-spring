package com.spring.jdbc.dao;

import java.util.List;
     
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		String query =  "INSERT INTO springJDBC(id, name, city) value(?, ?, ?)";
		int result = this.jdbcTemplate.update(query , student.getId(), student.getName(), student.getCity());
		return result;		
	}

	@Override
	public int update(Student student) {
		String query = "UPDATE springJDBC SET name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	@Override
	public int delete(int studentId) {
		String query = "DELETE FROM springJDBC WHERE id=?";
		int result = this.jdbcTemplate.update(query, studentId);
		return result;
	}

	@Override
	public Student getStudent(int studentId) {
		String query = "SELECT * FROM springJDBC WHERE id=?";
		RowMapper<Student> rowMapper = new  RowMapperImpl(); //this obj helps to map the ResultSet object to desired object 
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId); 
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		//selecting multiple students
		String query = "SELECT * FROM springJDBC";
		List<Student> students= this.jdbcTemplate.query(query,new RowMapperImpl() );
		return students;
	}

	
}
