# spring-boot-mysql-api

## 创建一个spring boot工程

> 实验目的: 编写api获取数据库中username对应的password
>
>  [POST]http://localhost:8081/api/v1/data
>
> 如 curl -d "username=hashtest"
>
> {"username":"hashtest", "password":"123456"}
>
> 实验前先在数据库中创建对用的表以及一些数据

## 在pom.xml中加入mysql驱动和alibaba的fastjson

```xml
<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.15</version>
</dependency>

<dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.3</version>
        </dependency>
```

## 修改配置文件application.properties

```
server.port = 8081
```

## 编写model层

```java
package com.nj_jay.mysqlapi.model;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = {"username", "password"})
public class LoginUser {

    String username;

    String password;

    public LoginUser() {

    }

    public LoginUser(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
```

## 编写database层

```java
package com.nj_jay.mysqlapi.database;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connect {

    public static final String url = "jdbc:mysql://47.95.1.229:3306/mysql_nj_jay_com?serverTimezone=GMT%2B8&useSSL=false";
    public static final String username = "mysql_nj_jay_com";
    public static final String password = "6435426njnj";
    public static Connection connect() {

        Connection conn;

        try {

            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(url, username, password);

            return conn;

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return null;
    }
}
```

```java
package com.nj_jay.mysqlapi.database;

public class sql {

    public static final String QuerySingleDataByUsername = "SELECT * FROM login WHERE username = ?";

}
```

## 编写service层与数据库交互

```java
package com.nj_jay.mysqlapi.service;

import com.nj_jay.mysqlapi.database.Connect;
import com.nj_jay.mysqlapi.database.sql;
import com.nj_jay.mysqlapi.model.LoginUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataCrud {

    public static LoginUser QuerySingleLogin(String username) {

        try {

            Connection conn = Connect.connect();

            if (conn != null) {

                PreparedStatement preparedStatement = conn.prepareStatement(sql.QuerySingleDataByUsername);

                preparedStatement.setString(1, username);

                ResultSet res = preparedStatement.executeQuery();

                LoginUser loginUser = new LoginUser();

                while (res.next()) {

                    loginUser.setUsername(res.getString("username"));
                    loginUser.setPassword(res.getString("password"));

                }

                res.close();

                preparedStatement.close();

                conn.close();

                return loginUser;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return null;
    }
}

```

## 编写controller层

```java
package com.nj_jay.mysqlapi.controller;
import com.nj_jay.mysqlapi.service.DataCrud;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

@RestController
public class jsonData {

    @PostMapping("/api/v1/data")
    public String showSingleData(@RequestParam("username") String username) {

        return JSON.toJSONString(DataCrud.QuerySingleLogin(username));

    }
}

```

> 这是最关键的一个地方
>
> 为前端提供接口http://localhost:8081/api/v1/data
>
> 参数为username

## 打包,运行

`mvn clean package`

`java -jar target/xxx.jar`

## 测试接口

```shell
curl -d "username=hashtest" http://localhost:8081/api/v1/data
#返回结果
{"username":"hashtest","password":"$2a$04$2aZIFXWtTr85OKqeBQeaDuxs8k4JzyAj0F4jR8QmMa5lazR/ZiRJy"}
#测试成功
```

## 总结

spring boot框架让我们只用专注业务代码即可

非常的方便编写restful api

配合maven工具的打包部署

简直是人性化到极致	