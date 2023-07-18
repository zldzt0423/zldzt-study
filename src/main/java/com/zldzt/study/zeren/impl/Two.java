package com.zldzt.study.zeren.impl;

import com.zldzt.study.zeren.ZeRenHandler;

public class Two extends ZeRenHandler {
    @Override
    public void service() {
        System.out.println("two");
        if(this.next != null){
            this.next.service();
        }
    }
}
