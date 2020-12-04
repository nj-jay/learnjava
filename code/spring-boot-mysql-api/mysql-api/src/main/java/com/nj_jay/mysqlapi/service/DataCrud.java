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
