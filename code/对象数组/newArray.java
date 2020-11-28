public class newArray {
	public static void main(String[] args) {
		
		//对象数组
		Person[] array = new Person[2];
		array[0] = new Person("nj", 20); //匿名对象
		array[1] = new Person("jay", 19);
		System.out.println("array[0]	" + array[0].getName() + " " + array[0].getAge());
		System.out.println("array[1]	" + array[1].getName() + " " + array[1].getAge());

	}
}
