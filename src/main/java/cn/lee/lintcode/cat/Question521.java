package cn.lee.lintcode.cat;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description?_from=cat
 */
public class Question521 {

    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        print(nums);
        return index + 1;
    }

    private void print(int[] nums) {
        for (int n : nums) {
            System.out.print("  " + n);
        }
        System.out.println("");
    }

    private void move(int[] nums, int i) {
        int t = nums[i];
        for (int j = i; j < nums.length - 1; j++) {
            nums[j] = nums[j + 1];
        }
        nums[nums.length - 1] = t;
    }

    public static void main(String[] args) {
        Question521 question = new Question521();
        System.out.println(question.deduplication(new int[]{1, 3, 1, 4, 4, 2}));
    }
}
