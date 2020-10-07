package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q263
 * @Description: https://leetcode-cn.com/problems/ugly-number/
 * @author: libo
 * @date: 2020/9/25 9:51
 * @Version: 1.0
 */
@Slf4j
public class Q263 {
    public boolean isUgly(int num) {
        if(num==1 || num==0){
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}
