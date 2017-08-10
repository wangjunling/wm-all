package site.wmblog.common.http;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import site.wmblog.common.web.xuser.XUserSession;

/**
 * Created by Fe on 14/11/2.
 */
public class RandomValidateCode {

    private static Logger logger   = LoggerFactory.getLogger(RandomValidateCode.class);

    private Random        random   = new Random();

    private int           width    = 80;
    private int           height   = 38;
    private int           lineSize = 40;

    /*
     * 获得字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 21);
    }

    /*
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public void randCode(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        g.setColor(getRandColor(110, 133));
        for (int i = 0; i <= lineSize; i++) {
            drawLine(g);
        }
        String randomString = RandomStringUtils.randomNumeric(4);
        drawString(g, randomString);

        XUserSession.getCurrent().setRandomCode(randomString);
        logger.info("generate random code, {}" ,randomString);
        g.dispose();
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "JPEG", outputStream);
            outputStream.flush();
            response.setStatus(200);
        } catch (Exception e) {
            logger.error("生成随机图片错误", e);
        } finally {
            IOUtils.closeQuietly(outputStream);

        }
    }

    /*
     * 绘制字符串
     */
    private void drawString(Graphics g, String randomString) {
        for (int i = 0; i < randomString.length(); i++) {
            g.setFont(getFont());
            g.setColor(new Color(random.nextInt(101), random.nextInt(150), random.nextInt(121)));
            g.translate(random.nextInt(5), random.nextInt(5));
            g.drawString(String.valueOf(randomString.charAt(i)), 14 * i + RandomUtils.nextInt(1, 8), RandomUtils.nextInt(20, 30));
        }
    }

    /*
     * 绘制干扰线
     */
    private void drawLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

}
