package com.platform.system.converter;

import com.platform.system.pojo.entity.SysMenu;
import com.platform.system.pojo.vo.menu.MenuVO;
import org.mapstruct.Mapper;

/**
 * @ClassName MenuConverter
 * @Description 菜单对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {

    MenuVO entity2VO(SysMenu entity);

}