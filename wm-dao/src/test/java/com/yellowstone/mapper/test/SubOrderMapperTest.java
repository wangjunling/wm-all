package com.yellowstone.mapper.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.yellowstone.common.test.BaseDBTest;
import com.yellowstone.dto.SaleRecord;
import site.wmblog.mapper.SubOrderMapper;

/**
 * Created by wangjunling on 2015年7月3日.
 */
public class SubOrderMapperTest extends BaseDBTest {

    @Resource
    private SubOrderMapper subOrderMapper;

    @Test
    public void testfindTransactionCount() throws Exception {
        int count = subOrderMapper.findSaleTime(1L);
        System.out.println(count);
        int time = subOrderMapper.findSaleQuantity(1L);
        System.out.println(time);
    }

    @Test
    public void testSelectTranRecord() throws Exception {
        Map<String, Object> param = Maps.newHashMap();
        param.put("start", 0);
        param.put("pageSize", 10);
        param.put("productId", 1L);
        List<SaleRecord> trs = subOrderMapper.selectSaleRecordByPage(param);
        System.out.println(trs);
    }
}
