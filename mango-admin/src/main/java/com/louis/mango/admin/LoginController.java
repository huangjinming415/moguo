package com.louis.mango.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: ${DESCRIPTION}
 * @ClassName: LoginController
 * @Author: huangjinming
 * @Date: 2021/7/25 16:24
 */
@RestController
public class LoginController {
    @PostMapping(value = "/login")
    public Object login(HttpServletRequest request) {
        String  token=request.getParameter("token");
        Map<String,Object> map= new HashMap();
        map.put("token",token);
        return map;
    }
}
