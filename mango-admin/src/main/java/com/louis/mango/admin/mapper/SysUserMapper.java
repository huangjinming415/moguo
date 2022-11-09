package com.louis.mango.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.louis.mango.admin.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> findAll();

    /**
     * 分页查询
     * @return
     */
    List<SysUser> findPage();
}