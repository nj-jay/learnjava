public class Person {
	
	private String name;
	private int age;
	static String room; //共享同一个数据，该变量属于类，推荐的调用方式为，Person.room
	public Person() {
		
	}
	public static void statDemo() {
		
		System.out.println("这是静态方法");	
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;	
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
} 

