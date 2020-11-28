# java抽象方法和抽象类

> 1.抽象方法所在的类必须是抽象类
>
> 2.抽象方法没有抽象体
>
> 3.不能直接new抽象类对象	
>
> 4.必须用一个子类继承抽象类
>
> 5.子类必须覆盖重写抽象父类当中所有的抽象方法(去掉抽象方法的abstract关键字，补上方法体)
>
> 除非该子类也是抽象类
>
> 6.抽象类中可以有构造方法，是供子类创建对象时，初始化父类成员使用的
>
> 7.抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类	
>
> ![](https://picture.nj-jay.com/6.6.13.57.png)

```java
//filename: Area.java
public abstract class Area {
    //计算图形面积，抽象类，抽象方法
    public abstract void computeArea();
}


//filename: Circle.java
public class Circle extends Area {

    @Override
    public void computeArea() {
        System.out.println("pi * r * r");
    }
}

//filename: Triangle.java
public class Triangle extends Area {

    @Override
    public void computeArea() {
        System.out.println("底 * 高 / 2");
    }
}


//filename: Main.java

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        circle.computeArea();
        System.out.println("=================");
        triangle.computeArea();
    }
}
//运行结果
pi * r * r
=================
底 * 高 / 2
```

