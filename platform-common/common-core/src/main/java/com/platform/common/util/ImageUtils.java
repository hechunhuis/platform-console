package com.platform.common.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @ClassName ImageUtils
 * @Description 图片工具类
 * @Author hechunhui
 * @Date 2023/2/8 11:40
 * @Version 1.0
 */
public class ImageUtils {

    private static final String[] imgSuffixArr = {"bmp", "dib", "gif", "jfif", "jpe", "jpeg", "jpg", "png", "tif", "tiff", "ico"};

    /**
     * 是否图片判断
     *
     * @param fileName
     * @return
     */
    public static boolean isImage(String fileName) {
        if (StrUtil.isBlank(fileName)) {
            return false;
        }

        String fileSuffix = FileUtil.getSuffix(fileName);

        for (String imgSuffix : imgSuffixArr) {
            if (fileSuffix.equals(imgSuffix)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 根据图片大小设置压缩比
     *
     * @param size 图片大小(单位：Bytes)
     * @return 压缩比例
     */
    public static float getCompressQuality(long size) {
        if (size > 0.1 * 1024 * 1024 && size <= 0.5 * 1024 * 1024) {
            return 0.8f;
        } else if (size > 0.5 * 1024 * 1024 && size <= 1 * 1024 * 1024) {
            return 0.6f;
        } else if (size > 1 * 1024 * 1024 && size <= 2 * 1024 * 1024) {
            return 0.4f;
        } else if (size > 2 * 1024 * 1024 && size <= 5 * 1024 * 1024) {
            return 0.2f;
        } else {
            // 大于5M
            return 0.1f;
        }
    }
}