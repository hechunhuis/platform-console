package com.platform.system.pojo.query;

import com.platform.common.base.BasePageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName RolePageQuery
 * @Description 角色分页查询实体
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Data
public class RolePageQuery extends BasePageQuery {

    @ApiModelProperty("关键字(角色名称/角色编码)")
    private String keywords;
}
