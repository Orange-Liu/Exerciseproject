package cn.e3shop.service.impl;

import com.e3shop.mapper.TbItemDescMapper;
import com.e3shop.mapper.TbItemMapper;
import com.e3shop.model.PageResult;
import com.e3shop.pojo.TbItem;
import com.e3shop.pojo.TbItemDesc;
import com.e3shop.pojo.TbItemExample;
import com.e3shop.service.ItemService;
import com.e3shop.utils.E3Result;
import com.e3shop.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

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

    /**
     * 添加商品信息
     *
     * @param item 商品信息
     * @param desc 商品描述信息
     * @return 结果集
     */
    @Override
    public E3Result addItem (TbItem item, String desc) {
        // 生成商品id信息
        long itemId = IDUtils.genItemId();
        // 补全商品信息实体对象
        item.setId(itemId);
        // 1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        // 保存商品信息实体
        itemMapper.insert(item);
        // 创建商品描述实体对象
        TbItemDesc itemDesc = new TbItemDesc();
        // 补全商品描述实体
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        // 保存商品描述实体
        itemDescMapper.insert(itemDesc);
        // 返回结果
        return E3Result.ok();
    }
}
