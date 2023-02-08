package com.platform.system.pojo.query;

import com.platform.common.base.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName UserPageQuery
 * @Description 用户分页查询对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@ApiModel
@Data
public class UserPageQuery extends BasePageQuery {

    @ApiModelProperty("关键字(用户名/昵称/手机号)")
    private String keywords;

    @ApiModelProperty("用户状态")
    private Integer status;

    @ApiModelProperty("部门ID")
    private Long deptId;

}
