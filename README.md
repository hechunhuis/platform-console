# PlatForm

Java开发脚手架，目前还处于建设 阶段，后期会不断完善，项目使用SpringCloud开发，集成了SpringCloud Alibaba、SpringGateway、SpringSecurity、Oauth2、OpenFeign等技术。

## 前言

[Java](https://www.java.com/zh-CN/)版本：JDK8及以上

[Maven](https://maven.apache.org/)版本：maven 3.6 及以上

[Nacos Server](https://github.com/alibaba/nacos/releases)：2.1.2（2022 年 10 月 17 日）

## 运行

```shell
# 下载项目并进入根目录执行以下命令
Maven 执行 mvn install
Maven执行mvn idea:idea
用idea打开，并选择父工程右键添加maven支持
启动nacos server
到Web工程下启动application.class
```
项目中使用[Lombok](https://projectlombok.org/features/all)，IDEA开发需要安装Lombok插件

