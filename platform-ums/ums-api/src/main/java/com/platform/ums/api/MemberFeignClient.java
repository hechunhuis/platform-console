package com.platform.ums.api;

import com.platform.common.result.Result;
import com.platform.ums.dto.MemberAddressDTO;
import com.platform.ums.dto.MemberAuthDTO;
import com.platform.ums.dto.MemberDTO;
import com.platform.ums.dto.MemberInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MemberFeignClient
 * @Description 会员Feign客户端
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@FeignClient(name = "platform-ums", contextId = "member")
public interface MemberFeignClient {

    /**
     * 新增会员
     *
     * @param member
     * @return
     */
    @PostMapping("/app-api/v1/members")
    Result<Long> addMember(@RequestBody MemberDTO member);

    /**
     * 获取会员的 openid
     *
     * @return
     */
    @PostMapping("/app-api/v1/members/{memberId}/openid")
    Result<String> getMemberOpenId(@PathVariable Long memberId);

    /**
     * 扣减会员余额
     */
    @PutMapping("/app-api/v1/members/{memberId}/balances/_deduct")
    <T> Result<T> deductBalance(@PathVariable Long memberId, @RequestParam Long amount);

    /**
     * 添加浏览记录
     */
//    @PostMapping("/app-api/v1/members/view/history")
//    <T> Result<T> addProductViewHistory(@RequestBody ProductHistoryVO product);

    /**
     * 根据openId获取会员认证信息
     *
     * @param openid
     * @return
     */
    @GetMapping("/app-api/v1/members/openid/{openid}")
    Result<MemberAuthDTO> loadUserByOpenId(@PathVariable String openid);

    /**
     * 根据手机号获取会员认证信息
     *
     * @param mobile
     * @return
     */
    @GetMapping("/app-api/v1/members/mobile/{mobile}")
    Result<MemberAuthDTO> loadUserByMobile(@PathVariable String mobile);

    /**
     * 获取会员地址列表
     *
     * @param memberId
     * @return
     */
    @GetMapping("/app-api/v1/members/{memberId}/addresses")
    Result<List<MemberAddressDTO>> listMemberAddresses(@PathVariable Long memberId);

    /**
     * 「实验室」重置会员余额
     *
     * @param memberId
     * @return
     */
    @PutMapping("/app-api/v1/members/{memberId}/balance/_reset")
    Result resetBalance(@PathVariable Long memberId);

    /**
     * 「实验室」获取会员信息
     *
     * @param memberId
     * @return
     */
    @GetMapping("/api/v1/members/{memberId}/info")
    Result<MemberInfoDTO> getMemberInfo(@PathVariable Long memberId);

}


