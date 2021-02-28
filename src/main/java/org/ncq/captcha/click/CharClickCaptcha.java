package org.ncq.captcha.click;

import org.ncq.captcha.domain.CharClickCaptchaResult;
import org.ncq.captcha.domain.ClickCaptchaResult;
import org.ncq.captcha.domain.Point;
import org.ncq.captcha.utils.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niuchangqing
 * 字符点选验证码
 */
public class CharClickCaptcha extends AbstractClickCaptcha <CharClickCaptchaResult> {
    public CharClickCaptcha(Font font, Color fontColor) {
        super(font, fontColor);
    }

    @Override
    public CharClickCaptchaResult getClickImage(String code, byte[] background) {
        //随机打乱code
        BufferedImage bufferedImage = background == null ? ImageUtil.read(ClickCaptchaUtil.class.getResourceAsStream("/image/bg.jpg")) : ImageUtil.read(background);
        String str = RandomUtil.randomRearrange(code.length(), code);
        Graphics2D graphics = GraphicsUtil.createGraphics(bufferedImage, null);
        //每个字符在图片中的位置信息
        List<CharClickCaptchaResult.CharPosition> list = new ArrayList<>();
        BigDecimal two = new BigDecimal(2);

        //设置字体
        graphics.setFont(this.font);
        //设置字体颜色
        graphics.setColor(this.fontColor);
        //该字体占用的行高度
        int fontHeight = GraphicsUtil.getFontHeight(graphics, font);
        //字体大小
        int fontSize = this.font.getSize();
        //字体大小一半的值
        BigDecimal halfFontSize = new BigDecimal(fontSize).divide(two,4,BigDecimal.ROUND_UP);

        //分块
        List<ClickBlock> blockList = new ArrayList<>();
        if ((bufferedImage.getHeight() - 10) / fontHeight > 2) {
            //分俩行
            int rowH = bufferedImage.getHeight() / 2;
            int c = 0;//计算需要多少列
            if (str.length() % 2 > 0) {
                c = str.length() / 2 + 1;
            }else {
                c = str.length() / 2;
            }
            int column = bufferedImage.getWidth() / c;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < c; j++) {
                    ClickBlock block = new ClickBlock();
                    block.setHeight(rowH);
                    block.setWidth(column);
                    block.setX(j * column);
                    if (i == 0){
                        //第一行
                        block.setY(rowH);
                    }else {
                        //第二行
                        block.setY(rowH * 2);
                    }
                    blockList.add(block);
                }
            }
        }else {
            //分一行
            //每列长度
            int column =  bufferedImage.getWidth() / str.length();
            for (int i = 0; i < str.length(); i++) {
                ClickBlock block = new ClickBlock();
                block.setHeight(bufferedImage.getHeight());
                block.setWidth(column);
                block.setX(i * column);
                block.setY(block.getHeight());
                blockList.add(block);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            int r = RandomUtil.randomInt(0, blockList.size());
            ClickBlock block = blockList.get(r);
            Point point = GraphicsUtil.randomStrPosition(graphics, s, this.font, block.getWidth(), block.getHeight());

            //获得该字体的最大半径长度
//            double radius = Math.sqrt(Math.pow(halfFontSize.doubleValue(), 2) + Math.pow(halfFontSize.doubleValue(), 2));
            double radius = halfFontSize.doubleValue();
            int x = block.getX() + point.getX();
            int y = block.getY() - (block.getHeight() - point.getY());
            CharClickCaptchaResult.CharPosition charPosition = new CharClickCaptchaResult.CharPosition();
            graphics.drawString(s, x, y);
            charPosition.setRadius(radius);
            charPosition.setCharStr(s);
            charPosition.setX(x + halfFontSize.intValue());
            charPosition.setY(y - halfFontSize.setScale(0,BigDecimal.ROUND_UP).intValue());
            list.add(charPosition);
            blockList.remove(r);
        }
        ClickCaptchaResult imageInfo = result(bufferedImage, ImageUtil.PNG);

        CharClickCaptchaResult result = new CharClickCaptchaResult(imageInfo.getBase64(),imageInfo.getBase64Data(), imageInfo.getBytes());
        result.setCharPositionList(list);
        return result;
    }
    //写入的文字随机进行旋转
//    AffineTransform at = new AffineTransform();
//    double k = Math.toRadians(RandomUtil.randomInt(-60,60));
//                at.setToRotation(k,x,y);
//                graphics.setTransform(at);
//    //随机旋转过的校验位置需要计算出来
//    double x1 = ((x + halfFontSize.doubleValue()) - x) * Math.cos(k) + ((y - halfFontSize.doubleValue()) - y) * Math.sin(k) + x;
//    double y1 = - ((x + halfFontSize.doubleValue()) - x) * Math.sin(k) + ((y - halfFontSize.doubleValue()) - y) * Math.cos(k) + y;
//                charPosition.setX(new BigDecimal(x1).intValue());
//                charPosition.setY(new BigDecimal(y1).intValue());
}
