package com.platform.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName BasePageQuery
 * @Description 基础分页请求对象
 * @Author hechunhui
 * @Date 2023/2/8 11:24
 * @Version 1.0
 */
@Data
@ApiModel
public class BasePageQuery {

    @ApiModelProperty(value = "页码", example = "1")
    private int pageNum = 1;

    @ApiModelProperty(value = "每页记录数", example = "10")
    private int pageSize = 10;
}
