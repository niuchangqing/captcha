package org.ncq.captcha.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author niuchangqing
 * @Description 绘笔工具类
 */
public class GraphicsUtil {

    /**
     * 创建绘笔公爵
     * @param bufferedImage         图片buffer
     * @param backgroundColor       背景颜色
     * @return
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
     * @return
     */
    public static Graphics drawStr(Graphics graphics, String str, Font font, Color color, int width, int height){
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
        ThreadLocalRandom random = RandomUtil.getRandom();
        for (int i = 0; i < len; i++) {
            if (null == color) {
                //随机产生字体颜色
                graphics.setColor(ImageUtil.randomColor());
            }
            //设置字体高度上下偏移量
            int y = textCenterYHeight / 5;
            int textHeight = textCenterYHeight - random.nextInt(-y,y);
            graphics.drawString(String.valueOf(str.charAt(i)),i * charWidth,textHeight);
        }
        return graphics;
    }

    /**
     * 获取内容居中高度的Y轴坐标
     * @param graphics                  绘笔对象
     * @param backgroundImageHeight     图片的高度
     * @return
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
}
