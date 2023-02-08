package com.platform.ums.convert;

import com.platform.ums.dto.MemberAddressDTO;
import com.platform.ums.pojo.entity.UmsAddress;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @ClassName AddressConvert
 * @Description 会员地址对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface AddressConvert {

    MemberAddressDTO entity2Dto(UmsAddress entity);

    List<MemberAddressDTO> entity2Dto(List<UmsAddress> entities);
}
