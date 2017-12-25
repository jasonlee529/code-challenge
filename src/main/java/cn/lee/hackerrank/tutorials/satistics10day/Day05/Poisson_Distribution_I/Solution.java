package cn.lee.hackerrank.tutorials.satistics10day.Day05.Poisson_Distribution_I;

/**
 * https://www.hackerrank.com/challenges/s10-poisson-distribution-1/problem
 * <pre>
 *     Objective
 * In this challenge, we learn about Poisson distributions. Check out the Tutorial tab for learning materials!
 *
 * Task
 * A random variable, , follows Poisson distribution with mean of . Find the probability with which the random variable  is equal to .
 *
 * Input Format
 *
 * The first line contains 's mean. The second line contains the value we want the probability for:
 *
 * 2.5
 * 5
 * If you do not wish to read this information from stdin, you can hard-code it into your program.
 *
 * Output Format
 *
 * Print a single line denoting the answer, rounded to a scale of  decimal places (i.e.,  format).
 * </pre>
 * Created by jason on 17-12-25.
 */
public class Solution {
    public static void main(String[] args) {
        int k = 5;
        double y = 2.5;
        double d = Math.pow(y, k) * Math.pow(Math.E, -y);
        double t = mux(k);
        System.out.println(String.format("%1.3f", d / t));
    }

    private static long mux(int n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
