package cn.lee.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q507
 * @Description: https://leetcode-cn.com/problems/perfect-number/
 * @author: libo
 * @date: 2020/9/27 13:45
 * @Version: 1.0
 */
@Slf4j
public class Q507 {

    public boolean checkPerfectNumber(int num) {
        int tmp = 0;
        for (int i = 1; i * 2 <= num; i++) {
            if (num % i == 0) {
                tmp += i;
            }
        }
        return num!=0 && tmp == num;
    }
}
