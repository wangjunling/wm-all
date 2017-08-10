package com.yellowstone.serivce.test;

import site.wmblog.common.test.BaseDBTest;
import com.yellowstone.dto.SearchCondition;
import com.yellowstone.dto.SearchParam;
import com.yellowstone.dto.SearchResult;
import com.yellowstone.entity.Brand;
import site.wmblog.mapper.BrandMapper;
import site.wmblog.service.SearchService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fe on 15/7/2.
 */
public class SearchServiceTest extends BaseDBTest {

    @Resource
    private BrandMapper brandMapper;

    @Test
    public void testQueryCondition() {
        SearchService searchService = applicationContext.getBean(SearchService.class);

        SearchCondition searchCondition = searchService.queryCondition(Arrays.asList(1l));

        System.out.println(searchCondition);
    }

    @Test
    public void testSearch() {
        SearchService searchService = applicationContext.getBean(SearchService.class);
        SearchParam searchParam = new SearchParam();
        searchParam.setKeyWord("123");
       // searchParam.setCategoryId(1l);
        searchParam.setBrandId(1l);
        List<Long> attributeIds = new ArrayList<Long>();
        attributeIds.add(1l);
        attributeIds.add(2l);
        searchParam.setAttributeIds(attributeIds);
        searchParam.setStart(0);
        searchParam.setPageSize(20);
        SearchResult searchResult = searchService.search(searchParam);
        System.out.println(searchResult);
    }

    @Test
    public void testBrand() {
        List<Long> brandIdList = new ArrayList<Long>();
        brandIdList.add(1l);
        List<Brand> brandList = brandMapper.selectByIds(brandIdList);
    }
}
