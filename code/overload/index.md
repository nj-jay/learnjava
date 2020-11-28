#  重载

> java是支持重载的
>
> 什么是重载？
>
> 重载是在一个类里面，方法名字相同，而参数不同，返回类型可以相同也可以不同

```java
//filename: overloadDemo.java
//date:2020.5.25
public class overloadDemo {
    //主程序
    public static void main(String[] args) {
        System.out.println(isSame(1, 2));　//有返回值
        isSame('a', 'a');　//无返回值
    }
    
    //方法
    public static boolean isSame(int a, int b) {
    	//判断两个整数是否相等
        System.out.println("调用参数为整数的方法");
     	return a == b;   
    }
    
    public static void isSame(char a, char b) {
        //判断两个字符是否相等
        System.out.println("调用参数为字符的方法");
        System.out.println(a == b);
    }
}
```

