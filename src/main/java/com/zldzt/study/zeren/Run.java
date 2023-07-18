package com.zldzt.study.zeren;

import com.zldzt.study.zeren.impl.EnumFactory;

public class Run {
    public static void main(String[] args) {
//        GatewayHandler one = new One();
//        GatewayHandler two = new Two();
//        one.setNext(two);
//        one.service();
        //动态责任链
//        ZeRenHandler firstZeRenHandler = EnumFactory.getFirstHandler();
        //某一步开始的动态责任链
        ZeRenHandler firstZeRenHandler = EnumFactory.getNextHandler(3);
        firstZeRenHandler.service();
    }
}
