package com.louis.mango.admin.controller;

import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Discription: ${Discription}
 * @ClassName: ${ClassName}
 * @Author: huangjinming
 * @Date: 2021/7/24 16:04
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @PostMapping(value = "findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return  HttpResult.ok(sysUserService.findPage(pageRequest));
    }
}
