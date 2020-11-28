# static关键字

## static修饰成员变量

> 修饰成员变量后，该变量是该类中所有变量可共享的数据

```java
//filename: Person.java
public class Person {
	
	private String name;
	private int age;
	static String room; //共享同一个数据，该变量属于类，推荐的调用方式为，Person.room
	public Person() {
		
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
```

```java
//filename: staticDemo.java
public class staticDemo {
		
		public static void main(String[] args) {
			Person one = new Person("郭靖", 20);
			Person two = new Person("黄蓉", 19);
			//one.room = "A124"; //相当于直接把类中的变量room赋值了
			Person.room = "A124";
			System.out.println("one: " + one.getName() + " " + one.getAge() + " " + one.room);
			System.out.println("two: " + two.getName() + " " + two.getAge() + " " + two.room);
		}
	}
//运行结果
one: 郭靖 20 A124
two: 黄蓉 19 A124
```

## static修饰方法

> public static  静态方法  可以通过对象去调用，也可以用类的名称直接调用
>
> 成员方法 无static 必须要创建对象再去调用该方法
>
> 注意：静态不能直接访问静态
>
> ​		   静态方法中不能写this

```java
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
```

```java
public class staticDemo {
		
		public static void main(String[] args) {
			
			
			Person one = new Person("郭靖", 20);
			Person two = new Person("黄蓉", 19);
			//one.room = "A124"; //相当于直接把类中的变量room赋值了
			Person.room = "A124";
			System.out.println("one: " + one.getName() + " " + one.getAge() + " " + one.room);
			System.out.println("two: " + two.getName() + " " + two.getAge() + " " + two.room);
			System.out.println("================================");
			
			//调用静态方法使用类名称，也可以使用对象
			Person.statDemo();

			//调用myClass方法
			//简易写法
			myClass();
			//实际上是staticDemo.myClass()
			staticDemo.myClass();
		}
		
		public static void myClass() {

			System.out.println("myClass()方法");
		}
	}
//运行结果
one: 郭靖 20 A124
two: 黄蓉 19 A124
================================
这是静态方法
myClass()方法
myClass()方法
```

