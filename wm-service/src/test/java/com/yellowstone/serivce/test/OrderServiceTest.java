package com.yellowstone.serivce.test;

import site.wmblog.common.Page;
import site.wmblog.common.cache.RedisCache;
import site.wmblog.common.test.BaseDBTest;
import com.yellowstone.dto.order.OrderDto;
import com.yellowstone.dto.enumeration.OrderStateEnum;
import com.yellowstone.entity.Order;
import site.wmblog.mapper.OrderMapper;
import site.wmblog.mapper.query.order.OrderQuery;
import site.wmblog.service.OrderService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by panwang.chengpw on 7/3/15.
 */
public class OrderServiceTest extends BaseDBTest {


    @Resource
    private OrderService orderService;
    @Resource
    private RedisCache redisCache;
    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testRedis() {
        logger.info(redisCache.get("hello"));
        logger.info(redisCache.set("hello", "你好") + "");
        logger.info(redisCache.get("hello"));


    }

    @Test
    public void testListOrder() {
        Order order = new Order();
        order.setBuyerId(1l);
        order.setState(OrderStateEnum.submit.getCode());
        order.setId("JC001");
        order.setRemark("test");
        orderMapper.insert(order);



        OrderQuery query = new OrderQuery();
        query.setBuyerId(1l);
        query.setId("JC29026491734774");

        Page<OrderDto> page = orderService.listOrder(query);
        logger.info("list order: " + page);
        assertEquals(page.getData().get(0).getId(), "JC29026491734774");
    }

    @Test
    public void testQueryOrder() {
        OrderQuery query = new OrderQuery();
        query.setId("JC29026491734774");

        OrderDto orderDto = orderService.queryDetail(query);
        logger.info("order dto :" + orderDto + "");

    }
}
