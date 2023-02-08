package com.platform.system.pojo.vo.perm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName PermPageVO
 * @Description 权限视图对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@ApiModel("权限视图对象")
@Data
public class PermPageVO {

    @ApiModelProperty("权限ID")
    private Long id;

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("URL权限标识-服务名称")
    private String serviceName;

    @ApiModelProperty("URL权限标识-请求标识")
    private String requestMethod;

    @ApiModelProperty("URL权限标识-请求方式")
    private String requestPath;

    @ApiModelProperty("按钮权限标识")
    private String btnPerm;

}
