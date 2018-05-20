package cn.e3shop.service.impl;

import com.e3shop.mapper.TbItemMapper;
import com.e3shop.pojo.TbItem;
import com.e3shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    /**
     * 根据商品id查询商品
     * @param itemId
     * @return
     */
    @Override
    public TbItem getItemById(long itemId) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        return tbItem;
    }
}
