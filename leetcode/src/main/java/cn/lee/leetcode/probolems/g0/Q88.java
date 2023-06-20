package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q88
 * @Description: https://leetcode-cn.com/problems/merge-sorted-array/
 * @author: libo
 * @date: 2020/9/9 13:50
 * @Version: 1.0
 */
@Slf4j
public class Q88 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q88().merge(new int[]{}, 3, new int[]{}, 2)));
    }

    /**
     * 复制排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        for (int i = 0; i < m + n; i++) {
            for (int j = i + 1; j < m + n; j++) {
                if (nums1[i] > nums1[j]) {
                    int t = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = t;
                }
            }
        }
        return nums1;
    }

    /**
     * 尾插
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        return null;
    }
}
