package dao;

import java.util.List;

import model.Student;

public interface IStudentDao {
	
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int id);
	
	public Student selectOne(int id);
	
	public List<Student> selectAll();

}
