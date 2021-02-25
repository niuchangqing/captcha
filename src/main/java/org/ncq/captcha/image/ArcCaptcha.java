package org.ncq.captcha.image;

import org.ncq.captcha.enums.InterferenceTypeEnum;
import org.ncq.captcha.utils.ImageUtil;

import java.awt.*;


/**
 * @author niuchangqing
 * 弧形验证码
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

    public ArcCaptcha(int width, int height, int interferenceCount){
        super(width, height, interferenceCount, null, null, null, null, null);
    }

    @Override
    protected void drawInterference(Graphics2D graphics2D) {
        DrawInterferenceUtil.drawArc(graphics2D, this.width, this.height, getInterferenceColorOrRandom());
    }

    @Override
    public boolean isSupport(org.ncq.captcha.enums.Interference interference) {
        return interference.getType().equals(InterferenceTypeEnum.ARC.getType());
    }
}
