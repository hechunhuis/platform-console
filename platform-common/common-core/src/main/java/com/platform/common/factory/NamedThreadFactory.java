package com.platform.common.factory;

import cn.hutool.core.util.StrUtil;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName NamedThreadFactory
 * @Description 自定义ThreadFactory，重命名线程池
 * @Author hechunhui
 * @Date 2023/2/8 11:34
 * @Version 1.0
 */
public class NamedThreadFactory implements ThreadFactory {

    private final AtomicInteger poolNumber = new AtomicInteger(1);

    private final ThreadGroup threadGroup;

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public final String namePrefix;

    public NamedThreadFactory(String name) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            this.threadGroup = securityManager.getThreadGroup();
        } else {
            this.threadGroup = Thread.currentThread().getThreadGroup();
        }

        if (StrUtil.isBlank(name)) {
            name = "pool";
        }
        namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(threadGroup, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }

        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
