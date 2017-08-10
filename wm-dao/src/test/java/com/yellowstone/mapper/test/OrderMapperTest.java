package com.yellowstone.mapper.test;

import com.google.common.collect.Maps;
import com.yellowstone.common.test.BaseDBTest;
import com.yellowstone.dto.enumeration.OrderStateEnum;
import com.yellowstone.entity.Order;
import site.wmblog.mapper.OrderMapper;
import site.wmblog.mapper.SubOrderMapper;
import site.wmblog.mapper.YellowstoneSequenceMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by panwang.chengpw on 7/3/15.
 */
public class OrderMapperTest extends BaseDBTest {

    @Resource
    private OrderMapper               orderMapper;
    @Resource
    private YellowstoneSequenceMapper yellowstoneSequenceMapper;

    @Test
    public void testSelectByPrimaryKey() {
        logger.info(applicationContext.getBean(SubOrderMapper.class) + "");
        Order insert = new Order();
        Map<String,Object> param = Maps.newHashMap();
        param.put("seqNamePre", "JC");
        param.put("seqCode", "ORDER");
        param.put("num", 14);
        String seq = yellowstoneSequenceMapper.nextSeqNo(param);
        insert.setId(seq);
        insert.setBuyerId(1l);
        insert.setState(OrderStateEnum.submit.getCode());
        orderMapper.insert(insert);

        Order order = orderMapper.selectByPrimaryKey(seq);
        logger.info(order + "");
        assertEquals(order.getId(), seq);

    }

}
