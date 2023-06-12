package org.example.leetcode.probolems.g6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q621
 * @Description: https://leetcode-cn.com/problems/task-scheduler/
 * @author: libo
 * @date: 2020/12/5 13:53
 * @Version: 1.0
 */
@Slf4j
public class Q621 {
    @Test
    public void test() {
        Assert.assertEquals(8, leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A'] += 1;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        int maxCount = 0;
        for (int count : counts) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }
}
