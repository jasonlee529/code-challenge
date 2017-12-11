package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-binary-numbers/problem
 * <pre>
 *     Objective
 * Today, we're working with binary numbers. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given a base- integer, , convert it to binary (base-). Then find and print the base- integer denoting the maximum number of consecutive 's in 's binary representation.
 *
 * Input Format
 *
 * A single integer, .
 *
 * Constraints
 *
 * Output Format
 *
 * Print a single base- integer denoting the maximum number of consecutive 's in the binary representation of .
 *
 * Sample Input 1
 *
 * 5
 * Sample Output 1
 *
 * 1
 * Sample Input 2
 *
 * 13
 * Sample Output 2
 *
 * 2
 * Explanation
 *
 * Sample Case 1:
 * The binary representation of  is , so the maximum number of consecutive 's is .
 *
 * Sample Case 2:
 * The binary representation of  is , so the maximum number of consecutive 's is .
 * </pre>
 * Created by jason on 17-12-11.
 */
public class Day10_BinaryNumbers {
    public static void main(String[] args) {
        binaryNumers(5);
        binaryNumers(13);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        binaryNumers(n);
    }

    private static void binaryNumers(int n) {
        int s = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(n % 2);
            n = n / 2;
        } while (n > 0);
        String r = sb.toString();
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '1') {
                s++;
            } else {
                s = 0;
            }
            max = max >= s ? max : s;
        }
        System.out.println(max);
    }
}
