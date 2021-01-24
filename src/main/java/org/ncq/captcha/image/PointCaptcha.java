package org.ncq.captcha.image;

import org.ncq.captcha.enums.Interference;
import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.utils.ImageUtil;
import org.ncq.captcha.utils.RandomUtil;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author niuchangqing
 * @Description 点类型干扰线
 */
public class PointCaptcha extends AbstractDrawing {

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
    public PointCaptcha(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
        super(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
    }

    @Override
    protected void drawInterference(Graphics2D graphics2D) {
        ThreadLocalRandom random = RandomUtil.getRandom();
        int x = random.nextInt(this.width);
        int y = random.nextInt(this.height);
        if (this.interferenceColor == null) {
            graphics2D.setColor(ImageUtil.randomColor());
        }else {
            graphics2D.setColor(this.interferenceColor);
        }
        graphics2D.drawOval(x,y,random.nextInt(4),random.nextInt(4));
    }

    @Override
    public boolean isSupport(Interference interference) {
        return interference.getType().equals(InterferenceTypeEnum.POINT.getType());
    }
}
