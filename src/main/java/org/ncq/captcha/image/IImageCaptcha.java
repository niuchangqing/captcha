package org.ncq.captcha.image;

import org.ncq.captcha.enums.Interference;

public interface IImageCaptcha {
    /**
     * 获取验证码图片base64字符串
     * @param code              验证码
     * @return                  验证码图片base64字符串
     */
    String getImageBase64(String code);

    /**
     * 获取验证码图片base64Data字符串
     * @param code               验证码
     * @return                   验证码图片base64Data字符串
     */
    String getImageBase64Data(String code);

    /**
     * 获取验证码图片字节流
     * @param code              验证码
     * @return                  验证码图片字节流
     */
    byte[] getImageBytes(String code);

    /**
     * 获取gif验证码图片的base64字符串
     * @param code              验证码
     * @return                  base64字符串
     */
    String getGifImageBase64(String code);

    /**
     * 获取gif验证码图片的base64Data字符串
     * @param code              验证码
     * @return                  base64Data字符串
     */
    String getGifImageBase64Data(String code);

    /**
     * 获取gif验证码图片的字节流
     * @param code              验证码
     * @return                  byte[]
     */
    byte[] getGifImageBytes(String code);

    /**
     * 是否支持干扰线类型
     * @param interference      干扰线类型
     * @return                  是否支持
     */
    boolean isSupport(Interference interference);
}
