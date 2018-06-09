package com.e3shop.controller;

import com.e3shop.model.PageResult;
import com.e3shop.pojo.TbItem;
import com.e3shop.service.ItemService;
import com.e3shop.utils.E3Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品类入口
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 根据id获取商品信息
     * @param itemId 商品id
     * @return
     */
    @RequestMapping("/getItemById/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem item = itemService.getItemById(itemId);
        return item;
    }

    /**
     * 分页获取商品列表
     * @param page 页数
     * @param rows 条数
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageResult getItemList(Integer page, Integer rows){
        PageResult result = itemService.getItemList(page, rows);
        return result;
    }

    /**
     * 添加商品
     * @param item 商品信息对象
     * @param desc 商品描述信息
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addItem(TbItem item, String desc) {
        return itemService.addItem(item, desc);
    }
}
