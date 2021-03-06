# jdbc

## 创建maven工程

```shell
mvn archetype:generate "-DgroupId=com.nj_jay.jdbc" "-DartifactId=jdbcDemo" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"
```

###  架构

<img src="https://picture.nj-jay.com/jdbc.png" style="zoom: 50%;" />

## pom.xml中注入jdbc驱动依赖

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.15</version>
</dependency>
```

## 连接数据库

> serverTimezone=GMT%2B8&useSSL=false
>
> 设置时区和禁用ssl
>
> 否则会报错

```java
package com.nj_jay.jdbc.database;
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

## 设计一个LoginUser类

```java
package com.nj_jay.jdbc.Dao;

public class LoginUser {

    public String username;

    public String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginUser() {
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

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

## 设计sql语句

```java
package com.nj_jay.jdbc.database;

public class sql {

    public static final String QueryAllLogin = "SELECT * FROM login";

    public static final String QuerySingleDataByUsername = "SELECT * FROM login WHERE username = ?";

    public static final String AddSingleLogin = "INSERT into login (username, password) values(?,?)";

    public static final String UpdateLogin = "UPDATE login SET password = ? WHERE username = ?";

    public static final String DeleteLoginByUsername = "DELETE FROM login WHERE username = ?";

}
```

## 增删改查

```java
package com.nj_jay.jdbc.service;
import com.nj_jay.jdbc.Dao.LoginUser;
import com.nj_jay.jdbc.database.Connect;
import com.nj_jay.jdbc.database.sql;

import java.sql.*;

public class DataCrud {

    /**
     * 查询所有用户
     */
    public static void QueryAllData() {

        try {

            Connection conn = Connect.connect();

            if (conn != null) {

                Statement stmt = conn.createStatement();

                ResultSet res = stmt.executeQuery(sql.QueryAllLogin);

                while(res.next()) {

                    System.out.println(new LoginUser(res.getString("username"), res.getString("password")));

                }

                res.close();

                stmt.close();

                conn.close();

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    /**
     * 查询单个用户
     * @param username String
     */
    public static void QuerySingleLogin(String username) {

        try {

            Connection conn = Connect.connect();

           if (conn != null) {

               PreparedStatement preparedStatement = conn.prepareStatement(sql.QuerySingleDataByUsername);

               preparedStatement.setString(1, username);

               ResultSet res = preparedStatement.executeQuery();

               while (res.next()) {

                   System.out.println(new LoginUser(res.getString("username"), res.getString("password")));

               }

               res.close();

               preparedStatement.close();

               conn.close();

           }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    /**
     *	注册用户
     * @param userinfo LoginUser
     */
    public static void addSingleLogin(LoginUser userinfo) {

        try {

            Connection conn = Connect.connect();

            if (conn != null) {

                PreparedStatement preparedStatement = conn.prepareStatement(sql.AddSingleLogin);

                preparedStatement.setString(1, userinfo.getUsername());

                preparedStatement.setString(2, userinfo.getPassword());

                int affectLine = preparedStatement.executeUpdate();

                if (affectLine != 0) {

                    System.out.println("添加成功");

                } else {

                    System.out.println("添加失败");

                }

                preparedStatement.close();

                conn.close();

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    /**
     * 删除用户
     * @param username String
     */
    public static void deleteLoginByUsername(String username) {

        try {

            Connection conn = Connect.connect();

            if (conn != null) {

                PreparedStatement preparedStatement = conn.prepareStatement(sql.DeleteLoginByUsername);

                preparedStatement.setString(1, username);

                int affectLine = preparedStatement.executeUpdate();

                if (affectLine != 0) {

                    System.out.println("删除成功");

                } else {

                    System.out.println("删除失败");

                }
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    /**
     *更新用户
     * @param username String
     * @param password String
     */
    public static void upgradeLogin(String username, String password) {

        try {

            Connection conn = Connect.connect();

            if (conn != null) {

                PreparedStatement preparedStatement = conn.prepareStatement(sql.UpdateLogin);

                preparedStatement.setString(1, password);

                preparedStatement.setString(2, username);

                int affectLine = preparedStatement.executeUpdate();

                if (affectLine != 0) {

                    System.out.println("修改成功");

                } else {

                    System.out.println("修改失败");

                }

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }
}
```

## 编写main

```java
package com.nj_jay.jdbc;
import com.nj_jay.jdbc.Dao.LoginUser;
import com.nj_jay.jdbc.service.DataCrud;

public class App {

    public static void main(String[] args) {

        System.out.println("====查询所有====");
        DataCrud.QueryAllData();
        System.out.println("=====单例查询=====");
        DataCrud.QuerySingleLogin("hashtest");
        System.out.println("====添加====");
        DataCrud.addSingleLogin(new LoginUser("hs-vae.com", "000000"));
        System.out.println("====test add====");
        DataCrud.QuerySingleLogin("hs-vae.com");
        System.out.println("====test delete====");
        DataCrud.deleteLoginByUsername("hs-vae.com");
        System.out.println("====更新用户信息====");
        DataCrud.upgradeLogin("admin", "12345678");

    }
}
```

## 总结

基础的jdbc要学会使用

并要能配合spring boot提供接口给前端

后面使用spring boot编写web服务