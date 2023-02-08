package com.platform.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.system.pojo.entity.SysDictItem;
import com.platform.system.pojo.form.DictItemForm;
import com.platform.system.pojo.query.DictItemPageQuery;
import com.platform.system.pojo.vo.dict.DictItemPageVO;

/**
 * @ClassName SysDictItemService
 * @Description
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
public interface SysDictItemService extends IService<SysDictItem> {
    /**
     * 字典数据项分页列表
     *
     * @param queryParams
     * @return
     */
    Page<DictItemPageVO> listDictItemPages(DictItemPageQuery queryParams);

    /**
     * 字典数据项表单详情
     *
     * @param id 字典数据项ID
     * @return
     */
    DictItemForm getDictItemForm(Long id);

    /**
     * 新增字典数据项
     *
     * @param dictItemForm 字典数据项表单
     * @return
     */
    boolean saveDictItem(DictItemForm dictItemForm);

    /**
     * 修改字典数据项
     *
     * @param id           字典数据项ID
     * @param dictItemForm 字典数据项表单
     * @return
     */
    boolean updateDictItem(Long id, DictItemForm dictItemForm);

    /**
     * 删除字典数据项
     *
     * @param idsStr 字典数据项ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteDictItems(String idsStr);
}
