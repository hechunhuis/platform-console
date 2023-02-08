package com.platform.common.web.constraint;

import lombok.Data;

/**
 * @ClassName CityEntity
 * @Description 城市实体
 * @Author hechunhui
 * @Date 2023/2/8 14:16
 * @Version 1.0
 */
@Data
public class CityEntity {
    private String value;
    private String name;
    private String parent;
}
