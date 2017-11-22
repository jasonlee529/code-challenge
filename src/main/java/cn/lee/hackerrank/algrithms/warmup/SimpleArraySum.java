package cn.lee.hackerrank.algrithms.warmup;

import java.util.Scanner;

/**
 * <pre>
 *     Given an array of N integers, can you find the sum of its elements?
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the size of the array.
 * The second line contains  space-separated integers representing the array's elements.
 *
 * Output Format
 *
 * Print the sum of the array's elements as a single integer.
 *
 * Sample Input
 *
 * 6
 * 1 2 3 4 10 11
 * Sample Output
 *
 * 31
 * Explanation
 *
 * We print the sum of the array's elements, which is: .
 *
 *
 * </pre>
 * Created by jason on 17-11-22.
 */
public class SimpleArraySum {
    static int simpleArraySum(int n, int[] ar) {
        // Complete this function
        int result = 0;
        for (int t : ar) {
            result += t;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
    }
}
