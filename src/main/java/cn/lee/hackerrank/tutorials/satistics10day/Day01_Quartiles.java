package cn.lee.hackerrank.tutorials.satistics10day;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-quartiles/problem
 * <pre>
 *     Objective
 * In this challenge, we practice calculating quartiles. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given an array, , of  integers, calculate the respective first quartile (), second quartile (), and third quartile (). It is guaranteed that , , and  are integers.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of elements in the array.
 * The second line contains  space-separated integers describing the array's elements.
 *
 * Constraints
 *
 * , where  is the  element of the array.
 * Output Format
 *
 * Print  lines of output in the following order:
 *
 * The first line should be the value of .
 * The second line should be the value of .
 * The third line should be the value of .
 * Sample Input
 *
 * 9
 * 3 7 8 5 12 14 21 13 18
 * Sample Output
 *
 * 6
 * 12
 * 16
 * Explanation
 *
 * . When we sort the elements in non-decreasing order, we get . It's easy to see that .
 *
 * As there are an odd number of data points, we do not include the median (the central value in the ordered list) in either half:
 *
 * Lower half (L): 3, 5, 7, 8
 *
 * Upper half (U): 13, 14, 18, 21
 *
 * Now, we find the quartiles:
 *
 * is the . So, .
 * is the . So, .
 * is the . So, .
 * </pre>
 * Created by jason on 17-12-21.
 */
public class Day01_Quartiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] ar = new int[n];
//        for (int i = 0; i < n; i++) {
//            ar[i] = sc.nextInt();
//        }
        int n = 9;
        int[] ar = new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18};
        int[] r = quartiles(n, ar);
        for (int i : r) {
            System.out.println(i);
        }
    }

    private static int[] quartiles(int n, int[] ar) {
        Arrays.sort(ar);
        int a1 = (int) Math.floor(n / 2);
        int a2 = (int) Math.ceil(n / 2);
        int[] left = new int[a1];
        int[] right = new int[a2];
        System.arraycopy(ar, 0, left, 0, a1);
        System.arraycopy(ar, a2 + 1, right, 0, n - a2 - 1);
        int[] r = new int[3];
        r[0] = median(left);
        r[1] = median(ar);
        r[2] = median(right);
        return r;

    }

    private static int median(int[] ar) {
        double l = ar.length - 1;
        Arrays.sort(ar);
        int a1 = (int) Math.floor(l / 2);
        int a2 = (int) Math.ceil(l / 2);
        return (ar[a1] + ar[a2]) / 2;
    }
}
