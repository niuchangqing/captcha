package org.ncq.captcha.utils;

import org.ncq.captcha.exception.CaptchaException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author niuchangqing
 * 图片工具类
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
            ImageIO.write((RenderedImage) image, imageType,out);
        }catch (Exception e) {
            throw new CaptchaException("image to ByteArrayOutputStream error",e);
        }
    }

    /**
     * image对象写入指定的输出流
     * @param image                 image对象
     * @param imageType             图片类型,如PNG,GIF等
     * @param outputStream          输出流
     */
    public static void write(Image image, String imageType, OutputStream outputStream){
        try {
            ImageIO.write((RenderedImage) image,imageType,outputStream);
        }catch (IOException e) {
            throw new CaptchaException("image to outputStream error",e);
        }
    }

    /**
     * image对象写入指定文件中
     * @param image                 image对象
     * @param imageType             图片类型,如PNG,GIF
     * @param file                  文件对象
     */
    public static void write(Image image, String imageType, File file){
        try {
            ImageIO.write((RenderedImage) image,imageType,file);
        }catch (IOException e) {
            throw new CaptchaException("image to file error",e);
        }
    }

    /**
     * 指定file文件转换为image
     * @param file              文件
     * @return                  bufferedImage对象
     */
    public static BufferedImage read(File file){
        try {
            return ImageIO.read(file);
        }catch (IOException e) {
            throw new CaptchaException("file to image error",e);
        }
    }

    /**
     * 指定url文件转换为image
     * @param url               url
     * @return                  bufferedImage
     */
    public static BufferedImage read(URL url){
        try {
            return ImageIO.read(url);
        }catch (IOException e) {
            throw new CaptchaException("url to image error",e);
        }
    }

    /**
     * 指定输入流转为image对象
     * @param inputStream           输入流
     * @return                      bufferedImage对象
     */
    public static BufferedImage read(InputStream inputStream){
        try {
            return ImageIO.read(inputStream);
        }catch (IOException e) {
            throw new CaptchaException("inputStream to image error",e);
        }
    }

    /**
     * 指定byte[]转为image对象
     * @param bytes                 byte[]
     * @return                      image
     */
    public static BufferedImage read(byte[] bytes){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            return read(inputStream);
        }finally {
            IOUtil.close(inputStream);
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
     * @return                      颜色对象
     */
    public static Color randomColor(){
        ThreadLocalRandom random = RandomUtil.getRandom();
        return new Color(random.nextInt(RGB_COLOR_UPPER_LIMIT), random.nextInt(RGB_COLOR_UPPER_LIMIT), random.nextInt(RGB_COLOR_UPPER_LIMIT));
    }

    /**
     * 随机获取一个和指定颜色不同的颜色
     * @param color                 可以为空
     * @return                      颜色对象
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

//    public static Image cut(Image image, GeneralPath generalPath, Point point){
//
//    }

    public static BufferedImage cut(BufferedImage image, int x, int y, int width, int height){
        return image.getSubimage(x,y,width,height);
    }
}
