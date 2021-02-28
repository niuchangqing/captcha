package org.ncq.captcha;

import org.junit.Test;
import org.ncq.captcha.domain.CharClickCaptchaResult;
import org.ncq.captcha.utils.ClickCaptchaUtil;
import org.ncq.captcha.utils.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author niuchangqing
 * @Description
 */
public class ImageUtilTest {
    @Test
    public void testCutImage(){
        File file = new File("/Users/xuweihong/Downloads/bg.jpg");
        BufferedImage bufferedImage = ImageUtil.read(file);
        BufferedImage cut = ImageUtil.cut(bufferedImage, 30, 10, 30, 30);
        File toFile = new File("/Users/xuweihong/Downloads/cut.jpg");
        ImageUtil.write(cut,"jpg",toFile);
    }


    @Test
    public void testClickImage(){
        System.out.println(System.currentTimeMillis());
        CharClickCaptchaResult a = ClickCaptchaUtil.getCharClickImage("点选验证码");
        System.out.println(System.currentTimeMillis());
//        System.out.println(JSONUtil.toJsonStr(a));
        System.out.println(a.getCharPositionList().get(1).getX());
        System.out.println(a.getCharPositionList().get(1).getY());
        System.out.println(a.getCharPositionList().get(1).getCharStr());
        System.out.println(a.getCharPositionList().get(1).getRadius());

//        File file = new File("/Users/xuweihong/Downloads/bg.jpg");
//        BufferedImage bufferedImage = ImageUtil.read(file);
//        Graphics2D graphics = GraphicsUtil.createGraphics(bufferedImage, null);
//        graphics.setColor(Color.BLACK);
//        graphics.setFont(new Font("Arial",Font.BOLD,50));
//        graphics.drawString("A",90,90);
//        File toFile = new File("/Users/xuweihong/Downloads/bbb.jpg");
//        ImageUtil.write(bufferedImage,"JPG",toFile);
    }

    @Test
    public void testValidClick(){
        boolean inCircle = ClickCaptchaUtil.isInCircle(73, 49, 170, 97, 13.0);
        System.out.println(inCircle);
    }
}
