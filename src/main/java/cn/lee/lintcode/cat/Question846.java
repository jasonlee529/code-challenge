package cn.lee.lintcode.cat;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Question846 {

    public int[][] multiSort(int[][] array) {
        // Write your code here
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        for (int[] a : array) {
            System.out.println(a[0] + "____" + a[1]);
        }
        return array;
    }

    public static void main(String[] args) {
        Question846 question = new Question846();
        int[][] num1 = {{2, 50}, {1, 50}, {3, 100}};
        int[][] num2 = {{2, 50}, {1, 50}, {3, 50}};
        System.out.println(question.multiSort(num1));
        System.out.println(question.multiSort(num2));
    }
}
