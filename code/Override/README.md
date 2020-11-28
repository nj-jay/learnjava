# java重写(Override)

> 当手机有新的功能时，继承老手机，并对某个方法进行重写即可

```java
//filename: Telephone.java
//老手机
public class Telephone {
    //call()
    public void call() {
        System.out.println("call()");
    }

    public void send() {
        System.out.println("send()");
    }

    public void show() {
        System.out.println("show()");
    }
}


//filename: Newtelephone.java
public class Newtelephone extends Telephone {
    @Override
    public void show() {
        System.out.println("show()\nshow(pic)\nshow(name)");
    }
}


//filename: Main.java
public class Main {
    public static void main(String[] args) {
        Telephone telephone = new Telephone();
        Newtelephone newtelephone = new Newtelephone();
        System.out.println("老手机");
        telephone.call();
        telephone.send();
        telephone.show();
        System.out.println("=============");
        System.out.println("新手机");
        newtelephone.call();
        newtelephone.send();
        newtelephone.show();
    }
}
//运行结果
老手机
call()
send()
show()
=============
新手机
call()
send()
show()
show(pic)
show(name)
```

