package com.nj_jay.jdbc.database;

public class sql {

    public static final String QueryAllLogin = "SELECT * FROM login";

    public static final String QuerySingleDataByUsername = "SELECT * FROM login WHERE username = ?";

    public static final String AddSingleLogin = "INSERT into login (username, password) values(?,?)";

    public static final String UpdateLogin = "UPDATE login SET password = ? WHERE username = ?";

    public static final String DeleteLoginByUsername = "DELETE FROM login WHERE username = ?";

}
