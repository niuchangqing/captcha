package org.ncq.captcha.image;

import org.ncq.captcha.enums.Interference;
import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.utils.ImageUtil;
import org.ncq.captcha.utils.RandomUtil;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author niuchangqing
 * @Description 弧形验证码
 */
public class ArcCaptcha extends AbstractDrawing {

    /**
     * 构造方法
     *
     * @param width             图片宽度
     * @param height            图片高度
     * @param interferenceCount 干扰数量
     * @param font              字体
     * @param fontColor         字体颜色
     * @param backgroundColor   背景颜色
     * @param interferenceColor 干扰线颜色
     * @param alphaComposite    字体透明度
     */
    public ArcCaptcha(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
        super(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
    }

    @Override
    protected void drawInterference(Graphics2D graphics2D) {
        final ThreadLocalRandom random = RandomUtil.getRandom();
        if (this.interferenceColor == null) {
            graphics2D.setColor(ImageUtil.randomColor());
        }else {
            graphics2D.setColor(this.interferenceColor);
        }
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int w = random.nextInt(width);
        int h = random.nextInt(height);
        graphics2D.setStroke(new BasicStroke(1.3F));
        graphics2D.drawArc(x,y,w,h,random.nextInt(360),random.nextInt(360));
    }

    @Override
    public boolean isSupport(Interference interference) {
        return interference.getType().equals(InterferenceTypeEnum.ARC.getType());
    }
}
