package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 * <pre>
 * Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is .
 *
 * Input Format
 *
 * The first line contains a single integer, , denoting the size of the array.
 * The second line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 * The answer will be .
 * Output Format
 *
 * A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is .
 *
 * Sample Input 0
 *
 * 6
 * 4 6 5 3 3 1
 * Sample Output 0
 *
 * 3
 * Explanation 0
 *
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e.,  and ), so we print the number of chosen integers, , as our answer.
 *
 * Sample Input 1
 *
 * 6
 * 1 2 2 3 1 2
 * Sample Output 1
 *
 * 5
 * Explanation 1
 *
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer.
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer.
 *
 * </pre>
 * Created by jason on 17-12-6.
 */
public class PickingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        pickNumbers(a);
    }

    private static void pickNumbers(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {

        }
    }

    private int maxMinus(int[] a) {
        int t = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                t = t > Math.abs(a[i] - a[j]) ? t : Math.abs(a[i] - a[j]);
            }
        }
        return t;
    }

}
