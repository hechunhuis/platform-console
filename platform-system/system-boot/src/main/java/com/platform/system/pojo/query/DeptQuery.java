package com.platform.system.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName UserForm
 * @Description 部门分页查询对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@ApiModel("部门分页查询对象")
@Data
public class DeptQuery {

    @ApiModelProperty("关键字(部门名称)")
    private String keywords;

    @ApiModelProperty("状态(1->正常；0->禁用)")
    private Integer status;

}
