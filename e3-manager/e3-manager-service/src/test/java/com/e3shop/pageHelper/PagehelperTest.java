package com.e3shop.pageHelper;

import com.e3shop.mapper.TbItemMapper;
import com.e3shop.pojo.TbItem;
import com.e3shop.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PagehelperTest {

    @Test
    public void testPageHelper(){
        //1、初始化spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //2、从容器中获取mybatis代理对象
        TbItemMapper itemMapper = ctx.getBean(TbItemMapper.class);
        //3、执行sql语句之前获取设置分页信息pageHelper
        PageHelper.startPage(1, 10);
        //4、执行sql
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        //5、取分页信息,从pageInfo中取
        PageInfo<TbItem> info = new PageInfo<TbItem>(tbItems);
        System.out.println(info.getTotal());
        System.out.println(info.getPages());
        System.out.println(tbItems.size());
    }
}
