package com.platform.ums.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName MemberVO
 * @Description 会员视图层对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@ApiModel("会员视图层对象")
@Data
public class MemberVO {

    @ApiModelProperty("会员ID")
    private Long id;

    @ApiModelProperty("会员昵称")
    private String nickName;

    @ApiModelProperty("会员头像地址")
    private String avatarUrl;

    @ApiModelProperty("会员手机号")
    private String mobile;

    @ApiModelProperty("会员余额(单位:分)")
    private Long balance;

}
