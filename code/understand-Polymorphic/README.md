# 理解多态

## maven创建工程

```shell
mvn archetype:generate "-DgroupId=com.nj_jay.polymorphic" "-DartifactId=polymorphicDemo" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

## 设计一个抽象类Animal

```java
package com.nj_jay.polymorphic.model;

public abstract class Animal {

    public void general() {

        System.out.println("general...");

    }
}
```

## 设计一个Dog继承Animal

```java
package com.nj_jay.polymorphic.model;

public class Dog extends Animal {

    public void special() {

        System.out.println("dog can look house");

    }
}
```

## 编写main

```java
package com.nj_jay.polymorphic;
import com.nj_jay.polymorphic.model.Animal;
import com.nj_jay.polymorphic.model.Dog;

/**
 * understand polymorphic
 * @author nj-jay
 */
public class App {

    public static void main( String[] args ) {

        Animal animal = new Dog();

        animal.general();

        System.out.println("==========");

        Dog dog = new Dog();

        dog.general();

        dog.special();

        System.out.println("===========");

        System.out.println("对animal向下转型");

        if (animal instanceof Dog) {

            Dog dog1 = (Dog) animal;

            dog1.special();
            
        }
    }
}
```

## 运行

运行结果

```shell
general...
==========
general...
dog can look house
===========
对animal向下转型
dog can look house
```

## 分析

`Animal animal = new Dog();`

使用animal接收一个Dog对象

只实现了Animal的方法

但是并没有Dog类的特有方法

`Dog dog = new Dog();`

dog不仅继承了Animal的方法

还拥有Dog类的方法

可以对animal进行向下转型为Dog对象

`Dog dog = (Dog) animal`;

拿到Dog特有的方法

这就是多态!!!

## 为什么要用到多态

为了代码的可维护性

例如List与ArrayList

List有很多实现类如ArrayList, LinkedList.等

他们中大部分方法都是相同的

当使用List list = new ArrayList();

后面想把list改成LinkedList的对象时就特别的容易

仅需改为List list = new LinkedList();

推荐一篇博客的讲解

[讲解推荐](https://www.cnblogs.com/zcscnn/p/7743507.html)