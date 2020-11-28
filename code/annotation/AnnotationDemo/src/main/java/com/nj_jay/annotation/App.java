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
