package org.example.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Title: Q349
 * @Description: https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author: libo
 * @date: 2020/10/10 14:24
 * @Version: 1.0
 */
@Slf4j
public class Q349 {
    /**
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *  
     * <p>
     * 说明：
     * <p>
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q349().intersection(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}
