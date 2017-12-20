package cn.lee.hackerrank.tutorials.satistics10day;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-weighted-mean/problem
 * <pre>
 *     Objective
 * In the previous challenge, we calculated a mean. In this challenge, we practice calculating a weighted mean. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given an array, , of  integers and an array, , representing the respective weights of 's elements, calculate and print the weighted mean of 's elements. Your answer should be rounded to a scale of  decimal place (i.e.,  format).
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of elements in arrays  and .
 * The second line contains  space-separated integers describing the respective elements of array .
 * The third line contains  space-separated integers describing the respective elements of array .
 *
 * Constraints
 *
 * , where  is the  element of array .
 * , where  is the  element of array .
 * Output Format
 *
 * Print the weighted mean on a new line. Your answer should be rounded to a scale of  decimal place (i.e., format).
 *
 * Sample Input
 *
 * 5
 * 10 40 30 50 20
 * 1 2 3 4 5
 * Sample Output
 *
 * 32.0
 * Explanation
 *
 * We use the following formula to calculate the weighted mean:
 *
 * And then print our result to a scale of  decimal place () on a new line.
 *
 * </pre>
 * Created by jason on 17-12-20.
 */
public class Day00_WeightedMean {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        double sum = 0;
        double sumW = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * w[i];
            sumW += w[i];
        }
        System.out.println(String.format("%1.1f", sum / sumW));
    }
}
