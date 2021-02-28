package org.ncq.captcha.click;

/**
 * @author niuchangqing
 * 点选图片切块
 */
class ClickBlock {
    /**
     * x轴坐标
     */
    private int x;

    /**
     * y轴坐标
     */
    private int y;

    /**
     * 块高
     */
    private int height;

    /**
     * 块长
     */
    private int width;


    public ClickBlock() {
    }

    public ClickBlock(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
