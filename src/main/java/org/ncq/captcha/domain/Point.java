package org.ncq.captcha.domain;

import java.io.Serializable;

/**
 * @author niuchangqing
 * x, y轴坐标
 */
public class Point implements Serializable {
    private static final long serialVersionUID = 6546517925794104394L;

    /**
     * x轴坐标
     */
    private int x;

    /**
     * y轴坐标
     */
    private int y;

    public Point(){}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
