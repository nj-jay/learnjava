# ArrayList

> java实现的一个类
>
> 可以改变数组的大小
>
> 提供了很多操作该集合的方法
>
> 支持泛型

## 注意事项

`ArrayList<String> list = new ArrayList<>();`

类型只能为引用类型

不能为一般类型

如果需要存放基础类型必须使用基本类型对应的`包装类`

| 基本类型 | 包装类(引用类型) |
| :------- | ---------------- |
| byte     | Byte             |
| short    | Short            |
| int      | Integer          |
| long     | Long             |
| float    | Float            |
| double   | Double           |
| char     | Character        |

```java
//编译器警告
//分清List 与 ArrayList　的区别
List list = new ArrayList();
list.add("hello");
//强制转换
String first = (String) list.get(0);
System.out.println(first);
```

```java
//编译器无警告
List<String> listStr = new ArrayList<>();
listStr.add("nj-jay");
String first = listStr.get(0);
System.out.println(first);
```

```java
List<Number> listNum = new ArrayList<>();
listNum.add(1);
listNum.add(12.34);
Number firstNum = listNum.get(0);
System.out.println((int) firstNum + 1);
Number secondNum = listNum.get(1);
System.out.println((double) secondNum + 3.14);
```

### 自定义泛型Student

```java
//student.java
public class student {

    private String name;
    private int age;

    public student() {

    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//Main
public class Main {

    public static void main(String[] args) {
        student stu1 = new student("nj", 20);
        student stu2 = new student("jay", 21);
        student stu3 = new student("nj-jay", 22);
        ArrayList<student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        for (int i = 0; i < list.size(); i++) {
            student stu = list.get(i);
            System.out.println(stu.getName() + stu.getAge());
        }
    }
```

