package com.platform.common.enums;

import com.platform.common.base.IBaseEnum;
import lombok.Getter;

/**
 * @ClassName DataPermissionEnum
 * @Description 数据权限枚举
 * @Author hechunhui
 * @Date 2023/2/8 11:30
 * @Version 1.0
 */
public enum DataPermissionEnum implements IBaseEnum<Integer> {
    /**
     * value 越小，数据权限范围越大
     */
    ALL(0, "所有数据"),
    DEPT_AND_SUB(1, "部门及子部门数据"),
    DEPT(2, "本部门数据"),
    SELF(3, "本人数据");

    @Getter
    private Integer value;

    @Getter
    private String label;

    DataPermissionEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
