package org.ncq.captcha.click;

import org.ncq.captcha.domain.ClickCaptchaResult;

/**
 * 点选方式验证码
 * @author niuchangqing
 */
public interface IClickCaptcha <T extends ClickCaptchaResult> {
    /**
     * 获取点选验证码
     * @param code              验证码
     * @param background        背景图片
     * @return                  结果
     */
    T  getClickImage(String code, byte[] background);
}
