package org.ncq.captcha.utils;


import org.ncq.captcha.domain.CalculationResultDTO;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author niuchangqing
 * 指定字符串随机生成长度
 */
public class RandomUtil {
    /**
     * 随机获取数字的字符串
     */
    public static final String NUMBER = "0123456789";

    /**
     * 随机获取字母的字符串
     */
    public static final String LOWER_CHAR = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 随机获取大写字母的字符串
     */
    public static final String UPPER_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 随机获取大小写字母的字符串
     */
    public static final String LOWER_UPPER_CHAR = LOWER_CHAR + UPPER_CHAR;

    /**
     * 随机获取数字+小字母的字符串
     */
    public static final String NUMBER_LOWER_CHAR = NUMBER + LOWER_CHAR;

    /**
     * 随机获取数字+大写字母的字符串
     */
    public static final String NUMBER_UPPER_CHAR = NUMBER + UPPER_CHAR;

    /**
     * 随机获取数字+大小写字母的字符串
     */
    public static final String NUMBER_LOWER_UPPER_CHAR = NUMBER + LOWER_UPPER_CHAR;

    /**
     * 空字符串
     */
    private static final String STRING_EMPTY = "";

    /**
     * 随机生成指定长度的字符串,默认包含字母+数字
     * @param length    生成的字符串长度
     * @return          随机字符串
     */
    public static String randomString(int length){
        return randomString(length, NUMBER_LOWER_UPPER_CHAR);
    }

    /**
     * 随机生成指定长度字符串，字符串内容为取样字符串中的字符(randomStr)
     * @param length        生成字符串的内容
     * @param randomStr     随机字符串的取样字符串
     * @return              随机生成的字符串
     */
    public static String randomString(int length,String randomStr){
        if (randomStr == null || randomStr.length() <= 0 || length <= 0) {
            return STRING_EMPTY;
        }
        StringBuilder stringBuilder = new StringBuilder(length);
        int randomStrLength = randomStr.length();
        for (int i = 0; i < length; i++) {
            int randomInt = randomInt(randomStrLength);
            stringBuilder.append(randomStr.charAt(randomInt));
        }
        return stringBuilder.toString();
    }

    /**
     * 获取随机数字，范围[0,max]
     * 不包含max
     * @param max   随机数字范围，不包含max
     * @return      随机数
     */
    public static int randomInt(int max){
        return getRandom().nextInt(max);
    }

    /**
     * 获取随机数字,范围[min,max]
     * 包含min,但不包含max
     * @param min       随机范围起始值
     * @param max       随机范围截止值
     * @return          随机数值
     */
    public static int randomInt(int min, int max){
        return getRandom().nextInt(min,max);
    }

    /**
     * 获取随机对象
     * @return  随机对象
     */
    public static ThreadLocalRandom getRandom(){
        return ThreadLocalRandom.current();
    }

    /**
     * 获取随机boolean [true or false]
     * @return       随机boolean值
     */
    public static boolean randomBoolean(){
        return getRandom().nextBoolean();
    }

    /**
     * 随机指定范围的+、-、*运算
     * @param max           最大数字，不包含该数字
     * @return              随机+-*运算结果对象
     */
    public static CalculationResultDTO randomCalculation(int max){
        return randomCalculation(0,max);
    }

    /**
     * 随机获取+、-、*运算
     * 不包含除法
     * @param min       最小值
     * @param max       最大值，不包含该数字
     * @return          随机+-*运算结果对象
     */
    public static CalculationResultDTO randomCalculation(int min, int max){
        ThreadLocalRandom random = getRandom();
        int first = random.nextInt(min,max);
        //随机获取运算符号
        String calculationLabel = randomString(1,"+-x");
        int second = random.nextInt(min,max);

        StringBuilder calculationStr = new StringBuilder();
        calculationStr.append(first);
        calculationStr.append(" ");
        calculationStr.append(calculationLabel);
        calculationStr.append(" ");
        calculationStr.append(second);
        calculationStr.append(" =");
        calculationStr.append(" ?");

        int calculationResult = 0;
        switch (calculationLabel) {
            case "+":
                calculationResult = first + second;
                break;
            case "-":
                calculationResult = first - second;
                break;
            case "x":
                calculationResult = first * second;
                break;
            default:
                throw new RuntimeException("calculationLabel not support");
        }
        CalculationResultDTO result = new CalculationResultDTO(calculationStr.toString(),first,second,calculationLabel,calculationResult);
        return result;
    }
}
