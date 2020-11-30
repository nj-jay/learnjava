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