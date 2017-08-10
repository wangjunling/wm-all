package com.yellowstone.serivce.test;

import site.wmblog.common.aliyun.oss.AliyunOssFileService;
import site.wmblog.common.aliyun.oss.FileType;
import site.wmblog.common.aliyun.oss.OSSUploadResult;
import site.wmblog.common.test.BaseDBTest;
import site.wmblog.common.util.FastJson;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Fe on 15/7/3.
 */
public class AliyunOssFileserviceTest extends BaseDBTest {

    @Test
    public void testUploadFile() {
        AliyunOssFileService aliyunOssFileService = applicationContext.getBean(AliyunOssFileService.class);

        File file = new File("/Users/Fe/Desktop/testt/thinkinjava.pdf");

        try {
            OSSUploadResult ossUploadResult = aliyunOssFileService.uploadFile(new FileInputStream(file), "jpg", AliyunOssFileService.FILE_TYPE_COMPACT, "thinkinjava.pdf", FileType.ATTACHMENT);

            System.out.println(FastJson.toJson(ossUploadResult));
            System.out.println("result url :" + aliyunOssFileService.getOSSFileUrl(ossUploadResult));

           // InputStream inputStream = aliyunOssFileService.downLoadOssFile(ossUploadResult);
           // System.out.println("size :" + inputStream.available());
        } catch (Exception e) {

        }
    }

}
