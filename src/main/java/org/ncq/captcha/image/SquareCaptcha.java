package org.ncq.captcha.image;

import org.ncq.captcha.enums.Interference;
import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.utils.ImageUtil;
import org.ncq.captcha.utils.RandomUtil;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author niuchangqing
 * @Description 方块干扰类型
 */
public class SquareCaptcha extends AbstractDrawing {

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
    public SquareCaptcha(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
        super(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
    }

    @Override
    protected void drawInterference(Graphics2D graphics2D) {
        ThreadLocalRandom random = RandomUtil.getRandom();
        int x1 = random.nextInt(0, (int) (this.width * 0.1));
        int y1 = random.nextInt(0, (int) (this.height * 0.1));
        int x2 = random.nextInt((int) (this.width * 0.1), width);
        int y2 = random.nextInt((int) (this.height * 0.1), height);
        graphics2D.setColor(ImageUtil.randomColor());
        int w = x2 - x1;
        int h = y2 - y1;
        if (w < 0) {
            w = -w;
        }
        if (h < 0) {
            h = -h;
        }
        graphics2D.setStroke(new BasicStroke(2.5F));
        graphics2D.drawRect(x1, y1, w, h);
    }

    @Override
    public boolean isSupport(Interference interference) {
        return interference.getType().equals(InterferenceTypeEnum.SQUARE.getType());
    }
}
