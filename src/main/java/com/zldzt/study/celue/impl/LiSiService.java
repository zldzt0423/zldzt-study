package com.zldzt.study.celue.impl;

import com.zldzt.study.celue.CeLueHandler;
import com.zldzt.study.celue.bean.Zldzt;
import com.zldzt.study.zeren.ZeRenHandler;
import com.zldzt.study.zeren.impl.EnumFactory;
import org.springframework.stereotype.Component;

@Component("lisi")
public class LiSiService implements CeLueHandler {
    @Override
    public Boolean BeUse(Integer type) {
        return type == 1;
    }

    @Override
    public String whatIsYourName(Zldzt zldzt) {
        ZeRenHandler firstZeRenHandler = EnumFactory.getFirstHandler();
        firstZeRenHandler.service();
        return zldzt.getName()+"你是个渣女";
    }
}
