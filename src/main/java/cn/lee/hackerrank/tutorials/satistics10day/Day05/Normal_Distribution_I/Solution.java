package cn.lee.hackerrank.tutorials.satistics10day.Day05.Normal_Distribution_I;

import org.apache.commons.math3.special.Gamma;

/**
 * https://www.hackerrank.com/challenges/s10-normal-distribution-1/problem
 * <pre>
 *     Objective
 * In this challenge, we learn about normal distributions. Check out the Tutorial tab for learning materials!
 *
 * Task
 * In a certain plant, the time taken to assemble a car is a random variable, , having a normal distribution with a mean of  hours and a standard deviation of  hours. What is the probability that a car can be assembled at this plant in:
 *
 * Less than  hours?
 * Between  and  hours?
 * Input Format
 *
 * There are  lines of input (shown below):
 *
 * 20 2
 * 19.5
 * 20 22
 * The first line contains  space-separated values denoting the respective mean and standard deviation for . The second line contains the number associated with question . The third line contains  space-separated values describing the respective lower and upper range boundaries for question .
 *
 * If you do not wish to read this information from stdin, you can hard-code it into your program.
 *
 * Output Format
 *
 * There are two lines of output. Your answers must be rounded to a scale of  decimal places (i.e.,  format):
 *
 * On the first line, print the answer to question  (i.e., the probability that a car can be assembled in less than  hours).
 * On the second line, print the answer to question  (i.e., the probability that a car can be assembled in between  to  hours).
 * </pre>
 * Created by jason on 17-12-25.
 */
@SuppressWarnings("")
public class Solution {
    public static void main(String[] args) {
        double m = 20;
        double o = 2;
        System.out.println(String.format("%1.3f", normal(19.5, m, o)));
        System.out.println(String.format("%1.3f", normal(22, m, o) - normal(20, m, o)));

    }

    private static double normal(double x, double u, double o) {
        final double dev = x - u;
        if (Math.abs(dev) > 40 * o) {
            return dev < 0 ? 0.0d : 1.0d;
        }
        return 0.5 * erf(-dev / (o * Math.sqrt(2)));
    }

    private static double erf2(double x) {
        return 0.8025873486341526;
    }

    private static double erf(double x) {
        if (Math.abs(x) > 40) {
            return x > 0 ? 0 : 2;
        }
        final double ret = Gamma.regularizedGammaQ(0.5, x * x, 1.0e-15, 10000);
        return x < 0 ? 2 - ret : ret;
    }
}
