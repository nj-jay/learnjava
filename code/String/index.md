# String

## 创建的方法

* 直接双引号创建
* 构造方法创建字符串

```java
public class Main {

    public static void main(String[] args) {
   
        String str1 = "abc";
        char[] charArray = {'a', 'b', 'c'};
        String str2 = new String(charArray);
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        
    }
}
```

### 注意

`==`对于基本类型来说比较的是内容是否相等

`==`对于引用类型来说比较的是地址值是否相等

![](https://picture.nj-jay.com/2020.10.11.14.24.png)

对于直接用双引号创建的字符串是存放在字符串常量池中的

而用new创建的字符串不同，结构如图所示

## 比较字符串的内容是否相等的equals方法

public boolean equals(Object obj):参数可以是任何对象

equals方法具有对称性，`a.equals(b)与b.equals(a)相同`

如果比较一个常量与一个变量，推荐`"abc".equals(str)` 

```java
String str1 = null;
System.out.println(str1.equals("abc")); //空指针异常
System.out.println("abc".equals(str1)); //false
```

## String常用方法

| String常用方法                                               | 作用                                                        |
| ------------------------------------------------------------ | ----------------------------------------------------------- |
| public int length()                                          | 长度                                                        |
| public String concat(String str)                             | 拼接字符串                                                  |
| public char charAt(int index)                                | 获取指定位置的字符                                          |
| public int indexOf(String str)                               | 查找参数字符串当中首次出现的位置(若没有返回-1)              |
| public String substring(int index)                           | 从参数位置到末尾                                            |
| public String substring(int begin, int end)                  | [begin, end)                                                |
| public char[] tocharArray()                                  | 将当前字符串拆分为字符数组并返回                            |
| public byte[] getBytes()                                     | 获得当前字符串底层的字节数组                                |
| public String replace(charSequence oldString, charSquence newString) | 将所有出现的老字符串替换成新字符串                          |
| public String() split(String regex)                          | 按照参数的规则将字符串切分为若干部分(split参数是正则表达式) |

## 一些特别的用法

### 获取变量类型

`str.getClass().getTypeName()`

### 输出数组

```java
int[] array1 = {1, 2, 3, 4};
char[] array2 = {'a', 'b', 'c'};
System.out.println(Arrays.toString(array1));
System.out.println(Arrays.toString(array2));
```



