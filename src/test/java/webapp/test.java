package webapp;

import org.junit.Test;

import serviceImpl.StundentServiceImpl;

public class test {
	@Test
	public void test(){
		StundentServiceImpl impl=new StundentServiceImpl();
		impl.getStudentById(2);
	}
}
