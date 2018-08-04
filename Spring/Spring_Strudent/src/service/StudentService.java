package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IStudentDao;
import model.Student;

@Service
public class StudentService {

	@Autowired
	private IStudentDao sDao;

	public Object studentList() {
			return sDao.selectAll();
		}
	
	public void deleteStudent(int id) {
		sDao.deleteStudent(id);
	}

	
	public void updateStudent(Student student) {
			sDao.updateStudent(student);
		}
	

	public Student getStudent(int id) {
		return sDao.selectOne(id);
	}
	
	public void insertStudent(Student student) {
		sDao.insertStudent(student);
	}

}
