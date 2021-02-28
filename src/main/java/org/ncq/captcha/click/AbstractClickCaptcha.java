package org.ncq.captcha.click;

import org.ncq.captcha.domain.ClickCaptchaResult;
import org.ncq.captcha.utils.IOUtil;
import org.ncq.captcha.utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * @author niuchangqing
 * 点选验证码
 */
public abstract class AbstractClickCaptcha<T extends ClickCaptchaResult> implements IClickCaptcha<T> {
    /**
     * 文字字体
     */
    protected Font font;

    /**
     * 字体颜色
     */
    protected Color fontColor;

    /**
     * 字体是否旋转
     */
//    protected boolean isRotation = true;

    /**
     * 构造方法
     * @param font              字体
     * @param fontColor         字体颜色
     */
    public AbstractClickCaptcha(Font font, Color fontColor) {
        this.font = font == null ? new Font("Arial",Font.BOLD, 35) : font;
        this.fontColor = fontColor == null ? Color.BLACK : fontColor;
    }

    protected ClickCaptchaResult result(BufferedImage bufferedImage, String imageType) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            ImageUtil.write(bufferedImage, imageType, out);
            bytes = out.toByteArray();
        }finally {
            //关闭
            IOUtil.close(out);
        }
        ClickCaptchaResult result = new ClickCaptchaResult();
        result.setBytes(bytes);
        //base64
        String base64 = Base64.getEncoder().encodeToString(bytes);
        result.setBase64(base64);
        //base64Data
        StringBuilder imageBase64Data = new StringBuilder();
        imageBase64Data.append("data:image/");
        imageBase64Data.append(imageType);
        imageBase64Data.append(";base64,");
        imageBase64Data.append(base64);
        result.setBase64Data(imageBase64Data.toString());
        return result;
    }
}
