package org.ncq.captcha.utils;

import org.ncq.captcha.audio.DefaultAudioCaptcha;
import org.ncq.captcha.audio.IAudioCaptcha;
import org.ncq.captcha.enums.ILanguage;
import org.ncq.captcha.enums.LanguageEnum;

import java.io.InputStream;

/**
 * @Author niuchangqing
 * @Description 音频验证码工具类
 * <p>
 *     默认验证码只支持0~9,a~z,A~Z
 *     继承AbstractAudioCaptcha类可进行自定义实现验证码音频实现
 *     {@link org.ncq.captcha.audio.AbstractAudioCaptcha}
 * </p>
 */
public class AudioCaptchaUtil {

    /**
     * 获取音频验证码base64Data字符串
     * @param code              验证码
     * @return
     */
    public static String getAudioBase64Data(String code){
        return getAudioBase64Data(code, LanguageEnum.ZH);
    }

    /**
     * 获取音频验证码base64Data字符串
     * @param code              验证码
     * @param language          音频语言类型,可以为空,为空默认为中文
     * <p>
     *     默认附带前缀音频和后缀音频
     *     音频验证码格式为:  prefix + code + suffix。例如: 您的验证码是 7391 请输入。
     * </p>
     * @return
     */
    public static String getAudioBase64Data(String code, ILanguage language){
        return getAudioBase64Data(code, language, getDefaultPrefixAudio(language), getDefaultSuffixAudio(language));
    }

    /**
     * 获取音频验证码base64Data字符串
     * @param code              验证码
     * @param language          语言类型,可以为空,默认为中文
     * @param prefix            验证码音频前缀音频,可以为空
     * @param suffix            验证码音频后缀音频,可以为空
     * <p>
     *   1.音频验证码格式为:  prefix + code + suffix。例如: 您的验证码是 7391 请输入。
     *   2.prefix和suffix为空，则只有验证码音频。例如:  7391
     * </p>
     * @return
     */
    public static String getAudioBase64Data(String code, ILanguage language, InputStream prefix, InputStream suffix){
        IAudioCaptcha audioCaptcha = new DefaultAudioCaptcha(language, prefix, suffix);
        return audioCaptcha.getAudioBase64Data(code);
    }

    /**
     * 获取音频验证码base64字符串
     * @param code              验证码
     * @return
     */
    public static String getAudioBase64(String code){
        return getAudioBase64(code, LanguageEnum.ZH);
    }

    /**
     * 获取音频验证码base64字符串
     * @param code              验证码
     * @param language          音频语言类型,可以为空,为空默认为中文
     * <p>
     *     默认附带前缀音频和后缀音频
     *     音频验证码格式为:  prefix + code + suffix。例如: 您的验证码是 7391 请输入。
     * </p>
     * @return
     */
    public static String getAudioBase64(String code, ILanguage language){
        return getAudioBase64(code, language, getDefaultPrefixAudio(language), getDefaultSuffixAudio(language));
    }

    /**
     * 获取音频验证码base64字符串
     * @param code              验证码
     * @param language          语言类型,可以为空,默认为中文
     * @param prefix            验证码音频前缀音频,可以为空
     * @param suffix            验证码音频后缀音频,可以为空
     * <p>
     *   1.音频验证码格式为:  prefix + code + suffix。例如: 您的验证码是 7391 请输入。
     *   2.prefix和suffix为空，则只有验证码音频。例如:  7391
     * </p>
     * @return
     */
    public static String getAudioBase64(String code, ILanguage language, InputStream prefix, InputStream suffix){
        IAudioCaptcha audioCaptcha = new DefaultAudioCaptcha(language, prefix, suffix);
        return audioCaptcha.getAudioBase64(code);
    }

    /**
     * 获取音频验证码byte[]
     * @param code              验证码
     * @return
     */
    public static byte[] getAudioBytes(String code){
        return getAudioBytes(code, LanguageEnum.ZH);
    }

    /**
     * 获取音频验证码byte[]
     * @param code              验证码
     * @param language          音频语言类型,可以为空,为空默认为中文
     * <p>
     *     默认附带前缀音频和后缀音频
     *     音频验证码格式为:  prefix + code + suffix。例如: 您的验证码是 7391 请输入。
     * </p>
     * @return
     */
    public static byte[] getAudioBytes(String code, ILanguage language){
        return getAudioBytes(code, language, getDefaultPrefixAudio(language), getDefaultSuffixAudio(language));
    }

    /**
     * 获取音频验证码byte[]
     * @param code              验证码
     * @param language          语言类型,可以为空,默认为中文
     * @param prefix            验证码音频前缀音频,可以为空
     * @param suffix            验证码音频后缀音频,可以为空
     * <p>
     *   1.音频验证码格式为:  prefix + code + suffix。例如: 您的验证码是 7391 请输入。
     *   2.prefix和suffix为空，则只有验证码音频。例如:  7391
     * </p>
     * @return
     */
    public static byte[] getAudioBytes(String code, ILanguage language, InputStream prefix, InputStream suffix){
        IAudioCaptcha audioCaptcha = new DefaultAudioCaptcha(language, prefix, suffix);
        return audioCaptcha.getAudioBytes(code);
    }

    /**
     * 自定义验证码实现
     * @param code          验证码
     * @param audioCaptcha  {@link org.ncq.captcha.audio.IAudioCaptcha}
     * @return
     */
    public static String getAudioBase64Data(String code, IAudioCaptcha audioCaptcha) {
        String audioBase64Data = audioCaptcha.getAudioBase64Data(code);
        return audioBase64Data;
    }

    /**
     * 自定义验证码实现
     * @param code          验证码
     * @param audioCaptcha  {@link org.ncq.captcha.audio.IAudioCaptcha}
     * @return
     */
    public static String getAudioBase64(String code, IAudioCaptcha audioCaptcha) {
        String audioBase64 = audioCaptcha.getAudioBase64(code);
        return audioBase64;
    }

    /**
     * 自定义验证码实现
     * @param code          验证码
     * @param audioCaptcha  {@link org.ncq.captcha.audio.IAudioCaptcha}
     * @return
     */
    public static byte[] getAudioBytes(String code, IAudioCaptcha audioCaptcha) {
        byte[] bytes = audioCaptcha.getAudioBytes(code);
        return bytes;
    }

    /**
     * 获取默认验证码前缀音频文件
     * @param language          验证码语言类型,可以为空,默认为中文
     * @return
     */
    private static InputStream getDefaultPrefixAudio(ILanguage language){
        language = language == null ? LanguageEnum.ZH : language;
        String path = "/audio/" + language.getName() + "/prefix.wav";
        return AudioCaptchaUtil.class.getResourceAsStream(path.toLowerCase());
    }

    /**
     * 获取默认验证码后缀音频文件
     * @param language
     * @return
     */
    private static InputStream getDefaultSuffixAudio(ILanguage language) {
        language = language == null ? LanguageEnum.ZH : language;
        String path = "/audio/" + language.getName() + "/suffix.wav";
        return AudioCaptchaUtil.class.getResourceAsStream(path.toLowerCase());
    }
}
