package org.ncq.captcha.domain;

import java.io.Serializable;

/**
 * @author niuchangqing
 * 随机生成运算字符串结果
 */
public class CalculationResultDTO implements Serializable {

    private static final long serialVersionUID = -3918308711448484716L;
    /**
     * 运算字符串
     * 如：1 + 3 = ？
     */
    public String calculationString;

    /**
     * 第一个数字
     */
    public int firstNumber;

    /**
     * 第二个数字
     */
    public int secondNumber;

    /**
     * 运算符号
     */
    public String calculationLabel;

    /**
     * 运算结果
     */
    public int result;

    public CalculationResultDTO() {
    }

    public CalculationResultDTO(String calculationString, int firstNumber, int secondNumber, String calculationLabel, int result) {
        this.calculationString = calculationString;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.calculationLabel = calculationLabel;
        this.result = result;
    }

    public String getCalculationString() {
        return calculationString;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getCalculationLabel() {
        return calculationLabel;
    }

    public int getResult() {
        return result;
    }

    public void setCalculationString(String calculationString) {
        this.calculationString = calculationString;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setCalculationLabel(String calculationLabel) {
        this.calculationLabel = calculationLabel;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
