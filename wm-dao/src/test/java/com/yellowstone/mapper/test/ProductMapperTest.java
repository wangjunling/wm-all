package com.yellowstone.mapper.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.yellowstone.common.test.BaseDBTest;
import com.yellowstone.dto.product.ProductDetail;
import com.yellowstone.dto.product.ProductSimple;
import com.yellowstone.entity.CategoryAttribute;
import com.yellowstone.entity.CategoryParameter;
import site.wmblog.mapper.BuyerShippingAddressMapper;
import site.wmblog.mapper.CategoryAttributeMapper;
import site.wmblog.mapper.CategoryParameterMapper;
import site.wmblog.mapper.ProductMapper;
import site.wmblog.mapper.query.PageQuery;
import site.wmblog.mapper.query.product.ProductDetailQuery;

/**
 * Created by wangjunling on 2015年7月3日.
 */
public class ProductMapperTest extends BaseDBTest {

    @Resource
    private ProductMapper              productMapper;
    @Resource
    private BuyerShippingAddressMapper buyerShippingAddressMapper;
    @Resource
    private CategoryAttributeMapper    categoryAttrMapper;
    @Resource
    private CategoryParameterMapper    categoryParameterMapper;

    @Test
    public void testSelectByPrimaryDetails() {
        ProductMapper productMapper = applicationContext.getBean(ProductMapper.class);
        ProductDetailQuery detailQuery = new ProductDetailQuery();

        ProductDetail productDto = productMapper.selectDetailByPrimaryKey(detailQuery);
        System.out.println(productDto);
    }

    @Test
    public void testName() throws Exception {
        ProductSimple productsim = productMapper.selectSimpleByPrimaryKey(1L);
        System.out.println(productsim);
        List<String> names = categoryAttrMapper.selectNameByCategoryId(1L);
        for (String string : names) {
            System.out.println(string);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("categoryId", 1L);
        param.put("name", "功率");
        List<CategoryAttribute> cas = categoryAttrMapper.selectValByNameAndCId(param);
        System.out.println(cas);
    }

    @Test
    public void testName1() throws Exception {
        PageQuery query = new PageQuery();
        query.setPageNum(1);
        query.setPageSize(10);
        List<CategoryParameter> cps = categoryParameterMapper.selectByPage(query);
        int count = categoryParameterMapper.countByPage();
    }
}
