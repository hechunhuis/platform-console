# 管理系统后台

## 简介

PLATFORM是基于SpringBoot 2.7、Spring Cloud & Alibaba构建的后台管理系统

## 🗂目录结构

```text
platform-console
├── middleware     -- 中间件(nacos/seata)
├── platform-auth    -- OAuth2认证授权中心
├── platform-common  -- 公共依赖
├── platform-gateway -- 网关
├── platform-system  -- 系统服务
├── platform-ums     -- 用户服务
└── end
```

## 🥇快速启动

1. 启动Nacos<br/>
   在IDEA打开命令行终端Terminal<br/>
   输入 <code>cd middleware/nacos/bin</code> 切换到Nacos的bin目录<br>
   执行 <code>startup -m standalone</code> 启动单机版Nacos服务
2. 启动服务<br/>
   <code>platform-gateway</code> 模块的启动类 GatewayApplication 启动网关<br/>
   <code>platform-auth</code> 模块的启动类 AuthApplication 启动认证中心<br/>
   <code>platform-system</code> -> <code>system-boot</code> 模块的启动类 SystemApplication 启动系统服务<br/>
   基础服务启动完成，其他服务按需启动，步骤与<code>platform-system</code>相同<br/>