package com.e3shop.test;

import com.e3shop.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * 图片服务器测试类
 */
public class FastDfsTest {

    @Test
    public void testUpload() throws Exception {
        // 创建一个配置文件，文件名任意，内容就是tracker服务器地址
        // 使用全局对象加载配置文件
        ClientGlobal.init("E:\\idea workspace\\e3shop\\e3-manager-web\\src\\main\\resources\\config\\client.conf");
        // 创建一个trackerClient对象
        TrackerClient client = new TrackerClient();
        // 通过trackerClient对象获取一个trackerServer对象
        TrackerServer server = client.getConnection();
        // 创建一个storageServer的引用，可以是null
        StorageServer storageServer = null;
        // 创建一个storageClient，参数需要trackerServer和storageServer
        StorageClient storageClient = new StorageClient(server, storageServer);
        // 使用storageClient上传文件
        String[] strs = storageClient.upload_file("E:\\Images\\other\\1.png", "png", null);
        for (String str : strs) {
            System.out.println(str);
            // 输出结果如下：
            // group1
            // M00/00/00/wKgZhVsbUAOAcAPfAAgllMmkXjs676.png
        }
    }

    @Test
    public void FastDfsUtilTest() throws Exception{
        FastDFSClient client = new FastDFSClient("E:\\idea workspace\\e3shop\\e3-manager-web\\src\\main\\resources\\config\\client.conf");
        String imgPath = client.uploadFile("E:\\Images\\other\\2.jpg");
        System.out.println(imgPath);
    }
}
