# java继承

> 面向对象的三大特征:封装性，继承性，多态性
>
> 继承是多态的前提

```java
//filename: Employee.java
public class Employee {

	private String name;
	private int id;

       	public Employee() {

	}

	public Employee(String name, int id) {
		
		this.name = name;
		this.id = id;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setId(int id) {
                this.id = id;
        }

        public int getId() {

                return id;
        }


}



//filename: teacher.java
public class teacher extends Employee {

	public void methodTeacher() {

		System.out.println("我是老师");
	}
}


//filename: main.java
public class main {

	public static void main(String[] args) {
		
		teacher tea1 = new teacher();
		tea1.setName("nj");
		tea1.setId(1);
		tea1.methodTeacher();
		System.out.println("tea1:" + "name:" + tea1.getName() + "	id:" + tea1.getId());
	}
}
```



# 区分继承后变量重名的方法

> 局部变量
>
> 本类的成员变量 this
>
> 父类的成员变量 super

```java
//filename:Fu.java
public class Fu {
	
	int num = 10;

}


//filename:Zi.java
public class Zi extends Fu{
	
	int num = 20;

	public void method() {

		int num = 30;
		System.out.println(num);//30
		System.out.println(this.num);//20
		System.out.println(super.num);//10
	}
}

//filename:Main.java
public class Main {


	public static void main(String[] args) {

		Zi zi = new Zi();
		zi.method();
	}
}

//运行结果
30
20
10
```

# 继承中成员方法的访问方法

> 创建的对象是谁，就优先用谁的方法
>
> 如果没有，则向上找父类中的方法

```java
//filename: Fu.java
public class Fu {
	
	public void method() {
	
		System.out.println("我是父类方法");
	}

}


//filename: Zi.java
public class Zi extends Fu{
	

	public void method() {

		System.out.println("我是子类方法");
	}
}



//filename: Main.java

public class Main {


	public static void main(String[] args) {

		Fu fu = new Fu();
		Zi zi = new Zi();
		fu.method();
		zi.method();
	}
}
//运行结果
我是父类方法
我是子类方法
```

