package com.platform.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.system.pojo.entity.SysRoleMenu;
import com.platform.system.mapper.SysRoleMenuMapper;
import com.platform.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    /**
     * 获取角色拥有的菜单ID集合
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Long> listMenuIdsByRoleId(Long roleId) {
        List<Long> menuIds = this.baseMapper.listMenuIdsByRoleId(roleId);
        return menuIds;
    }

}
