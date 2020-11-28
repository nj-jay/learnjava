
public class array {

	public static void main(String[] args) {
		
		//动态初始化数组	
		int[] arrayA = new int[3]; //指定长度
		System.out.println(arrayA);
		System.out.println(arrayA.length); //求长度

		//静态初始化数组
		int[] arrayB = new int[] {1, 2, 3}; //直接赋值
		System.out.println(arrayB);
		
		for (int value: arrayB) {

                	System.out.println(value);
            	}

		//静态初始化的省略格式
		int[] arrayC = {1, 2, 3};
		System.out.println(arrayC);

		//调用函数反转的函数
		int[] arrayList = new int[] {1, 2, 3, 4, 5};
		arrayList = reverse(arrayList);
		for (int value: arrayList) {
		
			System.out.println(value);
		}
	}
	
	//数组作为返回值, 数组作为函数参数
	public static int[] reverse(int[] arrayB) {
		//数组元素反转
		int[] list = new int[arrayB.length];
		for (int i = arrayB.length - 1, j = 0; j < arrayB.length; i--, j++) {
		//for循环中的写法还有点蒙蒙的
		
			list[j] = arrayB[i];
		}
		return list;
	
	}
}
