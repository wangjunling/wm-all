package com.yellowstone.serivce.test;

import site.wmblog.common.cache.Cache;
import site.wmblog.common.test.BaseDBTest;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Fe on 15/7/7.
 */
public class KvStoreTest extends BaseDBTest {


    @Resource
    private Cache redisCache;

    @Test
    public void testSet() {
        redisCache.set("jc_product","123");
    }


    @Test
    public void test01() {
        String str = "insert into `t_product` (`id`,`supplier_id`,`name`,`num`,`view_count`,`market_price`,`member_price`,`brand_id`,`category_id`,`keyword`,`title`,`description`,`main_image_url`,`image_url_list`,`state`,`update_time`,`create_time`)\n" +
                "values('45','1','toto卫浴45','123YHTGI666','0',111,110,'1','1','卫浴','toto卫浴','xxxxx','{\"fileName\":\"按钮.JPG\",\"ossBucKet\":\"jc-product\",\"ossLocation\":\"oss-cn-hangzhou\",\"ossfileName\":\"ce58c095-a1e3-4f4a-b119-8ce46081db46.JPG\"}','xxx','approved','2015-07-02 10:11:19','2015-07-02 10:11:22')";

        StringBuffer sb = new StringBuffer();
        for (int i = 45; i < 400; i++) {
            StringBuffer sql = new StringBuffer();
            sql.append("insert into `t_product` (`id`,`supplier_id`,`name`,`num`,`view_count`,`market_price`,`member_price`,`brand_id`,`category_id`,`keyword`,`title`,`description`,`main_image_url`,`image_url_list`,`state`,`update_time`,`create_time`) values");
            sql.append("('" + i + "','1','toto卫浴" + i + "','123YHTGI666','0',111,110,'1','1','卫浴','toto卫浴','xxxxx','{\"fileName\":\"按钮.JPG\",\"ossBucKet\":\"jc-product\",\"ossLocation\":\"oss-cn-hangzhou\",\"ossfileName\":\"ce58c095-a1e3-4f4a-b119-8ce46081db46.JPG\"}','xxx','approved','2015-07-02 10:11:19','2015-07-02 10:11:22')");

            sb.append(sql).append(";\n");

        }
        try {
            IOUtils.write(sb,new FileOutputStream(new File("/Users/Fe/Desktop/product_sql.sql")));
        } catch (Exception e) {

        }
    }

}
