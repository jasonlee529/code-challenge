package cn.lee.hackerrank.algrithms.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/closest-numbers/problem
 * <pre>
 * Sorting is often useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses, as well.
 *
 * Challenge
 * Given a list of unsorted integers, , can you find the pair of elements that have the smallest absolute difference between them? If there are multiple pairs, find them all.
 *
 * Input Format
 * The first line of input contains a single integer, , representing the length of array .
 * In the second line, there are  space-separated integers, , representing the elements of array .
 *
 * Output Format
 * Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending order, all on the same line (consecutively) with just a single space between each pair of numbers. If there's a number which lies in two pair, print it two times (see the sample case #3 for explanation).
 *
 * Constraints
 *
 * Sample Input #1
 *
 * 10
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
 * Sample Output #1
 *
 * -20 30
 * Explanation
 * (30) - (-20) = 50, which is the smallest difference.
 *
 * Sample Input #2
 *
 * 12
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470
 * Sample Output #2
 *
 * -520 -470 -20 30
 * Explanation
 * (-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.
 *
 * Sample Input #3
 *
 * 4
 * 5 4 3 2
 * Sample Output #3
 *
 * 2 3 3 4 4 5
 * Explanation
 * Here, the minimum difference will be 1. So valid pairs are (2, 3), (3, 4), and (4, 5). So we have to print 2 once, 3 and 4 twice each, and 5 once.
 *
 * </pre>
 * Created by jason on 17-12-11.
 */
public class ClosestNumbers {


    public static void main(String[] args) {
        closetNumber(new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854});
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        sc.close();
        closetNumber(ar);
    }

    private static void closetNumber(int[] ar) {
        insertionSort(ar);
        int[][] k = new int[ar.length-1][2];
        int[] m = new int[ar.length-1];
        for (int i = 0; i < ar.length - 1; i++) {
            k[i][0] = ar[i];
            k[i][1] = ar[i + 1];
            m[i] = Math.abs(ar[i + 1] - ar[i]);
        }
        int min = findMin(m);
        for (int i = 0; i < m.length; i++) {
            if (m[i] == min) {
                printArray(k[i]);
            }
        }
    }

    private static void printArray(int[] ints) {
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    private static int findMin(int[] m) {
        int min = m[0];
        for (int t : m) {
            min = min < t ? min : t;
        }
        return min;
    }

    private static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
    }
}
