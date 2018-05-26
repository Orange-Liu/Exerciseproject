package cn.e3shop.service.impl;

import com.e3shop.mapper.TbItemCatMapper;
import com.e3shop.model.TreeNode;
import com.e3shop.pojo.TbItemCat;
import com.e3shop.pojo.TbItemCatExample;
import com.e3shop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3shop.pojo.TbItemCatExample.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类接口实现类
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    /**
     * 根据分类parentId查询分类列表
     *
     * @param pId parentId
     * @return
     */
    @Override
    public List<TreeNode> getItemCatList(long pId) {
        // 分类查询工具类
        TbItemCatExample example = new TbItemCatExample();
        // 创建查询条件对象
        Criteria criteria = example.createCriteria();
        // 设置查询条件
        criteria.andParentIdEqualTo(pId);
        // 执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        // 创建返回结果对象
        List<TreeNode> results = new ArrayList<TreeNode>();
        // 封装结果集
        if (list != null && list.size() > 0){
            for (TbItemCat cat : list) {
                TreeNode node = new TreeNode();
                node.setId(cat.getId());
                node.setText(cat.getName());
                node.setState(cat.getIsParent() ? "closed" : "open");
                results.add(node);
            }
        }
        return results;
    }
}
