package com.platform.system.listener.rabbitmq;

import com.platform.common.web.model.CanalMessage;
import com.platform.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName CanalListener
 * @Description Canal + RabbitMQ 监听数据库数据变化
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class CanalListener {

    private final SysMenuService menuService;

    //@RabbitListener(queues = "canal.queue")
    public void handleDataChange(@Payload CanalMessage message) {
        String tableName = message.getTable();

        log.info("Canal 监听 {} 发生变化；明细：{}", tableName, message);
        if (Arrays.asList("sys_menu", "sys_role", "sys_role_menu").contains(tableName)) {
            log.info("======== 清理菜单路由缓存 ========");
            menuService.cleanCache();
        }
    }
}
