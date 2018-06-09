# Exerciseproject
根据视频做的练习项目，仅供学习使用

最初结构：
```
   |-- e3-parent: 管理jar包版本，打包方式pom
      |-- e3-common: 存放公共工具
      |-- e3-manager: 管理dao、pojo、interface、service、web，打包方式pom
      |-- e3-manager-dao : 数据处理层，打包方式jar
        |-- e3-manager-pojo : 实体模块，打包方式jar
        |-- e3-manager-interface : service接口模块，打包方式jar
        |-- e3-manager-service : service接口实现类模块，打包方式jar
        |-- e3-manager-web : 表现层模块，打包方式war
```
   
使用dubbo+zookeeper的结构：

    |-- e3-parent: 管理jar包版本，打包方式pom
       |-- e3-common: 存放公共工具
       |-- e3-manager: 管理dao、pojo、interface、service、web，打包方式pom
          |-- e3-manager-dao : 数据处理层，打包方式jar
          |-- e3-manager-pojo : 实体模块，打包方式jar
          |-- e3-manager-interface : service接口模块，打包方式jar
          |-- e3-manager-service : service接口实现类模块，打包方式war
       |-- e3-manager-web : 表现层模块，打包方式war
       
2018-06-09日志：

    1、添加FastDFS图片上传服务器（liunx系统）
    2、编写测试方法测试上传功能
    3、商品添加页面添加图片上传功能
    4、商品添加功能完成