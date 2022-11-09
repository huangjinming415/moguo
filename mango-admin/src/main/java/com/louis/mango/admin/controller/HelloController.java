package com.louis.mango.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription:HelloController
 * @Author: huangjinming
 * @Date: 2021/7/24 9:22
 */
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public Object hello() {
        return "Hello Mango!";
    }
}
