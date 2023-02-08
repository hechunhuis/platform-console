package com.platform.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.platform.common.base.BaseEntity;
import com.platform.system.enums.MenuTypeEnum;
import lombok.Data;

/**
 * @ClassName SysMenu
 * @Description 菜单实体类
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SysMenu extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String name;

    private String icon;

    /**
     * 路由path
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    private Integer sort;

    private Integer visible;

    private String redirect;

    /**
     * 菜单类型(1:菜单；2：目录；3：外链；4：按钮)
     */
    private MenuTypeEnum type;

    /**
     * 按钮权限标识
     */
    private String perm;

}
