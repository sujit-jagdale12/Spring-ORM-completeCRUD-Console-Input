package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.Student;

public class StudentDao {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	@Transactional
	public int addStudent(Student student) {
		Integer save = (Integer) template.save(student);
		
		return save;
	}
	
	@Transactional
	public void updateStudent(Student student) {
		template.update(student);
	}
	@Transactional
	public void deleteStudent(int id) {
		Student student = this.template.get(Student.class, id);
		template.delete(student);
	}
	
	public Student getStudent(int id) {
		Student student = template.get(Student.class, id);
		return student;
	}
	
	public List<Student> getStudents(){
		List<Student> students = template.loadAll(Student.class);		
		return students;	
	}
}
