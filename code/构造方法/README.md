# 构造方法

> 构造方法是专门用来创建对象用的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法
>
> 格式 public 类名称(参数类型  参数名称) {
>
> ​				方法体
>
> }
>
> 注意事项
>
> 1.构造方法的名称必须和所在的类名称完全一样
>
> 2.构造方法不写返回值类型
>
> 3.如果没有编写任何构造方法，那么编译器将会默认构造一个没有参数没有方法的构造方法
>
> 4.构造方法支持重载

## 最简单的构造方法实例

```java
//filename: student.java
public class student {
	
	public student() {
		
		System.out.println("构造方法执行!");
	}
}
```

```java
//filename: struct.java
public class struct {

	public static void main(String[] args) {
	
		student stu = new student(); //其实就是在调用构造方法
	}
}

//运行结果
构造方法执行!
```

## 构造方法重载实例

```java
//filename: student.java
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
```

```java
//filename: struct.java
public class struct {

	public static void main(String[] args) {
		

		student stu1 = new student(); //调用无参构造方法
		System.out.println("====================");
		student stu2 = new student("jay", 20); //调用有参构造方法
	}
}

//运行结果
无参构造方法执行!
====================
有参构造方法执行!
```

