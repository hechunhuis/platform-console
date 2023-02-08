package com.platform.common.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName DataPermission
 * @Description 数据权限注解
 * @Author <a href="hechunhui_email@163.com">hechunhui</a>
 * @Date 2023/2/8 13:44
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DataPermission {

    /**
     * 数据权限 {@link com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor}
     */
    String deptAlias() default ""; //部门别名

    String deptIdColumnName() default "dept_id"; //部门ID列名

    String userAlias() default ""; //用户别名

    String userIdColumnName() default "create_by"; //用户ID列名
}
