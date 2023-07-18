package com.zldzt.study.zeren.impl;

import com.zldzt.study.zeren.ZeRenHandler;

public class Three extends ZeRenHandler {
    @Override
    public void service() {
        System.out.println("three");
        if(this.next != null){
            this.next.service();;
        }
    }
}
