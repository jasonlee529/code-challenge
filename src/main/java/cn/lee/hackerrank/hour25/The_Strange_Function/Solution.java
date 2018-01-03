package cn.lee.hackerrank.hour25.The_Strange_Function;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
            for (int r = 0; r < a.length; r++) {
                int[] tmp = new int[r - l + 1];
                System.arraycopy(a, l, tmp, 0, r - l);
                Arrays.sort(tmp);
                long t = gcd(tmp) * (sum(tmp) - max(tmp));
                max = max > t ? max : t;
            }
        }
        return max;
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
        int g = a[0];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < a.length - 1; i++) {
            s.add(gcd(a[i], a[i + i]));
        }
        if (s.size() == 0) {
            g = a[0];
        } else if (s.size() == 1) {
            g = s.iterator().next();
        } else {
            return gcd(s.stream().mapToInt(Integer::intValue).toArray());
        }
        return g;
    }

    static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == 0) {
            return y;
        } else if (y % x == 0) {
            return x;
        } else {
            int t = y % x;
            y = x;
            x = t;
            return gcd(x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumValue(new int[]{670, 727, 143, -996, 772}));
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
