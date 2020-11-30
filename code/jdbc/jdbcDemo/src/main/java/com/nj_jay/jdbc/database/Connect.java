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
