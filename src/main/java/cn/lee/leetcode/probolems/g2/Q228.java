package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q228
 * @Description: https://leetcode-cn.com/problems/summary-ranges/
 * @author: libo
 * @date: 2020/11/17 9:38
 * @Version: 1.0
 */
@Slf4j
public class Q228 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new String[]{"0->2", "4->5", "7"}, summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).toArray(new String[3]));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        int left = -1;
        int right = -1;
        for (int n : nums) {
            if (left == -1) {
                left = n;
                right = n;
            } else if (right + 1 == n) {
                right = n;
            } else {
                if (left == right) {
                    res.add(left + "");
                } else {
                    res.add(left + "->" + right);
                }
                left = n;
                right = n;
            }
        }
        if (left == right) {
            res.add(left + "");
        } else {
            res.add(left + "->" + right);
        }
        return res;
    }
}
