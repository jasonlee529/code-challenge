package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * <pre>
 *     You are given an array of  integers, , and a positive integer, . Find and print the number of  pairs where  and  +  is divisible by .
 *
 * Input Format
 *
 * The first line contains  space-separated integers,  and , respectively.
 * The second line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the number of  pairs where  and  +  is evenly divisible by .
 *
 * Sample Input
 *
 * 6 3
 * 1 3 2 6 1 2
 * Sample Output
 *
 * 5
 * Explanation
 *
 * Here are the  valid pairs:
 *
 *
 * </pre>
 * Created by jason on 17-11-22.
 */
public class DivisibleSumPairs {
    static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}
