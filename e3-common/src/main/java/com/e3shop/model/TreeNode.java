package com.e3shop.model;

import java.io.Serializable;

/**
 * 树结构数据结果集
 */
public class TreeNode implements Serializable {

    private long id; // 树节点id
    private String text; // 节点名称
    private String state; // 节点状态，1-colsed-有子节点，0-open-无子节点

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
