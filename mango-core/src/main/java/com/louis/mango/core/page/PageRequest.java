package com.louis.mango.core.page;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 分页请求
 * @ClassName: PageRequest
 * @Author: huangjinming
 * @Date: 2021/7/25 8:27
 */
public class PageRequest {
    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 请求参数
     */
    private Map<String, Object> params = new HashMap<>();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
