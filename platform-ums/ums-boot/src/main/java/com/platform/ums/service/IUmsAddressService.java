package com.platform.ums.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.ums.dto.MemberAddressDTO;
import com.platform.ums.pojo.entity.UmsAddress;
import com.platform.ums.pojo.form.AddressForm;

import java.util.List;

/**
 * @ClassName IUmsAddressService
 * @Description 会员地址业务接口
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
public interface IUmsAddressService extends IService<UmsAddress> {

    /**
     * 新增地址
     *
     * @param addressForm
     * @return
     */
    boolean addAddress(AddressForm addressForm);

    /**
     * 修改地址
     *
     * @param addressForm
     * @return
     */
    boolean updateAddress(AddressForm addressForm);

    /**
     * 获取当前登录会员的地址列表
     *
     * @return
     */
    List<MemberAddressDTO> listCurrentMemberAddresses();
}
