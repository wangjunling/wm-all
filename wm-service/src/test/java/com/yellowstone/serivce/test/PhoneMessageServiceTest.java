package com.yellowstone.serivce.test;

import site.wmblog.common.sms.PhoneMessageInterface;
import site.wmblog.common.sms.PhoneMessageInterfaceFactory;
import site.wmblog.common.test.BaseDBTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Fe on 15/7/4.
 */
public class PhoneMessageServiceTest extends BaseDBTest {

    @Resource
    private PhoneMessageInterfaceFactory phoneMessageInterfaceFactory;


    @Test
    public void testSendMsg() {
        PhoneMessageInterface phoneMessageInterface = phoneMessageInterfaceFactory.getDefaultPhoneMessageInterface();
        phoneMessageInterface.sendMessage("test123123【街多多】","18621196336");

    }
}
