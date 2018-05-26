package cn.e3shop.controller;

import com.e3shop.model.TreeNode;
import com.e3shop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类controller
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService catService;

    /**
     * 根据分类parentId查询分类列表
     * @param pId parentId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(
            @RequestParam(name = "id", defaultValue = "0") long pId){
        List<TreeNode> result = catService.getItemCatList(pId);
        return result;
    }
}
