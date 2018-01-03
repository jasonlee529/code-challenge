package cn.lee.hackerrank.hour25.The_Strange_Function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
        long max = Long.MIN_VALUE;
        for (int l = 0; l < a.length; l++) {
            for (int r = l; r < a.length; r++) {
                long m = getMax(a, l, r);
                max = max > m ? max : m;
            }
        }
        return max;
    }

    private static long getMax(int[] a, int l, int r) {
        long t0 = System.currentTimeMillis();
        int[] tmp = new int[r - l + 1];
        System.arraycopy(a, l, tmp, 0, r - l + 1);
        long t1 = System.currentTimeMillis();
        long g = gcd(tmp);
        long t2 = System.currentTimeMillis();
        long sum = sum(tmp);
        long t3 = System.currentTimeMillis();
        long m = max(tmp);
        long t4 = System.currentTimeMillis();
        long t = g * (sum - m);
        long t5 = System.currentTimeMillis();
        System.out.println(String.format("%d,%d,%d,%d,%d,%d,%d,%d", t5 - t0, t5 - t4, t4 - t3, t3 - t2, t2 - t1, t1 - t0, l, r));
        return t;
    }

    static int max(int[] a) {
        int max = a[0];
        for (int i : a) {
            max = max > i ? max : i;
        }
        return max;
    }

    static long sum(int[] a) {
        long result = 0;
        for (int i : a) {
            result += i;
        }
        return result;
    }

    static int gcd(int[] a) {
        a = Arrays.stream(a).distinct().toArray();
        int g = a[0];
        for (int i = 1; i < a.length; i++) {
            g = gcd(g, a[i]);
        }
        return a[0];
    }

    static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (y != 0) {
            int t = y;
            x = y;
            y = t % y;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        int[] b = new int[]{1, 2, 1, 2};
        b = Arrays.stream(b).distinct().toArray();
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
        System.out.println(getMax(a, 0, 7985));
        System.out.println(maximumValue(a));
        System.out.println(maximumValue(new int[]{753000, 121000, 616000, -266000, -379000, 65000, 530000, 242000, 809000, 599000, 113000, -407000}));
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