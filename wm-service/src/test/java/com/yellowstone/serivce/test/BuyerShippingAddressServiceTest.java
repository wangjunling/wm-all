package com.yellowstone.serivce.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import site.wmblog.mapper.query.PageQuery;
import site.wmblog.mapper.query.Paginator;
import site.wmblog.service.CategoryParameterService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import site.wmblog.common.test.BaseDBTest;
import com.yellowstone.dto.address.BuyerAddressDto;
import site.wmblog.service.BuyerShippingAddressService;

/**
 * Created by wangjunling on 2015年7月16日.
 */
public class BuyerShippingAddressServiceTest extends BaseDBTest {

    @Resource
    private BuyerShippingAddressService buyerShippingAddressService;

    @Resource
    private CategoryParameterService categoryParameterService;

    @Test
    public void testList() throws Exception {
        List<BuyerAddressDto> dtos = buyerShippingAddressService.selectByBuyer();
        for (BuyerAddressDto buyerAddressDto : dtos) {
            System.out.println(buyerAddressDto);
        }
    }

    @Test
    public void testDate() {
        String source = "2015-09-08";
        Date result = null;
        try {
            result = DateUtils.parseDate(source, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
        } catch (ParseException e) {

        }

        System.out.println(result);
    }

    @Test
    public void testParameter(){
        PageQuery pageQuery = new PageQuery();
      Paginator pas = categoryParameterService.selectByPage(pageQuery);
        System.out.println(pas);
    }
}
