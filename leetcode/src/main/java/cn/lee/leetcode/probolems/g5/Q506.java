package cn.lee.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Title: Q506
 * @Description: https://leetcode-cn.com/problems/relative-ranks/
 * @author: libo
 * @date: 2020/9/28 14:51
 * @Version: 1.0
 */
@Slf4j
public class Q506 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q506().findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Q506().findRelativeRanks(new int[]{10, 3, 8, 9, 4, 9})));
    }

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        String[] res = new String[nums.length];
        TreeSet<Integer> set = new TreeSet();
        for (int n : nums) {
            set.add(n);
        }
        int len2 = set.size();
        for (int i = 0; i < len; i++) {
            int index = findIndex(nums[i], set);
            System.out.println(nums[i] + "  " + index);
            switch (len2-index) {
                case 1:
                    res[i] = "Gold Medal";
                    break;
                case 2:
                    res[i] = "Silver Medal";
                    break;
                case 3:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = (len - index) + "";
                    break;
            }
        }
        return res;
    }

    private int findIndex(int num, TreeSet<Integer> sorted) {
        int i = 0;
        for (Integer n : sorted) {
            if (n == num) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String[] findRelativeRanks2(int[] nums) {
        String[] res = new String[nums.length];
        int[] pos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pos[nums[i] - 1] = i;
        }
        int len = nums.length;
        for (int i = pos.length - 1; i >= 0; i--) {
            switch (len - i) {
                case 1:
                    res[pos[i]] = "Gold Medal";
                    break;
                case 2:
                    res[pos[i]] = "Silver Medal";
                    break;
                case 3:
                    res[pos[i]] = "Bronze Medal";
                    break;
                default:
                    res[pos[i]] = (len - i) + "";
                    break;
            }
        }
        return res;
    }
}
