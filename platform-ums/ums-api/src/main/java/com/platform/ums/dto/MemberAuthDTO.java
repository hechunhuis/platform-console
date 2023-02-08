package com.platform.ums.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName MemberAuthDTO
 * @Description 会员认证传输层对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class MemberAuthDTO {

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 会员名(openId、mobile)
     */
    private String username;

    /**
     * 状态(1:正常；0：禁用)
     */
    private Integer status;
}
