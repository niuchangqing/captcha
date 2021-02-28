package org.ncq.captcha.domain;

import java.io.Serializable;

/**
 * @author niuchangqing
 * 点选验证码响应结果
 */
public class ClickCaptchaResult implements Serializable {

    private static final long serialVersionUID = -5450076683080397333L;
    /**
     * 生成点选图片的base64字符串
     */
    private String base64;

    /**
     * 生成点下图片的base64Data字符串
     */
    private String base64Data;

    /**
     * 生成点选图片的byte[]
     */
    private byte[] bytes;

    public ClickCaptchaResult() {
    }

    public ClickCaptchaResult(String base64, String base64Data, byte[] bytes) {
        this.base64 = base64;
        this.base64Data = base64Data;
        this.bytes = bytes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBase64() {
        return base64;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
