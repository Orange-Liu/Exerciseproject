package com.e3shop.controller;

import com.e3shop.utils.FastDFSClient;
import com.e3shop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: liuchenghui
 * @Date: 2018/6/9 19:58
 * @Description: 图片上传controller
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            // 创建FastDFSClient对象
            FastDFSClient client = new FastDFSClient("classpath:config/client.conf");
            // 获取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            // 上传图片到图片服务器
            String url = client.uploadFile(uploadFile.getBytes(), extName);
            // 拼接完整的图片url
            url = IMAGE_SERVER_URL + url;
            // 封装结果到map中
            resultMap.put("error", 0);
            resultMap.put("url", url);
            return JsonUtils.objectToJson(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("error", 1);
            resultMap.put("message", "图片上传失败");
            return JsonUtils.objectToJson(resultMap);
        }
    }
}
