package com.zldzt.study.celue.impl;

import com.zldzt.study.celue.CeLueHandler;
import com.zldzt.study.celue.bean.Zldzt;
import com.zldzt.study.zeren.ZeRenHandler;
import com.zldzt.study.zeren.impl.EnumFactory;
import org.springframework.stereotype.Component;

@Component("zhangsan")
public class ZhangSanService implements CeLueHandler {
    @Override
    public Boolean BeUse(Integer type) {
        return type == 2;
    }

    @Override
    public String whatIsYourName(Zldzt zldzt) {
        ZeRenHandler firstZeRenHandler = EnumFactory.getNextHandler(2);
        firstZeRenHandler.service();
        return zldzt.getName()+"你是个人渣";
    }
}
