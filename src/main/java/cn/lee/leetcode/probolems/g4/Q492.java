package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q492
 * @Description: https://leetcode-cn.com/problems/construct-the-rectangle/
 * @author: libo
 * @date: 2020/10/9 23:46
 * @Version: 1.0
 */
@Slf4j
public class Q492 {
    public int[] constructRectangle(int area) {
        int[] a = new int[2];
        int low = (int) Math.ceil(Math.sqrt(area));
        while (low <=area) {
            if (area % low == 0) {
                a[0] = low;
                a[1] = area / low;
                break;
            }
            low++;
        }
        return a;
    }
}
