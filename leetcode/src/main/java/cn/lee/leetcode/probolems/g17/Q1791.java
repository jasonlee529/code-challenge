package cn.lee.leetcode.probolems.g17;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Q1791
 * @Description: https://leetcode-cn.com/problems/find-center-of-star-graph/
 * @author: libo
 * @date: 2022/2/18 0018 6:49
 * @Version: 1.0
 */
@Slf4j
public class Q1791 {
    public int findCenter(int[][] edges) {
        List<Integer> a = new ArrayList<>();
        a.add(edges[0][0]);
        a.add(edges[0][1]);
        for (int[] n : edges) {
            List<Integer> b = new ArrayList<>();
            b.add(n[0]);
            b.add(n[1]);
            a.retainAll(b);
        }
        return a.get(0);
    }

    @Test
    public void test_1() {
        Assert.assertEquals(2, findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(1, findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }
}