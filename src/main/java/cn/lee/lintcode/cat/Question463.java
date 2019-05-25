package cn.lee.lintcode.cat;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/sort-integers/description?_from=cat
 */
public class Question463 {

    public void sortIntegers(int[] A) {
        // Write your code here
        System.out.println("  ");
        Arrays.sort(A);
        for (int a : A) {
            System.out.print("  " + a);
        }
    }

    public static void main(String[] args) {
        Question463 question = new Question463();
        question.sortIntegers(new int[]{3, 2, 1, 4, 5});
        question.sortIntegers(new int[]{1, 1, 2, 1, 1});
    }
}
