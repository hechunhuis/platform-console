package com.platform.ums.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.ums.dto.MemberAddressDTO;
import com.platform.ums.dto.MemberAuthDTO;
import com.platform.ums.dto.MemberDTO;
import com.platform.ums.dto.MemberInfoDTO;
import com.platform.ums.pojo.entity.UmsMember;
import com.platform.ums.pojo.vo.MemberVO;

import java.util.List;

/**
 * @ClassName IUmsMemberService
 * @Description 会员业务接口
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
public interface IUmsMemberService extends IService<UmsMember> {

    IPage<UmsMember> list(Page<UmsMember> page, String nickname);

    /**
     * 根据 openid 获取会员认证信息
     *
     * @param openid
     * @return
     */
    MemberAuthDTO getByOpenid(String openid);

    /**
     * 根据手机号获取会员认证信息
     *
     * @param mobile
     * @return
     */
    MemberAuthDTO getMemberByMobile(String mobile);

    /**
     * 新增会员
     *
     * @param member
     * @return
     */
    Long addMember(MemberDTO member);

    /**
     * 获取登录会员信息
     *
     * @return
     */
    MemberVO getCurrMemberInfo();

    /**
     * 获取会员地址列表
     *
     * @param memberId
     * @return
     */
    List<MemberAddressDTO> listMemberAddress(Long memberId);

    /**
     * 「实验室」修改会员余额
     *
     * @param memberId
     * @param balance  会员余额
     * @return
     */
    boolean updateBalance(Long memberId, Long balance);

    /**
     * 「实验室」扣减账户余额
     *
     * @param memberId
     * @param amount   扣减金额
     * @return
     */
    boolean deductBalance(Long memberId, Long amount);

    /**
     * 「实验室」获取会员信息
     *
     * @param memberId
     * @return
     */
    MemberInfoDTO getMemberInfo(Long memberId);


}
