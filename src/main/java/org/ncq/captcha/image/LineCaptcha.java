package org.ncq.captcha.image;

import org.ncq.captcha.enums.Interference;
import org.ncq.captcha.enums.InterferenceTypeEnum;

import java.awt.*;

/**
 * @author niuchangqing
 * 直线干扰类型
 */
public class LineCaptcha extends AbstractDrawing {
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
    public LineCaptcha(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
        super(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
    }

    public LineCaptcha(int width, int height, int interferenceCount){
        super(width, height, interferenceCount, null, null, null, null, null);
    }


    @Override
    protected void drawInterference(Graphics2D graphics2D) {
        DrawInterferenceUtil.drawLine(graphics2D,this.width, this.height, getInterferenceColorOrRandom());
    }

    @Override
    public boolean isSupport(Interference interference) {
        return interference.getType().equals(InterferenceTypeEnum.LINE.getType());
    }
}
