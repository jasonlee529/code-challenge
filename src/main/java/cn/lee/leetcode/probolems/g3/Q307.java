package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Title: Q307
 * @Description: https://leetcode-cn.com/problems/range-sum-query-mutable/
 * @author: libo
 * @date: 2022/4/4 0004 17:23
 * @Version: 1.0
 */
@Slf4j
public class Q307 {
    class NumArray {
        private int[] tree;
        private int[] nums;

        public NumArray(int[] nums) {
            this.tree = new int[nums.length + 1];
            this.nums = nums;
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return prefixSum(right + 1) - prefixSum(left);
        }

        private int lowBit(int x) {
            return x & -x;
        }

        private void add(int index, int val) {
            while (index < tree.length) {
                tree[index] += val;
                index += lowBit(index);
            }
        }

        private int prefixSum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= lowBit(index);
            }
            return sum;
        }

    }

    @Test
    public void test_1() {
        NumArray num = new NumArray(new int[]{1, 3, 5});
        Assert.assertEquals(9, num.sumRange(0, 2));
        num.update(1, 2);
        Assert.assertEquals(8, num.sumRange(0, 2));
    }
}