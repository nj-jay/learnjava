# 对象数组

>  类似int[] array = new int[2]
>
> 假设对象是Person
>
> 那么定义对象数组的方式是
>
> Person[] array = new Person[2]

```java
//filename: Person.java
//来一个完整的类的写法
public class Person {
	
	private String name;
	private int age;
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
//filename: newArray.java
public class newArray {
	public static void main(String[] args) {
		
		//创建对象数组
		Person[] array = new Person[2];
		array[0] = new Person("nj", 20); //匿名对象
		array[1] = new Person("jay", 19);
		System.out.println("array[0]	" + array[0].getName() + " " + array[0].getAge());
		System.out.println("array[1]	" + array[1].getName() + " " + array[1].getAge());

	}
}

```

