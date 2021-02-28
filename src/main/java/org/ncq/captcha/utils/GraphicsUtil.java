package org.ncq.captcha.utils;

import org.ncq.captcha.domain.Point;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author niuchangqing
 * 绘笔工具类
 */
public class GraphicsUtil {

    /**
     * 创建绘笔公爵
     * @param bufferedImage         图片buffer
     * @param backgroundColor       背景颜色
     * @return                      Graphics2D
     */
    public static Graphics2D createGraphics(BufferedImage bufferedImage, Color backgroundColor){
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        if (null != backgroundColor) {
            //设置背景色
            graphics2D.setColor(backgroundColor);
            graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        }
        return graphics2D;
    }

    /**
     * 图片绘制指定字符串
     * @param graphics          绘笔对象
     * @param str               需要绘制的字符串
     * @param font              字体
     * @param color             字体颜色，颜色可以为空，为空每个字符的颜色进行随机
     * @param width             图片的宽度
     * @param height            图片的高度
     * @param backgroundColor   图片背景颜色
     * @return                  Graphics
     */
    public static Graphics drawStr(Graphics graphics, String str, Font font, Color color, int width, int height, Color backgroundColor){
        if (graphics instanceof Graphics2D) {
            ((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        //设置字体
        graphics.setFont(font);
        //设置文字高度居中Y轴坐标
        int textCenterYHeight = getCenterYHeight(graphics,height);
        if (null != color) {
            //指定内容颜色
            graphics.setColor(color);
        }
        int len = str.length();
        int charWidth = width / len;
        for (int i = 0; i < len; i++) {
            if (null == color) {
                //随机产生字体颜色，不能和图片背景颜色重复
                graphics.setColor(ImageUtil.randomColor(backgroundColor));
            }
            String s = String.valueOf(str.charAt(i));
            Point point = randomStrPosition(graphics, s, font, charWidth, height);
            graphics.drawString(s, point.getX() + (charWidth * i), point.getY());
        }
        return graphics;
    }

    /**
     * 随机获取字符所在画板的位置
     * @param graphics          绘笔对象
     * @param str               将要输入的字符
     * @param font              字体
     * @param width             宽度(图片宽度,x轴)
     * @param height            图片高度(图片高度,y轴)
     * @return                  [0] = x轴所在位置,[1] = y轴所在位置
     */
    public static Point randomStrPosition(Graphics graphics, String str, Font font, int width, int height) {
        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        int charWidth = getCharWidth(graphics, str, font);
        int charHeight = getFontHeight(graphics, font);
        ThreadLocalRandom random = RandomUtil.getRandom();

        int x = 0;
        //判断宽度是否小于字体宽度
        if (width <= charWidth) {
            x = 0;
        }else {
            //随机获取x坐标
            x = random.nextInt(0,width);
            //判断字体是否已经超出画板
            if (x + charWidth > width) {
                x = width - charWidth;
            }
        }
        int y = 0;
        //判断高度是否小于字体高度
        if (height <= charHeight) {
            //设置居中
            y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        }else {
            //随机获取y坐标
            y = random.nextInt(0,height);
            //判断坐标字体是否已经超出
            if (y < charHeight) {
                y = charHeight;
            }
        }
        return new Point(x,y);
    }

    /**
     * 获取内容居中高度的Y轴坐标
     * @param graphics                  绘笔对象
     * @param backgroundImageHeight     图片的高度
     * @return                          居中高度坐标
     */
    public static int getCenterYHeight(Graphics graphics, int backgroundImageHeight){
        //允许内容的最小高度
        FontMetrics fontMetrics = null;
        try {
            fontMetrics = graphics.getFontMetrics();
        } catch (Exception e) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }
        int y;
        if (null != fontMetrics) {
            y = (backgroundImageHeight - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        } else {
            y = backgroundImageHeight / 3;
        }
        return y;
    }

    public static void setAlphaComposite(Graphics2D graphics2D, AlphaComposite alphaComposite){
        if (alphaComposite != null) {
            graphics2D.setComposite(alphaComposite);
        }
    }

    /**
     * 获取对应字体的一行文本高度
     * @param graphics          画笔对象
     * @param font              字体
     * @return                  字体所占高度
     */
    public static int getFontHeight(Graphics graphics, Font font) {
        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        return fontMetrics.getHeight();
    }

    /**
     * 获取该字符串在对应字体下占用的宽度
     * @param graphics                  画笔对象
     * @param str                       对应的字符串
     * @param font                      字体
     * @return                          该字符所占用的宽度
     */
    public static int getCharWidth(Graphics graphics, String str, Font font){
        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        return fontMetrics.stringWidth(str);
    }

    /**
     * 获取旋转参数
     * @param degree        旋转度数,0 ～ 360
     * @param x             旋转圆心的x轴坐标
     * @param y             旋转圆心的y轴坐标
     * @return              旋转参数对象,use = graphics.setTransform(AffineTransform);
     */
    public static AffineTransform getRotation(int degree, int x, int y){
        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.toRadians(degree),x,y);
        return at;
    }
}
