package com.yellowstone.serivce.test;

import javax.annotation.Resource;

import site.wmblog.common.test.BaseDBTest;
import org.junit.Test;

import site.wmblog.service.YellowStoneSequenceService;

/**
 * Created by chengpanwang on 7/16/15.
 */
public class YellowstoneSequenceServiceTest extends BaseDBTest {

    @Resource
    private YellowStoneSequenceService yellowStoneSequenceService;

    @Test
    public void testSeq() {
        String seq = yellowStoneSequenceService.nextSeq();
        logger.info("seq:" + seq);
    }
}
