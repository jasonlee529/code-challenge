package cn.lee.hackerrank.tutorials.satistics10day.Day04.Binomial_Distribution_I;

/**
 * https://www.hackerrank.com/challenges/s10-binomial-distribution-1/problem
 * <pre>
 * Objective
 * In this challenge, we learn about binomial distributions. Check out the Tutorial tab for learning materials!
 *
 * Task
 * The ratio of boys to girls for babies born in Russia is . If there is  child born per birth, what proportion of Russian families with exactly  children will have at least  boys?
 *
 * Write a program to compute the answer using the above parameters. Then print your result, rounded to a scale of  decimal places (i.e.,  format).
 *
 * Input Format
 *
 * A single line containing the following values:
 *
 * 1.09 1
 * If you do not wish to read this information from stdin, you can hard-code it into your program.
 *
 * Output Format
 *
 * Print a single line denoting the answer, rounded to a scale of  decimal places (i.e.,  format).
 * </pre>
 * Created by jason on 17-12-23.
 */
public class Solution {
    private static final int N = 6;

    private static final double BOY = 1.09;
    private static final double GIRL = 1;


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double ratio = sc.nextDouble();
//        int per = sc.nextInt();

        double b0 = ratioBoy(N, 0);
        double b1 = ratioBoy(N, 1);
        double b2 = ratioBoy(N, 2);
        double r = 1 - b0 - b1 - b2;
        System.out.println(String.format("%1.3f", r));
    }

    private static double ratioBoy(int n, int i) {
        long c = combination(n, i);
        double t = Math.pow(BOY, i) * Math.pow(GIRL, n - i) * c;
        double d = Math.pow(BOY + GIRL, n);
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
