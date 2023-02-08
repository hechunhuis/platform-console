package com.platform.system.pojo.form;

import lombok.Data;

import java.util.List;

/**
 * @ClassName RolePermsForm
 * @Description 角色权限传输层对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Data
public class RolePermsForm {

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID集合
     */
    private List<Long> permIds;

}
