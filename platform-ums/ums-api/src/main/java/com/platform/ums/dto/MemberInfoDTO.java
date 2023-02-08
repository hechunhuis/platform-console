package com.platform.ums.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName MemberInfoDTO
 * @Description 会员传输层对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Data
public class MemberInfoDTO {

    private String nickName;

    private String avatarUrl;

    private Long balance;

}
