package com.nj_jay.mysqlapi.controller;

import com.nj_jay.mysqlapi.service.DataCrud;
import org.springframework.web.bind.annotation.*;

@RestController
public class jsonData {

    @PostMapping("/api/v1/data")
    public String showSingleData(@RequestParam("username") String username) {

        return DataCrud.QuerySingleLogin(username);

    }

}
