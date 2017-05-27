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
 * ѧ�������ʵ����
 * @author ��~
 *
 */
@Service("studentService")
public class StundentServiceImpl implements StudentService{
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;	
	
	public StundentServiceImpl(){
		init();//��ʼ������
	}
	
	
	/**
	 * ͨ��id����ȡ�־ò��ѧ������
	 */
	@Override
	public Student getStudentById(int id) {
		
		// ������Ҫ��ѯ���ݿ��е�ѧ�������ظ�ѧ������
//		String hql="from student as s where id="+id;
		Student stu = (Student) session  
	            .createQuery(" from Student where id = ? ").setParameter(0, id)  
	            .uniqueResult();
		
		System.out.println(stu.toString());
		return stu;
	}
	public void init(){
		//�������ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
				.applySettings(config.getProperties())
				.buildServiceRegistry();
		//�����Ự��������
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		//�Ự����
		session=sessionFactory.openSession();
		//��������
		transaction=session.beginTransaction();
	}
	
}
