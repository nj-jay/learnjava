public class overload {
    //主程序
    public static void main(String[] args) {
        System.out.println(isSame(1, 2));
        isSame('a', 'a');
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
