package com.platform.system.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName MenuQuery
 * @Description 菜单查询对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@ApiModel("部门分页查询对象")
@Data
public class MenuQuery {

    @ApiModelProperty("关键字(菜单名称)")
    private String keywords;

    @ApiModelProperty("状态(1->显示；0->隐藏)")
    private Integer status;

}
