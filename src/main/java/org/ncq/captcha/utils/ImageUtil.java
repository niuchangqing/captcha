package org.ncq.captcha.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author niuchangqing
 * @Description 图片工具类
 */
public class ImageUtil {
    /**
     * RGB颜色范围上限
     */
    private static final int RGB_COLOR_UPPER_LIMIT = 256;

    public static final String PNG = "PNG";

    public static final String GIF = "GIF";

    /**
     * image写入指定的字节数组的输出流
     * @param image                 image对象
     * @param imageType             图片类型
     * @param out                   字节数组输出流
     */
    public static void write(Image image, String imageType , ByteArrayOutputStream out){
        try {
            ImageIO.write((RenderedImage) image,imageType,out);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * image写入指定的字节数组输出流
     * @param image                 image对象
     * @param out                   字节数组输出流
     */
    public static void writePng(Image image, ByteArrayOutputStream out){
        write(image,PNG,out);
    }

    /**
     * 随机生成颜色
     * @return
     */
    public static Color randomColor(){
        ThreadLocalRandom random = RandomUtil.getRandom();
        return new Color(random.nextInt(RGB_COLOR_UPPER_LIMIT), random.nextInt(RGB_COLOR_UPPER_LIMIT), random.nextInt(RGB_COLOR_UPPER_LIMIT));
    }

    /**
     * 随机获取一个和指定颜色不同的颜色
     * @param color                 可以为空
     * @return
     */
    public static Color randomColor(Color color){
        Color c = randomColor();
        if (color == null) {
            return c;
        }
        //和指定颜色相同,递归获取颜色
        if (c.equals(color)) {
            return randomColor(color);
        }
        return c;
    }
}
