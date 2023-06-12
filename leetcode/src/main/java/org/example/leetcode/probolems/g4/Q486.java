package org.example.leetcode.probolems.g4;import lombok.extern.slf4j.Slf4j;

/**
    * @Title: Q486
    * @Description: https://leetcode-cn.com/problems/predict-the-winner/
    * @author libo
    * @date 2020/9/1 14:47
    * @Version 1.0
    */
@Slf4j
public class Q486 {
    public static void main(String[] args) {
        Q486 q = new Q486();
        System.out.println(q.PredictTheWinner(new int[]{0}));
        System.out.println(q.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }
}
