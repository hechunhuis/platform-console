package com.platform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.platform.system.pojo.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SysUserRoleMapper
 * @Description 用户角色持久层
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
