package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q134
 * @Description: https://leetcode-cn.com/problems/gas-station/
 * @author: libo
 * @date: 2020/11/18 13:39
 * @Version: 1.0
 */
@Slf4j
public class Q134 {
    @Test
    public void test() {
        Assert.assertEquals(3, canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(-1, canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int start = i, cnt = 0;
            int g = 0;
            while (g >= 0 && cnt < len) {
                g += gas[start] - cost[start];
                start = (start + 1) % len;
                cnt++;
            }
            if (g >= 0 && cnt == len) {
                return i;
            }
        }
        return -1;
    }
}
