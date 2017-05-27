package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;

import dao.Student;
import service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	// ע��ѧ������
	@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	// ƥ������ /student/show url
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView doSomeThing() {
		ModelAndView mv=new ModelAndView();
		System.out.println("doSomeThing");
		mv.addObject("msg","��doSomeThing�����з��ص�����");
		mv.setViewName("demo");
		return mv;
	}
	/**
	 * ������Controller ��ʽ
	 * @param id
	 * @param model
	 * @return
	 */
	// ƥ������ /student/function1?id=? url
	@RequestMapping(value = "/function1", method = RequestMethod.GET)
	public String showStudent1(@RequestParam("id") Integer id, Model model) {
		System.out.println("showStudent1");
		Student student = studentService.getStudentById(id);
		model.addAttribute(student);
		return "student";
	}
	
	/**
	 * ���ڵķ�ʽ
	 * @param id
	 * @param model
	 * @return
	 */
	// ƥ������ /student/function2/? url
	@RequestMapping(value = "/function2/{id}", method = RequestMethod.GET)
	public String showStudent2(@PathVariable("id") Integer id, Map<String, Object> model) {
		System.out.println("��ѯѧ��id:" + id);
		Student student = studentService.getStudentById(id);
		model.put("student", student);
		return "student";
	}
	/**
	 * ��ͳ�� HttpServletRequest ����ʽ
	 * @param request
	 * @return
	 */
	// ƥ������ /student/function3?id=? url
	@RequestMapping(value = "function3", method = RequestMethod.GET)
	public String showStudent3(HttpServletRequest request) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println("��ѯѧ��id:" + id);
		Student student = studentService.getStudentById(id);
		request.setAttribute("student", student);
		return "student";
	}
	/**
	 * ֧��Json�ķ���
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody Student getCourseJson(@PathVariable Integer id){
		return studentService.getStudentById(id);
	}
	/**
	 * ֧��Json�ĵڶ��ַ���
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/jsontype/{id}",method=RequestMethod.GET)
	public ResponseEntity<Student>getCourseJson2(@PathVariable Integer id){
		Student student = studentService.getStudentById(id);
		return 	new ResponseEntity<Student>(student,HttpStatus.OK);
	}

}
