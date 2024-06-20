package com.SpringORM;

import java.util.List;



import org.springframework.orm.hibernate5.HibernateTemplate;


public class StudentDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
			//enables write operation
	public void save(Student student) {
		hibernateTemplate.save(student);
	}
	
	public void update(Student student) {
		hibernateTemplate.update(student);
	}
	
	public void delete(Student student) {
		hibernateTemplate.delete(student);
	}
	
	public Student getById(int id) {
		Student student = hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	public List <Student> getAllStudents(){
		List <Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}
}
