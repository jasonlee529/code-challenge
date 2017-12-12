package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-2d-arrays/problem
 * <pre>
 *
 *     Objective
 * Today, we're building on our knowledge of Arrays by adding another dimension. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Context
 * Given a  2D Array, :
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:
 *
 * a b c
 * d
 * e f g
 * There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values.
 *
 * Task
 * Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
 *
 * Input Format
 *
 * There are  lines of input, where each line contains  space-separated integers describing 2D Array ; every value in  will be in the inclusive range of  to .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the largest (maximum) hourglass sum found in .
 *
 * Sample Input
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 *
 * 19
 * Explanation
 *
 * contains the following hourglasses:
 *
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * 1       0       0       0
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *
 * 0 1 0   1 0 0   0 0 0   0 0 0
 * 1       1       0       0
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * 0       2       4       4
 * 0 0 0   0 0 2   0 2 0   2 0 0
 *
 * 0 0 2   0 2 4   2 4 4   4 4 0
 * 0       0       2       0
 * 0 0 1   0 1 2   1 2 4   2 4 0
 * The hourglass with the maximum sum () is:
 *
 * 2 4 4
 * 2
 * 1 2 4
 * </pre>
 * Created by jason on 17-12-12.
 */
public class Day11_2DArrays {


    public static void main(String[] args) {
        int[][] arr = inputArray();
        hourglass(arr);
    }

    private static int[][] inputArray() {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        return arr;
    }

    private static void hourglass(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int s = 0;
                s += arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = max > s ? max : s;
            }
        }
        System.out.println(max);
    }
}
