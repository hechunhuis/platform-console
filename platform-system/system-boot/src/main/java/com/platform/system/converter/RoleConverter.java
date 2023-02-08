package com.platform.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.common.web.model.Option;
import com.platform.system.pojo.entity.SysRole;
import com.platform.system.pojo.form.RoleForm;
import com.platform.system.pojo.vo.role.RolePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @ClassName RoleConverter
 * @Description 角色对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    Page<RolePageVO> entity2Page(Page<SysRole> page);

    @Mappings({
            @Mapping(target = "value", source = "id"),
            @Mapping(target = "label", source = "name")
    })
    Option role2Option(SysRole role);


    List<Option> roles2Options(List<SysRole> roles);

    SysRole form2Entity(RoleForm roleForm);
}