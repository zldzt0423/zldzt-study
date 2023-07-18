package com.zldzt.study.zeren.impl;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZeRenEntity {
    private Integer id;
    private String name;
    private String classPath;
    private Integer nextId;

}
