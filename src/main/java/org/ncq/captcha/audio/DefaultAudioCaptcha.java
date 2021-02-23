package org.ncq.captcha.audio;

import org.ncq.captcha.enums.ILanguage;
import org.ncq.captcha.enums.LanguageEnum;
import org.ncq.captcha.exception.CaptchaException;
import org.ncq.captcha.utils.RandomUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author niuchangqing
 * @Description 默认音频验证码实现,只支持0～9,a~z,A~Z
 */
public class DefaultAudioCaptcha extends AbstractAudioCaptcha {

    public DefaultAudioCaptcha() {
    }

    public DefaultAudioCaptcha(ILanguage language) {
        super(language);
    }

    public DefaultAudioCaptcha(ILanguage language, InputStream prefix, InputStream suffix) {
        super(language, prefix, suffix);
    }

    @Override
    protected List<InputStream> getCodeAudio(String code) {
        //验证码音频语言,默认为中文
        String language = this.language == null ? LanguageEnum.ZH.getName() : this.language.getName();
        List<InputStream> list = new ArrayList<>();
        for (int i = 0; i < code.length(); i++) {
            boolean flag = RandomUtil.NUMBER_LOWER_UPPER_CHAR.contains(String.valueOf(code.charAt(i)));
            if (!flag) {
                throw new CaptchaException("default audio captcha supports 0 ~ 9 or a ~ z or A ~ Z");
            }
            String path = "/audio/" + language + "/" + code.charAt(i) + ".wav";
            InputStream inputStream = DefaultAudioCaptcha.class.getResourceAsStream(path.toLowerCase());
            list.add(inputStream);
        }
        return list;
    }
}
