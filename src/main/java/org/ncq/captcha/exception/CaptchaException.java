package org.ncq.captcha.exception;

/**
 * @Author niuchangqing
 * @Description 验证码异常信息
 */
public class CaptchaException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6092847885318101202L;

    public CaptchaException(String message) {
        super(message);
    }
}