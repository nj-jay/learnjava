
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
