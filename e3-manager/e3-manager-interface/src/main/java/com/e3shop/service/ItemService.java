package com.e3shop.service;

import com.e3shop.model.PageResult;
import com.e3shop.pojo.TbItem;
import com.e3shop.utils.E3Result;

public interface ItemService {

    /**
     * 根据商品id查询商品
     * @param itemId
     * @return 商品对象
     */
    TbItem getItemById(long itemId);

    /**
     * 分页查询商品信息列表
     * @param pageNum 页码数
     * @param pageSize 每页条数
     * @return 分页结果集
     */
     PageResult getItemList(int pageNum, int pageSize);

    /**
     * 添加商品信息
     * @param item 商品信息
     * @param desc 商品描述信息
     * @return 结果集
     */
     E3Result addItem(TbItem item, String desc);
}
