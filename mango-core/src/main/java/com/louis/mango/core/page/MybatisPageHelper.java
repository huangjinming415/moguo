package com.louis.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.louis.mango.common.utils.ReflectionUtils;

import java.util.List;

/**
 * @Description: 分页查询助手
 * @ClassName: MybatisPageHelper
 * @Author: huangjinming
 * @Date: 2021/7/25 8:37
 */
public class MybatisPageHelper {

    public static final String findPage = "findPage";


    /**
     * 分页查询, 约定查询方法名为 “findPage”
     * @param pageRequest 分页请求
     * @param mapper Dao对象，MyBatis的 Mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, findPage);
    }

    /**
     * 分页查询, 约定查询方法名为 “findPage”
     *
     * @param pageRequest 分页请求
     * @param mapper      Dao对象，MyBatis的 Mapper
     * @param args        方法参数
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {

        //设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        //利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo((List) result));
    }


    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
