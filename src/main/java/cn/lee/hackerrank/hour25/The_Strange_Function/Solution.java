package cn.lee.hackerrank.hour25.The_Strange_Function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-25/challenges/the-strange-function
 * <p>
 * One of the most important skills a programmer needs to learn early on is the ability to pose a problem in an abstract way. This skill is important not just for researchers but also in applied fields like software engineering and web development.
 * <p>
 * You are able to solve most of a problem, except for one last subproblem, which you have posed in an abstract way as follows: Given an array consisting of  integers , define
 * <p>
 * For example, for an input array [ 10, -5, 5, 20 ], a subsegment  would be computed as follows:
 * <p>
 * image
 * What is , i.e., the maximum value of  among all subsegments ?
 * <p>
 * Complete the function maximumValue which takes an integer array as input and returns the maximum value of  among all subsegments .
 * <p>
 * Note that:
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer .
 * <p>
 * The second line contains  space-separated integers , , ..., .
 * <p>
 * Constraints
 * <p>
 * Subtasks
 * <p>
 * For 15% of the total score:
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the answer.
 * <p>
 * Sample Input 0
 * <p>
 * 4
 * 10 -5 5 20
 * Sample Output 0
 * <p>
 * 50
 * Explanation 0
 * <p>
 * The maximum value occurs at  as shown below.
 * <p>
 * image
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * 7 12 24 6 5
 * Sample Output 1
 * <p>
 * 144
 * Explanation 1
 * <p>
 * The maximum value occurs at .
 * Created by jason on 18-1-3.
 */
public class Solution {


    static long maximumValue(int[] a) {
        // Return the maximum value of f among all subsegments [l..r].
        long max = 0;
        int g = 0;
        long m = 0;
        long sum = 0;
        for (int l = 0; l < a.length - 1; l++) {
            long t0 = System.currentTimeMillis();
            g = a[l];
            m = a[l];
            sum = a[l];
            for (int r = l + 1; r < a.length; r++) {
                g = gcd(g, a[r]);
                sum += a[r];
                m = Math.max(m, a[r]);
                long t = g * (sum - m);
                max = Math.max(t, max);
                long t5 = System.currentTimeMillis();
                System.out.println(String.format("%d,%d,%d", t5 - t0, l, r));
            }
        }
        return max;
    }

    static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int a = Math.min(x, y);
        int b = Math.max(x, y);
        while (a != 0) {
            int t = a;
            a = b % a;
            b = t;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        URL r = Solution.class.getResource("12.txt");
        BufferedReader reader = new BufferedReader(new FileReader(r.getPath()));
        String len = reader.readLine();
        int[] a = new int[Integer.parseInt(len)];
        String data = reader.readLine();
        int i = 0;
        for (String s : data.split(" ")) {
            a[i] = Integer.parseInt(s);
            i++;
        }
        System.out.println(maximumValue(new int[]{10, -5, 5, 20}));
        System.out.println(maximumValue(new int[]{7, 12, 24, 6, 5}));
        System.out.println(maximumValue(a));
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] a = new int[n];
//        for (int a_i = 0; a_i < n; a_i++) {
//            a[a_i] = in.nextInt();
//        }
//        long result = maximumValue(a);
//        System.out.println(result);
        in.close();
    }
}
