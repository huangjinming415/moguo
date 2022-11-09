package com.louis.mango.admin.service;

import com.louis.mango.admin.entity.SysUser;
import com.louis.mango.core.service.CurdService;

import java.util.List;

/**
 * @Discription: 用户service
 * @ClassName: SysUserService
 * @Author: huangjinming
 * @Date: 2021/7/24 15:57
 */
public interface SysUserService  extends CurdService {
    /**
     * 查找所有用户
     *
     * @return
     */
    List<SysUser> findAll();
}
