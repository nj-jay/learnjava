import java.util.Scanner;
public class scanner {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("输入一个整数");
		int num = s.nextInt();

		System.out.println("输入一个字符串");
		String str = s.next();
		

		//s.nextFloat 
		//s.nextDouble
		//s.nextBoolean
		
		//关闭
		s.close();

		//打印
		System.out.println();
		System.out.println(num);
		System.out.println(str);
	}
}
