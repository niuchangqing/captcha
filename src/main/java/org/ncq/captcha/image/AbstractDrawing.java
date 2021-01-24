package org.ncq.captcha.image;

import org.ncq.captcha.image.gif.AnimatedGifEncoder;
import org.ncq.captcha.utils.GraphicsUtil;
import org.ncq.captcha.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * @Author niuchangqing
 * @Description
 */
public abstract class AbstractDrawing implements IDrawing {
    /**
     * 生成图片的宽度
     */
    protected int width;

    /**
     * 生成图片的高度
     */
    protected int height;

    /**
     * 图片干扰数量
     */
    protected int interferenceCount;

    /**
     * 图片验证码字体
     */
    protected Font font;

    /**
     * 字体颜色
     */
    protected Color fontColor;

    /**
     * 图片的背景颜色
     */
    protected Color backgroundColor;

    /**
     * 干扰线颜色
     */
    protected Color interferenceColor;

    /**
     * 透明度
     */
    protected AlphaComposite alphaComposite;

    /**
     * gif图片延迟时间
     */
    protected int gifDelay = 150;

    /**
     * 构造方法
     * @param width                 图片宽度
     * @param height                图片高度
     * @param interferenceCount     干扰数量
     * @param font                  字体
     * @param fontColor             字体颜色
     * @param backgroundColor       背景颜色
     * @param interferenceColor     干扰线颜色
     * @param alphaComposite        字体透明度
     */
    public AbstractDrawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
        this.width = width < 10 ? 10 : width;
        this.height = height < 10 ? 10 : height;
        this.interferenceCount = interferenceCount;
        this.font = font == null ? new Font("Fixedsys",Font.BOLD,(int) (this.height * 0.65)) : font;
        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
        this.interferenceColor = interferenceColor;
        this.alphaComposite = alphaComposite;
    }

    /**
     * 绘制干扰线实现
     * @param graphics2D        绘笔对象
     */
    protected abstract void drawInterference(Graphics2D graphics2D);

    /**
     * 生成图片
     * @param code           图片验证码
     * @return
     */
    protected Image createImage(String code) {
        //图片buffer
        BufferedImage image = new BufferedImage(this.width,this.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = GraphicsUtil.createGraphics(image, this.backgroundColor);
        //添加干扰线
        if (this.interferenceCount > 0) {
            for (int i = 0; i < this.interferenceCount; i++) {
                drawInterference(graphics2D);
            }
        }
        //设置透明度
        GraphicsUtil.setAlphaComposite(graphics2D,this.alphaComposite);
        //绘制字符串
        GraphicsUtil.drawStr(graphics2D,code, this.font, this.fontColor, this.width, this.height);
        return image;
    }

    protected byte[] createGifImage(String code){
        // gif编码类
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        AnimatedGifEncoder gif = new AnimatedGifEncoder();
        gif.start(out);
        //设置量化器取样间隔
        gif.setQuality(10);
        //延迟时间100ms
        gif.setDelay(gifDelay);
        //设置循环播放次数,0是重复播放
        gif.setRepeat(0);
        BufferedImage frame;
        char[] chars = code.toCharArray();
        Color[] fontColor = new Color[chars.length];
        for (int i = 0; i < chars.length; i++) {
            fontColor[i] = ImageUtil.randomColor();
            frame = graphicsImage(chars, fontColor, chars, i);
            gif.addFrame(frame);
            frame.flush();
        }
        gif.finish();
        return out.toByteArray();
    }

    @Override
    public String getImageBase64(String code) {
        byte[] imageBytes = getImageBytes(code);
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    @Override
    public String getImageBase64Data(String code) {
        String imageBase64 = getImageBase64(code);
        StringBuilder imageBase64Data = new StringBuilder();
        imageBase64Data.append("data:image/");
        imageBase64Data.append(ImageUtil.PNG);
        imageBase64Data.append(";base64,");
        imageBase64Data.append(imageBase64);
        return imageBase64Data.toString();
    }

    @Override
    public byte[] getImageBytes(String code) {
        Image image = createImage(code);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageUtil.write(image, ImageUtil.PNG, out);
        return out.toByteArray();
    }

    @Override
    public String getGifImageBase64(String code) {
        byte[] imageBytes = getGifImageBytes(code);
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    @Override
    public String getGifImageBase64Data(String code) {
        String imageBase64 = getGifImageBase64(code);
        StringBuilder imageBase64Data = new StringBuilder();
        imageBase64Data.append("data:image/");
        imageBase64Data.append(ImageUtil.GIF);
        imageBase64Data.append(";base64,");
        imageBase64Data.append(imageBase64);
        return imageBase64Data.toString();
    }

    @Override
    public byte[] getGifImageBytes(String code) {
        return createGifImage(code);
    }

    /**
     * 绘制动态图
     * @param fontColor 随机字体颜色
     * @param words     字符数组
     * @param flag      透明度使用
     * @return BufferedImage
     */
    private BufferedImage graphicsImage(char[] chars, Color[] fontColor, char[] words, int flag) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //或得图形上下文
        Graphics2D graphics2D = image.createGraphics();
        //利用指定颜色填充背景
        graphics2D.setColor(this.backgroundColor == null ? Color.BLACK : this.backgroundColor);
        graphics2D.fillRect(0, 0, width, height);
        AlphaComposite ac;
        // 字符的y坐标
        float y = (height >> 1) + (font.getSize() >> 1);
        float m = 1.0f * (width - (chars.length * font.getSize())) / chars.length;
        //字符的x坐标
        float x = Math.max(m / 2.0f, 2);
        graphics2D.setFont(font);
        // 指定透明度
        if (null != this.alphaComposite) {
            graphics2D.setComposite(this.alphaComposite);
        }
        //绘制干扰线
        if (this.interferenceCount > 0) {
            for (int j = 0; j < this.interferenceCount; j++) {
                drawInterference(graphics2D);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getAlpha(chars.length, flag, i));
            graphics2D.setComposite(ac);
            graphics2D.setColor(fontColor[i]);
            graphics2D.drawString(words[i] + "", x + (font.getSize() + m) * i, y);
        }
        graphics2D.dispose();
        return image;
    }

    /**
     * 获取透明度,从0到1,自动计算步长
     *
     * @return float 透明度
     */
    private float getAlpha(int v, int i, int j) {
        int num = i + j;
        float r = (float) 1 / v;
        float s = (v + 1) * r;
        return num > v ? (num * r - s) : num * r;
    }

    public void setGifDelay(int gifDelay) {
        this.gifDelay = gifDelay;
    }
}
