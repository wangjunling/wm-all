package com.yellowstone.serivce.test;

import javax.annotation.Resource;

import org.junit.Test;

import site.wmblog.common.constant.Constant;
import site.wmblog.common.test.BaseDBTest;
import site.wmblog.common.web.xuser.XUserSession;
import site.wmblog.service.SendSMSService;

/**
 * Created by panwang.chengpw on 7/4/15.
 */
public class SendSMSServiceTest extends BaseDBTest {

    @Resource
    private SendSMSService sendSMSService;

    @Test
    public void testSendSMS() {

        sendSMSService.registerSMS("18202116916");
        logger.info("session: " + XUserSession.getCurrent().getAttr(Constant.REGISTER_SMS_KEY));

    }

}
