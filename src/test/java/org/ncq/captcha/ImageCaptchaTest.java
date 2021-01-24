package org.ncq.captcha;

import org.junit.Test;
import org.ncq.captcha.domain.CalculationResultDTO;
import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.utils.ImageCaptchaUtil;
import org.ncq.captcha.utils.RandomUtil;

/**
 * @Author niuchangqing
 * @Description 图片验证码测试
 */
public class ImageCaptchaTest {

    @Test
    public void testGifImageBase64Data(){
//        String gifImageBase64Data = ImageCaptchaUtil.getGifImageBase64Data();
//        System.out.println(gifImageBase64Data);
        //指定图片宽高干扰数量
//        String gifImageBase64Data = ImageCaptchaUtil.getGifImageBase64Data(RandomUtil.randomString(5), 150, 50, 20);
//        System.out.println(gifImageBase64Data);

        //指定干扰类型为直线
        String gifImageBase64Data = ImageCaptchaUtil.getGifImageBase64Data(RandomUtil.randomString(4), 100, 40, 10, InterferenceTypeEnum.LINE);
        System.out.println(gifImageBase64Data);
    }


    @Test
    public void testImageBase64Data(){
//        String imageBase64Data = ImageCaptchaUtil.getImageBase64Data();
//        System.out.println(imageBase64Data);

        //运算类的验证码,20以内的加减乘
        CalculationResultDTO calculationResultDTO = RandomUtil.randomCalculation(20);
        System.out.println(calculationResultDTO.getResult());
        String imageBase64Data = ImageCaptchaUtil.getImageBase64Data(calculationResultDTO.calculationString, 90, 30, 10);
        System.out.println(imageBase64Data);
    }
}
