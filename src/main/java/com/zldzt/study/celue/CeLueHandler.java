package com.zldzt.study.celue;

import com.zldzt.study.celue.bean.Zldzt;

/**
 * 策略模式主要是优化if else写法方便后期维护
 * 真要较真性能，还是if else性能更好
 */
public interface CeLueHandler {
    Boolean BeUse(Integer type);

    String whatIsYourName(Zldzt zldzt);
}
