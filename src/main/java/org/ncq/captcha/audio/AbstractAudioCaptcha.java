package org.ncq.captcha.audio;

import org.ncq.captcha.enums.ILanguage;
import org.ncq.captcha.enums.LanguageEnum;
import org.ncq.captcha.exception.CaptchaException;
import org.ncq.captcha.utils.AudioCaptchaUtil;
import org.ncq.captcha.utils.IOUtil;
import org.ncq.captcha.utils.WavUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

/**
 * @author niuchangqing
 * 音频验证码
 */
public abstract class AbstractAudioCaptcha implements IAudioCaptcha {

    /**
     * 语言类型枚举
     */
    protected ILanguage language;

    /**
     * 生成音频的前缀音频文件
     * prefix + code
     */
    protected byte[] prefix;

    /**
     * 生成音频的后缀音频文件
     * code + suffix
     */
    protected byte[] suffix;

    public AbstractAudioCaptcha(ILanguage language) {
        this.language = language == null ? LanguageEnum.ZH : language;
        String prefixPath = "/audio/" + language.getName() + "/prefix.wav";
        InputStream prefixStream = AudioCaptchaUtil.class.getResourceAsStream(prefixPath.toLowerCase());
        this.prefix = IOUtil.toByteArray(prefixStream);
        String suffixPath = "/audio/" + language.getName() + "/suffix.wav";
        InputStream suffixStream = AudioCaptchaUtil.class.getResourceAsStream(suffixPath.toLowerCase());
        this.suffix = IOUtil.toByteArray(suffixStream);
        IOUtil.close(prefixStream);
        IOUtil.close(suffixStream);
    }

    public AbstractAudioCaptcha(ILanguage language, byte[] prefix, byte[] suffix){
        this.language = language == null ? LanguageEnum.ZH : language;;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public byte[] getAudioBytes(String code) {
        if (code == null || code.length() <= 0) {
            throw new CaptchaException("code cannot be null");
        }
        List<InputStream> list = getCodeAudio(code);
        //集合第一位设置空白
        list.add(0,getBlank());
        //验证码前置音频文件不为空
        if (prefix != null) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(prefix);
            list.add(1,inputStream);
            list.add(2,getBlank());
        }
        //验证码后置音频文件不为空
        if (suffix != null) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(suffix);
            list.add(getBlank());
            list.add(inputStream);
        }
        byte[] merge = WavUtil.merge(list);
        return merge;
    }

    @Override
    public String getAudioBase64(String code) {
        byte[] bytes = getAudioBytes(code);
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

    @Override
    public String getAudioBase64Data(String code) {
        String base64 = getAudioBase64(code);
        StringBuilder base64Data = new StringBuilder();
        base64Data.append("data:audio/wav;base64,");
        base64Data.append(base64);
        return base64Data.toString();
    }

    /**
     * 获取验证码文件的输入流
     * @param code          验证码
     * @return              验证码字符对应的wav格式InputStream对象
     */
    protected abstract List<InputStream> getCodeAudio(String code);

    /**
     * 获取默认空白音频信息
     * 文件路径:/resources/audio/blank.wav
     * @return              空格wav格式InputStream
     */
    private InputStream getBlank(){
        InputStream inputStream = AbstractAudioCaptcha.class.getResourceAsStream("/audio/blank.wav");
        return inputStream;
    }
}
