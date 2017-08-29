
package com.CodeWar;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/6/2
 * Time:9:50
 */

public class DecodeResistorColors {
    //使用常量简化修改
    private static final int ONE_THOUSAND = 1000;
    private static final int ONE_MILLION = 1000000;
    //使用Map存储数据源
    private static final Map<String, Integer> colorCodes = new HashMap<String, Integer>();

    //静态块加载数据
    static {
        colorCodes.put("black", 0);
        colorCodes.put("brown", 1);
        colorCodes.put("red", 2);
        colorCodes.put("orange", 3);
        colorCodes.put("yellow", 4);
        colorCodes.put("green", 5);
        colorCodes.put("blue", 6);
        colorCodes.put("violet", 7);
        colorCodes.put("gray", 8);
        colorCodes.put("white", 9);
    }


/**
     * 解码颜色到数字
     *
     * @param bands
     * @return
 */

    public static String decodeResistorColors(String bands) {
        String[] stripes = bands.split(" ");
//数字部分获取
        int value = colorCodes.get(stripes[0]);
        value *= 10;
        value += colorCodes.get(stripes[1]);

        double ohms = value * Math.pow(10, colorCodes.get(stripes[2]));
//拼接结果
        StringBuilder builder = new StringBuilder();

        if (ohms >= ONE_MILLION) {
            double ohmsM = ohms / ONE_MILLION;
            builder.append(truncateZeros(ohmsM));
            builder.append('M');
        } else if (ohms >= ONE_THOUSAND) {
            double ohmsK = ohms / ONE_THOUSAND;
            builder.append(truncateZeros(ohmsK));
            builder.append('k');
        } else {
            builder.append(truncateZeros(ohms));
        }

        builder.append(" ohms, ");
//处理第四彩条
        if (stripes.length == 3) {
            builder.append("20%");
        } else if (stripes[3].equals("silver")) {
            builder.append("10%");
        } else {
            builder.append("5%");
        }

        return builder.toString();
    }


    /**
     * 使用强制转换规则处理小数点
     *
     * @param value
     * @return
     */

    private static String truncateZeros(double value) {
        int intValue = (int) value;

        if (value > intValue) {
            return String.valueOf(value);
        } else {
            return String.valueOf(intValue);
        }
    }
}

