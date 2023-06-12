package org.example.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Title: Q973
 * @Description: https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @author: libo
 * @date: 2020/11/9 17:30
 * @Version: 1.0
 */
@Slf4j
public class Q973 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{{-2, 2}}, kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        Assert.assertArrayEquals(new int[][]{ {3, 3},{-2, 4}}, kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int t1 = o1[0] * o1[0] + o1[1] * o1[1];
                int t2 = o2[0] * o2[0] + o2[1] * o2[1];
                return t1 - t2;
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }
}
