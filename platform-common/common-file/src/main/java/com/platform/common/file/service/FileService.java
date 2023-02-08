package com.platform.common.file.service;

import com.platform.common.file.vo.FileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileService
 * @Description 文件接口
 * @Author hechunhui
 * @Date 2023/2/8 13:31
 * @Version 1.0
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 表单文件对象
     * @return
     */
    FileInfo uploadFile(MultipartFile file);

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return
     */
    boolean deleteFile(String filePath);
}
