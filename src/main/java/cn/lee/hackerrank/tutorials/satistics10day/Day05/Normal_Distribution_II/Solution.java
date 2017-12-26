package cn.lee.hackerrank.tutorials.satistics10day.Day05.Normal_Distribution_II;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * https://www.hackerrank.com/challenges/s10-normal-distribution-2/problem
 * <pre>
 *     Objective
 * In this challenge, we go further with normal distributions. We recommend reviewing the previous challenge's Tutorial before attempting this problem.
 *
 * Task
 * The final grades for a Physics exam taken by a large group of students have a mean of  and a standard deviation of . If we can approximate the distribution of these grades by a normal distribution, what percentage of the students:
 *
 * Scored higher than  (i.e., have a )?
 * Passed the test (i.e., have a )?
 * Failed the test (i.e., have a )?
 * Find and print the answer to each question on a new line, rounded to a scale of  decimal places.
 *
 * Input Format
 *
 * There are  lines of input (shown below):
 *
 * 70 10
 * 80
 * 60
 * The first line contains  space-separated values denoting the respective mean and standard deviation for the exam. The second line contains the number associated with question . The third line contains the pass/fail threshold number associated with questions  and .
 *
 * If you do not wish to read this information from stdin, you can hard-code it into your program.
 *
 * Output Format
 *
 * There are three lines of output. Your answers must be rounded to a scale of  decimal places (i.e.,  format):
 *
 * On the first line, print the answer to question  (i.e., the percentage of students having ).
 * On the second line, print the answer to question  (i.e., the percentage of students having ).
 * On the third line, print the answer to question  (i.e., the percentage of students having ).
 * </pre>
 * Created by jason on 17-12-25.
 */
@SuppressWarnings("")
public class Solution {
    public static void main(String[] args) {
        double m = 70;
        double o = 10;
        NormalDistribution nd = new NormalDistribution(m, o);
        System.out.println(String.format("%1.2f", nd.probability(80,Double.MAX_VALUE)*100));
        System.out.println(String.format("%1.2f", nd.probability(60,Double.MAX_VALUE)*100));
        System.out.println(String.format("%1.2f", nd.probability(Double.MIN_VALUE,60)*100));

    }
}
