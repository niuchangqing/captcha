package org.ncq.captcha.enums;

import org.ncq.captcha.image.IDrawing;

import java.awt.*;

public interface Interference {
    String getType();

    /**
     * 构造画图实现接口
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceCount         干扰数量
     * @param font                      字体,可以为空
     * @param fontColor                 字体颜色,可以为空
     * @param backgroundColor           图片背景颜色,可以为空
     * @param interferenceColor         干扰线颜色,可以为空
     * @param alphaComposite            透明度,可以为空
     * @return
     */
    IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite);
}
