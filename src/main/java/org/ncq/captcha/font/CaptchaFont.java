package org.ncq.captcha.font;

import org.ncq.captcha.exception.CaptchaException;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author niuchangqing
 * <p>
 *     部分自定义扩展字体只支持字母数字以及一些符号
 *     如果要使用中文,繁体请选好字体后测试一下
 * </p>
 * @Description 字体扩展
 */
public final class CaptchaFont {

    /**
     * 扩展字体1,对应字体文件/resource/font/font1.ttf
     */
    public static final String CAPTCHA_FONT_1 = "captchaFont1";

    /**
     * 扩展字体2,对应字体文件/resource/font/font2.ttf
     */
    public static final String CAPTCHA_FONT_2 = "captchaFont2";

    /**
     * 扩展字体3,对应字体文件/resource/font/font3.ttf
     */
    public static final String CAPTCHA_FONT_3 = "captchaFont3";

    /**
     * 扩展字体4,对应字体文件/resource/font/font4.ttf
     */
    public static final String CAPTCHA_FONT_4 = "captchaFont4";

    /**
     * 扩展字体5,对应字体文件/resource/font/font5.ttf
     */
    public static final String CAPTCHA_FONT_5 = "captchaFont5";

    /**
     * 扩展字体6,对应字体文件/resource/font/font6.ttf
     */
    public static final String CAPTCHA_FONT_6 = "captchaFont6";

    /**
     * 扩展字体7,对应字体文件/resource/font/font7.ttf
     */
    public static final String CAPTCHA_FONT_7 = "captchaFont7";

    /**
     * 扩展字体8,对应字体文件/resource/font/font8.ttf
     */
    public static final String CAPTCHA_FONT_8 = "captchaFont8";

    /**
     * 扩展字体9,对应字体文件/resource/font/font9.ttf
     */
    public static final String CAPTCHA_FONT_9 = "captchaFont9";

    /**
     * 扩展字体10,对应字体文件/resource/font/font10.ttf
     */
    public static final String CAPTCHA_FONT_10 = "captchaFont10";

    /**
     * 扩展字体11,对应字体文件/resource/font/font11.ttf
     */
    public static final String CAPTCHA_FONT_11 = "captchaFont11";

    /**
     * 扩展字体12,对应字体文件/resource/font/font12.ttf
     * 沐瑶软笔手写体
     */
    public static final String CAPTCHA_FONT_12 = "captchaFont12";

    /**
     * 扩展字体13,对应字体文件/resource/font/font13.ttf
     * 庞门正道粗书体
     */
    public static final String CAPTCHA_FONT_13 = "captchaFont13";

    /**
     * 扩展字体14,对应字体文件/resource/font/font14.ttf
     * 手书体
     */
    public static final String CAPTCHA_FONT_14 = "captchaFont14";

    /**
     * 扩展字体15,对应字体文件/resource/font/font15.ttf
     */
    public static final String CAPTCHA_FONT_15 = "captchaFont15";

    /**
     * 扩展字体16,对应字体文件/resource/font/font16.ttf
     */
    public static final String CAPTCHA_FONT_16 = "captchaFont16";

    /**
     * 扩展字体name集合,判断是否支持的自定义字体
     */
    public static final Set<String> CAPTCHA_FONT_NAMES = new HashSet<String>(){{
        add(CAPTCHA_FONT_1);
        add(CAPTCHA_FONT_2);
        add(CAPTCHA_FONT_3);
        add(CAPTCHA_FONT_4);
        add(CAPTCHA_FONT_5);
        add(CAPTCHA_FONT_6);
        add(CAPTCHA_FONT_7);
        add(CAPTCHA_FONT_8);
        add(CAPTCHA_FONT_9);
        add(CAPTCHA_FONT_10);
        add(CAPTCHA_FONT_11);
        add(CAPTCHA_FONT_12);
        add(CAPTCHA_FONT_13);
        add(CAPTCHA_FONT_14);
        add(CAPTCHA_FONT_15);
        add(CAPTCHA_FONT_16);
    }};

    /**
     * 扩展字体对应的字体文件名称
     */
    private static final Map<String,String> CAPTCHA_FONT_FILENAMES = new ConcurrentHashMap<String, String>(){{
        put(CAPTCHA_FONT_1,"font1.ttf");
        put(CAPTCHA_FONT_2,"font2.ttf");
        put(CAPTCHA_FONT_3,"font3.ttf");
        put(CAPTCHA_FONT_4,"font4.ttf");
        put(CAPTCHA_FONT_5,"font5.ttf");
        put(CAPTCHA_FONT_6,"font6.ttf");
        put(CAPTCHA_FONT_7,"font7.ttf");
        put(CAPTCHA_FONT_8,"font8.ttf");
        put(CAPTCHA_FONT_9,"font9.ttf");
        put(CAPTCHA_FONT_10,"font10.ttf");
        put(CAPTCHA_FONT_11,"font11.ttf");
        put(CAPTCHA_FONT_12,"font12.ttf");
        put(CAPTCHA_FONT_13,"font13.ttf");
        put(CAPTCHA_FONT_14,"font14.ttf");
        put(CAPTCHA_FONT_15,"font15.otf");
        put(CAPTCHA_FONT_16,"font16.ttf");
    }};

    /**
     * 获取字体
     * @param name      字体name
     * @param style     字体样式
     * @param size      字体大小
     * {@link java.awt.Font#Font(String, int, int)}
     * @return
     */
    public static Font getFont(String name, int style, int size){
        if (CAPTCHA_FONT_NAMES.contains(name)) {
            //自定义字体
            return createCustomFont(name, style, size);
        }else {
            //系统自定义字体
            return new Font(name, style, size);
        }
    }

    /**
     * 创建自定义字体
     * use:{@link java.awt.Font#createFont(int, java.io.InputStream)}
     * @return
     */
    private static Font createCustomFont(String name, int style, int size){
        //获取文件路径
        String fontFileName = CAPTCHA_FONT_FILENAMES.get(name);
        if (fontFileName == null) {
            throw new CaptchaException("not find font file name");
        }
        InputStream resourceAsStream = CaptchaFont.class.getResourceAsStream("/font/".concat(fontFileName));
        try {
            return Font.createFont(Font.TRUETYPE_FONT,resourceAsStream).deriveFont(style, size);
        }catch (FontFormatException e) {
            throw new CaptchaException(e.getMessage());
        } catch (IOException ioException) {
            throw new CaptchaException(ioException.getMessage());
        }
    }
}
