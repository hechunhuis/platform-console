package com.platform.system.converter;

import com.platform.system.pojo.entity.SysDept;
import com.platform.system.pojo.form.DeptForm;
import com.platform.system.pojo.vo.dept.DeptVO;
import org.mapstruct.Mapper;

/**
 * @ClassName DeptConverter
 * @Description 部门对象转换器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Mapper(componentModel = "spring")
public interface DeptConverter {

    DeptForm entity2Form(SysDept entity);

    DeptVO entity2Vo(SysDept entity);

    SysDept form2Entity(DeptForm deptForm);

}