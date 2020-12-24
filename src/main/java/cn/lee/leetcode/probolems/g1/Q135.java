package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q135
 * @Description: https://leetcode-cn.com/problems/candy/
 * @author: libo
 * @date: 2020/12/24 13:58
 * @Version: 1.0
 */
@Slf4j
public class Q135 {

    @Test
    public void test1() {
        Assert.assertEquals(5, candy(new int[]{1, 0, 2}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, candy(new int[]{1, 2, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, candy(new int[]{3, 2, 1}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, candy(new int[]{2, 1}));
    }

    //爆破法
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] pos = new int[len];
        boolean ans = true;
        while (ans) {
            ans = false;
            for (int i = 0; i < len - 1; i++) {
//                if (ratings[i - 1] > ratings[i] && pos[i - 1] <= pos[i]) {
//                    pos[i - 1] = pos[i] + 1;
//                    ans = true;
//                }
//                if (ratings[i - 1] < ratings[i] && pos[i - 1] >= pos[i]) {
//                    pos[i] = pos[i - 1] + 1;
//                    ans = true;
//                }
                if (ratings[i + 1] > ratings[i] && pos[i + 1] <= pos[i]) {
                    pos[i + 1] = pos[i] + 1;
                    ans = true;
                }
                if (ratings[i + 1] < ratings[i] && pos[i + 1] >= pos[i]) {
                    pos[i] = pos[i + 1] + 1;
                    ans = true;
                }
            }
        }
        int sum = 0;
        for (int n : pos) {
            sum = sum + n + 1;
        }
        return sum;
    }

    // 贪心法
    public int candy2(int[] ratings) {

        return 0;
    }
}
