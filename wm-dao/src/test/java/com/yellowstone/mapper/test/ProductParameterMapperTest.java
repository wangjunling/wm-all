package com.yellowstone.mapper.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.yellowstone.dto.attribute.CategoryAttributeDto;
import com.yellowstone.entity.CategoryAttribute;
import com.yellowstone.entity.CategoryParameter;
import site.wmblog.mapper.CategoryAttributeMapper;
import site.wmblog.mapper.CategoryParameterMapper;
import site.wmblog.mapper.query.PageQuery;
import org.junit.Test;

import com.yellowstone.common.test.BaseDBTest;
import com.yellowstone.dto.product.ProductParameterDto;
import site.wmblog.mapper.ProductParameterMapper;

import javax.annotation.Resource;

/**
 * Created by wangjunling on 2015年7月3日.
 */
public class ProductParameterMapperTest extends BaseDBTest {

    @Resource
    private CategoryParameterMapper categoryParameterMapper;
    @Resource
    private CategoryAttributeMapper categoryAttributeMapper;
    @Test
    public void testSelectByProductId() throws Exception {
        ProductParameterMapper productParameterMapper = applicationContext.getBean(ProductParameterMapper.class);
        List<ProductParameterDto> pps = productParameterMapper.selectDtoByProductId(1L);
        for (ProductParameterDto pto : pps) {
            System.out.println(pto.getKey());
            System.out.println(pto.getValue());
        }
    }

    @Test
    public void testUpdate() {
        CategoryParameter categoryParameter = new CategoryParameter();
        categoryParameter.setId(11l);
        categoryParameter.setKey("a");
        categoryParameter.setSort(1);
        categoryParameter.setUpdateTime(new Date());
        categoryParameterMapper.updateByPrimaryKeySelective(categoryParameter);
    }

    @Test
    public void testAttributePage() {
        PageQuery query = new PageQuery();

      List<CategoryAttribute> attributes = categoryAttributeMapper.selectByPage(query);
        categoryAttributeMapper.countByPage();
        Map<String, Object> param = Maps.newHashMap();
        param.put("categoryId", 28l);
        param.put("name", "安装方式");
        List<CategoryAttribute> categoryAttribute = categoryAttributeMapper.selectValByNameAndCId(param);
    }
}
