package cn.lee.leetcode.probolems.g9;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q977
 * @Description: https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author: libo
 * @date: 2020/10/16 13:47
 * @Version: 1.0
 */
@Slf4j
public class Q977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q977().sortedSquares(new int[]{1,0,-1})));
    }
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
