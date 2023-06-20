package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q167
 * @Description: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author: libo
 * @date: 2020/9/15 22:48
 * @Version: 1.0
 */
@Slf4j
public class Q167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] pos = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    pos[0] = i+1;
                    pos[1] = j+1;
                    break;
                }
            }
        }
        return pos;
    }
}
