public class student {
	
	private String name;
	private int age;
	
	public student() {
		
		System.out.println("无参构造方法执行!");
	}
	
	//重载student()
	public student(String name, int age) {
		System.out.println("有参构造方法执行!");
		this.name = name;
		this.age = age;
	}
}
