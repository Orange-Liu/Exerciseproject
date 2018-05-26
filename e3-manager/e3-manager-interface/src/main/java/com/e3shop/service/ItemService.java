package com.e3shop.service;

import com.e3shop.model.PageResult;
import com.e3shop.pojo.TbItem;

public interface ItemService {

    /**
     * 根据商品id查询商品
     * @param itemId
     * @return
     */
    TbItem getItemById(long itemId);

    /**
     * 分页查询商品信息列表
     * @param pageNum 页码数
     * @param pageSize 每页条数
     * @return 结果集
     */
    public PageResult getItemList(int pageNum, int pageSize);
}
