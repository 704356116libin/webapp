package dao;

/**
 * �־û���(ͨ��Hibernateӳ�����ɱ�)
 * @author ��~
 *
 */
public class Student {
	private int id;
	private String name;
	private char sex;
	private int age;
	private String address;
	//�޲ι��췽��
	public Student() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "students [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", address=" + address + "]";
	}
	
	
}	
