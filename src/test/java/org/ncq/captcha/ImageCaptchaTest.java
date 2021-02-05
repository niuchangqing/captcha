package org.ncq.captcha;

import org.junit.Test;
import org.ncq.captcha.domain.CalculationResultDTO;
import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.font.CaptchaFont;
import org.ncq.captcha.utils.ImageCaptchaUtil;
import org.ncq.captcha.utils.RandomUtil;

import java.awt.*;
import java.io.InputStream;

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

    /**
     * 测试贝塞尔干扰类型图片验证码
     */
    @Test
    public void testBezierCurve(){
        String imageBase64Data = ImageCaptchaUtil.getImageBase64Data(RandomUtil.randomString(4), 100, 30, 4, InterferenceTypeEnum.BEZIER,new Font("楷体", Font.PLAIN, 28));
        System.out.println(imageBase64Data);
    }


    /**
     * 贝塞尔+圆圈干扰类型验证码
     */
    @Test
    public void testBezierOvalCaptcha(){
        String imageBase64Data = ImageCaptchaUtil.getImageBase64Data(RandomUtil.randomString(4), 100, 35, 3, InterferenceTypeEnum.BEZIER_OVAL);
        System.out.println(imageBase64Data);
    }

    /**
     * 弧形干扰类型
     */
    @Test
    public void testArcCaptcha(){
        String imageBase64Data = ImageCaptchaUtil.getGifImageBase64Data("1234", 90, 30, 10,null,Color.RED,null,null,null, InterferenceTypeEnum.ARC);
        System.out.println(imageBase64Data);
    }

    /**
     * 测试字体
     */
    @Test
    public void testCaptchaFont() throws Exception {
        System.out.println(System.currentTimeMillis());
        InputStream resourceAsStream = CaptchaFont.class.getResourceAsStream("/font/".concat("font16.ttf"));
        Font font = Font.createFont(Font.TRUETYPE_FONT,resourceAsStream).deriveFont(1, 40);
        String imageBase64Data = ImageCaptchaUtil.getImageBase64Data("东南西北", 170, 55, 3, InterferenceTypeEnum.BEZIER_OVAL,font);
        System.out.println(System.currentTimeMillis());
        
    }
}