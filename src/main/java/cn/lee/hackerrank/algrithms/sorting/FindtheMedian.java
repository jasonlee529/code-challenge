package cn.lee.hackerrank.algrithms.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-the-median/problem
 * <pre>
 *    Given a list of numbers, can you find the median?
 *
 * Input Format
 *
 * There will be two lines of input:
 *
 * - the size of the array
 * -  numbers that makes up the array
 * Constraints
 *
 * is odd
 * Output Format
 *
 * Output one integer, the median.
 *
 * Sample Input 0
 *
 * 7
 * 0 1 2 4 6 5 3
 * Sample Output 0
 *
 * 3
 * </pre>
 * Created by jason on 17-12-11.
 */
public class FindtheMedian {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        findMedian(intutArray());
    }

    private static void findMedian(int[] ints) {
        sortArray(ints);
        int mIndex = ints.length / 2 ;
        System.out.println(ints[mIndex]);
    }

    private static int[] intutArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        return ar;
    }

    private static int[] sortArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        return A;
    }
}
