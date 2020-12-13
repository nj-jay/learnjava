# 使用docker构建springboot微服务镜像

## 简介

> 参考资料:来自本人博客
>
> * [docker基本使用](https://blog.nj-jay.com/docker%e5%9f%ba%e6%9c%ac%e4%bd%bf%e7%94%a8/)

## 准备的工具

* jar包

## 编写Dockerfile

```dockerfile
FROM java:8
COPY *.jar /app.jar
CMD ["--server.port=8081"]
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 构建镜像

```shell
docker build -t nj-jay666 .
```

## 使用镜像

```shell
docker run -d -P --name=springboot-web-first nj-jay666
```

## 测试镜像

```shell
# 找到自动分配的端口
docker ps 
# 测试api
curl -d "username=admin" http://localhost:32769/api/v1/data
```

![image-20201213131527866](https://picture.nj-jay.com/spring-boot-docker1.png)

![image-20201213131618932](https://picture.nj-jay.com/spring-boot-docker2.png)

