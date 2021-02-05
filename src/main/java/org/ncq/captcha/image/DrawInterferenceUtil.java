package org.ncq.captcha.image;

import org.ncq.captcha.utils.ImageUtil;
import org.ncq.captcha.utils.RandomUtil;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author niuchangqing
 * @Description 绘制干扰线实现类
 */
class DrawInterferenceUtil {

    /**
     * 弧形干扰线绘制
     * @param graphics2D                绘笔对象
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceColor         干扰线颜色
     */
    public static void drawArc(Graphics2D graphics2D,int width,int height, Color interferenceColor){
        final ThreadLocalRandom random = RandomUtil.getRandom();
        graphics2D.setColor(interferenceColor);

        int x = random.nextInt(1,width);
        int y = random.nextInt(1,height);
        int w = random.nextInt(width / 5, width / 2);
        int h = random.nextInt(height / 5, height / 2);
        int arcAngle = 0;
        if (random.nextBoolean()) {
            arcAngle = random.nextInt(140,160);
        }else {
            arcAngle = random.nextInt(-160,-140);
        }
        graphics2D.drawArc(x,y,w,h,0,arcAngle);
    }

    /**
     * 直线干扰线绘制
     * @param graphics2D                绘笔对象
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceColor         干扰线颜色
     */
    public static void drawLine(Graphics2D graphics2D,int width,int height, Color interferenceColor){
        ThreadLocalRandom random = RandomUtil.getRandom();
        int xs = random.nextInt(width);
        int ys = random.nextInt(height);
        int xe = xs + random.nextInt(width / 4);
        int ye = ys + random.nextInt(height / 4);
        if (interferenceColor == null) {
            graphics2D.setColor(ImageUtil.randomColor());
        }else {
            graphics2D.setColor(interferenceColor);
        }
        graphics2D.setStroke(new BasicStroke(1.5F));
        graphics2D.drawLine(xs, ys, xe, ye);
    }

    /**
     * 贝塞尔干扰线绘制
     * @param graphics2D                绘笔对象
     * @param width                     图片快读
     * @param height                    图片高度
     * @param interferenceColor         干扰线颜色
     */
    public static void drawBezierCurve(Graphics2D graphics2D,int width,int height, Color interferenceColor){
        graphics2D.setColor(interferenceColor);
        ThreadLocalRandom random = RandomUtil.getRandom();
        int i = 5;
        int x1 = random.nextInt(i,10);
        int y1 = random.nextInt(i,height / 2);
        int x2 = width - i;
        int y2 = random.nextInt(height / 2, height - i);
        int clx = random.nextInt(width / 4 , width / 4 * 3);
        int cly = random.nextInt(i, height - i);
        if (random.nextBoolean()) {
            int t = y1;
            y1 = y2;
            y2 = t;
        }
        if (random.nextBoolean()) {
            QuadCurve2D shape = new QuadCurve2D.Double();
            shape.setCurve(x1, y1, clx, cly, x2, y2);
            graphics2D.draw(shape);
        }else {
            int clx1 = random.nextInt(width / 4, width / 4 * 3);
            int cly1 = random.nextInt(i, height - i);
            CubicCurve2D shape = new CubicCurve2D.Double(x1, y1, clx, cly, clx1, cly1, x2, y2);
            graphics2D.draw(shape);
        }
    }

    /**
     * 绘制椭圆形干扰线
     * @param graphics2D                绘笔对象
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceColor         干扰线颜色
     */
    public static void drawOval(Graphics2D graphics2D,int width,int height, Color interferenceColor){
        final ThreadLocalRandom random = RandomUtil.getRandom();
        graphics2D.setColor(interferenceColor);
        graphics2D.drawOval(random.nextInt(width), random.nextInt(height), random.nextInt(height >> 1), random.nextInt(height >> 1));
    }

    /**
     * 绘制点干扰线
     * @param graphics2D                绘笔对象
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceColor         干扰线颜色
     */
    public static void drawPoint(Graphics2D graphics2D,int width,int height, Color interferenceColor){
        graphics2D.setColor(interferenceColor);
        ThreadLocalRandom random = RandomUtil.getRandom();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        graphics2D.drawOval(x,y,random.nextInt(4),random.nextInt(4));
    }

    /**
     * 绘制方块干扰线
     * @param graphics2D                绘笔对象
     * @param width                     图片宽度
     * @param height                    图片高度
     * @param interferenceColor         干扰线颜色
     */
    public static void drawSquare(Graphics2D graphics2D,int width,int height, Color interferenceColor){
        graphics2D.setColor(interferenceColor);
        ThreadLocalRandom random = RandomUtil.getRandom();
        int x1 = random.nextInt(0, (int) (width * 0.1));
        int y1 = random.nextInt(0, (int) (height * 0.1));
        int x2 = random.nextInt((int) (width * 0.1), width);
        int y2 = random.nextInt((int) (height * 0.1), height);
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
}
