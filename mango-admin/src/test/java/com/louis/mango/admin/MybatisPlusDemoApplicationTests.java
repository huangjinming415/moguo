package com.louis.mango.admin;

import com.louis.mango.admin.mapper.SysUserMapper;
import com.louis.mango.admin.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: ${DESCRIPTION}
 * @ClassName: ${CLASSNAME}
 * @Author: huangjinming
 * @Date: 2021/9/29 10:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MangoAdminApplication.class)
public class MybatisPlusDemoApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询数据
     */
    @Test
    public void testSelectUser() {
        System.out.println(("----- 开始测试 mybatis-plus 查询数据 ------"));
        //  selectList() 方法的参数为 mybatis-plus 内置的条件封装器 Wrapper，这里不填写表示无任何条件，全量查询
        List<SysUser> userList = sysUserMapper.findAll();

        userList.forEach(System.out::println);
    }

    /**
     * 新增一条数据
     */
//    @Test
//    public void testInsertUser() {
//        System.out.println(("----- 开始测试 mybatis-plus 插入数据 ------"));
//        SysUser user = SysUser.builder()
//                .name("犬小哈教程 www.quanxiaoha.com")
//                .age(30)
//                .gender(1)
//                .build();
//
//        userMapper.insert(user);
//    }

    /**
     * 删除数据
     */
    @Test
    public void testDeleteUser() {
        System.out.println(("----- 开始测试 mybatis-plus 删除数据 ------"));
        // 根据主键删除记录
        sysUserMapper.deleteById(1);

        // 根据主键批量删除记录
        sysUserMapper.deleteBatchIds(Arrays.asList(1, 2));
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdateUser() {
        System.out.println(("----- 开始测试 mybatis-plus 更新数据 ------"));
        SysUser user = SysUser.builder()
                .id(1L)
                .name("犬小哈教程 www.quanxiaoha.com")
                .build();

        sysUserMapper.updateById(user);
    }
}
