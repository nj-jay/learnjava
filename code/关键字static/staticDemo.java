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
