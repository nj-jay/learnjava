

# instance of

## 写在前面

> instance of 为向下转型
>
> 这个机制类似于go中interface{}转成具体的类型
>
> go中通过类型断言
>
> java中通过instance of关键字向下转型
>
> 关键代码
>
> if (obj instance of SomeClass) {
>
> ​				SomeClass someclass = (SomeClass) obj
>
> }

## 使用maven创建工程

```shell
mvn archetype:generate "-DgroupId=com.nj_jay.instanceOf" "-DartifactId=InstanceOfDemo" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

## 设计一个Usb接口

```java
package com.nj_jay.instanceOf.model;

public interface Usb {

    public abstract void start();

    public abstract void stop();

}
```

## 设计Computer,Mouse,Keyboard

```java
package com.nj_jay.instanceOf.model;

public class Computer {

    public Computer() {

    }

    public void init() {

        System.out.println("computer初始化中...");

    }

    public void working(Usb usb) {

        usb.start();

        usb.stop();

    }

    public void shutdown() {

        System.out.println("shutdown now");

    }
}
```

```java
package com.nj_jay.instanceOf.model;

public class Mouse implements Usb{

    public Mouse() {

    }

    @Override
    public void start() {

        System.out.println("鼠标开始工作");

    }

    @Override
    public void stop() {

        System.out.println("鼠标停止工作");

    }
}
```

```java
package com.nj_jay.instanceOf.model;

public class Keyboard implements Usb{

    public Keyboard() {

    }

    @Override
    public void start() {

        System.out.println("键盘开始工作");

    }

    @Override
    public void stop() {

        System.out.println("键盘停止工作");

    }
}
```

## 编写Main

```java
package com.nj_jay.instanceOf;

import com.nj_jay.instanceOf.model.Computer;
import com.nj_jay.instanceOf.model.Keyboard;
import com.nj_jay.instanceOf.model.Mouse;

/**
 * Compare to go 类型断言
 * @author nj-jay
 */

public class App {

    public static void main( String[] args ) {

        //new一个computer
        Computer computer = new Computer();
        //new一个mouse
        Mouse mouse = new Mouse();
        //new一个keyboard
        Keyboard keyboard = new Keyboard();

        computer.init();

        whichWork(mouse);

        whichWork(keyboard);

        computer.shutdown();

    }

    public static void whichWork(Object obj) {

        if (obj instanceof Mouse) {

            Mouse mouse = (Mouse) obj;

            mouse.start();

            mouse.stop();

        }

        if (obj instanceof Keyboard) {

            Keyboard keyboard = (Keyboard) obj;

            keyboard.start();

            keyboard.start();

        }
    }
}
```

## 作用

体现了面向对象的多态特性

由于在java中任何一个类都默认继承自Object类

可以将任何类的对象向上转型为Object的对象

这一点与go中的空接口interface{}类似

但是从空接口向下转型为具体的类型必须要判断

go是通过类型断言完成

而java是通过instance of关键字完成