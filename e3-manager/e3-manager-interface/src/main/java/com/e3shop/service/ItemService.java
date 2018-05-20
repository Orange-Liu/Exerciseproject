package com.e3shop.service;

import com.e3shop.pojo.TbItem;

public interface ItemService {

    /**
     * 根据商品id查询商品
     * @param itemId
     * @return
     */
    TbItem getItemById(long itemId);
}
