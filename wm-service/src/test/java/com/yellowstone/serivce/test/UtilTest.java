package com.yellowstone.serivce.test;

import java.io.*;
import java.text.DecimalFormat;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import site.wmblog.common.test.BaseTest;
import site.wmblog.common.web.xuser.XUserSession;
import com.yellowstone.dto.ShoppingCart;
import com.yellowstone.entity.Buyer;

/**
 * Created by chengpanwang on 7/16/15.
 */

public class UtilTest extends BaseTest {

    @Test
    public void testDigest() {
        String password = "123456";
        logger.info(DigestUtils.md5Hex(password));

    }

    @Test
    public void testJson() {
        XUserSession session = new XUserSession();

        Buyer buyer = new Buyer();
        buyer.setChineseName("你好");
        session.setAttr("name", buyer);

        String json = JSON.toJSONString(session);
        logger.info(json);

        XUserSession xUserSession = JSON.parseObject(json, XUserSession.class);

        logger.info("{}", xUserSession);
    }

    @Test
    public void testSerialize() {
        XUserSession session = new XUserSession();
        System.out.println("hello");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProductToShoppingCart(1l, "hello", "", 1);

        session.setAttr("shopcart", shoppingCart);

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));

            oos.writeUnshared(session);
            oos.flush();
            byte[] bytes = bos.toByteArray();

            BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bytes));
            ObjectInputStream ois = new ObjectInputStream(bis);

            XUserSession o = (XUserSession) ois.readObject();
            System.out.print(((ShoppingCart) o.getAttr("shopcart")).getShoppingCartProductDetailMap() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEscape() {
        String text = "/area/list.json?cityCode=''><scRipt>alert(98733)</sCript>";
        System.out.println(StringEscapeUtils.escapeHtml4(text));
        System.out.println(StringEscapeUtils.escapeEcmaScript(text));
    }



    @Test
    public void testDouble() {
        Double a = 2342342344324d;
        DecimalFormat format = new DecimalFormat("#");
        System.out.println(format.format(a));
    }

}
