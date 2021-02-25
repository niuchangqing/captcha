package org.ncq.captcha;

import org.junit.Test;
import org.ncq.captcha.enums.LanguageEnum;
import org.ncq.captcha.utils.AudioCaptchaUtil;
import org.ncq.captcha.utils.RandomUtil;

/**
 * @author niuchangqing
 * @description
 */
public class AudioCaptchaTest {

    @Test
    public void zhAudioTest() {
        String code = RandomUtil.randomString(5);
        System.out.println(code);
        String audioBase64Data = AudioCaptchaUtil.getAudioBase64Data(code);
        System.out.println(audioBase64Data);
    }

    @Test
    public void enAudioTest(){
        String code = RandomUtil.randomString(4);
        System.out.println(code);
        String audioBase64Data = AudioCaptchaUtil.getAudioBase64Data(code, LanguageEnum.EN);
        System.out.println(audioBase64Data);
    }

    @Test
    public void jaAudioTest(){
        String code = RandomUtil.randomString(4);
        System.out.println(code);
        String audioBase64Data = AudioCaptchaUtil.getAudioBase64Data(code, LanguageEnum.JA);
        System.out.println(audioBase64Data);
    }

    @Test
    public void ruAudioTest(){
        String code = RandomUtil.randomString(4);
        System.out.println(code);
        String audioBase64Data = AudioCaptchaUtil.getAudioBase64Data(code, LanguageEnum.RU);
        System.out.println(audioBase64Data);
    }
}
