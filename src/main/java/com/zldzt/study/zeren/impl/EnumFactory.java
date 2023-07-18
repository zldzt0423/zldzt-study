package com.zldzt.study.zeren.impl;

import com.zldzt.study.zeren.ZeRenHandler;

import java.util.HashMap;
import java.util.Map;

public class EnumFactory {
    /**
     * 从头开始
     * @return
     */
    public static ZeRenHandler getFirstHandler(){

        ZeRenEntity entity = getFirstEntity();
        if(entity ==null){
            System.out.println("没找到第一个执行器");
            return null;
        }
        ZeRenHandler firstZeRenHandler = newGatewayhandler(entity);
        ZeRenHandler tempZeRenHandler = firstZeRenHandler;
        ZeRenEntity tempGatewayEntity = entity;

        while (tempGatewayEntity.getNextId() != null){
            ZeRenEntity gatewayEntity = ZeRenEnum.getNext(tempGatewayEntity.getNextId());
            ZeRenHandler zeRenHandler = newGatewayhandler(gatewayEntity);
            tempZeRenHandler.setNext(zeRenHandler);
            tempZeRenHandler = zeRenHandler;//因为你第一个执行完后，是在第二步去添加第三步而不是在第一步添加第三步所以才需要tempGatewayHandler的临时变量
            tempGatewayEntity = gatewayEntity;
        }
        return firstZeRenHandler;

    }
    /**
     * 从中间开始
     */
    public static ZeRenHandler getNextHandler(Integer id){

        ZeRenEntity entity = ZeRenEnum.getNext(id);
        if(entity ==null){
            System.out.println("没找到第一个执行器");
            return null;
        }
        ZeRenHandler firstZeRenHandler = newGatewayhandler(entity);
        ZeRenHandler tempZeRenHandler = firstZeRenHandler;
        ZeRenEntity tempGatewayEntity = entity;

        while (tempGatewayEntity.getNextId() != null){
            ZeRenEntity gatewayEntity = ZeRenEnum.getNext(tempGatewayEntity.getNextId());
            ZeRenHandler zeRenHandler = newGatewayhandler(gatewayEntity);
            tempZeRenHandler.setNext(zeRenHandler);
            tempZeRenHandler = zeRenHandler;//因为你第一个执行完后，是在第二步去添加第三步而不是在第一步添加第三步所以才需要tempGatewayHandler的临时变量
            tempGatewayEntity = gatewayEntity;
        }
        return firstZeRenHandler;
    }
    /**
     * 反射实例化处理者
     */
    private static ZeRenHandler newGatewayhandler(ZeRenEntity entity){
        //根据类路径获取类
        String classPath = entity.getClassPath();
        try {
            Class<?> clazz = Class.forName(classPath);
            return (ZeRenHandler) clazz.newInstance();//newInstance() 是用来创建对象，相当于new GatewayHandler()
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * 获取第一个Entity
     */
    private static ZeRenEntity getFirstEntity(){
        Map<Integer, ZeRenEntity> map = new HashMap<>();
        //获取第一个动态的责任链
        ZeRenEnum[] values = ZeRenEnum.values();
        for(ZeRenEnum e : values){
            ZeRenEntity entity = e.getEntity();
            map.put(entity.getId(),entity);
        }
        for (Map.Entry<Integer, ZeRenEntity> entry : map.entrySet()) {
            ZeRenEntity value = entry.getValue();
            //  没有上一个handler的就是第一个
            if (value.getId() == 1) {
                return value;
            }
        }
//        return Enum.ONE.getEntity();
        return null;
    }
}
