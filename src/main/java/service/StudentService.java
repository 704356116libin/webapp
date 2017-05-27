package service;

import dao.Student;


/**
 * 学生类服务的接口
 * @author 彬~
 *
 */
public interface StudentService {
	//提供一个通过id来查询学生数据的服务
	public Student getStudentById(int id);
}
