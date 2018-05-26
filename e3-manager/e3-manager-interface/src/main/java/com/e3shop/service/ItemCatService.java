package com.e3shop.service;

import com.e3shop.model.TreeNode;

import java.util.List;

/**
 * 商品分类接口
 */
public interface ItemCatService {

    /**
     * 根据分类parentId查询分类列表
     * @param pId parentId
     * @return
     */
    public List<TreeNode> getItemCatList(long pId);
}
