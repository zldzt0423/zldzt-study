package com.zldzt.study.zeren.impl;

public enum ZeRenEnum {

    ONE(new ZeRenEntity(1,"ONE","com.zldzt.study.zeren.impl.One",2)),
    TWO(new ZeRenEntity(2,"TWO","com.zldzt.study.zeren.impl.Two",3)),
    THREE(new ZeRenEntity(3,"TWO","com.zldzt.study.zeren.impl.Three",null));

    private ZeRenEntity entity;

    public static ZeRenEntity getNext(Integer nextId) {
        ZeRenEnum[] values = values();
        for(ZeRenEnum e : values){
            if(e.getEntity().getId().equals(nextId)){
                return e.getEntity();
            }
        }
        return null;
    }

    public ZeRenEntity getEntity() {
        return entity;
    }
    private ZeRenEnum(ZeRenEntity entity){
        this.entity = entity;
    }
}
