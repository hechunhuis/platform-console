package com.platform.ums.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName MemberDTO
 * @Description 会员传输层对象
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Data
public class MemberDTO {

    private Integer gender;

    private String nickName;

    private String mobile;

    private LocalDate birthday;

    private String avatarUrl;

    private String openid;

    private String sessionKey;

    private String city;

    private String country;

    private String language;

    private String province;

}
