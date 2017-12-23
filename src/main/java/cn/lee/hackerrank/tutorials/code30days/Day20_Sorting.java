package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-sorting/problem
 * <pre>
 * Objective
 * Today, we're discussing a simple sorting algorithm called Bubble Sort. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Consider the following version of Bubble Sort:
 *
 * for (int i = 0; i < n; i++) {
 * // Track number of elements swapped during a single array traversal
 * int numberOfSwaps = 0;
 *
 * for (int j = 0; j < n - 1; j++) {
 * // Swap adjacent elements if they are in decreasing order
 * if (a[j] > a[j + 1]) {
 * swap(a[j], a[j + 1]);
 * numberOfSwaps++;
 * }
 * }
 *
 * // If no elements were swapped during a traversal, array is sorted
 * if (numberOfSwaps == 0) {
 * break;
 * }
 * }
 * Task
 * Given an array, , of size  distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following  lines:
 *
 * Array is sorted in numSwaps swaps.
 * where  is the number of swaps that took place.
 * First Element: firstElement
 * where  is the first element in the sorted array.
 * Last Element: lastElement
 * where  is the last element in the sorted array.
 * Hint: To complete this challenge, you will need to add a variable that keeps a running tally of all swaps that occur during execution.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of elements in array .
 * The second line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 * , where .
 * Output Format
 *
 * Print the following three lines of output:
 *
 * Array is sorted in numSwaps swaps.
 * where  is the number of swaps that took place.
 * First Element: firstElement
 * where  is the first element in the sorted array.
 * Last Element: lastElement
 * where  is the last element in the sorted array.
 * Sample Input 0
 *
 * 3
 * 1 2 3
 * Sample Output 0
 *
 * Array is sorted in 0 swaps.
 * First Element: 1
 * Last Element: 3
 * Explanation 0
 *
 * The array is already sorted, so  swaps take place and we print the necessary  lines of output shown above.
 *
 * Sample Input 1
 *
 * 3
 * 3 2 1
 * Sample Output 1
 *
 * Array is sorted in 3 swaps.
 * First Element: 1
 * Last Element: 3
 * Explanation 1
 *
 * The array  is not sorted, so we perform the following  swaps:
 *
 * At this point the array is sorted and we print the necessary  lines of output shown above.
 *
 *
 * </pre>
 * Created by jason on 17-12-21.
 */
public class Day20_Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int total = 0;
        // Write Your Code Here
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }
            total += numberOfSwaps;
            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        System.out.println(String.format("Array is sorted in %d swaps.", total));
        System.out.println(String.format("First Element: %d", a[0]));
        System.out.println(String.format("Last Element: %d", a[a.length - 1]));
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}