package org.ncq.captcha.image;

import org.ncq.captcha.enums.Interference;
import org.ncq.captcha.enums.InterferenceTypeEnum;

import java.awt.*;

/**
 * @author niuchangqing
 * 圆圈干扰类型图片验证码
 */
public class OvalCaptcha extends AbstractDrawing {


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
    public OvalCaptcha(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
        super(width, height, interferenceCount, font, fontColor, backgroundColor, interferenceColor, alphaComposite);
    }

    public OvalCaptcha(int width, int height, int interferenceCount){
        super(width, height, interferenceCount, null, null, null, null, null);
    }

    /**
     * 圆形干扰线
     * @param graphics2D        绘笔对象
     */
    @Override
    protected void drawInterference(Graphics2D graphics2D) {
        DrawInterferenceUtil.drawOval(graphics2D,this.width, this.height, getInterferenceColorOrRandom());
    }

    @Override
    public boolean isSupport(Interference interference) {
        return interference.getType().equals(InterferenceTypeEnum.OVAL.getType());
    }
}
