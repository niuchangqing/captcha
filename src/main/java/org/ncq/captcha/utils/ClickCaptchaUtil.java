package org.ncq.captcha.utils;

import org.ncq.captcha.click.CharClickCaptcha;
import org.ncq.captcha.domain.CharClickCaptchaResult;

import java.awt.*;
import java.io.InputStream;

/**
 * @author niuchangqing
 * 点选验证码工具类
 */
public class ClickCaptchaUtil {

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @return              点选验证码结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code){
        return getCharImage(code, null, null, null);
    }

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @param background    背景图片
     * @return              返回结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code, InputStream background) {
        return getCharClickImage(code,background, null);
    }

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @param background    背景图片
     * @param font          字体
     * @return              返回结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code, InputStream background, Font font) {
        return getCharClickImage(code, background, font, null);
    }

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @param background    背景图片
     * @param font          字体
     * @param fonColor      字体颜色
     * @return              返回结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code, InputStream background, Font font, Color fonColor) {
        byte[] bytes = background == null ? null : IOUtil.toByteArray(background);
        return getCharImage(code, bytes, font, fonColor);
    }

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @param background    背景图片
     * @return              返回结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code, byte[] background) {
        return getCharClickImage(code, background, null);
    }

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @param background    背景图片
     * @param font          字体
     * @return              返回结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code, byte[] background, Font font) {
        return getCharClickImage(code, background, font, null);
    }

    /**
     * 获取字符点选验证码
     * @param code          验证码
     * @param background    背景图片
     * @param font          字体
     * @param fonColor      字体颜色
     * @return              返回结果
     */
    public static CharClickCaptchaResult getCharClickImage(String code, byte[] background, Font font, Color fonColor) {
        return getCharImage(code, background, font, fonColor);
    }


    /**
     * 判断一个点是否在圆形区域内
     * @param pointX            点的x(横)坐标
     * @param pointY            点的y(纵)坐标
     * @param circleX           圆心的x坐标
     * @param circleY           圆心的y坐标
     * @param radius            校验圆的半径
     * @return                  true=在范围内,false=未在范围内
     */
    public static boolean isInCircle(double pointX, double pointY, double circleX, double circleY, double radius){
        double hypot = Math.hypot((pointX - circleX), (pointY - circleY));
        if (hypot > radius) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 获取点选验证码图片实现逻辑
     * @param code                  验证码
     * @param background            背景图片
     * @param font                  验证码字体
     * @param fontColor             验证码字体颜色
     * @return                      字符点选验证码结果
     */
    private final static CharClickCaptchaResult getCharImage(String code , byte[] background, Font font, Color fontColor){
        CharClickCaptcha charClickCaptcha = new CharClickCaptcha(font, fontColor);
        return charClickCaptcha.getClickImage(code,background);
    }
}
