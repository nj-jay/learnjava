public class student {
	
	private String name;
	private int age;
	
	public student() {
		
	}
	
	//重载student()
	public student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//Geter and Setter
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
