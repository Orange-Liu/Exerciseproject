package cn.e3shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 显示首页
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**
     * 显示相应页面
     */
    @RequestMapping("/{pageName}")
    public String showPage(@PathVariable String pageName){
        return pageName;
    }
}
