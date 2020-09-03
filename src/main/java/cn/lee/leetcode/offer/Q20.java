package cn.lee.leetcode.offer;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @Title: Q20
 * @Description: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @author: libo
 * @date: 2020/9/3 11:43
 * @Version: 1.0
 */
@Slf4j
public class Q20 {
    public static void main(String[] args) {
        Q20 q = new Q20();
//        System.out.println(q.isNumber("+100"));
//        System.out.println(q.isNumber("12e5"));
        System.out.println(q.isNumber("12e5e5"));
        q = new Q20();
        System.out.println(q.isNumber("12e"));
        q = new Q20();
        System.out.println(q.isNumber(".1"));
        q = new Q20();
        System.out.println(q.isNumber("."));
    }
    private int index = 0;//全局索引
    private boolean scanUnsignedInteger(String str) {
        //是否包含无符号数
        int before = index;
        while(str.charAt(index) >= '0' && str.charAt(index) <= '9')
            index++;
        return index > before;
    }
    private boolean scanInteger(String str) {
        //是否包含有符号数
        if(str.charAt(index) == '+' || str.charAt(index) == '-')
            index++;
        return scanUnsignedInteger(str);
    }
    public boolean isNumber(String s) {
        //空字符串
        if(s == null || s.length() == 0)
            return false;
        //添加结束标志
        s = s + '|';
        //跳过首部的空格
        while(s.charAt(index) == ' ')
            index++;
        boolean numeric = scanInteger(s); //是否包含整数部分
        if(s.charAt(index) == '.') {
            index++;
            //有小数点，处理小数部分
            //小数点两边只要有一边有数字就可以，所以用||，
            //注意scanUnsignedInteger要在前面，否则不会进
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if((s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            //指数部分
            //e或E的两边都要有数字，所以用&&
            numeric = numeric && scanInteger(s);
        }
        //跳过尾部空格
        while(s.charAt(index) == ' ')
            index++;
        return numeric && s.charAt(index) == '|' ;
    }

    /**
     * 空格,trim去除
     * 符号位，可有可无，在指数出现之前，不能再有符号位出现
     * 整数或小数点
     * 指数e
     * 指数部分
     * 小数：小数点只能有一个
     * 指数：e只有1个，且e后面不能是小数
     *
     * @param s
     * @return
     */
    public boolean isNumber3(String s) {
        s = s.trim();
        boolean isNum = true;
        boolean isInt = true;
        boolean isDot = true;
        boolean isE = false;
        boolean signed = true;
        boolean end = false;
        int e=0;
        for (char c : s.toCharArray()) {
            if (!isNum) {
                break;
            }
            switch (c) {
                case '+':
                case '-':
                    isNum = isNum && signed;
                    signed = false;
                    end=false;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    isNum = isNum && isInt;
                    isE = e<1;
                    signed=false;
                    end=true;
                    break;
                case '.':
                    isNum = isNum && isDot;
                    isDot=false;
                    isInt=true;
                    isE=false;
                    end=true;
                    break;
                case 'e':
                case 'E':
                    isNum = isNum && isE;
                    isE=false;
                    e++;
                    isInt=true;
                    signed=true;
                    end=false;
                    break;
                default:
                    isNum = false;
                    break;

            }
            System.out.println(String.format("%s,%b",c,isNum));
        }
        return isNum&&end;
    }

    private boolean isInt(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSigned(char c) {
        return c == '+' || c == '-';
    }

    public boolean isNumber9(String s) {
        boolean is = true;
        try {
            new BigDecimal(s);
        } catch (Exception e) {
            is = false;
        }
        return is;
    }
}
