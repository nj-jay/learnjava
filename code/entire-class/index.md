# java构造一个完整的类

* 成员变量(私有变量)
* 构造方法(无参和有参(重载))
* Getter and Setter

```java
//filename: student.java
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
```

```java
//filename: entireClass.java

public class entireClass {

	public static void main(String[] args) {
		
		student stu1 = new student(); //调用无参构造方法
		//name与age是私有变量，无法直接访问		
		stu1.setName("jay");
		stu1.setAge(20);
		System.out.println("stu1的姓名" + stu1.getName() + "年龄" + stu1.getAge());
		System.out.println("===========================");
		
		student stu2 = new student("nj", 19); //调用有参构造，直接赋值
		System.out.println("stu2的姓名" + stu2.getName() + "年龄" + stu2.getAge());
		stu2.setName("nj-jay");
		stu2.setAge(21);
		System.out.println("===========重新set之后get到的name and age==========");
		System.out.println("stu2的姓名" + stu2.getName() + "年龄" + stu2.getAge());
		
	}
}
//运行结果
stu1的姓名jay年龄20
===========================
stu2的姓名nj年龄19
===========重新set之后get到的name and age==========
stu2的姓名nj-jay年龄21
```

