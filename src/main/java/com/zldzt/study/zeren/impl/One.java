package com.zldzt.study.zeren.impl;

import com.zldzt.study.zeren.ZeRenHandler;

public class One extends ZeRenHandler {
    @Override
    public void service() {
        System.out.println("one");
        if(this.next != null){
            this.next.service();;
        }
    }
}
