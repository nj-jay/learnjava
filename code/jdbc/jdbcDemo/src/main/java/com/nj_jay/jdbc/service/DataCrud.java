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
     *
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
