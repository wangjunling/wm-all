package com.yellowstone.mapper.test;

import site.wmblog.mapper.YellowstoneSequenceMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fe on 15/6/26.
 */
public class YellowStoneSequenceTest {

    public static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-datasource.xml");
    }

    @Test
    public void testTrriger() {
        final YellowstoneSequenceMapper yellowstoneSequenceMapper = applicationContext.getBean(YellowstoneSequenceMapper.class);

        final  Map<String,Object> param = new HashMap<String,Object>();
        param.put("seqNamePre","SH");
        param.put("seqCode","yixiangdan");
        param.put("num",12);

        String res = yellowstoneSequenceMapper.nextSeqNo(param);
        System.out.println(res);
    }
}
