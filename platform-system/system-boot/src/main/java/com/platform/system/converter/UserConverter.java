package com.platform.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.system.pojo.bo.UserBO;
import com.platform.system.pojo.bo.UserFormBO;
import com.platform.system.pojo.entity.SysUser;
import com.platform.system.pojo.form.UserForm;
import com.platform.system.pojo.vo.user.UserLoginVO;
import com.platform.system.pojo.vo.user.UserVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @ClassName UserConverter
 * @Description 用户对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "genderLabel", expression = "java(com.platform.common.base.IBaseEnum.getLabelByValue(bo.getGender(), com.platform.common.enums.GenderEnum.class))")
    })
    UserVO bo2Vo(UserBO bo);

    Page<UserVO> bo2Vo(Page<UserBO> po);

    UserForm bo2Form(UserFormBO po);

    @InheritInverseConfiguration(name = "entity2Form")
    SysUser form2Entity(UserForm entity);

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    UserLoginVO entity2LoginUser(SysUser entity);
}
