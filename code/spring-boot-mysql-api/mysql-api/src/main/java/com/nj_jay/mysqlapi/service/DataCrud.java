package com.nj_jay.mysqlapi.service;

import com.nj_jay.mysqlapi.database.Connect;
import com.nj_jay.mysqlapi.database.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataCrud {

    public static String QuerySingleLogin(String username) {

        try {

            Connection conn = Connect.connect();

            if (conn != null) {

                PreparedStatement preparedStatement = conn.prepareStatement(sql.QuerySingleDataByUsername);

                preparedStatement.setString(1, username);

                ResultSet res = preparedStatement.executeQuery();

                String ret = null;

                while (res.next()) {

                    ret = res.getString("username") + ":" + res.getString("password");

                }

                res.close();

                preparedStatement.close();

                conn.close();

                return ret;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return null;
    }
}
