package com.yellowstone.serivce.test;

import javax.annotation.Resource;

import com.google.common.collect.Lists;
import site.wmblog.common.test.BaseDBTest;
import com.yellowstone.dto.parameter.ParameterEditDto;
import com.yellowstone.entity.CategoryParameter;
import site.wmblog.service.CategoryParameterService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by wangjunling on 2015/8/18.
 */
public class CategoryParameterServiceTest extends BaseDBTest {

    @Resource
    private CategoryParameterService categoryParameterService;

    @Test
    public void testEdit() {
        ParameterEditDto vo = new ParameterEditDto();
        vo.setCategoryId(14l);
        List<CategoryParameter> parameters = Lists.newArrayList();
        CategoryParameter categoryParameter = new CategoryParameter();
        categoryParameter.setUpdateTime(new Date());
        categoryParameter.setId(11l);
        categoryParameter.setKey("a");
        categoryParameter.setSort(1);
        parameters.add(categoryParameter);
        vo.setParameter(parameters);
        categoryParameterService.editCategoryParameter(vo);
    }
}
