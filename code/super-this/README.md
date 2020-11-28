# super,this三种用法

* 访问父类/本类中的成员变量

* 访问父类/本类中的成员方法

* 访问父类/本类中的构造方法

```java
//Fu.java
public class Fu {

    int num = 10;
    public Fu() {
        
    }
    public void methodFu() {

        System.out.println("这是父类方法");
    }
}

//Zi.java
class Zi extends Fu {

    int num = 20;

    //访问父类构造方法
    public Zi() {
        super();
    }

    public void method() {

        System.out.println("zi.num = " + this.num);
        System.out.println("fu.num = " + super.num);
        super.methodFu();
        this.methodZi();
    }
    public void methodZi() {
        System.out.println("这是子类方法");
    }
}

//Main.java
public class Main {

    public static void main(String[] args) {

        Zi zi = new Zi();
        zi.method();
    }
}
```

