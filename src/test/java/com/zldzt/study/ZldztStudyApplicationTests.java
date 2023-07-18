package com.zldzt.study;

import com.zldzt.study.celue.CeLueHandler;
import com.zldzt.study.celue.bean.Zldzt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class ZldztStudyApplicationTests {
    @Autowired
    private List<CeLueHandler> ceLueHandlerList;
    @Test
    void contextLoads() {
        Zldzt zldzt = new Zldzt();
        zldzt.setName("董强");
        zldzt.setType(1);
        CeLueHandler ceLueHandler = ceLueHandlerList.stream().filter(item -> item.BeUse(zldzt.getType())).findFirst().orElse(null);
        if(ceLueHandler != null){
            String s = ceLueHandler.whatIsYourName(zldzt);
            System.out.println(s);
        }
//        System.out.println(1);

    }

}
