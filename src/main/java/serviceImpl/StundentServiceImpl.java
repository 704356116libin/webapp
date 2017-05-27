package serviceImpl;


import java.awt.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import dao.Student;
import service.StudentService;

/**
 * 学生服务的实现类
 * @author 彬~
 *
 */
@Service("studentService")
public class StundentServiceImpl implements StudentService{
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;	
	
	public StundentServiceImpl(){
		init();//初始化参数
	}
	
	
	/**
	 * 通过id来获取持久层的学生对象
	 */
	@Override
	public Student getStudentById(int id) {
		
		// 在这需要查询数据库中的学生并返回该学生对象
//		String hql="from student as s where id="+id;
		Student stu = (Student) session  
	            .createQuery(" from Student where id = ? ").setParameter(0, id)  
	            .uniqueResult();
		
		System.out.println(stu.toString());
		return stu;
	}
	public void init(){
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
				.applySettings(config.getProperties())
				.buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		//会话对象
		session=sessionFactory.openSession();
		//开启事务
		transaction=session.beginTransaction();
	}
	
}
