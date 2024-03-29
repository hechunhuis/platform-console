package com.platform.system.pojo.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @ClassName UserLoginVO
 * @Description 登录用户信息对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@ApiModel("当前登录用户对象")
@Data
public class UserLoginVO {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("用户角色编码集合")
    private Set<String> roles;

    @ApiModelProperty("用户权限标识集合")
    private Set<String> perms;

}
