package com.yellowstone.serivce.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import site.wmblog.common.aliyun.oss.OSSUploadResult;
import site.wmblog.common.test.BaseDBTest;
import com.yellowstone.dto.SaleRecord;
import com.yellowstone.dto.address.BuyerAddressDto;
import com.yellowstone.dto.product.ProductDetail;
import site.wmblog.mapper.query.Paginator;
import site.wmblog.mapper.query.product.ProductDetailQuery;
import site.wmblog.mapper.query.product.SaleRecordQuery;
import site.wmblog.service.ProductService;
import site.wmblog.service.SubOrderService;

/**
 * Created by wangjunling on 2015年7月3日.
 */
public class ProductServiceTest extends BaseDBTest {

    @Resource
    private ProductService              productService;
    @Resource
    private SubOrderService             subOrderService;

    @Test
    public void testDetail() throws Exception {
        ProductDetailQuery detailQuery = new ProductDetailQuery();
        detailQuery.setProductId(1L);
        detailQuery.setState("submit");
        ProductDetail productDetail = productService.selectDetailByPrimaryKey(detailQuery);
        System.out.println(productDetail);
    }

    @Test
    public void testSelectSaleRecordByPage() throws Exception {
        SaleRecordQuery query = new SaleRecordQuery();
        query.setPageNum(1);
        query.setPageSize(2);
        query.setProductId(1L);
        Paginator<SaleRecord> sa = subOrderService.selectSaleRecordByPage(query);
    }

    @Test
    public void testImage() throws Exception {
        OSSUploadResult result = JSON.parseObject("{'fileName':'按钮.JPG','ossBucKet':'jc-product','ossLocation':'oss-cn-hangzhou','ossfileName':'ce58c095-a1e3-4f4a-b119-8ce46081db46.JPG'}",
                                                  OSSUploadResult.class);
        List<OSSUploadResult> results = Lists.newArrayList();
        results.add(result);
        results.add(result);
        results.add(result);
        System.out.println(JSONArray.toJSONString(results));
        //        String imageUrlList = "[{'fileName':'按钮.JPG','ossBucKet':'jc-product','ossLocation':'oss-cn-hangzhou','ossfileName':'ce58c095-a1e3-4f4a-b119-8ce46081db46.JPG'},{'fileName':'按钮.JPG','ossBucKet':'jc-product','ossLocation':'oss-cn-hangzhou','ossfileName':'ce58c095-a1e3-4f4a-b119-8ce46081db46.JPG'}]";
        //        List<OSSUploadResult> results = JSONArray.parseArray(imageUrlList, OSSUploadResult.class);
        //        List<String> urls =AliyunOssFileService.getBatchOSSFileUrl(results);
        //        for (String url : urls) {
        //            System.out.println(url);
        //        }
    }

}
