package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-review-loop/problem
 * <pre>Objective
 * Today we're expanding our knowledge of Strings and combining it with what we've already learned about loops. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given a string, , of length  that is indexed from  to , print its even-indexed and odd-indexed characters as  space-separated strings on a single line (see the Sample below for more detail).
 *
 * Note:  is considered to be an even index.
 *
 * Input Format
 *
 * The first line contains an integer,  (the number of test cases).
 * Each line  of the  subsequent lines contain a String, .
 *
 * Constraints
 *
 * Output Format
 *
 * For each String  (where ), print 's even-indexed characters, followed by a space, followed by 's odd-indexed characters.
 *
 * Sample Input
 *
 * 2
 * Hacker
 * Rank
 * Sample Output
 *
 * Hce akr
 * Rn ak
 * Explanation
 *
 * Test Case 0:
 *
 *
 *
 *
 *
 *
 * The even indices are , , and , and the odd indices are , , and . We then print a single line of  space-separated strings; the first string contains the ordered characters from 's even indices (), and the second string contains the ordered characters from 's odd indices ().
 *
 * Test Case 1:
 *
 *
 *
 *
 * The even indices are  and , and the odd indices are  and . We then print a single line of  space-separated strings; the first string contains the ordered characters from 's even indices (), and the second string contains the ordered characters from 's odd indices ().
 * </pre>
 * Created by jason on 17-12-7.
 */
public class Day06_LetsReview {
    public static void main(String[] args) {
        printEven("Hacker");
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            printEven(sc.next());
        }
    }

    private static void printEven(String s) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                odd.append(s.charAt(i));
            } else {
                even.append(s.charAt(i));
            }
        }
        System.out.println(odd.toString() + " " + even.toString());
    }


}
