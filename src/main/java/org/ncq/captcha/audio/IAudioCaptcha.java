package org.ncq.captcha.audio;

public interface IAudioCaptcha {
    /**
     * 返回音频验证码
     * @param code          验证码
     * @return
     */
    byte[] getAudioBytes(String code);

    /**
     * 返回音频验证码base64字符串
     * @param code           验证码
     * @return
     */
    String getAudioBase64(String code);

    /**
     * 返回音频验证码base64Data字符串,浏览器可直接打开
     * @param code            验证码
     * @return
     */
    String getAudioBase64Data(String code);
}
