package com.e3shop.model;

import java.io.Serializable;
import java.util.List;

/**
 * 封装json格式的datagrid结果集类
 */
public class PageResult implements Serializable {

    private long total; // 总页数
    private List rows; // 数据

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
