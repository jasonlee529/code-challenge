package cn.lee.hackerrank.algrithms.implementation.library_fine;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/library-fine/problem
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
 * <p>
 * If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
 * If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
 * If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
 * If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
 * Input Format
 * <p>
 * The first line contains  space-separated integers denoting the respective , , and  on which the book was actually returned.
 * The second line contains  space-separated integers denoting the respective , , and  on which the book was expected to be returned (due date).
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the library fine for the book received as input.
 * <p>
 * Sample Input
 * <p>
 * 9 6 2015
 * 6 6 2015
 * Sample Output
 * <p>
 * 45
 * Explanation
 * <p>
 * Given the following return dates:
 * Actual:
 * Expected:
 * <p>
 * Because , we know it is less than a year late.
 * Because , we know it's less than a month late.
 * Because , we know that it was returned late (but still within the same month and year).
 * <p>
 * Per the library's fee structure, we know that our fine will be . We then print the result of  as our output.
 * Created by jason on 18-2-11.
 */
public class Solution {

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Complete this function
        int result = 0;
        if (y1 > y2) {
            result = 10000;
        } else if (y1 == y2 && m1 > m2) {
            result = 500 * (m1 - m2);
        } else if (y1 == y2 && m1 == m2 && d1 >= d2) {
            result = 15 * (d1 - d2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
