package org.example.leetcode.probolems.g16;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Title: Q1606
 * @Description: https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 * @author: libo
 * @date: 2022/3/30 0030 18:45
 * @Version: 1.0
 */
@Slf4j
public class Q1606 {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        return null;
    }

    @Test
    public void test_1() {
        Assert.assertArrayEquals( new Integer[]{1}, busiestServers(3,new int[]{1,2,3,4,5},new int[]{5,2,3,3,3}).toArray());
    }
    @Test
    public void test_2() {
        Assert.assertArrayEquals( new Integer[]{0}, busiestServers(3,new int[]{1,2,3,4},new int[]{1,2,1,2}).toArray());
    }
    @Test
    public void test_3() {
        Assert.assertArrayEquals( new Integer[]{0,1,2}, busiestServers(3,new int[]{1,2,3},new int[]{10,12,11}).toArray());
    }
    @Test
    public void test_4() {
        Assert.assertArrayEquals( new Integer[]{1}, busiestServers(3,new int[]{1,2,3,4,8,9,10},new int[]{5,2,10,3,1,2,2}).toArray());
    }
    @Test
    public void test_5() {
        Assert.assertArrayEquals( new Integer[]{0}, busiestServers(1,new int[]{1},new int[]{1}).toArray());
    }

}