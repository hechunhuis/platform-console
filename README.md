# 管理系统

## 前言

管理系统是一个初步搭建的系统

## 前提

1. JDK版本：1.8及以上
2. MAVEN版本：3.6及以上
3. NACOS版本：2.1.1及以上
4. Sentinel/Sentinel-dashboard版本：1.8.6及以上

## 基础环境搭建

### 1. nacos搭建

#### 下载

官方下载地址【Windows】：https://github.com/alibaba/nacos/releases/download/2.1.1/nacos-server-2.1.1.zip

官方下载地址【Linux】：https://github.com/alibaba/nacos/releases/download/2.1.1/nacos-server-2.1.1.tar.gz

#### 持久化

解压下载后的文件中的【nacos\conf\application.properties】，在文件末端追加以下内容：

```properties
spring.datasource.platform=mysql

db.num=1
db.url.0=jdbc:mysql://{host:port}/{databaseName}?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user={username}
db.password=[password]
```

根据以上信息创建数据库名为【databaseName】，并执行【nacos\conf\nacos-mysql.sql】文件进行建表

#### 导入系统所配置的nacos持久化后的sql文件

路径地址：【platform\init\nacos-mysql.sql】

#### 启动【单机模式】

进入【nacos\bin】下执行相应命令

**Windows：**

```powershell
startup.cmd -m standalone
```

**Linux/Unix/Mac** :

```shell
sh startup.sh -m standalone
```

#### 访问

浏览器打开：http://localhost:8848/nacos

账号：nacos

密码：nacos

### 2. Sentinel-DashBoard搭建

#### 下载

官方下载地址：https://github.com/alibaba/Sentinel/releases/download/1.8.6/sentinel-dashboard-1.8.6.jar

### 运行

```shell
java -jar sentinel-dashboard-1.8.6.jar
```

