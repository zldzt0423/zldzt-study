package com.zldzt.study.zeren;

public abstract class ZeRenHandler {
    public ZeRenHandler next;

    public void setNext(ZeRenHandler next) {
        this.next = next;
    }
    public  abstract void service();
}
