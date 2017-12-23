package cn.lee.hackerrank.tutorials.satistics10day.Day04.Binomial_Distribution_II;

/**
 * https://www.hackerrank.com/challenges/s10-binomial-distribution-2/problem
 * <pre>
 *
 *     Objective
 * In this challenge, we go further with binomial distributions. We recommend reviewing the previous challenge's Tutorial before attempting this problem.
 *
 * Task
 * A manufacturer of metal pistons finds that, on average,  of the pistons they manufacture are rejected because they are incorrectly sized. What is the probability that a batch of  pistons will contain:
 *
 * No more than  rejects?
 * At least  rejects?
 * Input Format
 *
 * A single line containing the following values (denoting the respective percentage of defective pistons and the size of the current batch of pistons):
 *
 * 12 10
 * If you do not wish to read this information from stdin, you can hard-code it into your program.
 *
 * Output Format
 *
 * Print the answer to each question on its own line:
 *
 * The first line should contain the probability that a batch of  pistons will contain no more than  rejects.
 * The second line should contain the probability that a batch of  pistons will contain at least  rejects.
 * Round both of your answers to a scale of  decimal places (i.e.,  format).
 * </pre>
 * Created by jason on 17-12-23.
 */
public class Solution {
    private static final int N = 10;

    public static void main(String[] args) {
        double b0 = ratioP(N, 0, 0.12);
        double b1 = ratioP(N, 1, 0.12);
        double b2 = ratioP(N, 2, 0.12);
        double r = 1 - b0 - b1 - b2;
        System.out.println(String.format("%1.3f", 1 - r));
        System.out.println(String.format("%1.3f", 1 - b0 - b1));
    }

    private static double ratioP(int n, int i, double p) {
        long c = combination(n, i);
        double t = Math.pow(p, i) * Math.pow(1 - p, n - i) * c;
        double d = Math.pow(1, n);
        return t / d;
    }


    private static long combination(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }
        if (m == 1) {
            return n;
        }
        return mux(n) / (mux(n - m) * mux(m));
    }

    private static long mux(int n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
