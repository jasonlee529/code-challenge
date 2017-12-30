package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-bitwise-and/problem
 * <pre>
 *
 *     Objective
 * Welcome to the last day! Today, we're discussing bitwise operations. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given set . Find two integers,  and  (where ), from set  such that the value of  is the maximum possible and also less than a given integer, . In this case,  represents the bitwise AND operator.
 *
 * Input Format
 *
 * The first line contains an integer, , the number of test cases.
 * Each of the  subsequent lines defines a test case as  space-separated integers,  and , respectively.
 *
 * Constraints
 *
 * Output Format
 *
 * For each test case, print the maximum possible value of  on a new line.
 *
 * Sample Input
 *
 * 3
 * 5 2
 * 8 5
 * 2 2
 * Sample Output
 *
 * 1
 * 4
 * 0
 * Explanation
 *
 *
 *
 * All possible values of  and  are:
 *
 * The maximum possible value of  that is also  is , so we print  on a new line.
 * </pre>
 * Created by jason on 17-12-30.
 */
public class Day29_Bitwise_AND {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ns = new int[t];
        int[] ks = new int[t];
        for (int i = 0; i < t; i++) {
            ns[i] = sc.nextInt();
            ks[i] = sc.nextInt();
        }

        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            int k = ks[i];
            int r = 0;
            for (int j = 1; j < n; j++) {
                for (int l = j + 1; l <= n; l++) {
                    int x = j & l;
                    x = x < k ? x : 0;
                    r = r >= x ? r : x;
                }

            }
            System.out.println(r);
        }
    }
}
