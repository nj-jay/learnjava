# spring-boot-quickstart

## 使用idea创建项目

> 使用命令行也可以,感觉稍微有点麻烦
>
> 个人建议使用idea创建项目
>
> 使用命令行编译项目

第一步

![](https://picture.nj-jay.com/spring-boot-1.png)

第二步

![](https://picture.nj-jay.com/spring-boot-2.png)

第三步

![](https://picture.nj-jay.com/spring-boot-3.png)

最后选择finish即可

编写一个controller设计一个路由

```java
package com.nj_jay.springstart.helloworld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/hello")
    public String say() {
        return "hello world";
    }
}
```

修改配置文件指定服务的端口号

`server.port=8081`

<img src="https://picture.nj-jay.com/spring-boot-4.png" style="zoom: 67%;" />

## 编译

`mvn clean package`

## 运行

`java -jar target/xxx.jar`

## 网页查看

<img src="https://picture.nj-jay.com/spring-boot-5.png" style="zoom: 67%;" />

## 总结

spring集成了很多的框架

使用了很多的注解

减少了很多配置文件的编写

方便了开发

配合maven项目管理工具

简直是开发利器