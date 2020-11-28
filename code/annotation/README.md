# java注解

## 写在前面

> 我是先看的spring框架之后发现注解的知识相当重要,于是好好学习了一下注解如何去使用.
>
> 或许有时候学到了后面才懂得前面的东西是多么的重要
>
> 哪里有兴趣就去了解哪里吧
>
> gogogo!!!

## 过程解析

### 第一步:使用maven创建一个工程

```shell
mvn archetype:generate "-DgroupId=com.nj_jay.annotation" "-DartifactId=AnnotationDemo" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

### 第二步:设计一个注解(本质是interface)

```java
package com.nj_jay.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {

    int min() default 0;

    int max() default 255;

}
```

解释:

> @Retention:定义annotation的生命周期
>
> - 仅编译期：`RetentionPolicy.SOURCE`；
>
> - 仅class文件：`RetentionPolicy.CLASS`；
>
> - 运行期：`RetentionPolicy.RUNTIME`。
>
>   
>
>   一般来说我们自定义的注解为运行期,即RUNTIME
>
> @Target:作用域
>
> - 类或接口：`ElementType.TYPE`；
> - 字段：`ElementType.FIELD`；
> - 方法：`ElementType.METHOD`；
> - 构造方法：`ElementType.CONSTRUCTOR`；
> - 方法参数：`ElementType.PARAMETER`。

## 设计一个Person类

```java
package com.nj_jay.annotation;

public class Person {

    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;

    @Range(min = 1, max = 100)
    public int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{Person: name=%s, city=%s, age=%d}", name, city, age);
    }
}
```

## 通过反射解析注解

```java
package com.nj_jay.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        //这段代码要好好理解 反射(获取class, field, method)
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        Field[] fields = personClass.getFields();
        System.out.println(Arrays.toString(fields));
        Method[] methods = personClass.getMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println("===============");

        //判断类有没有@Range注解
        System.out.println("Person是否有@Range注解:?" + personClass.isAnnotationPresent(Range.class));

        //判断类中的field有没有注解
        for (Field field : fields) {

            System.out.println(field.getName() + "是否有@Range注解:?" + field.isAnnotationPresent(Range.class));

        }
        for (Method method : methods) {

            System.out.println(method.getName() + "是否有@Range注解:?" +method.isAnnotationPresent(Range.class));

        }

        //获取注解的值
        for (Field field : fields) {

            if (field.isAnnotationPresent(Range.class)) {

                Range range = field.getAnnotation(Range.class);

                if (range != null) {

                    System.out.println(field.getName() + "  value of min = " + range.min() + "    value of max: " + range.max());

                }
            }
        }
    }
}
```

## 核心运行结果

`java -jar target/annotation.jar`

```shell
Person是否有@Range注解:?false
name是否有@Range注解:?true
city是否有@Range注解:?true
age是否有@Range注解:?true
toString是否有@Range注解:?false
wait是否有@Range注解:?false
wait是否有@Range注解:?false
wait是否有@Range注解:?false
equals是否有@Range注解:?false
hashCode是否有@Range注解:?false
getClass是否有@Range注解:?false
notify是否有@Range注解:?false
notifyAll是否有@Range注解:?false
name  value of min = 1    value of max: 20
city  value of min = 0    value of max: 10
age  value of min = 1    value of max: 100
```

## 反射的作用

通过注解,我们可以设置Person类field字段的限制

通过解析注解可以对创建的对象对字段进行Check

判断是否符合规定的要求

另外Spring boot中就是通过大量的注解去完成相关的工作

所以注解的知识非常的重要

推荐廖雪峰大神的讲解[注解教程](https://www.liaoxuefeng.com/wiki/1252599548343744/1255945389098144)

