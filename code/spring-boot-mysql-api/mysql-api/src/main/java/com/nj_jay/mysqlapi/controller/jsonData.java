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
