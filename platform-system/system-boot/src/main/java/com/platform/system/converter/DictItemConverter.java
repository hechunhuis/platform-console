package com.platform.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.system.pojo.entity.SysDictItem;
import com.platform.system.pojo.form.DictItemForm;
import com.platform.system.pojo.vo.dict.DictItemPageVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * @ClassName DictItemConverter
 * @Description 字典数据项对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface DictItemConverter {

    Page<DictItemPageVO> entity2Page(Page<SysDictItem> page);

    DictItemForm entity2Form(SysDictItem entity);

    @InheritInverseConfiguration(name = "entity2Form")
    SysDictItem form2Entity(DictItemForm entity);
}
