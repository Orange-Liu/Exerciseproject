package cn.e3shop.service.impl;

import com.e3shop.mapper.TbItemMapper;
import com.e3shop.model.PageResult;
import com.e3shop.pojo.TbItem;
import com.e3shop.pojo.TbItemExample;
import com.e3shop.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询商品信息列表
     * @param pageNum 页码数
     * @param pageSize 每页条数
     * @return 结果集
     */
    @Override
    public PageResult getItemList(int pageNum, int pageSize) {
        // 设置分页数据
        PageHelper.startPage(pageNum, pageSize);
        // 查询数据
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        // 获取分页信息
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        // 封装返回结果集
        PageResult result = new PageResult();
        result.setRows(tbItems);
        result.setTotal(info.getTotal());
        return result;
    }
}
