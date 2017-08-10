package com.yellowstone.serivce.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import site.wmblog.common.test.BaseDBTest;
import com.yellowstone.entity.Category;
import com.yellowstone.entity.Supplier;
import site.wmblog.mapper.query.PageQuery;
import site.wmblog.mapper.query.supplier.CheckQuery;
import site.wmblog.service.CategoryParameterService;
import site.wmblog.service.CategoryService;
import site.wmblog.service.SupplierService;

public class SupplierServiceTest extends BaseDBTest {

    @Resource
    private SupplierService supplierService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private CategoryParameterService categoryParameterService;
    @Test
    public void testCheck() throws Exception {
        CheckQuery query = new CheckQuery();
        Supplier supplier = supplierService.check(query);
    }
    @Test
    public void testName() throws Exception {
        List<Category> categorys =  categoryService.selectByBrandId(13l);
        for (Category category : categorys) {
            System.out.println(category.getName());
        }
     
    }
    @Test
    public void testName1() throws Exception {
        PageQuery query = new PageQuery();
        query.setPageNum(1);
        query.setPageSize(10);
        categoryParameterService.selectByPage(query);
    }
    
}
