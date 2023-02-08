package com.platform.ums.controller.app;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.platform.common.result.Result;
import com.platform.common.result.ResultCode;
import com.platform.common.security.util.SecurityUtils;
import com.platform.ums.dto.MemberAddressDTO;
import com.platform.ums.dto.MemberAuthDTO;
import com.platform.ums.dto.MemberDTO;
import com.platform.ums.pojo.entity.UmsMember;
import com.platform.ums.pojo.vo.MemberVO;
import com.platform.ums.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Api(tags = "「移动端」会员管理")
@RestController
@RequestMapping("/app-api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final IUmsMemberService memberService;

    @ApiOperation(value = "根据会员ID获取openid")
    @GetMapping("/{memberId}/openid")
    public Result<String> getMemberById(@ApiParam("会员ID") @PathVariable Long memberId) {
        UmsMember member = memberService.getOne(new LambdaQueryWrapper<UmsMember>()
                .eq(UmsMember::getId, memberId)
                .select(UmsMember::getOpenid));
        String openid = member.getOpenid();
        return Result.success(openid);
    }

    @ApiOperation(value = "新增会员")
    @PostMapping
    public Result<Long> addMember(@RequestBody MemberDTO member) {
        Long memberId = memberService.addMember(member);
        return Result.success(memberId);
    }

    @ApiOperation(value = "获取登录会员信息")
    @GetMapping("/me")
    public Result<MemberVO> getCurrMemberInfo() {
        MemberVO memberVO = memberService.getCurrMemberInfo();
        return Result.success(memberVO);
    }

    @ApiOperation(value = "扣减会员余额")
    @PutMapping("/{memberId}/balances/_deduct")
    public Result deductBalance(@PathVariable Long memberId, @RequestParam Long amount) {
        boolean result = memberService.update(new LambdaUpdateWrapper<UmsMember>()
                .setSql("balance = balance - " + amount)
                .eq(UmsMember::getId, memberId));
        return Result.judge(result);
    }

    @ApiOperation(value = "根据 openid 获取会员认证信息")
    @GetMapping("/openid/{openid}")
    public Result<MemberAuthDTO> getByOpenid(@ApiParam("微信身份标识") @PathVariable String openid) {
        MemberAuthDTO memberAuthInfo = memberService.getByOpenid(openid);
        if (memberAuthInfo == null) {
            return Result.failed(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(memberAuthInfo);
    }

    @ApiOperation(value = "根据手机号获取会员认证信息", hidden = true)
    @GetMapping("/mobile/{mobile}")
    public Result<MemberAuthDTO> getMemberByMobile(
            @ApiParam("手机号码") @PathVariable String mobile
    ) {
        MemberAuthDTO memberAuthInfo = memberService.getMemberByMobile(mobile);
        if (memberAuthInfo == null) {
            return Result.failed(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(memberAuthInfo);
    }

    @ApiOperation("获取会员地址列表")
    @GetMapping("/{memberId}/addresses")
    public Result<List<MemberAddressDTO>> listMemberAddress(
            @ApiParam("会员ID") @PathVariable Long memberId
    ) {
        List<MemberAddressDTO> addresses = memberService.listMemberAddress(memberId);
        return Result.success(addresses);
    }

    @ApiOperation(value = "「实验室」重置会员余额", hidden = true)
    @PutMapping("/{memberId}/balance/_reset")
    public Result resetBalance(@PathVariable Long memberId) {
        boolean result = memberService.update(
                new LambdaUpdateWrapper<UmsMember>()
                        .eq(UmsMember::getId, memberId)
                        .set(UmsMember::getBalance, 10000000l));
        return Result.judge(result);
    }

}
