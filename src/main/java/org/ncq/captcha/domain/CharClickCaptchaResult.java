package org.ncq.captcha.domain;

import java.util.List;

/**
 * @author niuchangqing
 * 字符类型点选响应结果
 */
public class CharClickCaptchaResult extends ClickCaptchaResult {

    /**
     * 字符串的每个字符在图片中的位置信息
     */
    public List<CharPosition> charPositionList;

    public CharClickCaptchaResult() {
    }

    public CharClickCaptchaResult(String base64Str, String base64DataStr, byte[] bytes) {
        super(base64Str, base64DataStr, bytes);
    }

    /**
     * 每个字符的坐标信息和默认验证半径信息
     */
    public static class CharPosition extends Point {

        public CharPosition(){
        }

        public CharPosition(String charStr, double radius) {
            this.charStr = charStr;
            this.radius = radius;
        }

        public CharPosition(int x, int y, String charStr, double radius) {
            super(x, y);
            this.charStr = charStr;
            this.radius = radius;
        }

        /**
         * 字符
         */
        private String charStr;

        /**
         * 推荐校验半径
         */
        private double radius;

        public String getCharStr() {
            return charStr;
        }

        public double getRadius() {
            return radius;
        }

        public void setCharStr(String charStr) {
            this.charStr = charStr;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }

    public List<CharPosition> getCharPositionList() {
        return charPositionList;
    }

    public void setCharPositionList(List<CharPosition> charPositionList) {
        this.charPositionList = charPositionList;
    }
}
