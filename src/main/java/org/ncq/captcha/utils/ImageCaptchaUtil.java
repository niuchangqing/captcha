package org.ncq.captcha.utils;

import org.ncq.captcha.enums.Interference;
import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.image.IImageCaptcha;

import java.awt.*;

/**
 * @Author niuchangqing
 * @Description 图形验证码工具类
 */
public class ImageCaptchaUtil {

    public static String getImageBase64Data(String code){
        return getImageBase64Data(code, 80, 30);
    }

    public static String getImageBase64Data(String code, int width, int height){
        return getImageBase64Data(code, width, height, 10);
    }

    public static String getImageBase64Data(String code, int width, int height, int interferenceCount){
        return getImageBase64Data(code,width,height,interferenceCount,null);
    }

    public static String getImageBase64Data(String code, int width, int height, int interferenceCount, Interference interference){
        return getImageBase64Data(code,width,height,interferenceCount,interference,null);
    }

    public static String getImageBase64Data(String code, int width, int height, int interferenceCount, Interference interference, Font font){
        return getImageBase64Data(code,width,height,interferenceCount,font,null,null,null,null,interference);
    }

    /**
     * 获取图片base64Data字符串
     * @param code                      验证码
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceCount         干扰线数量
     * @param font                      字体,可以为空
     * @param fontColor                 字体颜色,可以为空
     * @param backgroundColor           背景颜色,可以为空
     * @param interferenceColor         干扰线颜色,可以为空
     * @param alphaComposite            透明度,可以为空
     * @param interference              干扰线类型 事例:{@link org.ncq.captcha.enums.InterferenceTypeEnum},若是自定义继承实现{@link org.ncq.captcha.enums.Interference}
     * @return
     */
    public static String getImageBase64Data(String code,int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite, Interference interference){
        if (interference == null) {
            interference = InterferenceTypeEnum.OVAL;
        }
        IImageCaptcha drawing = interference.drawing(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
        return drawing.getImageBase64Data(code);
    }


    public static String getImageBase64(String code){
        return getImageBase64(code, 80, 30);
    }

    public static String getImageBase64(String code, int width, int height){
        return getImageBase64(code, width, height, 10);
    }

    public static String getImageBase64(String code, int width, int height, int interferenceCount){
        return getImageBase64(code,width,height,interferenceCount,null);
    }

    public static String getImageBase64(String code, int width, int height, int interferenceCount, Interference interference){
        return getImageBase64(code,width,height,interferenceCount,interference,null);
    }

    public static String getImageBase64(String code, int width, int height, int interferenceCount, Interference interference, Font font){
        return getImageBase64(code,width,height,interferenceCount,font,null,null,null,null,interference);
    }
    /**
     * 获取图片验证码base64字符串
     * @param code                      验证码
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceCount         图片干扰线数量
     * @param font                      字体,可以为空
     * @param fontColor                 字体颜色,可以为空
     * @param backgroundColor           背景颜色,可以为空
     * @param interferenceColor         干扰线颜色,可以为空
     * @param alphaComposite            透明度,可以为空
     * @param interference              干扰线类型 事例:{@link org.ncq.captcha.enums.InterferenceTypeEnum},若是自定义继承实现{@link org.ncq.captcha.enums.Interference}
     * @return
     */
    public static String getImageBase64(String code,int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite, Interference interference){
        if (interference == null) {
            interference = InterferenceTypeEnum.OVAL;
        }
        IImageCaptcha drawing = interference.drawing(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
        return drawing.getImageBase64(code);
    }

    public static byte[] getImageBytes(String code){
        return getImageBytes(code, 80, 30);
    }

    public static byte[] getImageBytes(String code, int width, int height){
        return getImageBytes(code, width, height, 10);
    }

    public static byte[] getImageBytes(String code, int width, int height, int interferenceCount){
        return getImageBytes(code,width,height,interferenceCount,null);
    }

    public static byte[] getImageBytes(String code, int width, int height, int interferenceCount, Interference interference){
        return getImageBytes(code,width,height,interferenceCount,interference,null);
    }

    public static byte[] getImageBytes(String code, int width, int height, int interferenceCount, Interference interference, Font font){
        return getImageBytes(code,width,height,interferenceCount,font,null,null,null,null,interference);
    }

    /**
     * 获取图片验证码字节流
     * @param code                      验证码
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceCount         干扰线数量
     * @param font                      字体,可以为空
     * @param fontColor                 字体颜色,可以为空
     * @param backgroundColor           背景颜色,可以为空
     * @param interferenceColor         干扰线颜色,可以为空
     * @param alphaComposite            透明度,可以为空
     * @param interference              干扰线类型,可以为空 事例:{@link org.ncq.captcha.enums.InterferenceTypeEnum},若是自定义继承实现{@link org.ncq.captcha.enums.Interference}
     * @return
     */
    public static byte[] getImageBytes(String code,int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite, Interference interference){
        if (interference == null) {
            interference = InterferenceTypeEnum.OVAL;
        }
        IImageCaptcha drawing = interference.drawing(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
        return drawing.getImageBytes(code);
    }

    public static String getGifImageBase64Data(String code){
        return getGifImageBase64Data(code, 80, 30);
    }

    public static String getGifImageBase64Data(String code, int width, int height){
        return getGifImageBase64Data(code, width, height, 10);
    }

    public static String getGifImageBase64Data(String code, int width, int height, int interferenceCount){
        return getGifImageBase64Data(code,width,height,interferenceCount,null);
    }

    public static String getGifImageBase64Data(String code, int width, int height, int interferenceCount, Interference interference){
        return getGifImageBase64Data(code,width,height,interferenceCount,interference,null);
    }

    public static String getGifImageBase64Data(String code, int width, int height, int interferenceCount, Interference interference, Font font){
        return getGifImageBase64Data(code,width,height,interferenceCount,font,null,null,null,null,interference);
    }

    /**
     * 获取动态图片验证码base64Data字符串
     * @param code                          验证码
     * @param width                         图片宽度
     * @param height                        图片高度
     * @param interferenceCount             干扰线数量
     * @param font                          字体,可以为空
     * @param fontColor                     字体颜色,可以为空
     * @param backgroundColor               图片背景颜色,可以为空
     * @param interferenceColor             干扰线颜色,可以为空
     * @param alphaComposite                透明度,可以为空
     * @param interference                  干扰线类型,可以为空 事例:{@link org.ncq.captcha.enums.InterferenceTypeEnum},若是自定义继承实现{@link org.ncq.captcha.enums.Interference}
     * @return
     */
    public static String getGifImageBase64Data(String code,int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite, Interference interference){
        if (interference == null) {
            interference = InterferenceTypeEnum.OVAL;
        }
        IImageCaptcha drawing = interference.drawing(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
        return drawing.getGifImageBase64Data(code);
    }

    public static String getGifImageBase64(String code){
        return getGifImageBase64(code, 80, 30);
    }

    public static String getGifImageBase64(String code, int width, int height){
        return getGifImageBase64(code, width, height, 10);
    }

    public static String getGifImageBase64(String code, int width, int height, int interferenceCount){
        return getGifImageBase64(code,width,height,interferenceCount,null);
    }

    public static String getGifImageBase64(String code, int width, int height, int interferenceCount, Interference interference){
        return getGifImageBase64(code,width,height,interferenceCount,interference,null);
    }

    public static String getGifImageBase64(String code, int width, int height, int interferenceCount, Interference interference, Font font){
        return getGifImageBase64(code,width,height,interferenceCount,font,null,null,null,null,interference);
    }
    /**
     * 获取动态图片验证码base64字符串
     * @param code                          验证码
     * @param width                         图片宽度
     * @param height                        图片高度
     * @param interferenceCount             干扰线数量
     * @param font                          字体,可以为空
     * @param fontColor                     字体颜色,可以为空
     * @param backgroundColor               图片背景颜色,可以为空
     * @param interferenceColor             干扰线颜色,可以为空
     * @param alphaComposite                透明度,可以为空
     * @param interference                  干扰线类型,可以为空 事例:{@link org.ncq.captcha.enums.InterferenceTypeEnum},若是自定义继承实现{@link org.ncq.captcha.enums.Interference}
     * @return
     */
    public static String getGifImageBase64(String code,int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite, Interference interference){
        if (interference == null) {
            interference = InterferenceTypeEnum.OVAL;
        }
        IImageCaptcha drawing = interference.drawing(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
        return drawing.getGifImageBase64(code);
    }

    public static byte[] getGitImageBytes(String code){
        return getGitImageBytes(code, 80, 30);
    }

    public static byte[] getGitImageBytes(String code, int width, int height){
        return getGitImageBytes(code, width, height, 10);
    }

    public static byte[] getGitImageBytes(String code, int width, int height, int interferenceCount){
        return getGitImageBytes(code,width,height,interferenceCount,null);
    }

    public static byte[] getGitImageBytes(String code, int width, int height, int interferenceCount, Interference interference){
        return getGitImageBytes(code,width,height,interferenceCount,interference,null);
    }

    public static byte[] getGitImageBytes(String code, int width, int height, int interferenceCount, Interference interference, Font font){
        return getGitImageBytes(code,width,height,interferenceCount,font,null,null,null,null,interference);
    }
    /**
     * 获取动态图片验证码字节流
     * @param code                          验证码
     * @param width                         图片宽度
     * @param height                        图片高度
     * @param interferenceCount             干扰线数量
     * @param font                          字体,可以为空
     * @param fontColor                     字体颜色,可以为空
     * @param backgroundColor               图片背景颜色,可以为空
     * @param interferenceColor             干扰线颜色,可以为空
     * @param alphaComposite                透明度,可以为空
     * @param interference                  干扰线类型,可以为空 事例:{@link org.ncq.captcha.enums.InterferenceTypeEnum},若是自定义继承实现{@link org.ncq.captcha.enums.Interference}
     * @return
     */
    public static byte[] getGitImageBytes(String code,int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite, Interference interference){
        if (interference == null) {
            interference = InterferenceTypeEnum.OVAL;
        }
        IImageCaptcha drawing = interference.drawing(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
        return drawing.getGifImageBytes(code);
    }
}
