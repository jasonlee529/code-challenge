package cn.lee.leetcode.weekly.w221;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: Q5638
 * @Description: https://leetcode-cn.com/contest/weekly-contest-221/problems/maximum-number-of-eaten-apples/
 * @author: libo
 * @date: 2020/12/27 10:52
 * @Version: 1.0
 */
@Slf4j
public class Q5638 {
    @Test
    public void test1() {
        Assert.assertEquals(7, eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
    }

    public int eatenApples(int[] apples, int[] days) {
        Deque<int[]> queue = new LinkedList<>();
        int cnt = 0;
        int d = 0;
        do {
            int i = d;
            if (d < apples.length) {
                int c = apples[i];
                queue.offerLast(new int[]{c, i + days[i]});
            }
            boolean canEat = false;
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                if (tmp[1] > i) {
                    canEat = true;
                    tmp[0] = tmp[0] - 1;
                    if (tmp[0] > 0) {
                        queue.offerFirst(tmp);
                    }
                    break;
                }
            }
            if (canEat) {
                cnt++;
            }
            d++;
        } while (d < apples.length || !queue.isEmpty());
        return cnt;
    }

    public int eatenApples2(int[] apples, int[] days) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        int d = 0;
        do {
            int i = d;
            if (d < apples.length) {
                int c = apples[i];
                while (c > 0) {
                    queue.add(i + days[i]);
                    c--;
                }
            }
            boolean canEat = false;
            while (!queue.isEmpty()) {
                if (queue.poll() > i) {
                    canEat = true;
                    break;
                }
            }
            if (canEat) {
                cnt++;
            }
            d++;
        } while (d < apples.length || !queue.isEmpty());
        return cnt;
    }
}
