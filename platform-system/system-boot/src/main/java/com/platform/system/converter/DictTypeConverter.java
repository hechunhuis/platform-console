package com.platform.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.system.pojo.entity.SysDictType;
import com.platform.system.pojo.form.DictTypeForm;
import com.platform.system.pojo.vo.dict.DictTypePageVO;
import org.mapstruct.Mapper;

/**
 * @ClassName DictTypeConverter
 * @Description 字典类型对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface DictTypeConverter {

    Page<DictTypePageVO> entity2Page(Page<SysDictType> page);

    DictTypeForm entity2Form(SysDictType entity);

    SysDictType form2Entity(DictTypeForm entity);
}
