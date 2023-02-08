package com.platform.system.listener.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.platform.system.pojo.dto.UserImportDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserImportListener
 * @Description 用户导入监听器
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Component
@Scope("prototype")
public class UserImportListener extends AnalysisEventListener<UserImportDTO.UserItem> {

    @Override
    public void invoke(UserImportDTO.UserItem userItem, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
