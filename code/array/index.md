# java中的array

> 使用new创造

```java

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
```

其他的操作与c语言差不多

比如数组作为函数参数，作为函数返回值(由于java不支持多返回值，因此可以选择使用数组返回多值)

# java.util.Arrays

* sort排序
* binarySearch 二分法查找数组中指定的值，返回index
* fill 增加元素
* equals 判断数组中元素值是否相等

```java
//filename: equals.java
//date: 2020.5.26
import java.util.Arrays;
public class equals {

	public static void main(String[] args) {
		
		int i = 4;
		int[] arrayA = new int[] {1, 2, 3, 4, 5};
		int[] arrayB = new int[] {1, 2, 3, 4};
		int[] arrayC = new int[] {3, 1, 2, 4};	
		System.out.println("2在数组中的index是" + Arrays.binarySearch(arrayA, 2));
		System.out.println(Arrays.equals(arrayA, arrayB));
		
		
		Arrays.sort(arrayC); //排序
		for (int value: arrayC) {
			
			System.out.print(value + "  ");	
		}
		System.out.println();
		
		//填充
		//Arrays.fill(arrayname ,starting index ,ending index ,value) 
	}
}
```

