package org.ncq.captcha.enums;

import org.ncq.captcha.image.*;

import java.awt.*;

/**
 * @Author niuchangqing
 * @Description 干扰线类型枚举
 */
public enum InterferenceTypeEnum implements  Interference {
    /**
     * 圆圈干扰类型
     */
    OVAL{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new OvalCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    /**
     * 弧形
     */
    ARC{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new ArcCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    /**
     * 直线
     */
    LINE{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new LineCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    /**
     * 点
     */
    POINT{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new PointCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    /**
     * 方块
     */
    SQUARE{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new SquareCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    /**
     * 贝塞尔曲线
     */
    BEZIER{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new BezierCurveCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    /**
     * 贝塞尔曲线加圆圈
     * 曲线和圈的比例,1:2
     */
    BEZIER_OVAL{
        @Override
        public IDrawing drawing(int width, int height, int interferenceCount, Font font, Color fontColor, Color backgroundColor, Color interferenceColor, AlphaComposite alphaComposite) {
            return new BezierOvalCaptcha(width,height,interferenceCount,font,fontColor,backgroundColor,interferenceColor,alphaComposite);
        }
    },
    ;

    @Override
    public String getType() {
        return this.name();
    }
}
