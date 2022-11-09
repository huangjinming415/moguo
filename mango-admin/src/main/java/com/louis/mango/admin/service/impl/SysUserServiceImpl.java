package com.louis.mango.admin.service.impl;

import com.louis.mango.admin.entity.SysUser;
import com.louis.mango.admin.mapper.SysUserMapper;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Discription: 用户SysUserServiceImpl
 * @ClassName: SysUserServiceImpl
 * @Author: huangjinming
 * @Date: 2021/7/24 16:01
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public int save(Object record) {
        return 0;
    }

    @Override
    public int delete(Object record) {
        return 0;
    }

    @Override
    public int delete(List records) {
        return 0;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest,sysUserMapper);
    }
}
